package 徐晨阳.Doc.src;

public class Addition {
    //二、编写Addition类，该类中应包含一组实现两数相加运算的重载方法。
    //实现加法运算的方法，应接受两个参数（即加数和被加数），方法将两个参数进行加法运算后，返回相加结果。重载一组方法，包括整型、长整型、浮点型、双精度浮点型、还有字符串。


    public int add(int number3, int number4) {
        int sum;
        sum = number3 + number4;
        return sum;
    }

    public double add(double number3, double number4) {
        double sum;
        sum = number3 + number4;
        return sum;
    }
    public float add(float number3, float number4) {
        float sum;
        sum = number3 + number4;
        return sum;
    }
    public String add(String number3, String number4) {
        String sum;
        sum = number3 + number4;
        return sum;
    }
    public long add(long number3, long number4) {
        long sum;
        sum = number3 + number4;
        return sum;
    }





}

class TextAddition{
    public static void main(String[] args) {
        Addition addition=new Addition();

        System.out.println("int:"+addition.add(12,12));
        System.out.println("double:"+addition.add(12.0,12.0));
        System.out.println("float:"+addition.add(12.0f,12.f));
        System.out.println("String:"+addition.add("12","12"));
        System.out.println("long:"+addition.add(12L,12L));


    }

}
