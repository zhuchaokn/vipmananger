package com.stonegate.vip.common.exception.handler;

import com.stonegate.vip.common.interfaces.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * @author chao.zhu created on 15/4/2 下午9:34
 * @version 1.0
 */
public class DefaultExceptionHandler implements ExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        response.setStatus(500);
        try {
            Writer writer = response.getWriter();
            writer.write(ex.getMessage());
            writer.close();
        } catch (IOException e) {
            logger.error("error while handle exception:{}", ex.getMessage(), e);
        }
        return null;
    }
}
