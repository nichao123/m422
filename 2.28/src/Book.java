public class Book {
    private String id;
    private String categlory;
    private String name;
    private String auther;
    private double price;

    public Book() {
    }

    public Book(String id, String categlory, String name, String auther, double price) {
        this.id = id;
        this.categlory = categlory;
        this.name = name;
        this.auther = auther;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCateglory() {
        return categlory;
    }

    public void setCateglory(String categlory) {
        this.categlory = categlory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", categlory='" + categlory + '\'' +
                ", name='" + name + '\'' +
                ", auther='" + auther + '\'' +
                ", price=" + price +
                '}';
    }
}
