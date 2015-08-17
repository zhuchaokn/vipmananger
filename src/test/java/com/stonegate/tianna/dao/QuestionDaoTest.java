package com.stonegate.tianna.dao;

import com.stonegate.tianna.bean.Question;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class QuestionDaoTest {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private QuestionDao questionDao;

    @org.junit.Test
    public void testSaveQuestion() throws Exception {
        questionDao.saveQuestion(new Question("who are you", "zc"));
    }

    @org.junit.Test
    public void testGetQuestionById() throws Exception {
        logger.info("result:{}", questionDao.getQuestionById(1));
    }
}