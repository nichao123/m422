import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lian1 {
    public static void main(String[] args) {
        List list=new ArrayList();
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(7);
        list.add(2);
        System.out.println("未排序前：");
        for (Object obj:
             list) {
            System.out.print(obj+" ");
        }
        //使用Collections的sort()方法升序打印输出集合中所有元素；
        Collections.sort(list);
        System.out.println();
        System.out.println("排序后：");
        for (Object obj:
                list) {
            System.out.print(obj+" ");
        }
        System.out.println();
        //使用Collection的max()方法获得集合中最大的元素；
        System.out.println("最大值是"+Collections.max(list));
        //使用Collections的min()方法获得集合中最小的元素；
        System.out.println("最小值是"+Collections.min(list));
        //使用Collections的binarySearch()方法获取元素的索引；
        System.out.println("4的位置是"+Collections.binarySearch(list,4));
        //使用Collections的reverse()方法降序打印输出集合中所有元素。
        System.out.println("降序后：");
        Collections.reverse(list);
        System.out.println(list);
    }
}
