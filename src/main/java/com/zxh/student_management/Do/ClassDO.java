package com.zxh.student_management.Do;

import lombok.*;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/24
 *
 * 班级表实体类
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClassDO {
    private  int classId;       // '班级号',
    private int majorId;        // '专业号',
    private long yearOfClass;   // '入校年份',
    private int departmentId;   // '系号',
    private long classNumber;    // '人数',
}
