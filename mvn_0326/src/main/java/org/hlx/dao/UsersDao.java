package org.hlx.dao;


import org.hlx.pojo.Users;

import java.util.List;

public interface UsersDao {

    //查询
    List<Users> all(String name);

    //添加
    int addUsers(Users users);

    //修改
    int updateUsers(Users users);

    //删除
    int delUsers(int id);

   //获得一条信息
    Users getUsers(int id);

    //登录
    int login(Users users);

}
