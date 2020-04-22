package org.nichao.dao;

import org.nichao.entity.Student;

import java.util.List;

public interface StudentDao {
    List<Student> all(String name);
    int addStudent(Student student);
    int updateStudent(Student student);
    int delStudent(int id);

    //获得一条信息
    Student getStudent(int id);
}
