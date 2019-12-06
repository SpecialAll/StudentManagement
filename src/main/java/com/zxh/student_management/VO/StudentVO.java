package com.zxh.student_management.VO;

import lombok.*;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/25
 *
 * 服务层实体类
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentVO {
    private long studentId;
    private String studentName;
    private int age;
    private String sex;
    private String studentMajor;   //'专业'
    private String studentDepartment;          // '系',
    private int studentClass;        //'班级号',
    private String studentDormitory; // '宿舍区',
}