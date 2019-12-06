package com.zxh.student_management.mapperTest;

import com.zxh.student_management.Do.CheckDepartmentNumDO;
import com.zxh.student_management.Do.ClassDO;
import com.zxh.student_management.Do.DepartmentDO;
import com.zxh.student_management.Do.MajorDO;
import com.zxh.student_management.mapper.CollegeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CollegeMapperTest {
    @Autowired
    private CollegeMapper collegeMapper;

    @Test
    public void testAll(){
//        List<DepartmentDO> list = collegeMapper.findAllDepartments();
//        for (DepartmentDO depart : list ){
//            System.out.println(depart.toString());
//        }
//        List<MajorDO> list = collegeMapper.findAllMajorsByDepartmentId(1);
//        for(MajorDO majorDO : list){
//            System.out.println(majorDO.toString());
//        }

//        List<ClassDO> list1 = collegeMapper.findClassByDepartmentIdAndMajorId(1,1);
//        for (ClassDO classDO : list1) {
//            System.out.println(classDO.toString());
//        }
//        DepartmentDO departmentDO = new DepartmentDO(4, "外国语学院","信远楼",0);
//        collegeMapper.insertDepartment(departmentDO);

//        MajorDO majorDO = new MajorDO(7,"法语学",6);
//        collegeMapper.insertMajor(majorDO);
//
//        ClassDO classDO = new ClassDO(7, 4,2019, 6,20);
//        collegeMapper.insertClass(classDO);
        List<CheckDepartmentNumDO> list = collegeMapper.checkNum();
        for (CheckDepartmentNumDO Num : list) {
            System.out.println(Num.toString());
        }
    }
}
