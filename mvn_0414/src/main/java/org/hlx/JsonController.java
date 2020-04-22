package org.hlx;

import org.hlx.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName LoginController
 * @Description: TODO
 * @Author 44401
 * @Date 2020/4/14
 * @Version V1.0
 **/
@Controller
public class JsonController {

    @RequestMapping(value = "/myjson")
    @ResponseBody  //返回json
    public User myjson(@RequestBody User user) {
        System.out.println(user);

        // 返回JSON格式的响应
        return user;
    }




}
