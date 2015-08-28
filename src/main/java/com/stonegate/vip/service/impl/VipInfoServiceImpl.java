package com.stonegate.vip.service.impl;

import com.stonegate.vip.bean.VipInfo;
import com.stonegate.vip.dao.VipInfoDao;
import com.stonegate.vip.service.VipInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @author chao.zhu created on 15/8/25 上午12:02
 * @version 1.0
 */
@Service
public class VipInfoServiceImpl implements VipInfoService {
    @Resource
    private VipInfoDao vipInfoDao;

    @Override
    public List<VipInfo> getVipInfoList(String userName, int page, int size) {
        List<VipInfo> result = vipInfoDao.getAllVipInfo(userName, (page - 1) * size, size);
        return (result == null) ? Collections.EMPTY_LIST : result;
    }
}
