package org.nichao;

import java.sql.*;

public class StatementData {

    //查询姓王的学生信息查询姓王的学生信息
    public void allStudent1() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school?useSSL=false&serverTimezone=UTC", "root", "2262nichao");
            Statement st = con.createStatement();
            String sql = "SELECT StudentName from student where StudentName LIKE 'niu%'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            rs.close();
            st.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //1、查询所有的信息;
    public void allStudent2() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school?useSSL=false&serverTimezone=UTC", "root", "2262nichao");
            Statement st = con.createStatement();
            String sql = "SELECT *from student";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3)
                        + "\t" + rs.getString(4) + "\t" + rs.getInt(5) + "\t" + rs.getString(6)
                        + "\t" + rs.getString(7) + "\t" + rs.getString(8) + "\t" + rs.getString(9));
            }
            rs.close();
            st.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //2、添加一条自己的信息
    public void add() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school?useSSL=false&serverTimezone=UTC", "root", "2262nichao");
            Statement st = con.createStatement();
            String sql = "INSERT  INTO `student`(`StudentNo`,`LoginPwd`,`StudentName`,`Sex`,`GradeId`,`Phone`,`Address`,`BornDate`,`Email`) " +
                    "VALUES (117007,'457','李四','男',1,'13911585601','解放路','2013-01-18 00:00:00','www.qq1@.com')";
            int count = st.executeUpdate(sql);

            st.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void change() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school?useSSL=false&serverTimezone=UTC", "root", "2262nichao");
            Statement st = con.createStatement();
            String sql = "UPDATE student set LoginPwd='00000',GradeId=2,Phone='13004568976',Address='杭州市' where StudentNo=100014";
            int count = st.executeUpdate(sql);

            st.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school?useSSL=false&serverTimezone=UTC", "root", "2262nichao");
            Statement st = con.createStatement();
            String sql = "DELETE from student where StudentNo=117006";
            int count = st.executeUpdate(sql);

            st.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
