package com.stonegate.vip.filtes;

import com.stonegate.vip.bean.Account;
import com.stonegate.vip.common.AccountCookieMaker;
import com.stonegate.vip.common.IpUtil;
import com.stonegate.vip.context.AccountContext;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chao.zhu created on 15/8/20 下午2:30
 * @version 1.0
 */
public class AccountFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {

            for (Cookie ck : cookies) {
                if (ck.getName().equals("_v")) {
                    Account account = AccountCookieMaker.parseCookie(ck.getValue());
                    String ipAddress = IpUtil.getIpAddr(request);
                    if (account == null || !ipAddress.equals(account.getLoginIp())) {
                        ((HttpServletResponse) servletResponse).sendRedirect("/login.html");
                    } else {
                        AccountContext.setContext(account);
                        filterChain.doFilter(servletRequest, servletResponse);
                    }
                }
            }
        }else {
            ((HttpServletResponse) servletResponse).sendRedirect("/login.html");
        }
    }

    @Override
    public void destroy() {

    }
}
