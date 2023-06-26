package com.proto.emr.domain.dto;

import com.proto.emr.domain.model.Patient;

import java.util.ArrayList;
import java.util.List;

public class ReadPatientRes {

    private final Long id;

    private final String name;

    private final Long age;

    private ReadPatientRes(long id, String name, long age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static ReadPatientRes from(Patient patient) {
        long id = patient.getId();
        String name = patient.getName();
        long age = patient.getAge();
        return new ReadPatientRes(id, name, age);
    }

    public static List<ReadPatientRes> from(List<Patient> patients) {
        List<ReadPatientRes> readPatientResList = new ArrayList<>();
        for(Patient patient : patients) {
            readPatientResList.add(from(patient));
        }
        return readPatientResList;
    }

    public Long getAge() {
        return age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return name;
    }

}

/*

{
    "age" : 30,
    "id" : 123,
    "name" : "lucas",
    "full_name" : "lucas"
}


 */
