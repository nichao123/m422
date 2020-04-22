package org.nichao;

import org.nichao.Counts;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * @ClassName User
 * @Description: TODO
 * @Author 44401
 * @Date 2020/3/24
 * @Version V1.0
 *  实体类用户监听
 **/
public class User  implements HttpSessionBindingListener {
    private String userName;

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        Counts.count++;
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        Counts.count--;
    }
}
