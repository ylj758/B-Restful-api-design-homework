package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private List<Student> studentList;
    private List<Group> groupList;

    public List<Student> getStudents() {
        studentList = new ArrayList<>();
        studentList.add(new Student(1, "成吉思汗", "male"));
        studentList.add(new Student(2, "鲁班七号", "male"));
        studentList.add(new Student(3, "太乙真人", "male"));
        studentList.add(new Student(4, "钟无艳", "female"));
        studentList.add(new Student(5, "花木兰", "female"));
        studentList.add(new Student(6, "雅典娜", "female"));
        studentList.add(new Student(7, "芈月", "female"));
        studentList.add(new Student(8, "白起", "male"));
        studentList.add(new Student(9, "刘禅", "male"));
        studentList.add(new Student(10, "庄周", "male"));
        studentList.add(new Student(11, "马超", "male"));
        studentList.add(new Student(12, "刘备", "male"));
        studentList.add(new Student(13, "哪吒", "male"));
        studentList.add(new Student(14, "大乔", "female"));
        studentList.add(new Student(15, "蔡文姬", "female"));
        return studentList;
    }

    public List<Group> getGroups(){
        groupList = new ArrayList<>(6);
        groupList.add(new Group(1, "1 组",null,null));
        groupList.add(new Group(2, "2 组",null,null));
        groupList.add(new Group(3, "3 组",null,null));
        groupList.add(new Group(4, "4 组",null,null));
        groupList.add(new Group(5, "5 组",null,null));
        groupList.add(new Group(6, "6 组",null,null));
        return groupList;
    }
}
