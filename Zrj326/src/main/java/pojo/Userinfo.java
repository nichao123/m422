package Zrj326.src.main.java.pojo;

public class Userinfo {
    private int userId;
    private String loginName;
    private String loginPass;
    private String phone;
    private String realname;
    private double amount;
    private int admin;
    public Userinfo() {
    }
    public Userinfo(String loginName, String loginPass, String phone, String realname) {
        this.loginName = loginName;
        this.loginPass = loginPass;
        this.phone = phone;
        this.realname = realname;
    }
    public Userinfo(int userId, String loginName, String loginPass, String phone, String realname, double amount, int admin) {
        this.userId = userId;
        this.loginName = loginName;
        this.loginPass = loginPass;
        this.phone = phone;
        this.realname = realname;
        this.amount = amount;
        this.admin = admin;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getLoginName() {
        return loginName;
    }
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    public String getLoginPass() {
        return loginPass;
    }
    public void setLoginPass(String loginPass) {
        this.loginPass = loginPass;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getRealname() {
        return realname;
    }
    public void setRealname(String reaname) {
        this.realname = reaname;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public int getAdmin() {
        return admin;
    }
    public void setAdmin(int admin) {
        this.admin = admin;
    }
    @Override
    public String toString() {
        return  userId + "\t" + loginName  + "\t" + loginPass  + "\t" + phone  + "\t" + realname  + "\t" + amount + "\t" + admin;
    }
}
