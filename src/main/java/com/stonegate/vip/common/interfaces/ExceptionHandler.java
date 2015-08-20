package com.stonegate.vip.common.interfaces;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author chao.zhu created on 15/4/2 下午8:34
 * @version 1.0
 */
public interface ExceptionHandler {
    /**
     * 处理异常 返回视图
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @return
     */
    ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex);
}
