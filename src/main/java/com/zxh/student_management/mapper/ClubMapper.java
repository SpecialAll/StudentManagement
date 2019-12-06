package com.zxh.student_management.mapper;

import com.zxh.student_management.Do.ClubDO;
import com.zxh.student_management.Do.ClubDetailsDO;
import com.zxh.student_management.Do.OtherDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/25
 *
 * 学会数据库操作
 */
@Mapper
@Repository
public interface ClubMapper {
    /**
     * 查询所有学会视图信息
     * @return
     */
    List<OtherDO> findAllClub();

    /**
     * 插入一个学会信息
     * @param clubDO
     */
    int insertClub(ClubDO clubDO);

    /**
     * 插入参加学会的学生信息
     */
    int insertClubDetails(ClubDetailsDO detailsDO);

    /**
     * 根据学会名删除指定学会
     * @param clubId
     * @return
     */
    int deleteClub(int clubId);

    /**
     * 删除指定学生和学会的学生信息
     * @param studentId
     * @param clubId
     * @return
     */
    int deleteClubDetails(@Param("studentId") int studentId, @Param("clubId") int clubId);

    /**
     * 查询指定学会的学会人员信息
     * @param clubId
     * @return
     */
    List<ClubDetailsDO> findByClubId(@Param("clubId") int clubId);

    /**
     * 查询所有学会信息
     * @return
     */
    List<ClubDO> findAllClubs();

    ClubDO findById(@Param("clubId") int clubId);

    int updateClub(ClubDO clubDO);

    /**
     * 获取视图数据
     */
    List<OtherDO> getView();

    ClubDO findClubByName(String clubName);
}
