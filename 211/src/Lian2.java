import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lian2 {
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
    }
}
