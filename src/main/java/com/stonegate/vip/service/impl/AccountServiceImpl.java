package com.stonegate.vip.service.impl;

import com.stonegate.vip.bean.Account;
import com.stonegate.vip.common.Md5Util;
import com.stonegate.vip.common.exception.exceptions.BizException;
import com.stonegate.vip.dao.AccountDao;
import com.stonegate.vip.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chao.zhu created on 15/8/17 下午4:06
 * @version 1.0
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

    @Override
    public boolean validate(Account account) {
        Account user = accountDao.getAccountByName(account.getUserName());
        if (user == null) {
            throw new BizException("用户不存在");
        }
        String passMd5 = Md5Util.md5WithSalt(account.getPassword());
        return passMd5.equals(user.getPassword());
    }
}
