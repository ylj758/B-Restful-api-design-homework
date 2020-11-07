package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.BusinessException;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.EmBusinessError;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class StudentService {
    final StudentRepository studentRepository;

    private List<Student> studentList;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        studentList = studentRepository.getStudents();
    }

    public void addStudent(Student student) {
        student.setId(studentList.get(studentList.size() - 1).getId() + 1);
        studentList.add(student);
    }

    public void deleteStudent(Integer studentId) throws BusinessException {
        Student delStu = null;
        for (Student stu : studentList) {
            if (stu.getId() == studentId) {
                delStu = stu;
            }
        }
        if (delStu == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        studentList.remove(delStu);
    }


    public List<Student> getStudentList() {
        return studentList;
    }

    public List<Student> getStudentListByGender(String gender) {
        return studentList.stream().filter(student -> student.getGender().equals(gender)).collect(Collectors.toList());
    }

    public Student getStudentListById(Integer id) {
        List<Student> collect = studentList.stream().filter(student -> student.getId() == id).collect(Collectors.toList());
        return collect.size() == 0 ? null : collect.get(0);
    }
}
