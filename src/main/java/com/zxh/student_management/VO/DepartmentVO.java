package com.zxh.student_management.VO;

import lombok.*;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/27
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DepartmentVO {
    private int departmentId;   // '系号',
    private String departmentName;  // '系名',
    private String departmentPlace;     // '办公室地点',
    private long departmentNumber;  // '系人数',
}
