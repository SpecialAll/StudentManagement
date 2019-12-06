package com.zxh.student_management.service;

import com.zxh.student_management.Do.StudentDO;
import com.zxh.student_management.VO.StudentVO;

import java.util.List;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/25
 *
 * 学生服务类接口
 */
public interface StudentService {

    //添加学生信息
    int addStudent(StudentVO studentVO);

    //删除学生信息
    int deleteStudent(int studentID);

    //查询所有学生信息
    List<StudentVO> findAllStudent();

    //修改一个学生信息
    int updateStudent(StudentVO studentVO);

    //根据id获取一个学生信息
    StudentVO getStudentById(int studentId);
}
