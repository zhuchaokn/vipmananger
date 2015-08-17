package com.stonegate.tianna.service;

import com.stonegate.tianna.bean.Answer;
import com.stonegate.tianna.bean.Question;

/**
 * @author chao.zhu created on 15/8/15 上午10:28
 * @version 1.0
 */
public interface AnswerService {
    public Answer findAnswer(Question question);

    public void saveAnswer(Answer answer);
}
