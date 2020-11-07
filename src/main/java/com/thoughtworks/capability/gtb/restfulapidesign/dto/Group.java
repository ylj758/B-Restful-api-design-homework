package com.thoughtworks.capability.gtb.restfulapidesign.dto;

import lombok.Data;

import java.util.List;

@Data
public class Group {
    private Integer id;
    private String name;
    private String note;
    private List<Student> students;
}
