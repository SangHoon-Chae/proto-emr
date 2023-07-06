package com.proto.emr.repository;

import com.proto.emr.domain.dto.UpdatePatient;
import com.proto.emr.domain.model.Patient;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientCrudRepository extends CrudRepository<Patient, Long> {

//    void updatePatientById(int id);

    // JPQL => SQL을 동적으로 만들어주는 JPA 문법
    @Modifying(clearAutomatically = true)
    @Query("update Patient p set p.name=:name, p.age=:age, p.sex=:sex where p.id=:id")
    int updatePatient(long id, String name, long age, String sex);

}
