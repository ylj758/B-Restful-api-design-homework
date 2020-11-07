package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.BusinessException;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.EmBusinessError;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class StudentService {
    final StudentRepository studentRepository;

    private List<Student> studentList;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
        studentList = studentRepository.getStudents();
    }

    public void addStudent(Student student) {
        student.setId(studentList.get(studentList.size()-1).getId()+1);
        studentList.add(student);
    }

    public void deleteStudent(Integer studentId) throws BusinessException {
        Student delStu = null;
        for (Student stu : studentList){
            if(stu.getId() == studentId){
                delStu = stu;
            }
        }
       if(delStu == null){
           throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
       }
       studentList.remove(delStu);
    }


    public List<Student> getStudentList() {
        return studentList;
    }
}
