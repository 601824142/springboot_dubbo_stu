package com.wan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author 万星明
 * @Date 2019/1/15
 */
@Controller
public class IndexController {

    /**
     * 设置默认欢迎页面
     * @return
     */
    @RequestMapping("/")
    public String welcome(){
        return "Home";
    }

}
