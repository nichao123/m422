package javaoop_0227.src.home.zhh;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class Task1 {
    public static void main(String[] args) {
        PhoneBiz biz=new PhoneBiz();
        biz.show();

        Phone p=new Phone("小米","小米10");
        biz.add(p);
        biz.show();

    }

}

class PhoneBiz {
    private String fileName = "phone.xml";

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
     * 写入对象
     *
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

    public void show() {

        Document document = getDocument();
//        NodeList list=document.getElementsByTagName("Brand");
//        for (int i = 0; i < list.getLength(); i++) {
//            StringBuffer buffer=new StringBuffer();
//            Element ele=(Element)list.item(i);
////            添加属性sn到字符串中
//            buffer.append(ele.getAttribute("name")+"\t");
////            添加name/age到字符串中
//
//
//            NodeList list1=document.getElementsByTagName("Type");
//            for (int j = 0; j < list1.getLength(); j++) {
//                Element ele1=(Element)list1.item(j);
//                buffer.append(ele1.getAttribute("name")+"\t");
//            }
//            System.out.println(buffer);
//
//        }
        NodeList brands = document.getElementsByTagName("Brand");
        for (int i = 0; i < brands.getLength(); i++) {
            Node node = brands.item(i);
            Element eleBrand = (Element) node;
            System.out.println(eleBrand.getAttribute("name"));

            NodeList types = eleBrand.getChildNodes();
            for (int j = 0; j < types.getLength(); j++) {
                Node typeNode = types.item(j);
                if (typeNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eleType = (Element) typeNode;
                    System.out.println(eleType.getAttribute("name"));
                }
            }
        }
    }

    /**
     * 添加一条数据
     * @param phone
     */
    public void add(Phone phone){
//         <student sn="02">
//            <name>陆飞</name>
//            <age>26</age>
//          </student>

        //1.获得文档对象
        Document document =getDocument();

        //2.创建student,name,age节点
//        <student></student>
        Element eleStudent= document.createElement("Brand");
//        <name></name>
        Element eleName= document.createElement("Type");

        // sn="02"
        //3.创建属性
        Attr attrSn= document.createAttribute("name");
        attrSn.setValue(phone.getName());  //设置值

        Attr attrSn1= document.createAttribute("name");
        attrSn1.setValue(phone.getType());  //设置值
        //4.属性添加到student节点上<student sn="02">
        eleStudent.setAttributeNode(attrSn);
        eleName.setAttributeNode(attrSn1);

        //5.name,age文本值
//        eleName.setTextContent(phone.getName());
//        eleAge.setTextContent(stu.getAge()+"");

        //6.将name,age节点添加到student节点下
        eleStudent.appendChild(eleName);

        //7.将student添加到根节点下students
        document.getDocumentElement().appendChild(eleStudent);

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
        NodeList list = document.getElementsByTagName("Brand");
        for (int i = 0; i < list.getLength(); i++) {
            //每一个项
            Element ele = (Element) list.item(i);

            //获得属性值 <student sn="21">
            String strId = ele.getAttribute("name");
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
    public void update(Phone phone) {
        //1.获得文档对象
        Document document = getDocument();
        //2.通过标签名student 获得孩子
        NodeList list = document.getElementsByTagName("Brand");
        for (int i = 0; i < list.getLength(); i++) {
            //每一个项
            Element ele = (Element) list.item(i);

            //获得属性值 <student sn="21">
            String strId = ele.getAttribute("name");
            //判断
            if (strId.equalsIgnoreCase(phone.getName())) {
                //找到就修改 name,age
                ele.getElementsByTagName("name").item(0).getFirstChild().setTextContent(phone.getName());
                break;

            }
        }

        //写入
        saveToXml(document);
        System.out.println("del OK!");
    }
}

 class Phone {
    private String Type;  //
    private String name;

    public Phone(String brand, String Type) {
        this.name = name;
        this.Type = Type;
    }

    public Phone() {
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return  Type + "\t" + name  ;
    }

    public void setName(String name) {
        this.name = name;
    }

     public String getType() {
         return Type;
     }

     public void setType(String type) {
         Type = type;
     }
 }
