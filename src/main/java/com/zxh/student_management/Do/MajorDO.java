package com.zxh.student_management.Do;

import lombok.*;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/24
 *
 * 专业表实体类
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MajorDO {
    private int majorId;    // '专业编号',
    private String majorName;   // '专业名',
    private int departmentId;   // '系号',
}
