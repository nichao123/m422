package Zrj326.src.main.java.service.serviceImpl;

import dao.UserinfoDao;
import dao.daoImpl.UserinfoDaoImpl;
import pojo.Userinfo;
import service.UserinfoService;

import java.util.List;

public class UserinfoServiceImpl implements UserinfoService {
    UserinfoDao userinfoDao=new UserinfoDaoImpl();
    @Override
    public List<Userinfo> all(String loginName) {
        return userinfoDao.all(loginName);
    }

    @Override
    public int addUserinfo(Userinfo userinfo) {
        return userinfoDao.addUserinfo(userinfo);
    }

    @Override
    public int updateUserinfo(Userinfo userinfo) {
        return userinfoDao.updateUserinfo(userinfo);
    }

    @Override
    public int delUserinfo(int userId) {
        return userinfoDao.delUserinfo(userId);
    }

    @Override
    public Userinfo getUserinfo(int userId) {
        return userinfoDao.getUserinfo(userId);
    }

    @Override
    public Userinfo getUserinfoName(String loginName) {
        return userinfoDao.getUserinfoName(loginName);
    }

    @Override
    public int setAmount(Userinfo userinfo) {
        return userinfoDao.setAmount(userinfo);
    }
}
