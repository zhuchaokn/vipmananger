package com.stonegate.vip.bean;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author chao.zhu created on 15/8/20 下午11:28
 * @version 1.0
 */
public class ConsumeRecord implements Serializable {

    private static final long serialVersionUID = -9006744671978342443L;
    private int id;
    private String vipPhone;
    private Date createTime;
    private BigDecimal amount;

    public ConsumeRecord() {
    }

    public ConsumeRecord(String vipPhone, BigDecimal amount) {
        this.vipPhone = vipPhone;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVipPhone() {
        return vipPhone;
    }

    public void setVipPhone(String vipPhone) {
        this.vipPhone = vipPhone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
