package com.zxh.student_management.controller;

import com.zxh.student_management.Do.OtherDO;
import com.zxh.student_management.VO.ClubDetailsVO;
import com.zxh.student_management.VO.ClubVO;
import com.zxh.student_management.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/12/4
 *
 * 学会控制层
 */
@Controller
@RequestMapping("/club")
public class ClubController {
    @Autowired
    private ClubService clubService;

    @RequestMapping("/list")
    public String clubs(Model model){
        List<ClubVO> list = clubService.findAll();
        model.addAttribute("list", list);
        return "/page/clubsMessage";
    }

    @RequestMapping("/addPage")
    public String addClub(Model model){
        return "/page/addClub";
    }

    @RequestMapping("/student/addPage")
    public String addStudent(Model model){
        return "/page/addClubStudent";
    }


    @RequestMapping("/add")
    public String addSubmit(ClubVO club, Model model, HttpSession session){
        clubService.insertClub(club);
        return "redirect:/club/list";
    }

    @RequestMapping("/student/add")
    public String addStudentSubmit(ClubDetailsVO details,
                                   @RequestParam("time")
                                   String time,
                                   Model model, HttpSession session){
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        details.setYear(date);
        clubService.insertClubDetail(details);
        return "redirect:/club/list";
    }

    @RequestMapping("/del/{clubId}")
    public String deleteClub(@PathVariable("clubId") int clubId){
        clubService.deleteClub(clubId);
        return "redirect:/club/list";
    }
    @RequestMapping("/edit/{clubId}")
    public String editClub(@PathVariable("clubId") int clubId, Model model){
        ClubVO club = clubService.findById(clubId);
        model.addAttribute("club", club);
        model.addAttribute("cludId", clubId);
        return "/page/editClub";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateClub(ClubVO club,Model model, HttpSession session){
        clubService.updateClub(club);
        return "redirect:/club/list";
    }

    @RequestMapping("/details/{clubId}")
    public String clubDetails(@PathVariable("clubId") int clubId, Model model){
        List<ClubDetailsVO> list = clubService.getClubDetails(clubId);
        model.addAttribute("list", list);
        return "/page/clubDetailsMessage";
    }

    @RequestMapping("/view")
    public String getView(Model model){
        List<OtherDO> list = clubService.getView();
        model.addAttribute("list", list);
        return "/page/viewMessage";
    }
}
