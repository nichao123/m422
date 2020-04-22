package 徐晨阳.Doc.src;

public class Noodles {
    //    它的属性有:牛肉面宽度 width,尺寸：size  (大碗还是小碗) 大碗8元，小碗6元,是否加肉：beef   :加肉+4元,
//    加蛋的数量：eggs  :每个1元；
    String width;
    int size;
    boolean beef;
    int eggs;

    //    定义构造方法来根据不同的条件创建不同的牛肉面
    public Noodles() {
        //不加肉，大碗，不加蛋，中宽；
        this.beef = false;
        this.size = 8;
        this.eggs = 0;
        this.width = "中宽";
    }

    public Noodles(String width, int size) {
        this.width = width;
        this.size = size;
    }

    public Noodles(String width, int size, boolean beef) {
        this.width = width;
        this.size = size;
        this.beef = beef;
    }

    public Noodles(String width, int size, boolean beef, int eggs) {
        this.width = width;
        this.size = size;
        this.beef = beef;
        this.eggs = eggs;
    }

    //    再定义一个方法，用来显示当前牛肉面的信息，并显示金额；
    public void showNoodleInfo() {
        int money;
        money = size + eggs;

        if (size == 6) {
            if (beef == true) {
                money += 4;
                System.out.println(width + "，小碗，加肉，加" + eggs + "个蛋.金额是：" + money);
            } else {
                System.out.println(width + "，小碗，不加肉，加" + eggs + "个蛋.金额是：" + money);
            }
        } else {
            if (beef == true) {
                money += 4;
                System.out.println(width + "，大碗，加肉，加" + eggs + "个蛋.金额是：" + money);
            } else {
                System.out.println(width + "，大碗，不加肉，加" + eggs + "个蛋.金额是：" + money);
            }
        }
    }

    public static void main(String[] args) {
        Noodles noodle1 = new Noodles();
        noodle1.showNoodleInfo();
        Noodles noodle2 = new Noodles("细", 6);
        noodle2.showNoodleInfo();
        Noodles noodle3 = new Noodles("中宽", 8, true);
        noodle3.showNoodleInfo();
        Noodles noodle4 = new Noodles("宽", 6, true, 2);
        noodle4.showNoodleInfo();
    }
}