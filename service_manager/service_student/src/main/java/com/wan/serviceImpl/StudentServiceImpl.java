package com.wan.serviceImpl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wan.dao.IStudentDao;
import com.wan.pojo.Class;
import com.wan.pojo.Student;
import com.wan.service.IClassService;
import com.wan.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author 万星明
 * @Date 2019/1/15
 */
@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentDao studentDao;
    @Reference
    private IClassService classService;

    /**
     * 查询全部学生信息
     * @return
     */
    @Override
    public List<Student> findAllStudent() {
        List<Student> studentList = studentDao.selectList(new QueryWrapper<>());

        for (Student student : studentList){
            Class classById = classService.findClassById(student.getClassid());
            student.setClassName(classById.getClassname());
        }
        return studentList;
    }


    /**
     * 添加学生
     * @param student
     * @return
     */
    @Override
    public Student addStudent(Student student) {
        int result = studentDao.insert(student);
        if(result==0){
            return null;
        }else {
            return student;
        }
    }


    /**
     * 删除学生
     * @param id
     * @return
     */
    @Override
    public int delStudent(Integer id) {
        int result = studentDao.deleteById(id);
        return result;
    }


}
