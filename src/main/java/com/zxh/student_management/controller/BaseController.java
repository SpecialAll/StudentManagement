package com.zxh.student_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/26
 *
 * 用作页面跳转控制层
 */
@Controller
public class BaseController {
    @RequestMapping("/student")
    public String redirect(){
        return "";
    }
}
