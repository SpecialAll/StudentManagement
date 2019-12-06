package com.zxh.student_management.mapperTest;

import com.zxh.student_management.Do.ClubDO;
import com.zxh.student_management.Do.ClubDetailsDO;
import com.zxh.student_management.Do.OtherDO;
import com.zxh.student_management.mapper.ClubMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ClubMapperTest {
    @Autowired
    private ClubMapper clubMapper;

    @Test
    public void testAll(){
//        List<OtherDO> list = clubMapper.findAllClub();
//        for (OtherDO other :list) {
//            System.out.println(other.toString());
//        }
//
//        List<ClubDO> ans = clubMapper.findAllClubs();
//        for (ClubDO club :ans) {
//            System.out.println(club.toString());
//        }

//        List<ClubDetailsDO> list = clubMapper.findByClubId(3);
//        for (ClubDetailsDO detail : list) {
//            System.out.println(detail.toString());
//        }

//        ClubDO clubDO = new ClubDO(6,"吉他社",2007,"活动中心");
//        clubMapper.insertClub(clubDO);
//        ClubDetailsDO detailsDO = new ClubDetailsDO(6,5,new Date());
//        clubMapper.insertClubDetails(detailsDO);
//
        clubMapper.deleteClub(1);
        clubMapper.deleteClubDetails(6,5);

    }
}
