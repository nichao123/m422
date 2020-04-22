package org.hlx.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Foodorderinfo {
    private Integer orderid;

    private Integer userid;

    private Integer foodid;

    private Integer sl;

    private Date dcdate;

    private BigDecimal subprice;

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getFoodid() {
        return foodid;
    }

    public void setFoodid(Integer foodid) {
        this.foodid = foodid;
    }

    public Integer getSl() {
        return sl;
    }

    public void setSl(Integer sl) {
        this.sl = sl;
    }

    public Date getDcdate() {
        return dcdate;
    }

    public void setDcdate(Date dcdate) {
        this.dcdate = dcdate;
    }

    public BigDecimal getSubprice() {
        return subprice;
    }

    public void setSubprice(BigDecimal subprice) {
        this.subprice = subprice;
    }
}