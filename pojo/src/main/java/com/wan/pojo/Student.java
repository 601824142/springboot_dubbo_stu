package com.wan.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author 万星明
 * @Date 2019/1/15
 */
@Data
public class Student implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private Integer studentId;

    private String name;

    private Integer age;

    private String sex;

    private Date birth;

    private Integer classid;

    //表示该字段不是数据库中的字段
    @TableField(exist = false)
    private String className;
}
