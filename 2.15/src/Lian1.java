import java.util.Scanner;

public class Lian1 {
    //练习1：判断一个字符串是否是对称字符串, 例如"abc"不是对称字符串，"aba"、"abba"、"aaa"、"mnanm"是对称字符串,使用StringBuffer实现这个功能
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        while (true){
            System.out.print("请您输入一个字符串：");
            String shuru=scanner.next();
            StringBuffer s=new StringBuffer(shuru);
            String shuru2=s.reverse().toString();
            if (shuru.equals(shuru2)){
                System.out.println("字符串["+shuru+"]:是");
            }else {
                System.out.println("字符串["+shuru+"]:否");
            }
            System.out.println("是否结束（y/n）");
            String jieshu=scanner.next();
            if (jieshu.equals("y")){
                System.out.println("结束");
                break;
            }

        }
    }
}
