public class TestBook {
    public static void main(String[] args) {
        Bookbiz b=new Bookbiz();
        b.show();
        b.del("T11");
        b.show();
        Book book=new Book("T15","heiheihei",666.0);
        b.update(book);
        b.show();
        Book book2=new Book("T19","66666",666.0);
        b.add(book2);
        b.show();
    }


}
