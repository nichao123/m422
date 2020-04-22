package javaoop_0226.src.lesson.org.hlx;

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

/**
 * @ClassName StudentBiz
 * @Description: TODO
 * @Author 44401
 * @Date 2020/2/26
 * @Version V1.0
 **/
public class StudentBiz {

    private String fileName = "student.xml";

    /**
     * 获得文档对象
     * @return
     */
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
     * 添加一条数据
     * @param stu
     */
    public void add(Student stu){
//         <student sn="02">
//            <name>陆飞</name>
//            <age>26</age>
//          </student>

        //1.获得文档对象
        Document document =getDocument();

        //2.创建student,name,age节点
//        <student></student>
        Element eleStudent= document.createElement("student");
//        <name></name>
        Element eleName= document.createElement("name");
//        <age></age>
        Element eleAge= document.createElement("age");

        // sn="02"
        //3.创建属性
         Attr attrSn= document.createAttribute("sn");
         attrSn.setValue(stu.getSn());  //设置值

        //4.属性添加到student节点上<student sn="02">
        eleStudent.setAttributeNode(attrSn);

        //5.name,age文本值
        eleName.setTextContent(stu.getName());
        eleAge.setTextContent(stu.getAge()+"");

        //6.将name,age节点添加到student节点下
         eleStudent.appendChild(eleName);
         eleStudent.appendChild(eleAge);

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
      NodeList list = document.getElementsByTagName("student");
      for (int i = 0; i < list.getLength(); i++) {
        //每一个项
          Element ele = (Element) list.item(i);

          //获得属性值 <student sn="21">
          String strId = ele.getAttribute("sn");
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
  public void update(Student student) {
      //1.获得文档对象
      Document document = getDocument();
      //2.通过标签名student 获得孩子
      NodeList list = document.getElementsByTagName("student");
      for (int i = 0; i < list.getLength(); i++) {
        //每一个项
          Element ele = (Element) list.item(i);

          //获得属性值 <student sn="21">
          String strId = ele.getAttribute("sn");
          //判断
          if (strId.equalsIgnoreCase(student.getSn())) {
              //找到就修改 name,age
              ele.getElementsByTagName("name").item(0).getFirstChild().setTextContent(student.getName());
              ele.getElementsByTagName("age").item(0).getFirstChild().setTextContent(student.getAge()+"");
              break;

          }
      }

      //写入
      saveToXml(document);
      System.out.println("del OK!");
  }

    /**
     * 写入对象
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


    public void show(){
        //1.获得文档对象
        Document document =getDocument();

        //2.通过标签名student 获得孩子
        NodeList list = document.getElementsByTagName("student");
        for (int i = 0; i <list.getLength() ; i++) {

            //字符串中
            StringBuffer buffer =new StringBuffer();

            //每一个项
            Element ele = (Element) list.item(i);

            //添加属性sn到字符串中
            buffer.append(ele.getAttribute("sn")+"\t");

            //添加name/age到字符串中
            buffer.append(document.getElementsByTagName("name").item(i).getFirstChild().getNodeValue()+"\t");
            buffer.append(document.getElementsByTagName("age").item(i).getFirstChild().getNodeValue());

            System.out.println(buffer);

        }
    }
}
