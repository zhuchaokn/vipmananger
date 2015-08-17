package com.stonegate.tianna.controller;

import com.stonegate.tianna.bean.Answer;
import com.stonegate.tianna.bean.Question;
import com.stonegate.tianna.service.AnswerService;
import com.stonegate.tianna.service.SuggestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author chao.zhu created on 15/8/7 上午6:34
 * @version 1.0
 */
@Controller
@RequestMapping("/ask")
public class AskController {
    @Resource
    private SuggestService suggestService;
    @Resource
    private AnswerService answerService;

    @RequestMapping("/question")
    @ResponseBody
    public Question askOne() {
        return suggestService.giveMeOneQuestion();
    }

    @RequestMapping
    @ResponseBody
    public String receiveAnswer(Answer answer) {
        answerService.saveAnswer(answer);
        return "ok";
    }
}
