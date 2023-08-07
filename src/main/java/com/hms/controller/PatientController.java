package com.hms.controller;

import com.hms.entity.Patient;
import com.hms.payload.PatientDTO;
import com.hms.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    private final PatientService patientService;

    // Constructor injection of PatientService
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // Endpoint to create a new patient
    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody PatientDTO patientDTO) {
        // Delegate the creation logic to the PatientService
        Patient patient = patientService.createPatient(patientDTO);

        // Return the created patient in the response body with HTTP status 201 (CREATED)
        return new ResponseEntity<>(patient, HttpStatus.CREATED);
    }
}
