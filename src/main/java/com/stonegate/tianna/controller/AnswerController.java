package com.stonegate.tianna.controller;

import com.stonegate.tianna.bean.Answer;
import com.stonegate.tianna.bean.Question;
import com.stonegate.tianna.service.AnswerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author chao.zhu created on 15/8/16 上午11:49
 * @version 1.0
 */
@Controller
@RequestMapping("/answer")
public class AnswerController {
    @Resource
    private AnswerService answerService;

    @RequestMapping("/question")
    public Answer findAnswer(Question question) {
        return answerService.findAnswer(question);
    }
}
