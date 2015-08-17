package com.stonegate.tianna.dao;

import com.stonegate.tianna.bean.Question;
import org.springframework.stereotype.Repository;

/**
 * @author chao.zhu created on 15/8/15 上午10:47
 * @version 1.0
 */
@Repository
public interface QuestionDao {
    public void saveQuestion(Question question);

    public Question getQuestionById(int id);

    public Question getLasQuestion();

    Question findQuestion(Question question);
}
