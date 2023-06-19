package com.proto.emr.repository;

import com.proto.emr.domain.model.Patient;
import org.springframework.stereotype.Repository;

@Repository
public class PatientRepository {

    private final PatientCrudRepository crudRepository;

    public PatientRepository(PatientCrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    public Patient savePatient(Patient patient) {
        return this.crudRepository.save(patient);
    }
    public Patient readPatient(long id) {
        return this.crudRepository.findById(4L).orElse(null);
    }
}
