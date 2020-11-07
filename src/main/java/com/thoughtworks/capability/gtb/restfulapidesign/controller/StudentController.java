package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.BusinessException;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Student> getStudents(){
        return studentService.getStudentList();
    }

    @PostMapping("/student")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @DeleteMapping("/students/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Integer id) throws BusinessException {
        studentService.deleteStudent(id);
    }

    @GetMapping("/students/{gender}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Student> getStudentsByGender(@PathVariable String gender){
        return studentService.getStudentListByGender(gender);
    }

}
