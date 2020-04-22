package org.hlx;

import static org.junit.Assert.assertTrue;

import org.hlx.dao.SubjectDao;
import org.hlx.dao.impl.SubjectDaoImpl;
import org.hlx.entity.Subject;
import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    //底层数据对象
    SubjectDao dao =new SubjectDaoImpl();

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


    @Test
    public void findById()
    {
           Subject sub = dao.getSubject(20);

            System.out.println(sub);

    }


    @Test
public void save()
{
    int count= dao.addSubject(new Subject("junit",8,2));

    System.out.println(count);

    //
    find();

}


    @Test
public void udpate()
{
    int count= dao.updateSubject(new Subject(23,"单元测试",81,3));

    System.out.println(count);

    //
    find();

}

    @Test
    public void del()
    {
        int count= dao.delSubject(23);

        System.out.println(count);

        //
        find();

    }
}
