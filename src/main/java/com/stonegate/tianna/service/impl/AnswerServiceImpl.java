package com.stonegate.tianna.service.impl;

import com.stonegate.tianna.bean.Answer;
import com.stonegate.tianna.bean.Question;
import com.stonegate.tianna.dao.AnswerDao;
import com.stonegate.tianna.dao.QuestionDao;
import com.stonegate.tianna.service.AnswerService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chao.zhu created on 15/8/16 上午11:52
 * @version 1.0
 */
@Service
public class AnswerServiceImpl implements AnswerService {
    @Resource
    private QuestionDao questionDao;
    @Resource
    private AnswerDao answerDao;

    @Override
    public Answer findAnswer(Question question) {
        Question record = questionDao.findQuestion(question);
        if (record == null) {
            questionDao.saveQuestion(question);
            return Answer.IDontKnow;
        }
        List<Answer> answerList = answerDao.getAnswerOfQuestion(record.getId());
        if (CollectionUtils.isEmpty(answerList)) {
            return Answer.IDontKnow;
        }
        return answerList.get(0);
    }

    @Override
    public void saveAnswer(Answer answer) {
        answerDao.saveAnswer(answer);
    }
}
