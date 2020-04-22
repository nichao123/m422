import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Lian2 {
    //使用IO包中的类读取D盘上remark.txt文本文件的内容，
    // 每次读取一行内容，将每行作为一个输入放入ArrayList的泛型集合中并将集合中的内容使用加强for进行输出显示。
    public static void main(String[] args) throws IOException {
        File file=new File("remark.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        ArrayList<String> list = new ArrayList<>();
        String line;
        while((line = br.readLine())!= null) {
            list.add(line);
        }
        br.close();
        for (String string : list) {
            System.out.println(string);
        }
    }
}
