package com.zxh.student_management.service.impl;

import com.zxh.student_management.Do.ClubDO;
import com.zxh.student_management.Do.ClubDetailsDO;
import com.zxh.student_management.Do.OtherDO;
import com.zxh.student_management.Do.StudentDO;
import com.zxh.student_management.VO.ClubDetailsVO;
import com.zxh.student_management.VO.ClubVO;
import com.zxh.student_management.mapper.ClubMapper;
import com.zxh.student_management.mapper.StudentMapper;
import com.zxh.student_management.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/12/4
 */
@Service
public class ClubServiceImpl implements ClubService {
    @Autowired
    private ClubMapper clubMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<ClubVO> findAll() {
        List<ClubDO> list = clubMapper.findAllClubs();
        List<ClubVO> ans = new ArrayList<>();
        for(ClubDO club : list){
            ans.add(convert(club));
        }
        return ans;
    }

    @Override
    public void insertClub(ClubVO club) {
        ClubDO clubDO = new ClubDO();
        clubDO.setClubId(club.getClubId());
        clubDO.setClubName(club.getClubName());
        clubDO.setClubPlace(club.getClubPlace());
        clubDO.setEstablishedTime(club.getEstablishedTime());
        clubMapper.insertClub(clubDO);
    }

    @Override
    public void deleteClub(int clubId) {
        clubMapper.deleteClub(clubId);
    }

    @Override
    public ClubVO findById(int clubId) {
        return convert(clubMapper.findById(clubId));
    }

    @Override
    public void updateClub(ClubVO club) {
        ClubDO clubDO = new ClubDO();
        clubDO.setClubId(club.getClubId());
        clubDO.setClubName(club.getClubName());
        clubDO.setClubPlace(club.getClubPlace());
        clubMapper.updateClub(clubDO);
    }

    @Override
    public List<ClubDetailsVO> getClubDetails(int clubId) {
        List<ClubDetailsDO> list = clubMapper.findByClubId(clubId);
        List<ClubDetailsVO> ans = new ArrayList<>();
        for(ClubDetailsDO details : list){
            ClubDetailsVO detailsVO = new ClubDetailsVO();
            StudentDO student = studentMapper.getStudentById(details.getStudentId());
            detailsVO.setStudentName(student.getName());
            detailsVO.setYear(details.getYear());
            detailsVO.setStudentSex(student.getSex());
            detailsVO.setStudentId(details.getStudentId());
            ans.add(detailsVO);
        }
        return ans;
    }

    @Override
    public List<OtherDO> getView() {
        return clubMapper.getView();
    }

    @Override
    public int insertClubDetail(ClubDetailsVO details) {
        ClubDetailsDO detailDO = new ClubDetailsDO();
        detailDO.setStudentId(details.getStudentId());
        detailDO.setYear(details.getYear());
        detailDO.setClubId((int) clubMapper.findClubByName(details.getClubName()).getClubId());
        return clubMapper.insertClubDetails(detailDO);

    }

    public static ClubVO convert(ClubDO clubDO){
        ClubVO clubVO = new ClubVO();
        clubVO.setClubId(clubDO.getClubId());
        clubVO.setClubName(clubDO.getClubName());
        clubVO.setClubPlace(clubDO.getClubPlace());
        clubVO.setEstablishedTime(clubDO.getEstablishedTime());
        return clubVO;
    }

    public static ClubDetailsVO convertDetailsVO(ClubDetailsDO clubDetails){
        ClubDetailsVO clubDetailsVO = new ClubDetailsVO();
        clubDetailsVO.setClubId(clubDetails.getClubId());
        return null;
    }
}
