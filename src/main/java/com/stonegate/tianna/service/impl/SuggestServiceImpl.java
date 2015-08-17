package com.stonegate.tianna.service.impl;

import com.stonegate.tianna.bean.Question;
import com.stonegate.tianna.dao.QuestionDao;
import com.stonegate.tianna.service.SuggestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chao.zhu created on 15/8/16 下午12:02
 * @version 1.0
 */
@Service
public class SuggestServiceImpl implements SuggestService {
    @Resource
    private QuestionDao questionDao;

    @Override
    public Question giveMeOneQuestion() {
        Question question = questionDao.getLasQuestion();
        return question;
    }
}
