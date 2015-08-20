package com.stonegate.vip.dao;

import com.stonegate.vip.bean.Account;
import com.stonegate.vip.common.Md5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AccountDaoTest {

    @Resource
    private AccountDao accountDao;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void testRegister() throws Exception {
        accountDao.register(new Account("test", Md5Util.md5WithSalt("1234")));
    }

    @Test
    public void testGetAccountByName() throws Exception {
        logger.info("result:{}", accountDao.getAccountByName("test"));
    }
}