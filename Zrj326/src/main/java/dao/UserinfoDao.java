package Zrj326.src.main.java.dao;

import pojo.Userinfo;

import java.util.List;

public interface UserinfoDao {
    List<Userinfo> all(String loginName);
    int addUserinfo(Userinfo userinfo);
    int updateUserinfo(Userinfo userinfo);
    int delUserinfo(int userId);
    Userinfo getUserinfo(int userId);
    Userinfo getUserinfoName(String loginName);
    int setAmount(Userinfo userinfo);
}
