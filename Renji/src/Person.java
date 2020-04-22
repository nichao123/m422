import java.util.Scanner;

public class Person {
    String name;
    int score;
    public int  showFist(){
        System.out.print("请出拳：1.剪刀 2.石头 3.布（输入相应数字）");
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();
        switch(i){
            case 1:
                System.out.println("你出拳： 剪刀");
                break;
            case 2:
                System.out.println("你出拳： 石头");
                break;
            case 3:
                System.out.println("你出拳： 布");
                break;
        }
        return i;
    }

}
