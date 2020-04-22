package org.hlx;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.sql.*;
import java.util.Scanner;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
//       StatementData.login(120,"JS");
//       StatementData.loginPs(20,"JS");

//        StatementData.addSubject("jquery",40,3);

          StatementData.allSubject("");
//        StatementData.allSubject("数据");
    }


    @Test
    public void testCon(){
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            //2.获得连接对象
            //jdbc:mysql://localhost(本机):3306(数据库端口号)/myschool(数据库名);  user用户名 ； password密码；
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myschool?useSSL=false&serverTimezone=UTC","root","root");

            System.out.println(con);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 查询方法: executeQuery();
     */
    @Test
    public void allSubject(){
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            //2.获得连接对象
            //jdbc:mysql://localhost(本机):3306(数据库端口号)/myschool(数据库名);  user用户名 ； password密码；
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myschool?useSSL=false&serverTimezone=UTC","root","root");

            //3.Statement对象
            Statement st = con.createStatement();

            //4.sql语句
            String sql="select * from subject";

            //5.执行SQL
            ResultSet rs= st.executeQuery(sql);
            //6.遍历
            //rs.next() 光标往下走；
            while(rs.next()){
                //(1)列的编号1,2,3....
                //getInt对应的数据列类型
//                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4));

                //(2)列的名称
                System.out.println(rs.getInt("SubjectNo")+"\t"+rs.getString("SubjectName")+"\t"+rs.getInt("ClassHour")+"\t"+rs.getInt("GradeID"));
            }

            //7.关闭
            rs.close();
            st.close();
            con.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加，删除，修改 调用的方法 executeUpdate（）；
     */
    @Test
    public void addSubject(){
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            //2.获得连接对象
            //jdbc:mysql://localhost(本机):3306(数据库端口号)/myschool(数据库名);  user用户名 ； password密码；
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myschool?useSSL=false&serverTimezone=UTC","root","root");

            //3.Statement对象
            Statement st = con.createStatement();

            //4.sql语句(请你在MySQL中写好了，复制过来！)
//            String sql="insert into subject(SubjectName,ClassHour,GradeID) values('HTML5',45,1)";
//            String sql="update subject set SubjectName='JS',ClassHour=35,GradeID=3 where subjectNo=20";
              String sql="delete from subject where subjectNo=19";

             //5.执行
            int count = st.executeUpdate(sql);

            System.out.println(count);

            //关闭
            st.close();
            con.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
