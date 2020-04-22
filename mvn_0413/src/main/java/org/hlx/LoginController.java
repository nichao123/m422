package org.hlx;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName HelloController
 * @Description: TODO
 * @Author 44401
 * @Date 2020/4/13
 * @Version V1.0
 **/
@Controller     //控制器
@RequestMapping("/user")  //类上
public class LoginController {


    /**
     * 表单提交默认是GET，但如果要用POST，必须是表单！！！
     *  RequestMethod.POST ()
     *  发生异常： HTTP Status 405 – Method Not Allowed
     * @return
     * 一般请求的映射路径名称login和处理请求的方法名称login()最好一致
     */
    @RequestMapping(value = "/backs",method = RequestMethod.GET)
    public String backs(){
        System.out.println("backs.....");
        return "login";      //跳转页面 login.jsp
//        return "redirect:login";
    }


    /**
     * 表单提交的参数名称必须与形式参数名称相同!!
     * @param model
     * @param uname
     * @param upass
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(Model model,String uname,String upass){
        System.out.println(uname);
//        if("dyy".equals(uname) && "aaa".equals(upass)) {
        if("戴一阳".equals(uname) && "aaa".equals(upass)) {
            model.addAttribute("myuname",uname);
            model.addAttribute("myupass",upass);
            return "welcome";      //跳转页面 /show.jsp
        }else{
            return "login";   //跳转页面 /login.jsp
        }
    }


}
