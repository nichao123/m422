//客户
public class Customer {
    private String Customername;//姓名
    private Order order;//订单

    public Customer() {
    }

    public Customer(String customername, Order order) {
        Customername = customername;
        this.order = order;
    }

    public String getCustomername() {
        return Customername;
    }

    public void setCustomername(String customername) {
        Customername = customername;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Customername='" + Customername + '\'' +
                ", order=" + order +
                '}';
    }
}
