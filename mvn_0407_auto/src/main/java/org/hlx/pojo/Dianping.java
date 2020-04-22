package org.hlx.pojo;

import java.util.Date;

public class Dianping {
    private Integer did;

    private Integer foodid;

    private String kouwei;

    private String dpcontent;

    private Integer userid;

    private Date dpdate;

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getFoodid() {
        return foodid;
    }

    public void setFoodid(Integer foodid) {
        this.foodid = foodid;
    }

    public String getKouwei() {
        return kouwei;
    }

    public void setKouwei(String kouwei) {
        this.kouwei = kouwei == null ? null : kouwei.trim();
    }

    public String getDpcontent() {
        return dpcontent;
    }

    public void setDpcontent(String dpcontent) {
        this.dpcontent = dpcontent == null ? null : dpcontent.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getDpdate() {
        return dpdate;
    }

    public void setDpdate(Date dpdate) {
        this.dpdate = dpdate;
    }
}