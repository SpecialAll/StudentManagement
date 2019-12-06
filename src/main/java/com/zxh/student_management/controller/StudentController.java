package com.zxh.student_management.controller;

import com.zxh.student_management.VO.StudentVO;
import com.zxh.student_management.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/26
 *
 * 学生信息管理
 */
@Controller
@RequestMapping("/student")
@Slf4j
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/index")
    public String indexPage(Model model){
        log.info("进入跳转方法");
        return "/page/index";
    }

    @RequestMapping("/list")
    public String getStudentList(Model model){
        log.info("跳转到list");
        List<StudentVO> list = studentService.findAllStudent();
        model.addAttribute("list", list);
        log.info("将要进入信息详情页");
        return "/page/studentMessages";
    }

    @RequestMapping("/del/{studentId}")
    public String deleteStudent(@PathVariable("studentId") int studentId){
        studentService.deleteStudent(studentId);
        return "redirect:/student/list";
    }

    //跳转到编辑页面
    @RequestMapping("/edit/{studentId}")
    public String toEdit(@PathVariable("studentId") int studentId, Model model){
        //获取当前学生信息
        StudentVO student = studentService.getStudentById(studentId);
        model.addAttribute("studentId", studentId);
        model.addAttribute("student", student);
        return "/page/editStudent";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(StudentVO student,

                        Model model, HttpSession session){
        studentService.updateStudent(student);
        return "redirect:/student/list";
    }

    @RequestMapping("/addPage")
    public String addStudent(Model model){
        return "/page/addStudent";
    }

    @RequestMapping("/add")
    public String addSubmit(StudentVO student, Model model, HttpSession session){
        studentService.addStudent(student);
        return "redirect:/student/list";
    }
}
