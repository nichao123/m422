package javaoop_0227.src.home.lyx;

public class Book {
    private String id;
    private String bno;
    private String name;
    private double price;

    public Book(String id, String bno, String name, double price) {
        this.id = id;
        this.bno = bno;
        this.name = name;
        this.price = price;
    }

    public Book(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBno() {
        return bno;
    }

    public void setBno(String bno) {
        this.bno = bno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
