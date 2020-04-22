public class Computer {
    String name;
    int score;
    public int showtwo(){
        int q = (int)(Math.random()*3);
        switch(q){
            case 1:
                System.out.println("电脑出拳： 剪刀");
                break;
            case 2:
                System.out.println("电脑出拳： 石头");
                break;
            case 3:
                System.out.println("电脑出拳： 布");
                break;
        }
        return q;
    }}