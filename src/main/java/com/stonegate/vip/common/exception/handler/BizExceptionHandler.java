package com.stonegate.vip.common.exception.handler;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.stonegate.vip.common.annotations.HandleException;
import com.stonegate.vip.common.exception.exceptions.BizException;
import com.stonegate.vip.common.interfaces.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

/**
 * @author chao.zhu created on 15/8/17 下午9:36
 * @version 1.0
 */
@HandleException(BizException.class)
public class BizExceptionHandler implements ExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        try {
            response.setContentType("application/json");
            Writer writer = response.getWriter();
            Map<String, String> map = Maps.newHashMap();
            map.put("message", ex.getMessage());
            writer.write(JSON.toJSONString(map));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            logger.error("error while handle exception:{}", ex.getMessage(), e);
            e.printStackTrace();
        }
        return null;
    }
}
