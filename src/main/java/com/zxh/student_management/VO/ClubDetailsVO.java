package com.zxh.student_management.VO;

import lombok.*;

import java.util.Date;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/12/4
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClubDetailsVO {
    private int studentId;  // '学会学生学号',
    private String studentName;  //学生姓名
    private String studentSex; //学生性别
    private String clubName; //学会名称
    private int clubId; // '学会编号',
    private Date year;  // '入会时间'
}

