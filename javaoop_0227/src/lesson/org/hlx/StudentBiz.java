package javaoop_0227.src.lesson.org.hlx;


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

/**
 * @ClassName StudentBiz
 * @Description: TODO
 * @Author 44401
 * @Date 2020/2/27
 * @Version V1.0
 **/
public class StudentBiz {

    //文件
    private String fileName = "student.xml";

    /**
     * 文档对象
     *
     * @return
     */
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

    /**
     * 添加数据
     * @param student
     */
    public void add(Student student){
        //获得文档
        Document document =getDocument();
//         <student sn="02">
//            <name>陆飞</name>
//            <age>26</age>
//         </student>

        //获得根元素
        Element root =document.getRootElement();
    //  <student sn="02">
        Element eleStudent=root.addElement("student").addAttribute("sn",student.getSn());
     // <name>陆飞</name>
        eleStudent.addElement("name").addText(student.getName());
//           <age>26</age>
        eleStudent.addElement("age").addText(student.getAge()+"");

        //写入XML
        saveToXml(document);
        System.out.println("add OK!");

    }


    /**
     * 删除数据
     * @param id
     */
    public void del(String id) {
        //获得文档
        Document document = getDocument();
        //获得根元素
        Element root =document.getRootElement();
        //获得根元素的孩子
        List<Element> list = root.elements();
        for (Element ele:
            list ) {
            //获得sn属性值
            if(ele.attributeValue("sn").equalsIgnoreCase(id)){
                //删除
                root.remove(ele);
                break;
            }
        }

        //
        saveToXml(document);
        System.out.println("del OK!");


    }

    /**
     * 更新数据
     * @param student
     */
    public void update(Student student) {
        //获得文档
        Document document = getDocument();
        //获得根元素
        Element root =document.getRootElement();
        //获得根元素的孩子
        List<Element> list = root.elements();
        for (Element ele:
                list ) {
            //获得sn属性值
            if(ele.attributeValue("sn").equalsIgnoreCase(student.getSn())){
                //修改 name,age
                ele.element("name").setText(student.getName());
                ele.element("age").setText(student.getAge()+"");
                break;
            }
        }
        //
        saveToXml(document);
        System.out.println("update OK!");


    }



    /**
     * 写入到XML文件中
     */
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


    /**
     * 显示所有的数据
     */
    public  void show(){
        //获得文档
        Document document =getDocument();

        //获得根元素
        Element root =document.getRootElement();

        //获得根元素的孩子student
        List<Element> list = root.elements();
        //System.out.println("size="+list.size());
        //循环
        for (Element ele:
            list ) {
           //字符串对象
            StringBuilder builder=new StringBuilder();

            //追加数据到字符串中
            builder.append(ele.attributeValue("sn")+"\t");  //sn属性
            builder.append(ele.elementTextTrim("name")+"\t"); //name文本值
            builder.append(ele.elementTextTrim("age")+"\t"); //age文本值

            System.out.println(builder);
        }

    }
}
