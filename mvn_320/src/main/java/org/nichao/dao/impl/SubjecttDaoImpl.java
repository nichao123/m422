package org.nichao.dao.impl;

import org.nichao.dao.SubjectDao;
import org.nichao.entity.Subject;
import org.nichao.util.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SubjecttDaoImpl extends BaseDao implements SubjectDao {
    @Override
    public List<Subject> all(String name) {
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
        String sql = "insert into subject(SubjectName,ClassHour,GradeID) values(?,?,?)";
        //参数
        Object[] objs = {subject.getSubjectName(), subject.getClassHour(), subject.getGradeID()};

        return this.executeUpdate(sql, objs);
    }

    @Override
    public int updateSubject(Subject subject) {
        String sql = "update subject set SubjectName=?,ClassHour=?,GradeID=? where subjectID=?";
        //参数
        Object[] objs = {subject.getSubjectName(), subject.getClassHour(), subject.getGradeID(), subject.getSubjectID()};

        return this.executeUpdate(sql, objs);

    }

    @Override
    public int delSubject(int id) {
        String sql = "delete from subject where subjectID=?";

        Object[] objs = {id};

        return this.executeUpdate(sql, objs);
    }

    @Override
    public Subject getSubject(int id) {
        //sql
        String sql="select * from subject where subjectID=?";

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
