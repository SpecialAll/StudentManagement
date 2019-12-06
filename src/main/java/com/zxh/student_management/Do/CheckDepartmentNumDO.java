package com.zxh.student_management.Do;

import lombok.*;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/25
 *
 * 通过游标判断检查系人数是否正确，不正确返回数值并修改
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CheckDepartmentNumDO {
    private int departmentId;
    private String departmentName;
    private long departmentNumber;   //原来人数
    private long realNum;   //实际人数
}
