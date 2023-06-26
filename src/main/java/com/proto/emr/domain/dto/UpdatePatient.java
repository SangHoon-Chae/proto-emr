package com.proto.emr.domain.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePatient {
    private long id;
    private String name;
    private long age;
    private String sex;
}
