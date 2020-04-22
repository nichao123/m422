package org.hlx.util;


import java.sql.*;

/**
 * @ClassName BaseDao
 * @Description: TODO
 * @Author 44401
 * @Date 2020/3/15
 * @Version V1.0
 **/
public class BaseDao0 {
    //具体对象
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    // 获取数据库连接
    public boolean getConnection() {
        // 读出配置信息
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/myschool?useSSL=false&serverTimezone=UTC";
        String username="root";
        String password="root";
        // 加载JDBC驱动
        try {
            Class.forName(driver);
            // 与数据库建立连接
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     *
     * @param sql
     * @param params  可变数组
     * @return
     */
    // 增删改
    public int executeUpdate(String sql, Object... params) {
        int row = 0;
        //连接判断
        if(getConnection()){
            try {
                //ps对象
                ps=conn.prepareStatement(sql);
                //填充占位符
                for(int i=0;i<params.length;i++){
                    ps.setObject(i+1, params[i]);
                }
//                执行
                row=ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                //关闭
                this.closeResource();
            }
        }
        return row;
    }

    // 查询
    public ResultSet executeSQL(String sql,Object...params) {
        //连接判断
        if(getConnection()){
            try {
                ps=conn.prepareStatement(sql);
                //填充占位符
                for(int i=0;i<params.length;i++){
                    ps.setObject(i+1, params[i]);
                }
                //返回结果集
                rs=ps.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rs;
    }

    // 关闭资源（由里到外关闭）
    public boolean closeResource() {
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

}
