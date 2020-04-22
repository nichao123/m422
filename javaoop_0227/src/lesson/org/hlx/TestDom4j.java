package javaoop_0227.src.lesson.org.hlx;

/**
 * @ClassName TestDom4j
 * @Description: TODO
 * @Author 44401
 * @Date 2020/2/27
 * @Version V1.0
 **/
public class TestDom4j {
    public static void main(String[] args) {
         StudentBiz biz = new StudentBiz();
         biz.show();

//         Student student =new Student("mike","08",20);
//         biz.add(student);
//         biz.show();

        biz.del("05");
//        biz.show();


         Student student =new Student("曼克","08",18);
         biz.update(student);
         biz.show();
    }
}
