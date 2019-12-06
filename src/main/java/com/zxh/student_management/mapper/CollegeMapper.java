package com.zxh.student_management.mapper;

import com.zxh.student_management.Do.CheckDepartmentNumDO;
import com.zxh.student_management.Do.ClassDO;
import com.zxh.student_management.Do.DepartmentDO;
import com.zxh.student_management.Do.MajorDO;
import com.zxh.student_management.VO.DepartmentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/25
 *
 * 院系班级数据库操作
 */
@Mapper
@Repository
public interface CollegeMapper {
    /**
     * 查询所有院系信息
     * @return
     */
    List<DepartmentDO> findAllDepartments();

    /**
     * 根据院系编号查询专业信息
     * @param departmentId
     * @return
     */
    List<MajorDO> findAllMajorsByDepartmentId(int departmentId);

    /**
     * 根据院系编号和专业号查询班级
     * @param departmentId
     * @param majorId
     * @return
     */
    List<ClassDO> findClassByDepartmentIdAndMajorId(@Param("departmentId") int departmentId, @Param("majorId") int majorId);

    /**
     * 插入院系信息
     * @param departmentDO
     * @return
     */
    int insertDepartment(DepartmentDO departmentDO);

    /**
     * 插入专业信息
     */
    int insertMajor(MajorDO majorDO);

    /**
     * 插入班级信息
     */
    int insertClass(ClassDO classDO);

    /**
     * 检查系人数，并修改和返回
     * @return
     */
    List<CheckDepartmentNumDO> checkNum();

    /**
     * 根据专业id查找专业名称
     * @param majorId
     * @return
     */
    MajorDO findMajorById(int majorId);

    /**
     * 根据系号查找系名
     * @param departmentId
     * @return
     */
    DepartmentDO findDepartmentById(int departmentId);

    /**
     * 根据专业名称查找ID
     */
    MajorDO findMajorByName(String name);

    DepartmentDO findDepartmentByName(String name);

    int deleteMajorById(int majorId);

    int updateMajor(@Param("majorId") int majorId, @Param("majorName") String majorName, @Param("departmentId") int departmentID);

    int deleteDepartmentById(int departmentId);

    void updateDepartment(DepartmentDO department);

    List<ClassDO> findAllClass();

    int updateClass(@Param("classId") int classId, @Param("newId") int newId);
}
