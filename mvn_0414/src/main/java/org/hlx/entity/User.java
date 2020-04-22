package org.hlx.entity;

/**
 * @ClassName User
 * @Description: TODO
 * @Author 44401
 * @Date 2020/4/14
 * @Version V1.0
 * 实体类
 **/
public class User {
    private String uname;
    private String upass;

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", upass='" + upass + '\'' +
                '}';
    }

    public User(String uname, String upass) {
        this.uname = uname;
        this.upass = upass;
    }

    public User() {
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }
}
