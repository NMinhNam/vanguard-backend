package com.fpt.vanguard.mapper.mybatis;

import com.fpt.vanguard.entity.WifiInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WifiMapper {
    Boolean isWifiInfoExist(String publicIp);
    List<WifiInfo> getWifiInfoList();
    Integer insertWifiInfo(WifiInfo wifiInfo);
    Integer updateWifiInfo(WifiInfo wifiInfo);
    Integer deleteWifiInfo(String publicIp);
}
