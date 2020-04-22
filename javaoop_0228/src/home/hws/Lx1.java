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

public class Lx1 {

    private String fileN = "phone.xml";


    public Document getDoc() {
//        读取对象
        SAXReader reader = new SAXReader();
//   获得文档对象
        try {
            Document document = reader.read(new File(fileN));
            return document;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void add(Phone phone) {
//  获取文档
        Document document = getDoc();
//  获取根元素
        Element root = document.getRootElement();

//        <Brand name="三星">
//           <Type name="a1"/>
//           <Type name="a2"/>
//        </Brand>
//  添加Brand
        Element elePh = root.addElement("Brand").addAttribute("name", phone.getBrand());
//       添加Type
        elePh.addElement("Type").addAttribute("name",phone.getType());
        elePh.addElement("Type").addAttribute("name",phone.getType());
//  写入
        save(document);
        System.out.println("add OK!");
    }

    public void del(String brand){
        Document document = getDoc();
        Element root = document.getRootElement();
//        获得根元素的孩子
        List<Element> list = root.elements();
        for (Element ele:
             list) {
//            获得brand的name
            if (ele.attributeValue("name").equalsIgnoreCase(brand)){
                root.remove(ele);
                break;
            }

        }
        save(document);
        System.out.println("del OK!");
    }

    public void upd(Phone phone){
        Document document = getDoc();
        Element root = document.getRootElement();
        List<Element> list = root.elements();
        for (Element ele :
                list) {
            if (ele.attributeValue("name").equalsIgnoreCase(phone.getBrand())){

//                获取Brand的孩子
                List<Element> list1 = ele.elements();
                for (Element e :
                        list1) {
//                    修改type的name
                    e.addAttribute("name",phone.getType());
                }
                break;
            }
        }
        save(document);
        System.out.println("updaet OK!");
    }

    public void show() {
        Document document = getDoc();
        Element root = document.getRootElement();

        List<Element> list = root.elements();


        for (Element element :
                list) {
            StringBuilder builder = new StringBuilder();

            builder.append(element.attributeValue("name") + "\t");
            List<Element> list1 = element.elements();
            for (Element ele :
                    list1) {
                builder.append(ele.attributeValue("name") + "\t");
            }

            System.out.println(builder);

        }

    }


    private void save(Document document){
        XMLWriter writer = null;
        try (FileWriter fw = new FileWriter(fileN)){
            OutputFormat format = OutputFormat.createPrettyPrint();
            //设置编码
            format.setEncoding("utf-8");
            writer = new XMLWriter(fw,format);

            writer.write(document);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

class Phone {
    private String brand;
    private String type;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Phone() {
    }

    public Phone(String brand, String type) {
        this.brand = brand;
        this.type = type;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Phone{");
        sb.append("brand='").append(brand).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

class Test {
    public static void main(String[] args) {
        Lx1 lx1 = new Lx1();
        lx1.show();

        Phone phone = new Phone("三星","Note9");
        lx1.add(phone);
        lx1.show();


//        lx1.del("苹果");
//        lx1.show();


        Phone phone1 = new Phone("三星","ss");
        lx1.upd(phone1);
        lx1.show();


    }
}
