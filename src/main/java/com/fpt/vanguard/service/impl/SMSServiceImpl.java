//package com.fpt.vanguard.service.impl;
//
//import com.fpt.vanguard.dto.request.SMSDtoRequest;
//import com.fpt.vanguard.service.SMSService;
//import com.twilio.Twilio;
//import com.twilio.rest.api.v2010.account.Message;
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//@Service
//public class SMSServiceImpl implements SMSService {
//    @Value("${twilio.account-sid}")
//    protected String ACCOUNT_SID;
//
//    @Value("${twilio.auth-token}")
//    protected String AUTH_TOKEN;
//
//    @Value("${twilio.outgoing-sms-number}")
//    protected String OUTGOING_SMS_NUMBER;
//
//    @PostConstruct
//    private void setup() {
//        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//    }
//
//    @Override
//    public String sendSMS(SMSDtoRequest request) {
//        Message message = Message.creator(
//                        new com.twilio.type.PhoneNumber(request.getSmsNumber()),
//                        new com.twilio.type.PhoneNumber(OUTGOING_SMS_NUMBER),
//                        request.getSmsMessage())
//                .create();
//
//        return message.getStatus().toString();
//    }
//}
