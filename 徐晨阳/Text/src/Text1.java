package 徐晨阳.Text.src;

import java.util.Scanner;

public class Text1 {
    //    //
//    编号0031，要求：从键盘输入x的值，计算并打印下列分段函数的值。
//    y=0(x<60)
//    y=1(60<=x<70)
//    y=2(70<=x<80)
//    y=3(80<=x<90)
//    y=4(x>=90)


    //判断输出，有参有返回
    public int showy(int x) {
        int y = -1;
        if (x < 60) {
            y = 0;
        } else if (x >= 60 && x < 70) {
            y = 1;
        } else if (x >= 70 && x < 80) {
            y = 2;
        } else if (x >= 80 && x < 90) {
            y = 3;
        } else if (x >= 90) {
            y = 4;
        }

        return y;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //创建对象
        Text1 text1 = new Text1();
        //输入
        System.out.println("请输入一个数字");

//调用方法，有参无返回
        System.out.println("y="+text1.showy(scanner.nextInt()));

    }
}


