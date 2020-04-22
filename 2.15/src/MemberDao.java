import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//业务类
public class MemberDao {

    Scanner sc = new Scanner(System.in);
    //会员集合
    List<Member> list  = new ArrayList<Member>();
    //开始菜单
    public void menu(){
        System.out.println("****************欢迎登陆超市会员管理系统********************");
        System.out.println("1 积分累计   2 积分兑换    3 积分查询    4 修改密码   5 开卡   6 退出");
        System.out.println("******************************************************");
        System.out.println("请选择：");
    }

    //开始
    public void start(){
        do{
            menu();
            int choose = sc.nextInt();
            switch(choose){
                case 1 :
                    //积分累计
                    if(saveScore()){
                        System.out.println("积分累计成功");
                    }else{
                        System.out.println("积分累计失败");
                    }
                    continue;
                case 2:
                    //积分兑换
                    if(minusScore()){
                        System.out.println("积分兑换成功");
                    }else{
                        System.out.println("积分兑换失败");
                    }
                    continue;
                case 3:
                    //积分查询
                    showScore();
                    continue;
                case 4:
                    //修改密码
                    updatePwd();
                    continue;
                case 5:
                    //开卡
                    register();
                    continue;
                case 6:
                    //退出
                    System.out.println("感谢使用此系统，欢迎下次再用！");
                    break;
                default :
                    System.out.println("您的操作有误，请重新操作！");
                    continue;
            }
            break;
        }while(true);


    }
    //查询当前会员是否存在，根据会员卡号及密码查找该会员是否存在
    //存在返回会员对象 不存在返回null
    public Member hasMember (int id ,String pwd){
        for (Member member:list){
            if(member.getCardId()==id&&(member.getPassWord()).equals(pwd)){
                return member;
            }
        }
        return null;
    }


    //1、积分累计
    public boolean saveScore(){
        boolean flag = true;
        System.out.println("请输入会员卡号：");
        int id = sc.nextInt();
        System.out.println("请输入会员密码：");
        String pwd = sc.next();
        Member member = hasMember(id, pwd);
        if(member!=null){
            System.out.println("请输入您此次消费金额（一元一积分）");
            int score = sc.nextInt();
            member.setScore(member.getScore()+score);
            flag = true;
        }else{
            System.out.println("不好意思、该会员卡号不存在、积分累计失败！");
            flag = false;
        }
        return flag;
    }


    //2、积分兑换
    public boolean minusScore(){
        boolean flag = true;
        System.out.println("请输入会员卡号：");
        int id = sc.nextInt();
        System.out.println("请输入会员密码：");
        String pwd = sc.next();
        Member member = hasMember(id, pwd);
        if(member!=null){
            System.out.println("请输入您此次需要抵消的积分：");
            int score = sc.nextInt();
            if(score<=member.getScore()){
                member.setScore(member.getScore()-score);
                System.out.println("您此次抵消的积分为："+score/100*0.1+"元");
            }else{
                System.out.println("积分不足、不可以积分兑换！");
            }
            flag = true;
        }else{
            System.out.println("不好意思、该会员卡号不存在、积分兑换失败！");
            flag = false;
        }
        return flag;
    }


    //3、积分查询
    public void showScore(){
        System.out.println("请输入会员卡号：");
        int id = sc.nextInt();
        System.out.println("请输入会员密码：");
        String pwd = sc.next();
        Member member = hasMember(id, pwd);
        if(member!=null){
            System.out.println("会员姓名         会员卡号         密码        剩余积分         "
                    + ""
                    + " 开卡日期 ");
            System.out.println(member.getName()+"   "+member.getCardId()+"   "+member.getPassWord()+"   "+member.getScore()+"   "+member.getRegistDate());

        }else{
            System.out.println("不好意思、该会员卡号不存在、积分查询失败！");
        }
    }


    //4、修改密码
    public void updatePwd(){
        System.out.println("请输入会员卡号：");
        int id = sc.nextInt();
        System.out.println("请输入会员密码：");
        String pwd = sc.next();
        Member member = hasMember(id, pwd);
        if(member!=null){
            System.out.println("请输入会员新密码：");
            String againPwd ;
            boolean flag = true;
            do{
                againPwd = sc.next();
                if(againPwd.length()>=6){
                    member.setPassWord(againPwd);
                    flag = true;
                    System.out.println("修改密码成功！");
                }else{
                    System.out.println("密码长度不应该小于6位、请重新输入：");
                    flag = false;
                }
            }while(!flag);
        }else{
            System.out.println("卡号和密码不存在！修改密码失败！！");
        }
    }
    //随机方法
    public int  createId(){
        Random random = new Random();
        int id = random.nextInt(99999999);
        for(Member member : list){
            if(id == member.getCardId()){
                id = random.nextInt(99999999);
            }
        }
        return id;
    }


    //5、开卡
    public void register(){
        Member member = new Member();
        //注册会员姓名
        System.out.println("请注册会员姓名：");
        member.setName(sc.next());
        //生成随机卡号
        int cardId = createId();
        member.setCardId(cardId);

        System.out.println("请输入注册密码：");
        String pwd;
        boolean flag = true;
        do{
            pwd = sc.next();
            if(pwd.length()<6){
                System.out.println("会员密码不能小于6位！请重新输入一个密码：");
                flag = false;
            }else{
                flag = true;
                member.setPassWord(pwd);
            }
        }while(!flag);
        //每张卡开卡后默认赠送100积分
        member.setScore(100);
        //开卡日期
        Date date = new Date();
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-mm-dd");
        String sdate = formater.format(date);
        member.setRegistDate(sdate);
        list.add(member);
        System.out.println("恭喜！会员开卡成功！系统赠送您100积分！您的会员卡号是："+cardId);

    }
}

