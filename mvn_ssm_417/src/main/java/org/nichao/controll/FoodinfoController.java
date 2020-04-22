package org.nichao.controll;

import com.github.pagehelper.PageInfo;
import org.apache.commons.io.FileUtils;
import org.nichao.pojo.Foodinfo;
import org.nichao.pojo.Parames;
import org.nichao.service.FoodrinfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName UserinfoController
 * @Description: TODO
 * @Author 44401
 * @Date 2020/4/15
 * @Version V1.0
 **/
@Controller
public class FoodinfoController {

    //业务数据
    @Resource
    private FoodrinfoService foodrinfoService;

    //list0.jsp
//    @RequestMapping("/list")
//    public String list(ModelMap map){
//
//        //业务方法
//        List<Userinfo> list= userinfoService.all();
//
//        //保存数据
//        map.addAttribute("list",list);
//
//        //转发
//        return "list";  //list.jsp
//    }


    @RequestMapping("/find")
    public String find(ModelMap map,int foodId){

        //业务方法
        Foodinfo list= foodrinfoService.findById(foodId);

        //保存数据
        map.addAttribute("food",list);

        //转发
        return "find";  //find.jsp
    }



    @RequestMapping("/edit")
    public String edit(ModelMap map,int foodId){

        //业务方法
        Foodinfo list= foodrinfoService.findById(foodId);

        //保存数据
        map.addAttribute("food",list);

        //转发
        return "update";  //update.jsp
    }



    @RequestMapping("/add")
    public String add(Foodinfo foodinfo){
        //业务方法
        int count= foodrinfoService.insert(foodinfo);
        //转发
        return "redirect:/list";  //直接跳转到list
    }


    @RequestMapping("/update")
    public String update(Foodinfo foodinfo){
        //业务方法
        int count= foodrinfoService.update(foodinfo);
        //转发
        return "redirect:/list";  //直接跳转到list
    }


    @RequestMapping("/del")
    public String del(int foodId){
        //业务方法
        int count= foodrinfoService.delete(foodId);
        //转发
        return "redirect:/list";  //直接跳转到list
    }


    //list1.jsp
//    @RequestMapping("/list")
//    public String list(ModelMap map,Parames parame){
//
//        //业务方法
//        PageInfo<Userinfo> pageInfo= userinfoService.getPageInfo(parame);
//
//        //保存数据
//        map.addAttribute("pageInfo",pageInfo);
//
//        //转发
//        return "list";  //list.jsp
//    }


    @RequestMapping("/list")
    public String list(ModelMap map, Parames parame, Foodinfo foodinfo){

        //业务方法
        PageInfo<Foodinfo> pageInfo= foodrinfoService.findName(foodinfo,parame);

        //保存数据
        map.addAttribute("pageInfo",pageInfo);

        //用户数据
        map.addAttribute("foodinfo",foodinfo);

        //转发
        return "list";  //list.jsp
    }
    //produces处理json的乱码
    @RequestMapping(value = "/add2",produces ="text/html;charset=utf-8")
    @ResponseBody
    public String add(@RequestParam("file") CommonsMultipartFile partFile, Foodinfo foodinfo, HttpServletRequest request ){
        //服务器路径
//        String path = request.getServletContext().getRealPath("/upload");
        String path ="d:/myupload";
        //
        // System.out.println("path="+path);

        //文件名
        String filename =partFile.getOriginalFilename();
        //System.out.println("filename="+filename);

        //拼接路径
        File file = new File(path+"/"+filename);
        //System.out.println("file=>"+file);

        //文件输入流
        try (InputStream inputStream = partFile.getInputStream()){
            //文件的拷贝
            FileUtils.copyInputStreamToFile(inputStream, file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //设置一下文件图片路径
        foodinfo.setFoodImage(filename);

        //业务方法
        int count= foodrinfoService.insert(foodinfo);

        //json
        return "文件上传成功！";
    }


    /**
     * 下载
     * @return
     */
    @RequestMapping(value = "/downs",produces ="text/html;charset=utf-8")
    @ResponseBody
    public String downs(HttpServletRequest request, HttpServletResponse response){

        //下载的路径:
        String path ="d:/myupload";
        //文件对象
        File file=new File(path);
        //获得文件列表
        File[] files= file.listFiles();
        //随机获取一个文件，实际中按需编写代码
        //文件名
        String  fileName = files[0].getName();
        ///////////////
        // System.out.println("文件的名字："+fileName);

        //下载文件头信息必须写的！
        response.addHeader("content-disposition", "attachment;filename="+fileName);
        try {
            //文件拷贝
            FileUtils.copyFile(files[0], response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "下载成功哦！";
    }

}
