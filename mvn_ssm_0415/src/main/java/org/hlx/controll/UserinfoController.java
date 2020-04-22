package mvn_ssm_0415.src.main.java.org.hlx.controll;

import org.hlx.pojo.Userinfo;
import org.hlx.service.UserinfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserinfoController
 * @Description: TODO
 * @Author 44401
 * @Date 2020/4/15
 * @Version V1.0
 **/
@Controller
public class UserinfoController {

    //业务数据
    @Resource
    private UserinfoService userinfoService;

    @RequestMapping("/list")
    public String list(ModelMap map){

        //业务方法
        List<Userinfo> list= userinfoService.all();

        //保存数据
        map.addAttribute("list",list);

        //转发
        return "list";  //list.jsp
    }


    @RequestMapping("/find")
    public String find(ModelMap map,int userId){

        //业务方法
        Userinfo list= userinfoService.findById(userId);

        //保存数据
        map.addAttribute("user",list);

        //转发
        return "find";  //find.jsp
    }


    @RequestMapping("/add")
    public String add(Userinfo userinfo){
        //业务方法
        int count= userinfoService.insert(userinfo);
        //转发
        return "redirect:/list";  //直接跳转到list
    }


    @RequestMapping("/update")
    public String update(Userinfo userinfo){
        //业务方法
        int count= userinfoService.update(userinfo);
        //转发
        return "redirect:/list";  //直接跳转到list
    }


    @RequestMapping("/del")
    public String del(int userId){
        //业务方法
        int count= userinfoService.delete(userId);
        //转发
        return "redirect:/list";  //直接跳转到list
    }

}
