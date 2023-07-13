package com.proto.emr.repository;

import com.proto.emr.domain.dto.UpdatePatient;
import com.proto.emr.domain.model.Patient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
            int result = this.crudRepository.updatePatient2(patient.getId(), patient.getName(), patient.getAge(), patient.getSex());
            if (result <= 0) {
                throw new RuntimeException("UPDATE_PATIENT_ERROR");
            }
            return patient;
    }

    public Patient findById(long id) {
        // Optional<T>.get() -> null or T
        /*
            Optional<Patient> optionalPatient = this.crudRepository.findById(id);
            if (optionalPatient.isPresent()) {
                return optionalPatient.get();
            } else {
                throw new RuntimeException("Patient (" + id + ") : NOT FOUND");
            }
         */

        return this.crudRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient (" + id + ") : NOT FOUND"));
    }

    public Patient deletePatientById(long id) {
        Patient returnPatient = this.crudRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient (" + id + ") : NOT FOUND"));
        crudRepository.deleteById(id);

        return returnPatient;
    }

    public void softDeletePatientById(long id) {
        if (!this.crudRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "NO_USER (" + id + ")");
        }
        crudRepository.softDeleteById(id);
    }
}
