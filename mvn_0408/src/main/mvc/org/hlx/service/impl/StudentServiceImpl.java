package org.hlx.service.impl;

import org.hlx.dao.StudentDao;
import org.hlx.pojo.Student;
import org.hlx.service.StudentService;

/**
 * @ClassName StudentServiceImpl
 * @Description: TODO
 * @Author 44401
 * @Date 2020/4/8
 * @Version V1.0
 * 业务层
 **/
public class StudentServiceImpl implements StudentService {

    //底层数据
    private StudentDao studentDao;

    //必须用set注入////
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void add(Student student) {
        System.out.println("2-业务层调用");
        studentDao.save(student);
    }
}
