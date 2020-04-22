package javaoop_0225.src.lesson.org.hlx;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * @ClassName TestXml
 * @Description: TODO
 * @Author 44401
 * @Date 2020/2/25
 * @Version V1.0
 **/
public class TestXml {
    public static void main(String[] args) {
//        getAllStudent();
//        getAllStudent("books.xml");

        //有没有简单的办法？？


    }


    private static void getAllStudent(String file) {
        //        DOM解析XML文件步骤
//        1.创建解析器工厂对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        2.解析器工厂对象创建解析器对象
        try {
            DocumentBuilder db = factory.newDocumentBuilder();

            //  3.解析器对象指定XML文件创建Document对象
            Document document = db.parse(file);

//        4.以Document对象为起点操作DOM树

            //4.1 获得根节点
            Element root = document.getDocumentElement();
            System.out.println(root.getNodeName());

            //4.2获得根节点的孩子
            NodeList lists = root.getChildNodes();
            System.out.println("根节点大小：" + lists.getLength());

            //存入数据
            StringBuffer buffer =new StringBuffer();

            //循环
            for (int i = 0; i < lists.getLength(); i++) {
                //遍历每一项 ,返回Node节点；
                Node node = lists.item(i);
                //发生异常： Exception in thread "main" java.lang.ClassCastException: com.sun.org.apache.xerces.internal.dom.DeferredTextImpl cannot be cast to org.w3c.dom.Element
                //解决:去判断当前节点是元素 (必须要判断！！)
                if (node instanceof Element) {
                    //属性值  ，需要是元素，强制类型转换；
                    String eleSn = ((Element) node).getAttribute("id");
                    //存入
                    buffer.append(eleSn+"\t");
                }
                //学生节点的孩子（name,age)
                NodeList list2 = node.getChildNodes();
                for (int j = 0; j < list2.getLength(); j++) {
                    //遍历每一项 ,返回Node节点;
                    Node node2 = list2.item(j);
                    /////判断当前节点是节点
                    if (node2.getNodeType() == Node.ELEMENT_NODE) {
                        //获取节点值
                        String name = node2.getFirstChild().getNodeValue();  //不一样!!
                        //存入
                        buffer.append(name);
                    }
                }
                //换行
                buffer.append("\n");
            }
            //显示结果
            System.out.println(buffer);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getAllStudent() {
        //        DOM解析XML文件步骤
//        1.创建解析器工厂对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        2.解析器工厂对象创建解析器对象
        try {
            DocumentBuilder db = factory.newDocumentBuilder();

            //  3.解析器对象指定XML文件创建Document对象
            Document document = db.parse("student.xml");

//        4.以Document对象为起点操作DOM树

            //4.1 获得根节点
            Element root = document.getDocumentElement();
            System.out.println(root.getNodeName());

            //4.2获得根节点的孩子
            NodeList lists = root.getChildNodes();
            System.out.println("根节点大小：" + lists.getLength());

            //存入数据
            StringBuffer buffer =new StringBuffer();

            //循环
            for (int i = 0; i < lists.getLength(); i++) {
                //遍历每一项 ,返回Node节点；
                Node node = lists.item(i);
                //发生异常： Exception in thread "main" java.lang.ClassCastException: com.sun.org.apache.xerces.internal.dom.DeferredTextImpl cannot be cast to org.w3c.dom.Element
                //解决:去判断当前节点是元素 (必须要判断！！)
                if (node instanceof Element) {
                    //属性值  ，需要是元素，强制类型转换；
                    String eleSn = ((Element) node).getAttribute("sn");
                    //存入
                    buffer.append(eleSn+"\t");
                }
                //学生节点的孩子（name,age)
                NodeList list2 = node.getChildNodes();
                for (int j = 0; j < list2.getLength(); j++) {
                    //遍历每一项 ,返回Node节点;
                    Node node2 = list2.item(j);
                   /////判断当前节点是节点
                    if (node2.getNodeType() == Node.ELEMENT_NODE) {
                        //获取节点值
                        String name = node2.getFirstChild().getNodeValue();  //不一样!!
                        //存入
                        buffer.append(name);
                    }
                }
                //换行
                buffer.append("\n");
            }
            //显示结果
            System.out.println(buffer);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
