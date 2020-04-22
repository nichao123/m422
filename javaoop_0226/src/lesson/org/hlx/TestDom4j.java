package javaoop_0226.src.lesson.org.hlx;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

/**
 * @ClassName TestDom4j
 * @Description: TODO
 * @Author 44401
 * @Date 2020/2/26
 * @Version V1.0
 **/
public class TestDom4j {
    public static void main(String[] args) {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read("student.xml");
            System.out.println(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
