import java.io.*;
import java.util.Scanner;

public class H2 {
    Customer cust = new Customer();

    public static void main(String[] args) {
        H2 h2 = new H2();
        File file = new File("save.bin");
        if (!file.exists()) {
            h2.add();
            h2.serializable();
        }else {
           h2.deSerializable();
        }
        //计算
        float total = 0;
        System.out.println("产品名\t单价\t数量");
        for(Object obj:h2.cust.getOrder().getCommoditylist()){
            Commodity Commdity=(Commodity) obj;
            System.out.println(Commdity.getCommodityname()
                    +"\t"+Commdity.getCommodityprice()
                    +"\t"+Commdity.getCommoditycount());
            total += Commdity.getCommodityprice() * Commdity.getCommoditycount();
        }
        System.out.println("\n订单总价：" + total);

    }

    public void add() {
        System.out.print("请输入用户名：");
        Scanner scanner = new Scanner(System.in);
        String shuruCustomerName = scanner.next();
        Order order = new Order("A2321");
        System.out.println("请输入选择的商品：");
        while (true) {
            System.out.println("产品号：");
            String commodityid = scanner.next();
            System.out.println("名称：");
            String commodityrname = scanner.next();
            System.out.println("购买数量：");
            int commoditycount = scanner.nextInt();
            System.out.println("产品单价：");
            double commodityprice = scanner.nextDouble();
            Commodity comm = new Commodity(commodityid, commodityrname, commoditycount, commodityprice);
            //加入订单
            order.getCommoditylist().add(comm);
            System.out.println("是否继续？ Y/N");
            String panduan = scanner.next();
            if (panduan.equals("n")) {
                break;
            }

        }
        cust.setCustomername(shuruCustomerName);
        cust.setOrder(order);
    }

    public void serializable() {
        // 序列化
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("save.bin"));
            // 对象序列化，写入输出流
            oos.writeObject(cust);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }


    }
    public void deSerializable(){
        // 反序列化
        ObjectInputStream ois = null;
        try {
            // 创建ObjectInputStream输入流
            ois = new ObjectInputStream(new FileInputStream("save.bin"));
            // 反序列化，强转类型
            cust = (Customer)ois.readObject();
            // 输出生成后对象信息
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {ois.close();}
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}
