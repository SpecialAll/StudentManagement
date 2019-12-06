package com.zxh.student_management.service;

import com.zxh.student_management.Do.OtherDO;
import com.zxh.student_management.VO.ClubDetailsVO;
import com.zxh.student_management.VO.ClubVO;

import java.util.List;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/12/4
 */
public interface ClubService {
    //获取所有学会信息
    List<ClubVO> findAll();

    void insertClub(ClubVO club);

    void deleteClub(int clubId);

    ClubVO findById(int clubId);

    void updateClub(ClubVO club);

    List<ClubDetailsVO> getClubDetails(int clubId);

    List<OtherDO> getView();

    int insertClubDetail(ClubDetailsVO details);
}
