package com.stonegate.vip.dao;

import com.stonegate.vip.bean.VipInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chao.zhu created on 15/8/20 下午11:31
 * @version 1.0
 */
@Repository
public interface VipInfoDao {
    public List<VipInfo> getAllVipInfo(@Param("userName")String userName,@Param("from") int from, @Param("size") int size);

    public void saveVipInfo(VipInfo vipInfo);

    public VipInfo getVipInfoByPhone(@Param("phone")String phone,@Param("userName")String userName);
}
