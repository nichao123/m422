package javaoop_0227.src.home.lyx;

public class Ts2 {
    public static void main(String[] args) {
        Bookbiz bz=new Bookbiz();

        Book book1=new Book("T12","1313131","老人与海",30.0);
        Book book2=new Book("T15","584859592","小火柴的女孩",10.1);

        System.out.println("显示书");
        bz.show();
        System.out.println("添加书T12");
        bz.add(book1);
        bz.show();
        System.out.println("删除书T11");
        bz.delete("T11");
        bz.show();
        System.out.println("修改书T15");
        bz.change(book2);
        bz.show();

    }
}
