package com.zxh.student_management.Do;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/24
 *
 * 数据库实体类 学生表
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentDO {
    private long studentId ;
    private String name ;
    private int age;
    private String sex;
    private int majorId;   //'专业号'
    private int departmentId;          // '系号',
    private int classId;        //'班级号',
    private String dormitory; // '宿舍区',
}
