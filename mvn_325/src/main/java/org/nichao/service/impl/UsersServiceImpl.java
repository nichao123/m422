package org.nichao.service.impl;


import org.nichao.dao.UsersDao;
import org.nichao.dao.impl.UsersDaoImpl;
import org.nichao.pojo.Users;
import org.nichao.service.UsersService;

import java.util.List;

/**
 * @ClassName UsersServiceImpl
 * @Description: TODO
 * @Author 44401
 * @Date 2020/3/25
 * @Version V1.0
 * 业务类
 **/
public class UsersServiceImpl implements UsersService {

    //底层调用数据
    private UsersDao dao= new UsersDaoImpl();

    @Override
    public List<Users> all(String name) {
        return dao.all(name);
    }

    @Override
    public int addUsers(Users users) {
        return dao.addUsers(users);
    }

    @Override
    public int updateUsers(Users users) {
        return dao.updateUsers(users);
    }

    @Override
    public int delUsers(int id) {
        return dao.delUsers(id);
    }

    @Override
    public Users getUsers(int id) {
        return dao.getUsers(id);
    }
    @Override
    public int isLogin(Users user) {
        return dao.login(user);
    }
}
