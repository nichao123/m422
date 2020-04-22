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

public class Phonebiz {
    //文件
    private String fileName = "phone.xml";

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

    public void show() {
        //获得文档
        Document document = getDocument();

        //获得根元素
        Element root = document.getRootElement();

        //获得根元素的孩子student
        List<Element> list = root.elements();
        //System.out.println("size="+list.size());
        //循环
        for (Element ele :
                list) {
            //字符串对象
            StringBuilder builder = new StringBuilder();

            //追加数据到字符串中
            builder.append(ele.attributeValue("name") + "\t");
            List<Element> list2 = ele.elements();
            for (Element ele2 :
                    list2) {
                builder.append(ele2.attributeValue("name") + "\t");
            }

            System.out.println(builder);
        }
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
            if (ele.attributeValue("name").equals(id)) {
                //删除
                root.remove(ele);
                break;
            }
        }
        saveToXml(document);
        System.out.println("del OK!");
    }
    private void saveToXml(Document document) {
        //xml写对象
        XMLWriter writer =null;

        //文件写对象
        try(FileWriter fw =new FileWriter(fileName)){

            //输出的格式
            OutputFormat format =OutputFormat.createPrettyPrint();

            //xml写对象
            writer =new XMLWriter(fw,format);
            //写入
            writer.write(document);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}