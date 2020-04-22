import java.util.Scanner;

public class Game {
    Person a;
    Computer b;
    int count;
    public void initial(){//初始化方法
        a= new Person();
        b = new Computer();
        count = 0;
    }
    public void StartGame(){
        Scanner input = new Scanner(System.in);
        System.out.println("-----------欢迎进入游戏世界------------");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("\t\t\t**********************");
        System.out.println("\t\t\t******猜拳,开始********");
        System.out.println("\t\t\t**********************");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("出拳规则：1.剪刀 2.石头 3.布");
        System.out.println("请输入你的姓名：");
        String Playname = input.next();//玩家姓名！！
        System.out.println("请选择对方角色(1.刘备 2.孙权 3.曹操)");
        int f = input.nextInt();
        String Computername = "";
        switch(f){
            case 1:
                Computername = "刘备";
                break;
            case 2:
                Computername = "孙权";
                break;
            case 3:
                Computername = "曹操";
                break;
        }
        System.out.println("您选择了" +Computername +"对战" );
        System.out.println(" ");
        System.out.println("要开始吗？(y/n)");
        String con = input.next();
        int m;
        int n;
        int x = 0;
        int y = 0;
        int z = 0;
        String can;
        if (con.equals("y")){
            do{
                m=a.showFist();
                n=b.showtwo();
                if ((m==1&&n==1)||(m==2&&n==2)||(m==3&&n==3)){
                    System.out.println("结果：和局，真衰！！");
                    x++;
                }else if ((m==1&&n==2)||(m==2&&n==3)||(m==3&&n==1)){
                    System.out.println("结果：恭喜你，你赢了！！");
                    y++;
                }else if ((m==1&&n==3)||(m==2&&n==1)||(m==3&&n==2)){
                    System.out.println("结果：^_^ 你输了，真笨！！");
                    z++;
                }
                System.out.println("是否开始下一局？(y/n)");
                can = input.next();
                count++;
            }while(can.equals("y"));
        }//此处留有游戏及时退出出口！！
        System.out.println("--------------------------------------------------");
        System.out.println(Computername+"   vs   "+Playname );
        System.out.println("对战次数：  " + count);
        System.out.println("结果：   胜  "+ y +"局   负  " + z + "局    平  " + x + "局");

    }

}