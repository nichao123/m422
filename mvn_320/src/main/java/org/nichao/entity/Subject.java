package org.nichao.entity;

public class Subject {
    private int subjectID;
    private String subjectName;
    private int classHour;
    private int gradeID;

    public Subject(int subjectID, String subjectName, int classHour, int gradeID) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.classHour = classHour;
        this.gradeID = gradeID;
    }

    public Subject() {
    }

    public Subject(int subjectID, String subjectName, int classHour) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.classHour = classHour;
    }

    public Subject(String subjectName, int classHour, int gradeID) {
        this.subjectName = subjectName;
        this.classHour = classHour;
        this.gradeID = gradeID;
    }

    @Override
    public String toString() {
        return subjectID +
                "\t" + subjectName  +
                "\t" + classHour +
                "\t" + gradeID;
    }
    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
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
