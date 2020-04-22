package pojo;

public class Userinfo {
    private int userid;
    private String uname;
    private String upwd;
    private String usex;
    private String ubirth;
    private String utel;
    private String uadd;
    private int utype;

    public Userinfo() {
    }

    public Userinfo(int userid, String uname, String upwd, String usex, String ubirth, String utel, String uadd, int utype) {
        this.userid = userid;
        this.uname = uname;
        this.upwd = upwd;
        this.usex = usex;
        this.ubirth = ubirth;
        this.utel = utel;
        this.uadd = uadd;
        this.utype = utype;
    }

    public Userinfo(String uname, String upwd, String usex, String ubirth, String utel, String uadd) {
        this.uname = uname;
        this.upwd = upwd;
        this.usex = usex;
        this.ubirth = ubirth;
        this.utel = utel;
        this.uadd = uadd;
    }

    public Userinfo(String uname, String upwd, String usex, String ubirth, String utel, String uadd, int utype) {
        this.uname = uname;
        this.upwd = upwd;
        this.usex = usex;
        this.ubirth = ubirth;
        this.utel = utel;
        this.uadd = uadd;
        this.utype = utype;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    public String getUbirth() {
        return ubirth;
    }

    public void setUbirth(String ubirth) {
        this.ubirth = ubirth;
    }

    public String getUtel() {
        return utel;
    }

    public void setUtel(String utel) {
        this.utel = utel;
    }

    public String getUadd() {
        return uadd;
    }

    public void setUadd(String uadd) {
        this.uadd = uadd;
    }

    public int getUtype() {
        return utype;
    }

    public void setUtype(int utype) {
        this.utype = utype;
    }

    @Override
    public String toString() {
        return "Userinfo{" +
                "userid=" + userid +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", usex='" + usex + '\'' +
                ", ubirth='" + ubirth + '\'' +
                ", utel='" + utel + '\'' +
                ", uadd='" + uadd + '\'' +
                ", utype=" + utype +
                '}';
    }
}
