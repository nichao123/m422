package 徐晨阳.Text.src;

import java.util.Arrays;
import java.util.Scanner;

public class Text2 {
    //编号0032，输入10个整型数据，找出其中的最大值并显示出来。


    //判断并返回最大值，有参有返回
    public int max(int number[]) {
        int max = number[0];
        for (int i = 1; i < number.length; i++) {
            if (max < number[i]) {
                max = number[i];
            }
        }
        return max;
    }


    public double avg(int number[]) {
        double numberavg = 0;
        for (int i = 0; i < number.length; i++) {
            numberavg += number[i];
        }
        numberavg = numberavg / 10;
        return numberavg;
    }

    public int[] sort(int number[]) {
        Arrays.sort(number);
        return number;
    }

    public int min(int number[]) {
        int min = number[0];
        for (int i = 1; i < number.length; i++) {
            if (min > number[i]) {
                min = number[i];
            }
        }
        return min;
    }

}

class Text {
    public static void main(String[] args) {
        int number[] = new int[10];
        Scanner scanner = new Scanner(System.in);
        //创建对象
        Text2 text2 = new Text2();

//循环输出
        for (int i = 0; i < number.length; i++) {
            System.out.print("请输入数字：");
            number[i] = scanner.nextInt();
        }
        System.out.println("最大的数字是：" + text2.max(number));
        System.out.println("平均值为：" + text2.avg(number));
        for (int a : text2.sort(number)
        ) {
            System.out.print(a + "\t");
        }

        int[] number5 = new int[5];
        for (int i = 0; i < number5.length; i++) {
            System.out.print("请输入数字：");
            number5[i] = scanner.nextInt();
        }
        System.out.println("最小值是：" + text2.min(number5));
    }


}

