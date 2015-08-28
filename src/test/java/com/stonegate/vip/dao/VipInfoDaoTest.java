package com.stonegate.vip.dao;

import com.stonegate.vip.bean.VipInfo;
import org.junit.Test;

import javax.annotation.Resource;

public class VipInfoDaoTest extends BaseTest {

    @Resource
    private VipInfoDao vipInfoDao;

    @Test
    public void testGetAllVipInfo() throws Exception {
        logger.info("result:{}",vipInfoDao.getAllVipInfo("test",0,10));
    }

    @Test
    public void testSaveVipInfo() throws Exception {
        VipInfo vipInfo = new VipInfo();
        vipInfo.setPoints(19);
        vipInfo.setVipName("test");
        vipInfo.setUserName("test");
        vipInfo.setVipPhone("123414");
        vipInfoDao.saveVipInfo(vipInfo);
    }

    @Test
    public void testGetVipInfoByPhone() throws Exception {
        logger.info("result:{}", vipInfoDao.getVipInfoByPhone("123414","test"));
    }
}