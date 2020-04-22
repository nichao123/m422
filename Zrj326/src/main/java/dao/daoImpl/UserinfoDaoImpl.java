package Zrj326.src.main.java.dao.daoImpl;

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
        String sql="select * from userinfo ";
        if (loginName!=null && !loginName.equalsIgnoreCase("")){
            sql=sql+"where loginname like ? ";
            Object[] objs={"%"+loginName+"%"};
            rs=this.search(sql,objs);
        }else {
            rs=this.search(sql);
        }
        Userinfo userinfo=null;
        try {
            while (rs.next()){
                userinfo=new Userinfo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7));
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
        String sql="insert into userinfo(loginname,loginpass,phone,realname) values(?,?,?,?)";
        Object[] objs={userinfo.getLoginName(),userinfo.getLoginPass(),userinfo.getPhone(),userinfo.getRealname()};
        return this.update(sql,objs);
    }

    @Override
    public int updateUserinfo(Userinfo userinfo) {
        String sql="update userinfo set realname=? ,loginpass= ? ,phone= ? where loginName = ?";
        Object[] objs={userinfo.getRealname(),userinfo.getLoginPass(),userinfo.getPhone(),userinfo.getLoginName()};
        return this.update(sql,objs);
    }

    @Override
    public int delUserinfo(int userId) {
        String sql="delete from userinfo where userid = ?";
        Object[] objs={userId};
        return this.update(sql,objs);
    }

    @Override
    public Userinfo getUserinfo(int userId) {
        String sql="select * from userinfo where userId = ? ";
        Object[] objs={userId};
        ResultSet rs=this.search(sql,objs);
        Userinfo userinfo=null;
        try {
            while (rs.next()){
                userinfo=new Userinfo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7));
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
        String sql="select * from userinfo where loginName = ? ";
        Object[] objs={loginName};
        ResultSet rs=this.search(sql,objs);
        Userinfo userinfo=null;
        try {
            while (rs.next()){
                userinfo=new Userinfo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            this.closeResource();
        }
        return userinfo;
    }

    @Override
    public int setAmount(Userinfo userinfo) {
        String sql="update userinfo set amount=? where loginName = ?";
        Object[] objs={userinfo.getAmount(),userinfo.getLoginName()};
        return this.update(sql,objs);
    }
}
