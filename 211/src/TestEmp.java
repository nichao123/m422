import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestEmp {
    public static void main(String[] args) {
        //（2）创建主运行类，实例化List对象，并添加三个Emp对象；
        Emp emp1=new Emp(10,"mike",18);
        Emp emp2=new Emp(3,"jack",20);
        Emp emp3=new Emp(6,"heihei",19);
        List<Emp> list=new ArrayList<>();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        System.out.println("未排序：");
        for (Emp ee:
             list) {
            System.out.println(ee);
        }
        //调用Collections类的sort方法对Emp按照升序排序，因为Collections类提供的都是静态方法，因此可以不用实例化，而通过类名直接调用sort方法。
        System.out.println("根据id大小升序后：");
        Collections.sort(list);
        for (Emp ee:
                list) {
            System.out.println(ee);
        }

    }
}
