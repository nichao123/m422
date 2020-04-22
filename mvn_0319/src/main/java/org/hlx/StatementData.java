package org.hlx;

import java.sql.*;
import java.util.Scanner;

/**
 * @ClassName StatementData
 * @Description: TODO
 * @Author 44401
 * @Date 2020/3/19
 * @Version V1.0
 **/
public class StatementData {


    public static void allSubject(String name) {
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            //2.获得连接对象
            //jdbc:mysql://localhost(本机):3306(数据库端口号)/myschool(数据库名);  user用户名 ； password密码；
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myschool?useSSL=false&serverTimezone=UTC", "root", "root");

            //4.sql语句
            StringBuilder sql = new StringBuilder("select * from subject");

            //3.ps对象
            PreparedStatement ps = null;

            //判断
            if (name != null && !name.equalsIgnoreCase("")) {
                //追加sql
                sql.append(" where subjectName like ?");
                ps = con.prepareStatement(sql.toString());
                //?参数值
                ps.setString(1, "%" + name + "%");

            } else {
                ps= con.prepareStatement(sql.toString());
            }

            //5.执行SQL
            ResultSet rs = ps.executeQuery();
            //6.遍历
            //rs.next() 光标往下走；
            while (rs.next()) {
                //(1)列的编号1,2,3....
                //getInt对应的数据列类型
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getInt(4));

            }

            //7.关闭
            rs.close();
            ps.close();
            con.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addSubject(String name, int hour, int gid) {
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            //2.获得连接对象
            //jdbc:mysql://localhost(本机):3306(数据库端口号)/myschool(数据库名);  user用户名 ； password密码；
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myschool?useSSL=false&serverTimezone=UTC", "root", "root");

            //.sql语句(请你在MySQL中写好了，复制过来！)
            String sql = "insert into subject(SubjectName,ClassHour,GradeID) values(?,?,?)";

            //3.Statement对象
            PreparedStatement ps = con.prepareStatement(sql);

//           参数
            ps.setString(1, name);
            ps.setInt(2, hour);
            ps.setInt(3, gid);

            //5.执行
            int count = ps.executeUpdate();

            System.out.println(count);

            //关闭
            ps.close();
            con.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询方法: executeQuery();
     */
    public static void login(int id, String name) {
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            //2.获得连接对象
            //jdbc:mysql://localhost(本机):3306(数据库端口号)/myschool(数据库名);  user用户名 ； password密码；
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myschool?useSSL=false&serverTimezone=UTC", "root", "root");

            //3.Statement对象
            Statement st = con.createStatement();

            //4.sql语句  (安全性问题！) 如何解决? PreparedStatement预编译对象;
            String sql = "select count(1) from subject where subjectno=" + id + " and subjectname='" + name + "' or '1'='1'";

            //5.执行SQL
            ResultSet rs = st.executeQuery(sql);
            //6.遍历
            //rs.next() 光标往下走；
            rs.next();

            //获得当前的值
            int count = rs.getInt(1);

            if (count > 0) {
                System.out.println("登录成功!");
            } else {
                System.out.println("登录失败!");
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
     * @param id
     * @param name
     */
    public static void loginPs(int id, String name) {
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            //2.获得连接对象
            //jdbc:mysql://localhost(本机):3306(数据库端口号)/myschool(数据库名);  user用户名 ； password密码；
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myschool?useSSL=false&serverTimezone=UTC", "root", "root");

            //3.Statement对象
//            Statement st = con.createStatement();

            //////////////////////////////////////////////////////////////////
            //sql语句  (安全性问题！) 如何解决? PreparedStatement预编译对象;
            String sql = "select count(1) from subject where subjectno=? and subjectname=?";

            //3.获得ps对象
            PreparedStatement ps = con.prepareStatement(sql);

            //？占位符 ，对应赋值
            ps.setInt(1, id);
            ps.setString(2, name);


            //5.执行SQL
            ResultSet rs = ps.executeQuery();

            //////////////////////////////////////////////

            //6.遍历
            //rs.next() 光标往下走；
            rs.next();

            //获得当前的值
            int count = rs.getInt(1);

            if (count > 0) {
                System.out.println("登录成功!");
            } else {
                System.out.println("登录失败!");
            }


            //7.关闭
            rs.close();
            ps.close();
            con.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
