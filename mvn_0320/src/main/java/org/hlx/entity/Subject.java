package org.hlx.entity;

/**
 * @ClassName Subject
 * @Description: TODO
 * @Author 44401
 * @Date 2020/3/20
 * @Version V1.0
 **/
public class Subject {
    //ctrl+alt+L
    private int subjectNo;
    private String subjectName;
    private int classHour;
    private int gradeID;

    public Subject(int subjectNo, String subjectName, int classHour, int gradeID) {
        this.subjectNo = subjectNo;
        this.subjectName = subjectName;
        this.classHour = classHour;
        this.gradeID = gradeID;
    }

    public int getSubjectNo() {
        return subjectNo;
    }

    public Subject() {
    }

    public Subject(int subjectNo, String subjectName, int classHour) {
        this.subjectNo = subjectNo;
        this.subjectName = subjectName;
        this.classHour = classHour;
    }

    public Subject(String subjectName, int classHour, int gradeID) {
        this.subjectName = subjectName;
        this.classHour = classHour;
        this.gradeID = gradeID;
    }

    /**
     * 数据
     * @return
     */
    @Override
    public String toString() {
        return subjectNo +
                "\t" + subjectName  +
                "\t" + classHour +
                "\t" + gradeID;
    }

    public void setSubjectNo(int subjectNo) {
        this.subjectNo = subjectNo;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getClassHour() {
        return classHour;
    }

    public void setClassHour(int classHour) {
        this.classHour = classHour;
    }

    public int getGradeID() {
        return gradeID;
    }

    public void setGradeID(int gradeID) {
        this.gradeID = gradeID;
    }
}
