package org.nichao.dao.impl;

import org.nichao.dao.StudentDao;
import org.nichao.entity.Student;
import org.nichao.util.BaseDao0;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl  extends BaseDao0 implements StudentDao {
    @Override
    public List<Student> all(String name) {
        List<Student> list = new ArrayList<>();

        //sql
        StringBuilder sql =new StringBuilder( "select * from student");

        ResultSet rs =null;
        //判断
        if(name!=null &&  !name.equals("")) {
            sql.append(" where studentName like ?");
            //parameter
            Object[] objs ={name+"%"};
            //调用方法
            rs = this.executeSQL(sql.toString(),objs);
        }else{
            rs = this.executeSQL(sql.toString());
        }

        try {
            //遍历数据
            while (rs.next()) {
                //封装对象
                Student student =new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));

                //添加集合
                list.add(student);

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            this.closeResource(); //关闭数据
        }


        return list;
    }



    @Override
    public int addStudent(Student student) {
        //sql语句
        String sql = "INSERT  INTO `student`(`StudentNo`,`LoginPwd`,`StudentName`,`Sex`,`GradeId`,`Phone`,`Address`,`BornDate`,`Email`) VALUES(?,?,?,?,?,?,?,?,?)";
        //参数
        Object[] objs = {student.getStudentNo(),student.getLoginPwd(),student.getStudentName(),student.getSex(),student.getGradeId(),student.getPhone(),student.getAddress(),student.getBornDate(),student.getEmail()};

        return this.executeUpdate(sql, objs);
    }

    @Override
    public int updateStudent(Student student) {

        String sql = "UPDATE student set LoginPwd=?,GradeId=?,Phone=?,Address=? where StudentNo=?";
        //参数
        Object[] objs = {student.getLoginPwd(),student.getGradeId(),student.getPhone(),student.getAddress(),student.getStudentNo()};

        return this.executeUpdate(sql, objs);
    }

    @Override
    public int delStudent(int id) {

        String sql = "DELETE from student where StudentNo=?";
        //参数
        Object[] objs = {id};

        return this.executeUpdate(sql, objs);
    }

    @Override
    public Student getStudent(int id) {
        String sql="select * from student where StudentNo=?";

        //parameter
        Object[] objs ={id};

        //调用方法
        ResultSet rs = this.executeSQL(sql,objs);
        Student student =null;
        try {
            //遍历数据
            while (rs.next()) {
                //封装对象
                student =new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            this.closeResource(); //关闭数据
        }


        return student;
    }
}
