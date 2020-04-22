import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class Ss {
    public static Document document;

    //获取DOM
    public static void getDom(){
        SAXReader saxReader = new SAXReader();
        try {
            document = saxReader.read(new File("phone.xml"));
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }


    //获取所有节点信息
    public static void showInfo(){
        Element root = document.getRootElement();
        for(Iterator itBrand=root.elementIterator();itBrand.hasNext();){
            Element brand = (Element) itBrand.next();
            System.out.println("品牌"+brand.attributeValue("name"));
            for(Iterator itType=brand.elementIterator();itType.hasNext();){
                Element type = (Element) itType.next();
                System.out.println("\t型号"+type.attributeValue("name"));
            }
        }

    }

    //添加节点
    public static void addNode(){
        Element root = document.getRootElement();
        Element eBrand = root.addElement("Brand");
        eBrand.addAttribute("name", "xiaomi");
        Element eType = eBrand.addElement("type");
        eType.addAttribute("name", "xiaomi5");
        saveXml("phone.xml");
    }





    //删除节点
    public static void deleteNode(){
        Element root = document.getRootElement();
        for(Iterator iBrand=root.elementIterator();iBrand.hasNext();){
            Element brand = (Element)iBrand.next();
            if(brand.attributeValue("name").equals("华为")){
                brand.getParent().remove(brand);
            }
        }
        saveXml("phone.xml");
    }



    //保存XML
    public static void saveXml(String path){
        XMLWriter writer;
        try {
            writer = new XMLWriter(new FileWriter(path));
            writer.write(document);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Ss ss = new Ss();
        ss.getDom();
        ss.deleteNode();
        ss.addNode();
        ss.showInfo();

    }







}
