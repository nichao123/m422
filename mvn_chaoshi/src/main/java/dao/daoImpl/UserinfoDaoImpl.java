package dao.daoImpl;

import dao.UserinfoDao;
import pojo.Userinfo;
import util.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserinfoDaoImpl extends BaseDao implements UserinfoDao {

    @Override
    public List<Userinfo> all(String loginName) {
        List<Userinfo> list= new ArrayList<>();
        ResultSet rs=null;
        String sql="select * from users ";
        if (loginName!=null && !loginName.equalsIgnoreCase("")){
            sql=sql+"where uname like ? ";
            Object[] objs={"%"+loginName+"%"};
            rs=this.search(sql,objs);
        }else {
            rs=this.search(sql);
        }
        Userinfo userinfo=null;
        try {
            while (rs.next()){
                userinfo=new Userinfo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8));
                list.add(userinfo);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            this.closeResource();
        }
        return list;
    }

    @Override
    public int addUserinfo(Userinfo userinfo) {
        String sql="insert into users(uname,upwd,usex,ubirth,utel,uadd,utype) values(?,?,?,?,?,?,?)";
        Object[] objs={userinfo.getUname(),userinfo.getUpwd(),userinfo.getUsex(),userinfo.getUbirth(),userinfo.getUtel(),userinfo.getUadd(),userinfo.getUtype()};
        return this.update(sql,objs);
    }

    @Override
    public int updateUserinfo(Userinfo userinfo) {
        String sql="update users set uname=? ,upwd= ? ,usex= ?,ubirth= ?,utel= ?,uadd= ?,utype= ? where uname = ?";
        Object[] objs={userinfo.getUname(),userinfo.getUpwd(),userinfo.getUsex(),userinfo.getUbirth(),userinfo.getUtel(),userinfo.getUadd(),userinfo.getUtype()};
        return this.update(sql,objs);
    }

    @Override
    public int delUserinfo(int userId) {
        String sql="delete from users where userid = ?";
        Object[] objs={userId};
        return this.update(sql,objs);
    }

    @Override
    public Userinfo getUserinfo(int userId) {
        String sql="select * from users where userid = ? ";
        Object[] objs={userId};
        ResultSet rs=this.search(sql,objs);
        Userinfo userinfo=null;
        try {
            while (rs.next()){
                userinfo=new Userinfo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            this.closeResource();
        }
        return userinfo;
    }

    @Override
    public Userinfo getUserinfoName(String loginName) {
        String sql="select * from users where uname = ? ";
        Object[] objs={loginName};
        ResultSet rs=this.search(sql,objs);
        Userinfo userinfo=null;
        try {
            while (rs.next()){
                userinfo=new Userinfo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            this.closeResource();
        }
        return userinfo;
    }


    }

