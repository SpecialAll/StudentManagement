package com.zxh.student_management.service.impl;

import com.zxh.student_management.Do.MajorDO;
import com.zxh.student_management.Do.StudentDO;
import com.zxh.student_management.VO.StudentVO;
import com.zxh.student_management.mapper.CollegeMapper;
import com.zxh.student_management.mapper.StudentMapper;
import com.zxh.student_management.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Author ningque
 * @Date 2019/11/25
 *
 * 学生服务实体类
 */
@Service
@Slf4j
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CollegeMapper collegeMapper;

    @Override
    public int addStudent(StudentVO studentVO) {
        return studentMapper.insertStudent(convertDO(studentVO));
    }

    @Override
    public int deleteStudent(int studentID) {
        return studentMapper.deleteStudentByID(studentID);
    }

    @Override
    public List<StudentVO> findAllStudent() {
        List<StudentDO> list = studentMapper.findAll();
        List<StudentVO> ans = new ArrayList<>();
        for (StudentDO student : list) {
            ans.add(convert(student));
        }
        return ans;
    }

    @Override
    public int updateStudent(StudentVO studentVO) {
        return studentMapper.updateStudent(convertDO(studentVO));
    }

    private StudentDO convertDO(StudentVO studentVO) {
        StudentDO studentDO = new StudentDO();
        studentDO.setStudentId(studentVO.getStudentId());
        studentDO.setAge(studentVO.getAge());
        studentDO.setName(studentVO.getStudentName());
        studentDO.setSex(studentVO.getSex());
        studentDO.setClassId(studentVO.getStudentClass());
        studentDO.setDormitory(studentVO.getStudentDormitory());
        studentDO.setDepartmentId(collegeMapper.findDepartmentByName(studentVO.getStudentDepartment()).getDepartmentId());
        studentDO.setMajorId(collegeMapper.findMajorByName(studentVO.getStudentMajor()).getMajorId());
        return studentDO;
    }

    @Override
    public StudentVO getStudentById(int studentId) {
        StudentDO studentDO = studentMapper.getStudentById(studentId);
        if(studentDO != null)
            return convert(studentDO);
        return null;
    }

    private StudentVO convert(StudentDO student) {
        StudentVO studentVO = new StudentVO();
        studentVO.setStudentId(student.getStudentId());
        studentVO.setAge(student.getAge());
        studentVO.setStudentClass(student.getClassId());
        studentVO.setStudentDepartment(collegeMapper.findDepartmentById(student.getDepartmentId()).getDepartmentName());
        studentVO.setStudentDormitory(student.getDormitory());
        MajorDO majorDO = collegeMapper.findMajorById(student.getMajorId());
        if(majorDO != null)
            studentVO.setStudentMajor(majorDO.getMajorName());
        studentVO.setStudentName(student.getName());
        studentVO.setSex(student.getSex());
        return studentVO;
    }

}
