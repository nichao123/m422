package org.hlx.dao.impl;

import org.hlx.dao.StudentDao;
import org.hlx.pojo.Student;

/**
 * @ClassName StudentDaoImpl
 * @Description: TODO
 * @Author 44401
 * @Date 2020/4/8
 * @Version V1.0
 **/
public class StudentDaoImpl implements StudentDao {
    @Override
    public void save(Student student) {
        System.out.println("1-底层数据"+student);
    }
}
