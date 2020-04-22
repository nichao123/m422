package org.hlx;

import org.hlx.util.ConfigManager;
import org.junit.Test;
import sun.security.krb5.Config;

/**
 * @ClassName TestPs
 * @Description: TODO
 * @Author 44401
 * @Date 2020/3/20
 * @Version V1.0
 **/
public class TestPs {

    @Test
    public void test1(){

        //通过配置文件来读取数据
        String driver = ConfigManager.getInstance().getString("mysql.driver");
        String url = ConfigManager.getInstance().getString("mysql.url");
        String username = ConfigManager.getInstance().getString("mysql.username");
        String password = ConfigManager.getInstance().getString("mysql.password");


        System.out.println(driver+"\t"+url+"\t"+username+"\t"+password);
    }
}
