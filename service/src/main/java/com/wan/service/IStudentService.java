package com.wan.service;

import com.wan.pojo.Student;

import java.util.List;

/**
 * @Author 万星明
 * @Date 2019/1/15
 */
public interface IStudentService {
    //查询全部学生
    List<Student> findAllStudent();

    //添加学生
    Student addStudent(Student student);

    //删除学生
    int delStudent(Integer id);

}
