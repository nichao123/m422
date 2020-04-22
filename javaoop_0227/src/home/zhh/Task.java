package javaoop_0227.src.home.zhh;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Task {
    private Document document=null;
    public static void main(String[] args) {
        Task task=new Task();
        task.getDocument();
        task.showInfo();

//        添加，
//        task.add();
//        task.showInfo();
//        修改
//        task.update();
//        task.showInfo();
//        删除，
//        task.delete();
//        task.showInfo();
    }

    public void getDocument(){
        DocumentBuilderFactory  factory=DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder=factory.newDocumentBuilder();
            document=builder.parse("phone.xml");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //获取手机品牌和属性
    public void showInfo(){
        NodeList brands=document.getElementsByTagName("Brand");
        for(int i=0;i<brands.getLength();i++){
            Node node=brands.item(i);
            Element eleBrand=(Element)node;
            System.out.println(eleBrand.getAttribute("name"));

            NodeList types=eleBrand.getChildNodes();
            for(int j=0;j<types.getLength();j++){
                Node typeNode=types.item(j);
                if(typeNode.getNodeType()==Node.ELEMENT_NODE){
                    Element eleType=(Element)typeNode;
                    System.out.println(eleType.getAttribute("name"));
                }
            }
        }
    }

    //保存XML文件
    public void savaXML(String path){
        TransformerFactory factory=TransformerFactory.newInstance();
        factory.setAttribute("indent-number", "4");
        try {
            Transformer transformer=factory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "gb2312");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//            StreamResult result=new StreamResult(new FileOutputStream(path));
            StreamResult result=new StreamResult(new OutputStreamWriter(new FileOutputStream(path), "gb2312"));
            DOMSource  source=new DOMSource(document);
            transformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //添加
    public void add(){
        Element element=document.createElement("Brand");
        element.setAttribute("name", "三星");
        Element ele1=document.createElement("Type");
        ele1.setAttribute("name", "Note3");
        element.appendChild(ele1);
        document.getElementsByTagName("PhoneInfo").item(0).appendChild(element);
        this.savaXML("phone.xml");
    }

    //修改
    public void update(){
        NodeList brands=document.getElementsByTagName("Brand");
        for(int i=0;i<brands.getLength();i++){
            Node brand=brands.item(i);
            Element eleBrand=(Element)brand;
            eleBrand.setAttribute("id", i+"");
        }
        this.savaXML("phone.xml");
    }

    //删除
    public void delete(){
        NodeList brands=document.getElementsByTagName("Brand");
        for(int i=0;i<brands.getLength();i++){
            Node brand=brands.item(i);
            Element eleBrand=(Element)brand;
            if(eleBrand.getAttribute("name").equals("华为")){
                eleBrand.getParentNode().removeChild(eleBrand);
            }
        }
        this.savaXML("phone.xml");
    }
}
