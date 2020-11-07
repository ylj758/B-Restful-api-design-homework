package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.BusinessException;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.EmBusinessError;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        Optional<Student> studentOptional = getStudentById(studentId);
        if (!studentOptional.isPresent()){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        studentList.remove(studentOptional.get());
    }


    public List<Student> getStudentList() {
        return studentList;
    }

    public List<Student> getStudentListByGender(String gender) {
        return studentList.stream().filter(student -> student.getGender().equals(gender)).collect(Collectors.toList());
    }

    public Student getStudentListById(Integer id) throws BusinessException {
        Optional<Student> studentOptional = getStudentById(id);
        if (!studentOptional.isPresent()){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        return studentOptional.get();
    }

    public void updateStudentPartInfo(Student student) {
        Optional<Student> studentOptional = getStudentById(student.getId());
        if (studentOptional.isPresent()){
            Student stu = studentOptional.get();
            stu.setGender(student.getGender());
            stu.setName(student.getName());
            stu.setNote(student.getNote());
        }

    }

    private Optional<Student> getStudentById(Integer id){
        List<Student> collect = studentList.stream().filter(student -> student.getId() == id).collect(Collectors.toList());
        return collect.size() == 0 ? null : Optional.of(collect.get(0));
    }
}
