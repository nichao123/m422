package org.hlx.pojo;

/**
 * @ClassName Users
 * @Description: TODO
 * @Author 44401
 * @Date 2020/3/25
 * @Version V1.0
 **/
public class Users {
    private int id;
    private String name;
    private String pass;

    public Users(int id, String name, String pass) {
        this.id = id;
        this.name = name;
        this.pass = pass;
    }


    public Users(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public Users() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
