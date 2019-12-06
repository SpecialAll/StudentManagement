package com.zxh.student_management.Do;

import lombok.*;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/24
 *
 * 学会表实体类
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClubDO {
    private long clubId;    // '学会号',
    private String clubName;    // '学会名',
    private long establishedTime;      // 成立年份',
    private String clubPlace;   // '地点',
}
