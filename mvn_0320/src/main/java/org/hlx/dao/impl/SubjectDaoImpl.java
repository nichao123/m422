package org.hlx.dao.impl;

import org.hlx.dao.SubjectDao;
import org.hlx.entity.Subject;
import org.hlx.util.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SubjectDaoImpl
 * @Description: TODO
 * @Author 44401
 * @Date 2020/3/20
 * @Version V1.0
 * 实现类=继承Basedao =>实现接口
 **/
public class SubjectDaoImpl extends BaseDao implements SubjectDao {
    @Override
    public List<Subject> all(String name) {
        //集合对象
        List<Subject> list = new ArrayList<>();

        //sql
        StringBuilder sql =new StringBuilder( "select * from subject");

        ResultSet rs =null;
        //判断
        if(name!=null &&  !name.equals("")) {
            sql.append(" where subjectName like ?");
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
                Subject subject =new Subject(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));

                //添加集合
                list.add(subject);

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            this.closeResource(); //关闭数据
        }


        return list;
    }

    @Override
    public int addSubject(Subject subject) {
        //sql语句
        String sql = "insert into subject(SubjectName,ClassHour,GradeID) values(?,?,?)";
        //参数
        Object[] objs = {subject.getSubjectName(), subject.getClassHour(), subject.getGradeID()};

        return this.executeUpdate(sql, objs);
    }

    @Override
    public int updateSubject(Subject subject) {

        //sql语句
        String sql = "update subject set SubjectName=?,ClassHour=?,GradeID=? where subjectNo=?";
        //参数
        Object[] objs = {subject.getSubjectName(), subject.getClassHour(), subject.getGradeID(), subject.getSubjectNo()};

        return this.executeUpdate(sql, objs);

    }

    @Override
    public int delSubject(int id) {
        String sql = "delete from subject where subjectNo=?";

        Object[] objs = {id};

        return this.executeUpdate(sql, objs);
    }

    @Override
    public Subject getSubject(int id) {

        //sql
        String sql="select * from subject where subjectNo=?";

        //parameter
        Object[] objs ={id};

        //调用方法
        ResultSet rs = this.executeSQL(sql,objs);
        Subject subject =null;
        try {
            //遍历数据
            while (rs.next()) {
                //封装对象
               subject =new Subject(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            this.closeResource(); //关闭数据
        }


        return subject;
    }
}
