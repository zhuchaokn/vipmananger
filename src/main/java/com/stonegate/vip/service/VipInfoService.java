package com.stonegate.vip.service;

import com.stonegate.vip.bean.VipInfo;

import java.util.List;

/**
 * @author chao.zhu created on 15/8/25 上午12:02
 * @version 1.0
 */
public interface VipInfoService {
    List<VipInfo> getVipInfoList(String userName,int page,int size);
}
