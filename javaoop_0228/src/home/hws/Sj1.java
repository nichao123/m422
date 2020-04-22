package javaoop_0228.src.home.hws;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class Sj1 {


    private String fileName = "book.xml";

    public Document getDocument() {
        //读取对象
        SAXReader reader = new SAXReader();
        //获得文档对象
        try {
            Document document = reader.read(new File(fileName));
            return document;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void add(Book book){
        //获得文档
        Document document = getDocument();

        //获得根元素
        Element root = document.getRootElement();
        //  id
        Element eleStudent = root.addElement("book").addAttribute("id", book.getId());

        eleStudent.addElement("name").addText(book.getName());

        eleStudent.addElement("price").addText(book.getPrice() + "");

        //写入XML
        saveToXml(document);
        System.out.println("add OK!");

    }


    public void del(String id) {
        //获得文档
        Document document = getDocument();
        //获得根元素
        Element root = document.getRootElement();
        //获得根元素的孩子
        List<Element> list = root.elements();
        for (Element ele :
                list) {
            //获得sn属性值
            if (ele.attributeValue("id").equalsIgnoreCase(id)) {
                //删除
                root.remove(ele);
                break;
            }
        }

        //
        saveToXml(document);
        System.out.println("del OK!");


    }


    public void update(Book book) {
        //获得文档
        Document document = getDocument();
        //获得根元素
        Element root = document.getRootElement();
        //获得根元素的孩子
        List<Element> list = root.elements();
        for (Element ele :
                list) {
            //获得sn属性值
            if (ele.attributeValue("id").equalsIgnoreCase(book.getId())) {
                //修改 name,age
                ele.element("name").setText(book.getName());
                ele.element("price").setText(book.getPrice()+ "");
                break;
            }
        }
        //
        saveToXml(document);
        System.out.println("update OK!");


    }


    /**
     * 写入到XML文件中
     */
    private void saveToXml(Document document) {
        //xml写对象
        XMLWriter writer = null;

        //文件写对象
        try (FileWriter fw = new FileWriter(fileName)) {

            //输出的格式
            OutputFormat format = OutputFormat.createPrettyPrint();

            //xml写对象
            writer = new XMLWriter(fw, format);
            //写入
            writer.write(document);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * 显示所有的数据
     */
    public void show() {
        //获得文档
        Document document = getDocument();

        //获得根元素
        Element root = document.getRootElement();

        List<Element> list = root.elements();

        for (Element ele :
                list) {
            //字符串对象
            StringBuilder builder = new StringBuilder();

            //追加数据到字符串中
            builder.append(ele.attributeValue("id") + "\t");  //sn属性
            builder.append(ele.elementTextTrim("name") + "\t"); //name文本值
            builder.append(ele.elementTextTrim("price") + "\t"); //age文本值

            System.out.println(builder);
        }

    }
}
class Book{
    private String id;
    private String name;
    private Double price;

    public Book() {
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Book{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }

    public Book(String id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
class TestB{
    public static void main(String[] args) {
        Sj1 sj1 = new Sj1();
        sj1.show();

        Book book = new Book("T1","xx",10.1);
        sj1.add(book);
        sj1.show();

        sj1.del("T1");
        sj1.show();

        Book book1 = new Book("T11","xxz",15.1);
        sj1.update(book1);
        sj1.show();
    }
}


