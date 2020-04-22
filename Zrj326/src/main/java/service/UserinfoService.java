package Zrj326.src.main.java.service;

import pojo.Userinfo;

import java.util.List;

public interface UserinfoService {
    List<Userinfo> all(String loginName);
    int addUserinfo(Userinfo userinfo);
    int updateUserinfo(Userinfo userinfo);
    int delUserinfo(int userId);
    Userinfo getUserinfo(int userId);
    Userinfo getUserinfoName(String loginName);
    int setAmount(Userinfo userinfo);
}
