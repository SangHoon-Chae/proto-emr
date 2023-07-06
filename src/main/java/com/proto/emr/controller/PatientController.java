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
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/emr")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/patients")
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

    @PutMapping ("/patients/{patientId}")
    //Replace 는 put. 리소스 설계를 할 때 기본적으로 도메인 이름은 복수가 낫다.
    public Patient update(@RequestBody UpdatePatient dto, @PathVariable long patientId) {
        if (dto == null || dto.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "UpdatePatient is empty");
        }
        return patientService.update(dto, patientId);
    }

    @DeleteMapping("/{patientId}/delete")
    public Patient delete(@PathVariable long patientId) {
        Patient deleted = patientService.deletePatient(patientId);
        return deleted;
    }
}