package com.stonegate.vip.dao;

import com.stonegate.vip.bean.ConsumeRecord;
import org.junit.Test;

import javax.annotation.Resource;
import java.math.BigDecimal;

public class ConsumeRecordDaoTest extends BaseTest {

    @Resource
    private ConsumeRecordDao consumeRecordDao;

    @Test
    public void testGetConsumeList() throws Exception {
        logger.info("result:{}", consumeRecordDao.getConsumeList("1234", 0, 10));
    }

    @Test
    public void testSaveConsumeRecord() throws Exception {
        consumeRecordDao.saveConsumeRecord(new ConsumeRecord("1234", new BigDecimal(8)));
    }
}