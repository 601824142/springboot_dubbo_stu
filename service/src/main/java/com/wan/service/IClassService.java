package com.wan.service;

import com.wan.pojo.Class;

import java.util.List;

/**
 * @Author 万星明
 * @Date 2019/1/15
 */
public interface IClassService {

    //查询全部班级信息
    List<Class> findAllClass();

    //根据ID查询班级信息
    Class findClassById(Integer id);

}
