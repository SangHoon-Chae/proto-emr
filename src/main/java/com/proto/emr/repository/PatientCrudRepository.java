package com.proto.emr.repository;

import com.proto.emr.domain.dto.CreatePatient;
import com.proto.emr.domain.model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientCrudRepository extends CrudRepository<Patient, Long> {
}
