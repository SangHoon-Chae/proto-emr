package com.proto.emr.controller;

import com.proto.emr.domain.dto.CreatePatient;
import com.proto.emr.domain.dto.ReadPatient;
import com.proto.emr.domain.dto.ReadPatientRes;
import com.proto.emr.domain.dto.UpdatePatient;
import com.proto.emr.domain.model.Patient;
import com.proto.emr.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emr")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/patient/save")
    public Patient saveData(@RequestBody CreatePatient dto)  {
        return patientService.save(dto);
    }

    @GetMapping("/patients")
    public List<ReadPatientRes> allPatients()  {
        return patientService.readAll();
    }

    @GetMapping("/patients/{patientId}")
    public ReadPatientRes patient(@PathVariable long patientId) {
        return patientService.read(patientId);
    }

    @PostMapping("/patient/update/{patientId}")
    public Patient update(@RequestBody UpdatePatient dto, @PathVariable long patientId) {
        return patientService.update(dto, patientId);
    }
}

//Github slack test