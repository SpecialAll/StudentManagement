package com.zxh.student_management.Do;

import lombok.*;

import java.util.Date;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/24
 *
 * 学会人员信息表
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClubDetailsDO {
    private int studentId;  // '学会学生学号',
    private int clubId; // '学会编号',
    private Date year;  // '入会时间'
}
