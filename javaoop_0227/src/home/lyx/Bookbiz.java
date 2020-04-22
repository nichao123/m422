package javaoop_0227.src.home.lyx;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import javax.print.Doc;
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

public class Bookbiz {
    private String filename="books.xml";

    public Document getdocument(){
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
//        System.out.print("无");
        return null;
    }

//    显示
    public void show(){
        Document document=getdocument();

        NodeList list=document.getElementsByTagName("book");

        for (int i = 0; i <list.getLength() ; i++) {

            Element ele=(Element) list.item(i);

            StringBuffer buffer=new StringBuffer();

            buffer.append("id:"+ele.getAttribute("id")+"\tbno:"+ele.getAttribute("bno")+"\t");

            buffer.append("书名:"+document.getElementsByTagName("name").item(i).getFirstChild().getNodeValue()+"\t价格");
            buffer.append(document.getElementsByTagName("price").item(i).getFirstChild().getNodeValue());
            System.out.println(buffer);
        }
    }

//    添加
    public void add(Book book){
        Document document=getdocument();

        Element elebook=document.createElement("book");
        Element elename=document.createElement("name");
        Element eleprice=document.createElement("price");

        Attr attrid=document.createAttribute("id");
        attrid.setValue(book.getId());
        Attr attrbno=document.createAttribute("bno");
        attrbno.setValue(book.getBno());

        elebook.setAttributeNode(attrid);
        elebook.setAttributeNode(attrbno);

        elename.setTextContent(book.getName());
        eleprice.setTextContent(book.getPrice()+"");

        elebook.appendChild(elename);
        elebook.appendChild(eleprice);

        document.getDocumentElement().appendChild(elebook);

        save(document);
        System.out.println("添加成功");
    }

//    保存
    public void save(Document document){
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
//删除
    public void delete(String id){
        Document document=getdocument();

        NodeList list=document.getElementsByTagName("book");

        for (int i = 0; i < list.getLength(); i++) {
            Element ele=(Element) list.item(i);

            String sid=ele.getAttribute("id");

            if(sid.equalsIgnoreCase(id)){
                document.getDocumentElement().removeChild(ele);
                break;
            }
        }

        save(document);

        System.out.println("删除成功");
    }

    public void change(Book book){
        Document document=getdocument();

        NodeList list=document.getElementsByTagName("book");

        for (int i = 0; i < list.getLength(); i++) {
            Element ele=(Element) list.item(i);

            String sid=ele.getAttribute("id");

            if(sid.equalsIgnoreCase(book.getId())){
                ele.getElementsByTagName("name").item(0).getFirstChild().setTextContent(book.getName());
                ele.getElementsByTagName("price").item(0).getFirstChild().setTextContent(book.getPrice()+"");
                break;
            }
        }

        save(document);
        System.out.println("修改成功");
    }
}
