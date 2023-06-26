package com.proto.emr.service;

import com.proto.emr.domain.dto.CreatePatient;
import com.proto.emr.domain.dto.ReadPatient;
import com.proto.emr.domain.dto.ReadPatientRes;
import com.proto.emr.domain.dto.UpdatePatient;
import com.proto.emr.domain.model.Patient;
import com.proto.emr.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    // CreatePatientRes
    // ReadPatientRes
    public ReadPatientRes read(long id) {
        Patient patient = patientRepository.readPatient(id);
        return ReadPatientRes.from(patient);
    }

    public List<ReadPatientRes> readAll() {
        List<Patient> patients = patientRepository.readPatients();
        return ReadPatientRes.from(patients);
    }

    public Patient update (UpdatePatient dto, long id) {
        dto.setId(id);
        String name = dto.getName();
        long age = dto.getAge();
        String sex = dto.getSex();

        Patient patient = Patient.builder()
                .id(id)
                .name(name)
                .age(age)
                .sex(sex)
                .build();

        return patientRepository.updatePatient(patient);
    }
}

