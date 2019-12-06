package com.zxh.student_management.mapper;

import com.zxh.student_management.Do.StudentDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/25
 *
 * 学生：数据库操作接口
 */
@Mapper
@Repository
public interface StudentMapper {
    /**
     * 插入学生信息
     * @param studentDO
     */
    int insertStudent(StudentDO studentDO);

    /**
     * 删除一个学生，根据学号
     * @param studentId
     * @return
     */
    int deleteStudentByID(int studentId);

    /**
     * 修改一个学生的信息
     * @param studentDO
     * @return
     */
    int updateStudent(StudentDO studentDO);

    /**
     * 查看所有学生信息
     * @return
     */
    List<StudentDO> findAll();

    /**
     * 根据ID获取一个学生信息
     */
    StudentDO getStudentById(int studentId);
}
