package com.zxh.student_management.service;

import com.zxh.student_management.Do.CheckDepartmentNumDO;
import com.zxh.student_management.VO.ClassVO;
import com.zxh.student_management.VO.DepartmentVO;
import com.zxh.student_management.VO.MajorVO;

import java.util.List;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/27
 *
 * 院系服务接口
 */
public interface CollegeService {
    //查询所有院系信息
    List<DepartmentVO> findAll();

    //查询当前院系所有的专业信息
    List<MajorVO> findAllMajors(int departmentId);

    //删除专业
    int deleteMajorById(int majorId);

    //获取专业
    MajorVO findMajorsById(int majorId);

    //更新专业信息
    int updateMajor(MajorVO major);

    //插入一个专业
    void insertMajor(MajorVO major);

    int deleteDepartmentById(int departmentId);

    DepartmentVO findDepartmentById(int departmentId);

    void updateDepartment(DepartmentVO department);

    void insertDepartment(DepartmentVO department);

    List<CheckDepartmentNumDO> checkNumber();

    List<ClassVO> getClassesList();

    void updateClass(int classId, int newId);
}
