package javaoop_0227.src.home.zhh;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task3 {
    private String fileName = "book.xml";

    /**
     * 获得文档对象
     * @return
     */
    public Document getDocument() {
        //1.创建解析器工厂对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //2.通过解析器工厂对象获得解析器对象
        try {
            DocumentBuilder db = factory.newDocumentBuilder();
            //3.获得文档对象
            return db.parse(fileName);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 添加一条数据
     * @param book
     */
    public void add(Book book){
//         <student sn="02">
//            <name>陆飞</name>
//            <age>26</age>
//          </student>

        //1.获得文档对象
        Document document =getDocument();

        //2.创建student,name,age节点
//        <student></student>
        Element eleBook= document.createElement("book");
//        <name></name>
        Element eleName= document.createElement("name");
//        <age></age>
        Element elePrice= document.createElement("price");

        // sn="02"
        //3.创建属性
        Attr attrId= document.createAttribute("id");
        attrId.setValue(book.getId());  //设置值
        Attr attrBno= document.createAttribute("bno");
        attrBno.setValue(book.getBno());  //设置值

        //4.属性添加到student节点上<student sn="02">
        eleBook.setAttributeNode(attrId);
        eleBook.setAttributeNode(attrBno);

        //5.name,age文本值
        eleName.setTextContent(book.getName());
        elePrice.setTextContent(book.getPrice()+"");

        //6.将name,age节点添加到student节点下
        eleBook.appendChild(eleName);
        eleBook.appendChild(elePrice);

        //7.将student添加到根节点下students
        document.getDocumentElement().appendChild(eleBook);

        //能？//
        saveToXml(document);
        ///////////////

        System.out.println("add Ok!");


    }

    /**
     * 删除一条信息
     * @param id
     */
    public void del(String id) {
        //1.获得文档对象
        Document document = getDocument();
        //2.通过标签名student 获得孩子
        NodeList list = document.getElementsByTagName("book");
        for (int i = 0; i < list.getLength(); i++) {
            //每一个项
            Element ele = (Element) list.item(i);

            //获得属性值 <student sn="21">
            String strId = ele.getAttribute("id");
            //判断
            if (strId.equalsIgnoreCase(id)) {
                //找到就删除
                document.getDocumentElement().removeChild(ele);
                break;

            }
        }

        //写入
        saveToXml(document);
        System.out.println("del OK!");
    }
    /**
     * 修改一条信息
     * @param student
     */
    public void update(Book book) {
        //1.获得文档对象
        Document document = getDocument();
        //2.通过标签名student 获得孩子
        NodeList list = document.getElementsByTagName("book");
        for (int i = 0; i < list.getLength(); i++) {
            //每一个项
            Element ele = (Element) list.item(i);

            //获得属性值 <student sn="21">
            String strId = ele.getAttribute("id");
            //判断
            if (strId.equalsIgnoreCase(book.getId())) {
                //找到就修改 name,age
                ele.setAttribute("bno",book.getBno());
                ele.getElementsByTagName("name").item(0).getFirstChild().setTextContent(book.getName());
                ele.getElementsByTagName("price").item(0).getFirstChild().setTextContent(book.getPrice()+"");
                break;

            }
        }

        //写入
        saveToXml(document);
        System.out.println("del OK!");
    }

    /**
     * 写入对象
     * @param document
     */
    public  void saveToXml (Document document){
//       1. 获得TransformerFactory对象
        TransformerFactory factory = TransformerFactory.newInstance();
//        2.创建Transformer对象
        try {
            Transformer  transformer =factory.newTransformer();
            //包含XML信息  换行
            transformer.setOutputProperty("indent","yes");

            // 3.创建DOMSource对象
            DOMSource  source =new DOMSource(document);


//        4.创建StreamResult对象,写入到XML
            StreamResult result =new StreamResult(new FileOutputStream(fileName));

//        5.将XML保存到指定文件中
            transformer.transform(source,result);


        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }


    }


    public void show(){
        //1.获得文档对象
        Document document =getDocument();

        //2.通过标签名student 获得孩子
        NodeList list = document.getElementsByTagName("book");
        for (int i = 0; i <list.getLength() ; i++) {

            //字符串中
            StringBuffer buffer =new StringBuffer();

            //每一个项
            Element ele = (Element) list.item(i);

            //添加属性sn到字符串中
            buffer.append(ele.getAttribute("id")+"\t");
            buffer.append(ele.getAttribute("bno")+"\t");

            //添加name/age到字符串中
            buffer.append(document.getElementsByTagName("name").item(i).getFirstChild().getNodeValue()+"\t");
            buffer.append(document.getElementsByTagName("price").item(i).getFirstChild().getNodeValue());

            System.out.println(buffer);

        }
    }

    public static void main(String[] args) {
        Task3 task3=new Task3();
        task3.show();

//        添加
//        Book book=new Book("a","123","123",80.5);
//        task3.add(book);
//        task3.show();

//        删除
//        task3.del("123");
//        task3.show();

//        修改
        Book book1=new Book("a","T11","1",100);
        task3.update(book1);
        task3.show();


    }

}
class Book {
    private String name;
    private String id;
    private String bno;
    private double price;

    public Book(String name, String id, String bno,double price) {
        this.name = name;
        this.id = id;
        this.bno = bno;
        this.price = price;
    }

    public Book() {
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return  id + "\t" + bno + "\t"+ name + "\t"+ price ;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}