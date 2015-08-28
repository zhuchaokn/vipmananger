package com.stonegate.vip.controller;

import com.google.common.collect.Maps;
import com.stonegate.vip.bean.Account;
import com.stonegate.vip.common.AccountCookieMaker;
import com.stonegate.vip.common.IpUtil;
import com.stonegate.vip.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author chao.zhu created on 15/8/17 下午5:50
 * @version 1.0
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Resource
    private AccountService accountService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> login(@RequestBody Account account, HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        account.setLoginIp(IpUtil.getIpAddr(request));
        accountService.validate(account);
        Cookie[] cookies = AccountCookieMaker.makeCookies(account);
        Map<String, String> cookieMap = Maps.newHashMap();
        for (Cookie cookie : cookies) {
            cookieMap.put(cookie.getName(), cookie.getName()+"="+cookie.getValue());
        }
        return cookieMap;
    }
}
