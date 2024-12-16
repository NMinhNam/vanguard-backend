package com.fpt.vanguard.scheduler;

import com.fpt.vanguard.service.BangLuongService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TinhLuongScheduler {
    private final BangLuongService bangLuongService;

    @Scheduled(cron = "0 */15 * * * ?")
    public void tinhLuongHangThang() {
        bangLuongService.updateBangLuongTinhLuong();
    }
}
