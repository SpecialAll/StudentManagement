package com.zxh.student_management.service.impl;

import com.zxh.student_management.Do.CheckDepartmentNumDO;
import com.zxh.student_management.Do.ClassDO;
import com.zxh.student_management.Do.DepartmentDO;
import com.zxh.student_management.Do.MajorDO;
import com.zxh.student_management.VO.ClassVO;
import com.zxh.student_management.VO.DepartmentVO;
import com.zxh.student_management.VO.MajorVO;
import com.zxh.student_management.mapper.CollegeMapper;
import com.zxh.student_management.service.CollegeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/30
 */
@Service
@Slf4j
public class CollegeServiceImpl implements CollegeService {
    @Autowired
    private CollegeMapper collegeMapper;

    @Override
    public List<DepartmentVO> findAll() {
        List<DepartmentDO> list = collegeMapper.findAllDepartments();
        List<DepartmentVO> ans = new ArrayList<>();
        for(DepartmentDO departmentDO : list) {
            ans.add(convertVO(departmentDO));
        }
        return ans;
    }

    @Override
    public List<MajorVO> findAllMajors(int departmentId) {
        List<MajorDO> list = collegeMapper.findAllMajorsByDepartmentId(departmentId);
        List<MajorVO> ans = new ArrayList<>();
        for(MajorDO majorDO : list) {
            ans.add(convertMajorVO(majorDO));
        }
        return ans;
    }

    @Override
    public int deleteMajorById(int majorId) {
        int ans = collegeMapper.deleteMajorById(majorId);
        if(ans <= 0)
            log.info("删除失败：{}", ans);
        return ans;
    }

    @Override
    public MajorVO findMajorsById(int majorId) {
        MajorDO majorDO = collegeMapper.findMajorById(majorId);
        return convertMajorVO(majorDO);
    }

    @Override
    public int updateMajor(MajorVO major) {
        int departmentId = collegeMapper.findDepartmentByName(major.getDepartmentName()).getDepartmentId();
        int ans = collegeMapper.updateMajor(major.getMajorId(), major.getMajorName(), departmentId);
        if(ans <= 0)
            log.info("更新失败：{}",ans);
        return ans;
    }

    @Override
    public void insertMajor(MajorVO major) {
        int departmentId = collegeMapper.findDepartmentByName(major.getDepartmentName()).getDepartmentId();
        MajorDO majorDO = new MajorDO();
        majorDO.setDepartmentId(departmentId);
        majorDO.setMajorName(major.getMajorName());
        int ans = collegeMapper.insertMajor(majorDO);
        if(ans <= 0)
            log.info("插入专业失败：{}",ans);
    }

    @Override
    public int deleteDepartmentById(int departmentId) {
        int ans = collegeMapper.deleteDepartmentById(departmentId);
        if(ans <= 0)
            log.info("删除失败：{}", ans);
        return ans;
    }

    @Override
    public DepartmentVO findDepartmentById(int departmentId) {
        return convertVO(collegeMapper.findDepartmentById(departmentId));
    }

    @Override
    public void updateDepartment(DepartmentVO department) {
        DepartmentDO departmentDO = new DepartmentDO();
        departmentDO.setDepartmentId(department.getDepartmentId());
        departmentDO.setDepartmentName(department.getDepartmentName());
        departmentDO.setDepartmentPlace(department.getDepartmentPlace());
        collegeMapper.updateDepartment(departmentDO);
    }

    @Override
    public void insertDepartment(DepartmentVO department) {
        DepartmentDO departmentDO = new DepartmentDO();
        departmentDO.setDepartmentId(department.getDepartmentId());
        departmentDO.setDepartmentName(department.getDepartmentName());
        departmentDO.setDepartmentPlace(department.getDepartmentPlace());
        collegeMapper.insertDepartment(departmentDO);
    }

    @Override
    public List<CheckDepartmentNumDO> checkNumber() {
        List<CheckDepartmentNumDO> list = collegeMapper.checkNum();
        if(list == null)
            return null;
        return list;
    }

    @Override
    public List<ClassVO> getClassesList() {
        List<ClassDO> list = collegeMapper.findAllClass();
        List<ClassVO> ans = new ArrayList<>();
        for(ClassDO cl : list){
            ClassVO classVO = new ClassVO();
            classVO.setClassId(cl.getClassId());
            classVO.setMajorName(collegeMapper.findMajorById(cl.getMajorId()).getMajorName());
            classVO.setDepartmentName(collegeMapper.findDepartmentById(cl.getDepartmentId()).getDepartmentName());
            classVO.setClassNumber(cl.getClassNumber());
            classVO.setYearOfClass(cl.getYearOfClass());
            ans.add(classVO);
        }
        return ans;
    }

    @Override
    public void updateClass(int classId, int newId) {
        collegeMapper.updateClass(classId, newId);
    }


    private MajorVO convertMajorVO(MajorDO majorDO) {
        MajorVO majorVO = new MajorVO();
        majorVO.setMajorId(majorDO.getMajorId());
        majorVO.setMajorName(majorDO.getMajorName());
        return majorVO;
    }

    private DepartmentVO convertVO(DepartmentDO departmentDO) {
        DepartmentVO departmentVO = new DepartmentVO();
        departmentVO.setDepartmentId(departmentDO.getDepartmentId());
        departmentVO.setDepartmentName(departmentDO.getDepartmentName());
        departmentVO.setDepartmentPlace(departmentDO.getDepartmentPlace());
        departmentVO.setDepartmentNumber(departmentDO.getDepartmentNumber());
        return departmentVO;
    }

}
