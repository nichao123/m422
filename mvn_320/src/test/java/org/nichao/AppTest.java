package org.nichao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.nichao.dao.StudentDao;
import org.nichao.dao.SubjectDao;
import org.nichao.dao.impl.StudentDaoImpl;
import org.nichao.dao.impl.SubjecttDaoImpl;
import org.nichao.entity.Student;
import org.nichao.entity.Subject;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    StudentDao dao = new StudentDaoImpl();
    @Test
    public void find() {
        List<Student> list = dao.all("");
        for (Student stu :
                list) {
            System.out.println(stu);
        }

    }

    @Test
    public void find1() {
        //1、查询姓王的学生信息，如果没有参数，就查询所有的信息;
        List<Student> list = dao.all("王");
        for (Student stu :
                list) {
            System.out.println(stu);
        }

    }
    //        2、添加一条自己的信息
    @Test
    public void tianjia()
    {
        int count= dao.addStudent(new Student(117008,"789","李四","男",1,"13911585601","解放路","2013-01-18 00:00:00","www.qq1@.com"));

        System.out.println(count);

        find();

    }
    //        3、修改编号100014的学生密码000000，年级2，电话13004568976，地址杭州市；
    @Test
    public void update()
    {
        int count= dao.updateStudent(new Student("050000",2,"13004568976","杭州市",100014));

        System.out.println(count);


        find();

    }
//        4、删除编号117006学生信息；
@Test
public void delete()
{
    int count= dao.delStudent(100001);

    System.out.println(count);


    find();

}

}
