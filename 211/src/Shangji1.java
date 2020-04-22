import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shangji1 {
    public static void main(String[] args) {
        List list=new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("未排序前：");
        for (Object obj:
                list) {
            System.out.print(obj+" ");
        }
        System.out.println();
        //Java使用Collections.reverse()反转一个List
        System.out.println("反转后：");
        Collections.reverse(list);
        for (Object obj:
                list) {
            System.out.print(obj+" ");
        }
        System.out.println();
        //java.util.Collections.swap()方法（交换数据）
        Collections.swap(list,0,4);
        System.out.println("交换后：");
        for (Object obj:
                list) {
            System.out.print(obj+" ");
        }
        //fill填充
        System.out.println();
        System.out.println("填充后：");
        Collections.fill(list,6);
        for (Object obj:
                list) {
            System.out.print(obj+" ");
        }
        //copy拷贝
        List list1=new ArrayList();
        Collections.addAll(list1,new Object[list.size()]);
        Collections.copy(list1,list);
        System.out.println();
        System.out.println("复制后的集合的元素是"+list1);
    }
}
