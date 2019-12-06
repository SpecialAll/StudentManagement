package com.zxh.student_management.Do;

import lombok.*;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/25
 *
 * 学会视图实体类
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OtherDO {
    private String clubName; //学会名字
    private long count;     //学会人数
}
