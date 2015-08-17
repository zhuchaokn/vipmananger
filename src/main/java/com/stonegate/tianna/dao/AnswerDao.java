package com.stonegate.tianna.dao;

import com.stonegate.tianna.bean.Answer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chao.zhu created on 15/8/15 上午10:48
 * @version 1.0
 */
@Repository
public interface AnswerDao {
    public void saveAnswer(Answer answer);

    public List<Answer> getAnswerOfQuestion(int questionId);
}
