package javaoop_0227.src.home.lyx;

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


public class PhoneBiz {

    private String filename="phone.xml";

//获得文档对象
    public Document getDocument(){
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db=factory.newDocumentBuilder();
            return db.parse(filename);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

//添加对象
    public void add(Phone phone){

        Document document=getDocument();

        Element eleBrand=document.createElement("Brand");

        Element eleType=document.createElement("Type");

        Attr attrname1=document.createAttribute("name");
        attrname1.setValue(phone.getBrand());
        Attr attrname2=document.createAttribute("name");
        attrname2.setValue(phone.getType());

        eleBrand.setAttributeNode(attrname1);
        eleType.setAttributeNode(attrname2);

        eleBrand.appendChild(eleType);

        document.getDocumentElement().appendChild(eleBrand);

        save(document);
        System.out.println("添加成功");
    }

//    写入对象
    public void save(Document document) {
        TransformerFactory factory=TransformerFactory.newInstance();

        try {
            Transformer transformer=factory.newTransformer();

            transformer.setOutputProperty("indent","yes");

            DOMSource source=new DOMSource(document);

            StreamResult result=new StreamResult(new FileOutputStream(filename));

            transformer.transform(source,result);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

//显示
    public void show(){
        //
        Document document=getDocument();

        //根节点孩子Brand
        NodeList list=document.getElementsByTagName("Brand");
        //
        for (int i = 0; i <list.getLength() ; i++) {
            StringBuffer buf=new StringBuffer();
            Element ele=(Element) list.item(i);
            buf.append(ele.getAttribute("name")+"\t");

            //获得Brand的孩子Type
            NodeList list1=ele.getElementsByTagName("Type");
            for (int j = 0; j <list1.getLength() ; j++) {
                Element ele1=(Element) list1.item(j);
                buf.append(ele1.getAttribute("name")+"\t");

            }
            System.out.println(buf);
        }
    }

//    删除
    public void delete(String Brandname){
        Document document=getDocument();

        NodeList list=document.getElementsByTagName("Brand");

        for (int i = 0; i <list.getLength() ; i++) {
            Element ele=(Element) list.item(i);

            String Bname=ele.getAttribute("name");

            if(Bname.equalsIgnoreCase(Brandname)){
                document.getDocumentElement().removeChild(ele);
                break;
            }
        }

        save(document);
        System.out.println("完成删除");
    }
//修改
    public void change(Phone phone){
        Document document=getDocument();

        NodeList list=document.getElementsByTagName("Brand");
        for (int i = 0; i < list.getLength(); i++) {
            Element ele=(Element)list.item(i);

            String Bname=ele.getAttribute("name");
            if(phone.getBrand().equalsIgnoreCase(Bname)){

                /////
                NodeList list2=ele.getElementsByTagName("Type");
                for (int j = 0; j <list2.getLength() ; j++) {
                    Element ele2=(Element)list2.item(j);
                    ele2.setAttribute("name",phone.getType());
                }
                break;
            }
        }

        save(document);
        System.out.println("完成修改");
    }
}


