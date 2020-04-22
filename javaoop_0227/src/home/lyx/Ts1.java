package javaoop_0227.src.home.lyx;

//练习1：显示手机品牌型号
//        需求说明：显示“phone.xml”文件中收藏的手机品牌和型号
//
//        练习2：在练习1的基础上扩展添加，删除，修改收藏的手机品牌和型号到xml文件中
public class Ts1 {
    public static void main(String[] args) {
        PhoneBiz biz = new PhoneBiz();
        biz.show();

//        Phone phone = new Phone("小米", "小米10");
//        biz.add(phone);
//        biz.show();
//
//
//        biz.delete("华为");
//        biz.show();
//
        Phone phone1 = new Phone("小米", "小米2");
        biz.change(phone1);
        biz.show();
    }
}
