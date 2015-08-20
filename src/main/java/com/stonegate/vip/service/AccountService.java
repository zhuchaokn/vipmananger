package com.stonegate.vip.service;

import com.stonegate.vip.bean.Account;

/**
 * @author chao.zhu created on 15/8/17 下午4:05
 * @version 1.0
 */
public interface AccountService {
    /**
     * 验证登陆权限
     * 
     * @param account
     * @return
     */
    public boolean validate(Account account);
}
