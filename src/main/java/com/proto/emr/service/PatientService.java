package com.proto.emr.service;

import com.proto.emr.domain.dto.CreatePatient;
import com.proto.emr.domain.dto.ReadPatientRes;
import com.proto.emr.domain.dto.UpdatePatient;
import com.proto.emr.domain.model.Patient;
import com.proto.emr.repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
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
        String sex = dto.getSex();

        LocalDateTime now = LocalDateTime.now();

        Patient patient = Patient.builder()
                .name(name)
                .age(age)
                .sex(sex)
                .createdAt(now)
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

    @Transactional
    public Patient update (UpdatePatient dto, long id) {

        /*
            String name = dto.getName();
            long age = dto.getAge();
            String sex = dto.getSex();

            Patient patient = Patient.builder()
                    .id(id)
                    .name(name)
                    .age(age)
                    .sex(sex)
                    .build();
         */

        Patient patient = patientRepository.findById(id);
        patient.update(dto);

        return patientRepository.updatePatient(patient);
    }

    public Patient deletePatient(long patientId) {
        return patientRepository.deletePatientById(patientId);
    }

    @Transactional
    public void softDeletePatient(long patientId) {
        patientRepository.softDeletePatientById(patientId);
    }
}