package service;

import pojo.Userinfo;

import java.util.List;

public interface UserinfoService {
    List<Userinfo> all(String uname);
    int addUserinfo(Userinfo userinfo);
    int updateUserinfo(Userinfo userinfo);
    int delUserinfo(int userid);
    Userinfo getUserinfo(int userid);
    Userinfo getUserinfoName(String uname);
}
