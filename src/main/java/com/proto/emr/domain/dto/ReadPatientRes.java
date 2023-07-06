package com.proto.emr.domain.dto;

import com.proto.emr.domain.model.Patient;

import java.util.ArrayList;
import java.util.List;

public class ReadPatientRes {
    private final Long id;
    private final String name;
    private final Long age;
    private final String createdAt;
    private final boolean delete;
    private final String updatedAt;

    private ReadPatientRes(long id, String name, long age, String createdAt, String updatedAt, boolean delete) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.updatedAt =  updatedAt;
        this.delete = delete;
        this.createdAt = createdAt;
    }

    public static ReadPatientRes from(Patient patient) {
        long id = patient.getId();
        String name = patient.getName();
        long age = patient.getAge();
        String createTime = patient.getCreatedAt();
        String updateTime = patient.getUpdatedAt();
        Boolean delete = patient.getDeleted();
        return new ReadPatientRes(id, name, age, createTime, updateTime, delete);
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

    public String getCreateTime() {
        return createdAt;
    }
    public String getUpdateTime() {
        return updatedAt;
    }
    public boolean getDelete() {
        return delete;
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
