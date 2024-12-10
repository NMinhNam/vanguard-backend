package com.fpt.vanguard.service.impl;

import com.fpt.vanguard.dto.request.UngVienDtoRequest;
import com.fpt.vanguard.service.EmailListenerService;
import com.fpt.vanguard.service.TuyenDungService;
import com.fpt.vanguard.service.UngVienService;
import com.sun.mail.imap.IMAPFolder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.event.MessageCountEvent;
import javax.mail.event.MessageCountListener;
import javax.mail.internet.InternetAddress;
import java.util.Properties;
@Service
@RequiredArgsConstructor
public class EmailListenerSeviceImpl implements EmailListenerService {
    private final UngVienService ungVienService;
    private final TuyenDungService tuyenDungService;
    private final String host = "imap.gmail.com";
    private final String username = "minhnam1810@gmail.com";
    private final String password = "badl gfvc rbcz zavi";

    @Override
    public void startListening() {
        try {
            // Cấu hình IMAP
            Properties props = new Properties();
            props.put("mail.store.protocol", "imaps");
            props.put("mail.imap.host", host);
            props.put("mail.imap.port", "993");
            props.put("mail.imap.ssl.enable", "true");
            Session session = Session.getInstance(props);
            Store store = session.getStore("imaps");
            store.connect(host, username, password);
            IMAPFolder inbox = (IMAPFolder) store.getFolder("INBOX");
            inbox.open(Folder.READ_WRITE);
            inbox.addMessageCountListener(new MessageCountListener() {
                @Override
                public void messagesAdded(MessageCountEvent event) {
                    for (Message message : event.getMessages()) {
                        try {
                            Address[] froms = message.getFrom();
                            if (froms != null && froms.length > 0) {
                                InternetAddress address = (InternetAddress) froms[0];
                                String name = address.getPersonal();
                                String email = address.getAddress();
                                String subject = message.getSubject();

                                String maViTri = tuyenDungService.getMaViTriByTenViTri(subject);
                                UngVienDtoRequest ungVien = new UngVienDtoRequest();
                                ungVien.setEmail(email);
                                ungVien.setHoTen(name);
                                ungVien.setMaViTriTuyenDung(maViTri);
                                ungVienService.insertUngVien(ungVien);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }


                @Override
                public void messagesRemoved(MessageCountEvent event) {
                }
            });
            while (true) {
                inbox.idle();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
