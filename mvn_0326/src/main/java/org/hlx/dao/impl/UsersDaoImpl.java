package org.hlx.dao.impl;

import org.hlx.dao.UsersDao;
import org.hlx.pojo.Users;
import org.hlx.util.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UsersDaoImpl
 * @Description: TODO
 * @Author 44401
 * @Date 2020/3/20
 * @Version V1.0
 * 实现类=继承Basedao =>实现接口
 **/
public class UsersDaoImpl extends BaseDao implements UsersDao {
    @Override
    public List<Users> all(String name) {
        //集合对象
        List<Users> list = new ArrayList<>();

        //sql
        StringBuilder sql =new StringBuilder( "select * from users");

        ResultSet rs =null;
        //判断
        if(name!=null &&  !name.equals("")) {
            sql.append(" where name like ?");
            //parameter
            Object[] objs ={"%"+name+"%"};
            //调用方法
            rs = this.executeSQL(sql.toString(),objs);
        }else{
            rs = this.executeSQL(sql.toString());
        }

        try {
            //遍历数据
            while (rs.next()) {
                //封装对象
                Users Users =new Users(rs.getInt(1),rs.getString(2),rs.getString(3));

                //添加集合
                list.add(Users);

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            this.closeResource(); //关闭数据
        }


        return list;
    }

    @Override
    public int addUsers(Users user) {
        //sql语句
        String sql = "insert into users(name,pass) values(?,?)";
//        参数
        Object[] objs = {user.getName(),user.getPass()};

        return this.executeUpdate(sql, objs);
    }

    @Override
    public int updateUsers(Users user) {

        //sql语句
        String sql = "update users set name=?,pass=? where id=?";
        //参数
        Object[] objs = {user.getName(),user.getPass(),user.getId()};

        return this.executeUpdate(sql, objs);

    }

    @Override
    public int delUsers(int id) {
        String sql = "delete from Users where id=?";

        Object[] objs = {id};

        return this.executeUpdate(sql, objs);
    }

    /**
     * 根据id
     * @param id
     * @return
     */
    @Override
    public Users getUsers(int id) {

        //sql
        String sql="select * from Users where id=?";

        //parameter
        Object[] objs ={id};

        //调用方法
        ResultSet rs = this.executeSQL(sql,objs);
        Users user =null;
        try {
            //遍历数据
            while (rs.next()) {
                //封装对象
                 user=new Users(rs.getInt(1),rs.getString(2),rs.getString(3));
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            this.closeResource(); //关闭数据
        }

        return user;
    }

    @Override
    public int login(Users users) {

        //sql
        String sql="SELECT count(1) from users where name=? and pass=?";

        //parameter
        Object[] objs ={users.getName(),users.getPass()};

        //调用方法
        ResultSet rs = this.executeSQL(sql,objs);

        //光标往下移
        try {
            rs.next();

            //获得数据
            return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {   //关闭
            this.closeResource();
        }

        return 0;
    }
}
