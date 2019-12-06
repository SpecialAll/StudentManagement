package com.zxh.student_management.mapperTest;

import com.zxh.student_management.Do.StudentDO;
import com.zxh.student_management.mapper.StudentMapper;
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
public class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void insertStudentTest(){
        studentMapper.insertStudent(studentDO);
    }
        StudentDO studentDO = new StudentDO(8,"赵四",15,"男",2,1,2,"海棠");

    @Test
    public void testAll(){
//        studentMapper.deleteStudentByID(12);
        List<StudentDO> list = studentMapper.findAll();
        for (StudentDO student :list) {
            System.out.println(student.toString());
        }
//        studentMapper.updateStudent(studentDO);

    }
}
