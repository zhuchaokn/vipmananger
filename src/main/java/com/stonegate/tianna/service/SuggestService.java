package com.stonegate.tianna.service;

import com.stonegate.tianna.bean.Question;

/**
 * @author chao.zhu created on 15/8/16 上午11:43
 * @version 1.0
 */
public interface SuggestService {
    /**
     * 找到一个合适的问题
     * 
     * @return
     */
    public Question giveMeOneQuestion();
}
