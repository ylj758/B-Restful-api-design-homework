package com.thoughtworks.capability.gtb.restfulapidesign.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private String gender;
    private String note;

    public Student(Integer id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }
}
