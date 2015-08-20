package com.stonegate.vip.common.exception.resolver;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Maps;
import com.stonegate.vip.common.annotations.HandleException;
import com.stonegate.vip.common.exception.handler.DefaultExceptionHandler;
import com.stonegate.vip.common.interfaces.ExceptionHandler;

/**
 * 统一异常处理接口 捕获所有的出口异常,调用已注册的handler类处理相关异常
 * 
 * @author chao.zhu created on 15/4/2 下午5:57
 * @version 1.0
 */
public class UnifyExceptionResolver implements HandlerExceptionResolver {
    @Resource
    private ApplicationContext context;
    private Logger logger = LoggerFactory.getLogger(getClass());
    private Map<Class<? extends Exception>, ExceptionHandler> handlerMap = Maps.newHashMap();
    private ExceptionHandler defaultHandler = new DefaultExceptionHandler();

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) {
        for (Map.Entry<Class<? extends Exception>, ExceptionHandler> entry : handlerMap.entrySet()) {
            Class<? extends Exception> exceptionClazz = entry.getKey();
            if (ex.getClass().isAssignableFrom(exceptionClazz)) {
                return entry.getValue().handle(request, response, handler, ex);
            }
        }
        logger.error("unexpected exception", ex);
        return defaultHandler.handle(request, response, handler, ex);
    }

    @PostConstruct
    public void initHandlerList() {
        Map<String, ExceptionHandler> beanMap = context.getBeansOfType(ExceptionHandler.class);
        for (Map.Entry<String, ExceptionHandler> entry : beanMap.entrySet()) {
            ExceptionHandler handler = entry.getValue();
            HandleException exception = handler.getClass().getAnnotation(HandleException.class);
            if (exception != null) {
                handlerMap.put(exception.value(), handler);
            }
        }
        if (handlerMap.get(Exception.class) != null) {
            defaultHandler = handlerMap.remove(Exception.class);
        }
    }
}
