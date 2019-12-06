package com.zxh.student_management.controller;

import com.zxh.student_management.Do.CheckDepartmentNumDO;
import com.zxh.student_management.Do.ClassDO;
import com.zxh.student_management.VO.ClassVO;
import com.zxh.student_management.VO.DepartmentVO;
import com.zxh.student_management.VO.MajorVO;
import com.zxh.student_management.service.CollegeService;
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
 * @Date 2019/11/27
 *
 * 院系信息管理
 */
@Controller
@RequestMapping("/college")
@Slf4j
public class CollegeController {
    @Autowired
    private CollegeService collegeService;

    @RequestMapping("/department/list")
    public String getDepartmentsList(Model model){
        List<DepartmentVO> list = collegeService.findAll();
        model.addAttribute("list",list);
        return "/page/departmentsMessage";
    }

    @RequestMapping("/checkNum")
    public String checkNumber(Model model){
        List<CheckDepartmentNumDO> list = collegeService.checkNumber();
        model.addAttribute("list", list);
        return "/page/checkNum";
    }

    @RequestMapping("/classes")
    public String getClassesList(Model model){
        List<ClassVO> list = collegeService.getClassesList();
        model.addAttribute("list", list);
        return "/page/classMessage";
    }

    @RequestMapping("/major/{departmentId}")
    public String getMajorList(Model model,
                               @PathVariable("departmentId") int departmentId){
        List<MajorVO> list = collegeService.findAllMajors(departmentId);
        model.addAttribute("list", list);
        return "/page/majorMessage";
    }

    @RequestMapping("/major/del/{majorId}")
    public String deleteMajor(@PathVariable("majorId") int majorId){
        collegeService.deleteMajorById(majorId);
        return "redirect:/college/department/list";
    }

    @RequestMapping("/department/del/{departmentId}")
    public String deleteDepartment(@PathVariable("departmentId") int departmentId){
        collegeService.deleteDepartmentById(departmentId);
        return "redirect:/college/department/list";
    }

    //跳转到编辑页面
    @RequestMapping("/major/edit/{majorId}")
    public String toEdit(@PathVariable("majorId") int majorId, Model model){
        //获取当前专业信息
        MajorVO major = collegeService.findMajorsById(majorId);
        model.addAttribute("major", major);
        model.addAttribute("majorId", majorId);
        return "/page/editMajor";
    }

    //跳转到编辑页面
    @RequestMapping("/class/edit/{classId}")
    public String toClassEdit(@PathVariable("classId") int classId, Model model){
        //获取当前班级信息
        model.addAttribute("classId", classId);
        return "/page/editClass";
    }
    @RequestMapping(value = "/class/update", method = RequestMethod.POST)
    public String update(@RequestParam("classId") int classId,
                         @RequestParam("newId") int newId,
                         Model model, HttpSession session){
        collegeService.updateClass(classId, newId);
        return "redirect:/college/classes";
    }


    //跳转到编辑页面
    @RequestMapping("/department/edit/{departmentId}")
    public String toDepartmentEdit(@PathVariable("departmentId") int departmentId, Model model){
        //获取当前院系信息
         DepartmentVO department = collegeService.findDepartmentById(departmentId);
        model.addAttribute("department", department);
        model.addAttribute("departmentId", departmentId);
        return "/page/editDepartment";
    }

    @RequestMapping(value = "/major/update", method = RequestMethod.POST)
    public String update(MajorVO major,

                         Model model, HttpSession session){
        collegeService.updateMajor(major);
        return "redirect:/college/department/list";
    }

    @RequestMapping(value = "/department/update", method = RequestMethod.POST)
    public String updateDepartment(DepartmentVO department,

                         Model model, HttpSession session){
        collegeService.updateDepartment(department);
        return "redirect:/college/department/list";
    }

    @RequestMapping("/major/addPage")
    public String addMajor(Model model){
        return "/page/addMajor";
    }

    @RequestMapping("/department/addPage")
    public String addDepartment(Model model){
        return "/page/addDepartment";
    }

    @RequestMapping("/major/add")
    public String addSubmit(MajorVO major, Model model, HttpSession session){
        collegeService.insertMajor(major);
        return "redirect:/college/department/list";
    }

    @RequestMapping("/department/add")
    public String addDepartmentSubmit(DepartmentVO department, Model model, HttpSession session){
        collegeService.insertDepartment(department);
        return "redirect:/college/department/list";
    }
}
