package com.stonegate.vip.context;

import com.stonegate.vip.bean.Account;

/**
 * @author chao.zhu created on 15/8/20 下午3:14
 * @version 1.0
 */
public class AccountContext {
    private static ThreadLocal<Account> accountThreadLocal = new ThreadLocal<Account>() {
        @Override
        protected Account initialValue() {
            return null;
        }
    };

    public static void setContext(Account account) {
        accountThreadLocal.set(account);
    }

    public static Account currentAccount() {
        return accountThreadLocal.get();
    }
}
