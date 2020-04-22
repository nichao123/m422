package org.nichao.entity;

public class Student {
    private int studentNo;
    private String loginPwd;
    private String studentName;
    private String sex;
    private int gradeId;
    private String phone;
    private String address;
    private String bornDate;
    private String email;

    public Student() {
    }

    public Student(int studentNo, String loginPwd, String studentName, String sex, int gradeId, String phone, String address, String bornDate, String email) {
        this.studentNo = studentNo;
        this.loginPwd = loginPwd;
        this.studentName = studentName;
        this.sex = sex;
        this.gradeId = gradeId;
        this.phone = phone;
        this.address = address;
        this.bornDate = bornDate;
        this.email = email;
    }

    public Student(String loginPwd, String studentName, String sex, int gradeId, String phone, String address, String bornDate, String email) {
        this.loginPwd = loginPwd;
        this.studentName = studentName;
        this.sex = sex;
        this.gradeId = gradeId;
        this.phone = phone;
        this.address = address;
        this.bornDate = bornDate;
        this.email = email;
    }

    public Student(String loginPwd, int gradeId, String phone, String address,int studentNo) {
        this.studentNo = studentNo;
        this.loginPwd = loginPwd;
        this.gradeId = gradeId;
        this.phone = phone;
        this.address = address;
    }

    public int getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBornDate() {
        return bornDate;
    }

    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return studentNo +
                "\t" + loginPwd  +
                "\t" + studentName +
                "\t" + sex +
                "\t" + gradeId +
                "\t" + phone +
                "\t" + address +
                "\t" + bornDate +
                "\t" + email;
    }

}
