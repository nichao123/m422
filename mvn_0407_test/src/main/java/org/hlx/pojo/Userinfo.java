package org.hlx.pojo;

import java.math.BigDecimal;

public class Userinfo {
    private Integer userid;

    private String loginname;

    private String loginpass;

    private String phone;

    private String realname;

    private BigDecimal amount;

    private Integer admin;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    public String getLoginpass() {
        return loginpass;
    }

    public void setLoginpass(String loginpass) {
        this.loginpass = loginpass == null ? null : loginpass.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Userinfo{" +
                "userid=" + userid +
                ", loginname='" + loginname + '\'' +
                ", loginpass='" + loginpass + '\'' +
                ", phone='" + phone + '\'' +
                ", realname='" + realname + '\'' +
                ", amount=" + amount +
                ", admin=" + admin +
                '}';
    }
}