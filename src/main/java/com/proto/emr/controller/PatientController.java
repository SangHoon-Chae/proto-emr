package com.proto.emr.controller;

import com.proto.emr.domain.dto.CreatePatient;
import com.proto.emr.domain.dto.ReadPatient;
import com.proto.emr.domain.model.Patient;
import com.proto.emr.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emr/patient")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save")
    public Patient saveData(@RequestBody CreatePatient dto)  {
        return patientService.save(dto);
    }

    @GetMapping("/read")
    public Patient readData()  {
        Patient p = patientService.read(3);
        return patientService.read(3);
    }
}

//Github slack test