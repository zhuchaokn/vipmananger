package com.stonegate.vip.controller;

import com.stonegate.vip.bean.Account;
import com.stonegate.vip.common.AccountCookieMaker;
import com.stonegate.vip.common.IpUtil;
import com.stonegate.vip.common.exception.exceptions.BizException;
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
    public String login(@RequestBody Account account, HttpServletRequest request, HttpServletResponse response) {
        account.setLoginIp(IpUtil.getIpAddr(request));
        if (accountService.validate(account)) {
            Cookie[] cookies = AccountCookieMaker.makeCookies(account);
            for (Cookie cookie : cookies) {
                response.addCookie(cookie);
            }
            return "/index.html";
        }
        throw new BizException("用户名或密码不正确");
    }
}
