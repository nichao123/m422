package javaoop_0224.src.home.weekhome.zrj;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TestStu {
    public static void main(String[] args) {
//        项目简介:(面向对象+集合+IO)
//        3个学生有3门课的成绩，从键盘输入数据（包括学生姓名和三门课的成绩），输入的格式为mike,80,45,20 并存入到集合中，
//        且输入exit退出程序!
//        求每个人的总成绩，并把学生的信息和计算出的总分数按降序顺序写入到文件score.txt中。
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入成绩信息格式：mike,80,45,20输入exit退出");
        List<StuScore> stuScores=new ArrayList<>();
        do {
            String stu=scanner.nextLine();
            //
            if (stu.equalsIgnoreCase("exit")){
                break;
            }else {
                String strs[] = stu.split(",");
                int score1 = Integer.parseInt(strs[1]);
                int score2 = Integer.parseInt(strs[2]);
                int score3 = Integer.parseInt(strs[3]);
                StuScore stuScore = new StuScore(strs[0], score1, score2, score3);
                stuScores.add(stuScore);
            }
        }while (true);

        Collections.sort(stuScores);

        File file=new File("score.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileOutputStream fis=new FileOutputStream(file);
            OutputStreamWriter isr=new OutputStreamWriter(fis);
            BufferedWriter bw=new BufferedWriter(isr)){
            for (StuScore stus:
                 stuScores) {
                String strs=stus+"总分："+(stus.getScorePython()+stus.getScoreJava()+stus.getScoreH5())+"\n";
                bw.write(strs);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//学生成绩类
class StuScore implements Comparable<StuScore> {
//    姓名
    private String name;
//    成绩3个
    private int scoreJava;
    private int scorePython;
    private int scoreH5;
//    封装
    public StuScore() {
    }
    public StuScore(String name, int scoreJava, int scorePython, int scoreH5) {
        this.name = name;
        this.scoreJava = scoreJava;
        this.scorePython = scorePython;
        this.scoreH5 = scoreH5;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getScoreJava() {
        return scoreJava;
    }
    public void setScoreJava(int scoreJava) {
        this.scoreJava = scoreJava;
    }
    public int getScorePython() {
        return scorePython;
    }
    public void setScorePython(int scorePython) {
        this.scorePython = scorePython;
    }
    public int getScoreH5() {
        return scoreH5;
    }
    public void setScoreH5(int scoreH5) {
        this.scoreH5 = scoreH5;
    }
    @Override
    public String toString() {
        return "StuScore{" +
                "name='" + name + '\'' +
                ", scoreJava=" + scoreJava +
                ", scorePython=" + scorePython +
                ", scoreH5=" + scoreH5 +
                '}';
    }

    @Override
    public int compareTo(StuScore o) {
        return (o.getScoreH5()+o.getScoreJava()+o.getScorePython()-(this.scoreH5+this.scoreJava+this.scorePython));
    }
}
