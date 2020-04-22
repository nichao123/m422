package Zrj326.src.main.java;

import pojo.Userinfo;
import service.UserinfoService;
import service.serviceImpl.UserinfoServiceImpl;

import java.util.List;

public class Text {
    public static void main(String[] args) {
        UserinfoService userinfoService=new UserinfoServiceImpl();
//        userinfoService.addUserinfo(new Userinfo("zzz","123","12345678910","张任捷"));
//        userinfoService.delUserinfo(17);
//        userinfoService.updateUserinfo(new Userinfo("zsz","123","12345678910","张任捷"));
        System.out.println(userinfoService.getUserinfoName("zzz"));
//        List<Userinfo> list=userinfoService.all("");
//        for (Userinfo u:
//             list) {
//            System.out.println(u);
//        }
    }
}
