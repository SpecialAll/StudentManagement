package com.zxh.student_management.VO;

import lombok.*;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/30
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MajorVO {
    private int majorId;    // '专业编号',
    private String majorName;   // '专业名',
    private String departmentName; //学院名称
}

