package org.nichao;

import java.sql.*;

public class PreparedStatementData {
    //1、查询所有的信息;
    public void allStudent2() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school?useSSL=false&serverTimezone=UTC", "root", "2262nichao");
            Statement st = con.createStatement();
            String sql = "SELECT *from subject";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3)
                        + "\t" + rs.getInt(4));
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

    public void loginAll(String name) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school?useSSL=false&serverTimezone=UTC", "root", "2262nichao");

            String sql = "SELECT * from `subject` WHERE SubjectName like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,"%"+name+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1)+ "\t" + rs.getString(2)
                        + "\t" + rs.getInt(3)+ "\t" + rs.getInt(4));
            }
            ps.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void add(int subjectId,String name,int classhour,int gradeId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school?useSSL=false&serverTimezone=UTC", "root", "2262nichao");
            String sql = "INSERT  INTO `subject`(`SubjectId`,`SubjectName`,`ClassHour`,`GradeId`)VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, subjectId);
            ps.setString(2, name);
            ps.setInt(3, classhour);
            ps.setInt(4, gradeId);
            int count = ps.executeUpdate();
            ps.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void change(int subjectId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school?useSSL=false&serverTimezone=UTC", "root", "2262nichao");
            String sql = "UPDATE subject set SubjectName='html5',ClassHour=5,GradeId=2 where SubjectId=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, subjectId);
            int count = ps.executeUpdate();
            ps.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(int subjectId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school?useSSL=false&serverTimezone=UTC", "root", "2262nichao");
            String sql = "DELETE from subject where SubjectId=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, subjectId);
            int count = ps.executeUpdate();
            ps.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
