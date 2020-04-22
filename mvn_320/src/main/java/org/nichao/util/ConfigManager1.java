package org.nichao.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassName ConfigManager
 * @Description: TODO
 * @Author 44401
 * @Date 2020/3/15
 * @Version V1.0
 **/
public class ConfigManager1 {
    //静态
    private static ConfigManager1 configManager;

    //    读取属性文件
    private static Properties properties;

//    private String fileName = "Resources/db.properties";

    private String fileName = "db.properties";

    //0.私有的构造方法  ==>不能实例化？
    private ConfigManager1() {

        //实例化对象
        properties = new Properties();

        //获得输入流
        InputStream is = ConfigManager1.class.getClassLoader().getResourceAsStream(fileName);
        try {
            //加载文件
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    //1.通过静态实例  （单例模式）运行时，只能有一个实例
    // 懒汉模式: 解决安全问题
    public static synchronized ConfigManager1 getInstance() {
       if (configManager == null) {
            configManager = new ConfigManager1();
        }
        return configManager;
    }





    //2.通过key返回值
    public static String getString(String key) {
        return properties.getProperty(key);
}

}
