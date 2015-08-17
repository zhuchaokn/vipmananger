package com.stonegate.tianna.service.impl;

import com.stonegate.tianna.bean.Question;
import com.stonegate.tianna.dao.QuestionDao;
import com.stonegate.tianna.service.QuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chao.zhu created on 15/8/15 上午11:47
 * @version 1.0
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Resource
    private QuestionDao questionDao;

    @Override
    public void saveQuestion(Question question) {
        questionDao.saveQuestion(question);
    }
}
