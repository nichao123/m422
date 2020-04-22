package org.nichao;
import org.junit.Test;
import org.nichao.dao.SubjectDao;
import org.nichao.dao.impl.SubjecttDaoImpl;
import org.nichao.entity.Subject;

import java.util.List;

public class TestP {
    SubjectDao dao =new SubjecttDaoImpl();
    //1、查询课程包含a信息，如果没有参数，就查询所有的信息;
    @Test
    public void find1()
    {
        List<Subject> list = dao.all("a");
        for (Subject sub:
                list ) {
            System.out.println(sub);
        }
    }
    @Test
    public void find()
    {
        List<Subject> list = dao.all("");
//        List<Subject> list = dao.all("数学");
//        List<Subject> list = dao.all("C");
        for (Subject sub:
                list ) {
            System.out.println(sub);
        }
    }
//    2、添加一条信息（JSP2,40,2)
@Test
public void tianjia()
{
    int count= dao.addSubject(new Subject("JSP2",40,2));

    System.out.println(count);

    find();

}


//            3、修改编号4的课程名html6,课时45，年级2；
@Test
public void xiugai()
{
    int count= dao.updateSubject(new Subject(4,"html6",45,2));

    System.out.println(count);


    find();

}
//            4、删除编号3的信息；
@Test
public void delete()
{
    int count= dao.delSubject(3);

    System.out.println(count);


    find();

}
}
