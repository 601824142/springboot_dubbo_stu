package com.wan.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wan.pojo.Class;
import com.wan.pojo.Student;
import com.wan.service.IClassService;
import com.wan.service.IStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

/**
 * @Author 万星明
 * @Date 2019/1/15
 */
@Controller
@RequestMapping("/stu")
public class StudentController {

    @Reference
    private IStudentService studentService;
    @Reference
    private IClassService classService;

    /**
     * 查询全部学生,并返回到遍历页面
     * @param model
     * @return
     */
    @RequestMapping("/student")
    public String findAllStudent(Model model){
        List<Student> studentList = studentService.findAllStudent();
        model.addAttribute("studentList",studentList);
        return "StudentList";
    }

    @RequestMapping("/toAddStudent")
    public String toAddStudent(Model model){
        System.out.println("进入准备添加学生");
        List<Class> classList = classService.findAllClass();
        model.addAttribute("classList",classList);
        return "StudentAdd";
    }

    @RequestMapping("/addStudent")
    public String addStudent(Student student){
        System.out.println("进入添加学生:"+student);
        student.setBirth(new Date());
        Student addStudent = studentService.addStudent(student);
        System.out.println("添加成功:"+addStudent);
        if(addStudent!=null){
            return "redirect:/stu/student";
        }else{
            return "StudentAdd";
        }
    }

    @RequestMapping("/delStudent/{id}")
    public String delStudent(@PathVariable("id") Integer id){
        System.out.println("进入删除模块"+id);
        int result = studentService.delStudent(id);
        if(result!=0){
            return "redirect:/stu/student";
        }else{
            return "redirect:/stu/student";
        }
    }

}
