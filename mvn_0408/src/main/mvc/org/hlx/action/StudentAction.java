package org.hlx.action;

import org.hlx.pojo.Student;
import org.hlx.service.StudentService;

/**
 * @ClassName StudentAction
 * @Description: TODO
 * @Author 44401
 * @Date 2020/4/8
 * @Version V1.0
 *
 * 控制层
 **/
public class StudentAction {

    //业务层 注入
    private StudentService studentService;
    //学生对象注入
    private  Student student;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * 处理方法
     *
     */
    public void insert(){
        System.out.println("3-控制层调用");
        studentService.add(student);
    }

}
