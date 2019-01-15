package com.wan.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wan.dao.IClassDao;
import com.wan.pojo.Class;
import com.wan.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author 万星明
 * @Date 2019/1/15
 */
@Service
public class ClassServiceImpl implements IClassService {

    @Autowired
    private IClassDao classDao;

    /**
     * 查询全部班级
     * @return
     */
    @Override
    public List<Class> findAllClass() {
        return classDao.selectList(new QueryWrapper<>());
    }

    /**
     * 根据ID查询班级信息
     * @param id
     * @return
     */
    @Override
    public Class findClassById(Integer id) {
        return classDao.selectById(id);
    }


}
