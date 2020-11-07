package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Group;
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
    public List<Student> getStudents() {
        return studentService.getStudentList();
    }

    @PostMapping("/student")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @DeleteMapping("/students/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Integer id) throws BusinessException {
        studentService.deleteStudent(id);
    }

    @GetMapping("/students/{gender}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Student> getStudentsByGender(@PathVariable String gender) {
        return studentService.getStudentListByGender(gender);
    }

    @GetMapping("/student/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Student getStudentsById(@PathVariable Integer id) throws BusinessException {
        return studentService.getStudentListById(id);
    }

    @PatchMapping("/student")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void updateStudentPartInf(@RequestBody Student student) {
        studentService.updateStudentPartInfo(student);
    }

    @GetMapping("/students/groups")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Group> groupStudents() {
        return studentService.groupStudents();
    }

    @PatchMapping("/group")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void updateGroupName(@RequestBody Group group) throws BusinessException {
        studentService.updateGroupName(group);
    }

    @GetMapping("/groups")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Group> getGroups() {
        return studentService.getGroups();
    }
}
