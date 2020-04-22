package org.hlx;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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
public class HelloController {

    /**
     *   @RequestMapping：作用是映射路径url
     * @return
     */
    @RequestMapping(value = "/helloworld",method = RequestMethod.GET)
    public String helloworld(Model model, ModelMap map){
        System.out.println("helloworld()!!");
        //保存数据
        model.addAttribute("msg","TestSpringMVC");
        map.addAttribute("uname","戴一阳");

        return "show";     //跳转页面 prefix+show+suffix =》/show.jsp
    }

    /**
     * 表单提交默认是GET，但如果要用POST，必须是表单！！！
     *  RequestMethod.POST ()
     *  发生异常： HTTP Status 405 – Method Not Allowed
     * @return
     * 一般请求的映射路径名称login和处理请求的方法名称login()最好一致
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        System.out.println("login()!!");
        return "show";      //跳转页面 prefix+show+suffix =》/show.jsp
    }


    @RequestMapping(value = "/my",method = RequestMethod.GET)
    public ModelAndView my(){
        //视图模型对象
        ModelAndView  view =new ModelAndView("my");

        //保存数据
        view.addObject("addr","杭州市");

        return view;      //跳转页面 prefix+show+suffix =》/show.jsp
    }
}
