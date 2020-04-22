import java.io.*;

public class Lian1 {
    //按照刚才读取的模板文件pet. template的模板格式保存宠物数据到文本文件，
    // 即把{name}、{type}、{master}替换为具体的宠物信息，将替换后的内容写入到C:\myDoc\pet.txt中
    public static String change(String shuru, String name, String type, String master) {
        shuru=shuru.replace("前", "后");
        shuru = shuru.replace("{name}", name);
        shuru = shuru.replace("{type}", type);
        shuru = shuru.replace("{master}", master);
        return shuru;
    }

    public static void main(String[] args) {
        File file=new File("pet. template");
        try {
            FileReader fr = new FileReader(file);
            BufferedReader bfr = new BufferedReader(fr);
            String str = bfr.readLine();
            str = change(str, "欧欧", "狗狗", "李伟");
            FileWriter fw = new FileWriter(new File("pet.txt"),true);
            BufferedWriter bfw = new BufferedWriter(fw);
            fw.write(str);
            fw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}