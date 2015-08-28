package com.stonegate.vip.dao;

import com.stonegate.vip.bean.ConsumeRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chao.zhu created on 15/8/24 下午11:39
 * @version 1.0
 */
@Repository
public interface ConsumeRecordDao {
    public List<ConsumeRecord> getConsumeList(@Param("vipPhone")String vipPhone,@Param("from")int from,@Param("size")int size);

    public void saveConsumeRecord(ConsumeRecord consumeRecord);
}
