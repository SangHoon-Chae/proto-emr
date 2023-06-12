package com.proto.emr.service;

import com.proto.emr.domain.dto.CreatePatient;
import com.proto.emr.domain.model.Patient;
import com.proto.emr.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient save(CreatePatient dto) {
        String name = dto.getName();
        long age = dto.getAge();

        Patient patient = Patient.builder()
                .name(name)
                .age(age)
                .build();

        return patientRepository.savePatient(patient);
    }
}

