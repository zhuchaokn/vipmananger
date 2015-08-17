package com.stonegate.tianna.common.exception.handler;

import com.stonegate.tianna.common.interfaces.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author chao.zhu created on 15/4/2 下午9:34
 * @version 1.0
 */
public class DefaultExceptionHandler implements ExceptionHandler {
    @Override
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        response.setStatus(200);
        // todo
        return null;
    }
}
