package Test;

import pojo.Userinfo;
import service.UserinfoService;
import service.serviceImpl.UserinfoServiceImpl;

public class TestUser {
    public static void main(String[] args) {
        UserinfoService userinfoService=new UserinfoServiceImpl();
       userinfoService.addUserinfo(new Userinfo("3号","333333","男","1900-11-11","123sasa456789","伤害",3));
//        userinfoService.delUserinfo(3);
//        List<Userinfo> list=userinfoService.all("");
//        for (Userinfo u:
//             list) {
//            System.out.println(u);
//        }
    }
}
