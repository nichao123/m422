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
@RequestMapping("/user")
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(ModelMap map, User user) {

        System.out.println(user);
        //判断
        if ("戴洋洋".equals(user.getUname()) && "aaa".equals(user.getUpass())) {
            map.addAttribute("user", user);
            return "welcome";
        } else {
            return "login";
        }
    }


//    @RequestMapping(value = "/login5", method = RequestMethod.POST)
    @RequestMapping(value = "/login5")
    public String login5(@ModelAttribute("userinfo") User user) {
        System.out.println(user);
        //判断
        if ("戴洋洋".equals(user.getUname()) && "aaa".equals(user.getUpass())) {
            return "welcome";
        } else {
//            return "login";
            //某一个控制器中的处理方法中;
//            return "forward:/user/show";
//            return "redirect:/user/show";
//            return "redirect:http://www.baidu.com";

//            转发到一个静态资源
//            return "forward:/html/index.html";

            return "json1";
        }
    }


    @RequestMapping("/show")
    public String show() {
        System.out.println("show()");
        return "show";
    }

    @RequestMapping(value = "/login2", method = RequestMethod.POST)
    public String login2(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        //请求参数
        String name = request.getParameter("uname");
        String pwd = request.getParameter("upass");

        //判断
        if ("戴洋洋".equals(name) && "aaa".equals(pwd)) {
            session.setAttribute("name", name);  //保存数据
            return "welcome";
        } else {
            return "login";
        }
    }


    @RequestMapping(value = "/login3/{uname}/{upass}")
    public String login3(@PathVariable("uname") String name, @PathVariable("upass") String pwd) {

        //判断
        if ("戴洋洋".equals(name) && "aaa".equals(pwd)) {
            return "welcome";
        } else {
            return "login";
        }
    }


    @RequestMapping(value = "/login4")
    public String login4(@RequestParam("uname1") String name, @RequestParam("upass") String pwd) {

        //判断
        if ("戴洋洋".equals(name) && "aaa".equals(pwd)) {
            return "welcome";
        } else {
            return "login";
        }
    }


    @RequestMapping("/json1")
    @ResponseBody
    public String josn1(User user) {
        System.out.println(user);

        // 返回JSON格式的响应
        return user.toString();
    }

}
