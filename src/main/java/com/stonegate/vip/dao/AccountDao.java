package com.stonegate.vip.dao;

import com.stonegate.vip.bean.Account;
import org.springframework.stereotype.Repository;

/**
 * @author chao.zhu created on 15/8/17 下午3:57
 * @version 1.0
 */
@Repository
public interface AccountDao {
    public void register(Account account);

    public Account getAccountByName(String userName);
}
