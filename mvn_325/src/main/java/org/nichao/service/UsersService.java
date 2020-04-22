package org.nichao.service;


import org.nichao.pojo.Users;

import java.util.List;

public interface UsersService {

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

    int isLogin(Users user);
}
