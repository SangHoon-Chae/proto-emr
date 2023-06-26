package com.proto.emr.repository;

import com.proto.emr.domain.dto.UpdatePatient;
import com.proto.emr.domain.model.Patient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.List;

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
        return this.crudRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "NOT_FOUND_PATIENT"));
    }

    public List<Patient> readPatients() {
        List<Patient> patients = new ArrayList<>();
        for (Patient patient : this.crudRepository.findAll()) {
            patients.add(patient);
        }
        return patients;
    }

    public Patient updatePatient(Patient patient) {
        Patient pt;
//        if(this.crudRepository.existsById(patient.getId())) {
            return this.crudRepository.save(patient);
//        }
    }
}
