package com.stonegate.tianna.dao;

import com.stonegate.tianna.bean.Answer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AnswerDaoTest {

    @Resource
    private AnswerDao answerDao;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void testSaveAnswer() throws Exception {
        answerDao.saveAnswer(new Answer("I am tianna.", 1, "zc"));
    }

    @Test
    public void testGetAnswerOfQuestion() throws Exception {
        logger.info("result:{}", answerDao.getAnswerOfQuestion(1));
    }
}