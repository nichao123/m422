import org.dom4j.Document;

import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookBiz {
    private String fname = "book2.xml";
    List arr = new ArrayList();


    public Document getDocument() {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new File(fname));
            return document;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void show() {

        Document document = getDocument();
        Element element = document.getRootElement();
        List<Element> list = element.elements();
        for (Element ele :
                list) {
            StringBuilder builder = new StringBuilder();
            builder.append(ele.attributeValue("id") + "\t");
            builder.append(ele.attributeValue("categlory") + "\t");
            builder.append(ele.elementTextTrim("name") + "\t");
            builder.append(ele.elementTextTrim("author") + "\t");
            builder.append(ele.elementTextTrim("price") + "\t");
            //查询所有的数据封装到集合List<>中
            List arr = new ArrayList();
            arr.add(builder);
            System.out.println(builder);
//            for (Object o:
//                    arr) {
//                System.out.println(o);
//            }
        }
    }
    public void save(Document document){
        XMLWriter writer=new XMLWriter();
        try(FileWriter fw=new FileWriter(fname)) {
            OutputFormat outputFormat=OutputFormat.createPrettyPrint();
            writer=new XMLWriter(fw,outputFormat);
            writer.write(document);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void delete(String id,String categlory){
        Document document = getDocument();
        Element element = document.getRootElement();
        List<Element> list = element.elements();
        for (Element ele :
                list) {
            if (ele.attributeValue("id").equalsIgnoreCase(id)||ele.attributeValue("categlory").equalsIgnoreCase(categlory)){
                element.remove(ele);
                break;
            }
        }
        save(document);
    }
    public void add(Book book){
        Document document=getDocument();
        Element element = document.getRootElement();
        Element eleid=element.addElement("book").addAttribute("id",book.getId())
                .addAttribute("categlory",book.getCateglory());
        eleid.addElement("name").addText(book.getName());
        eleid.addElement("author").addText(book.getAuther());
        eleid.addElement("price").addText(book.getPrice()+"");
        save(document);
    }
    public void update(Book book) {
        Document document = getDocument();
        Element element =document.getRootElement();
        List<Element> list = element.elements();
        for (Element ele:
                list ) {
            if(ele.attributeValue("id").equalsIgnoreCase(book.getId())||ele.attributeValue("categlory").equalsIgnoreCase(book.getCateglory())){
                //修改 name,age
                ele.element("name").setText(book.getName());
                ele.element("author").setText(book.getAuther());
                ele.element("price").setText(book.getPrice()+"");
                break;
            }
        }
        save(document);
    }
}
