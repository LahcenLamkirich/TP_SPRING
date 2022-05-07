package com.lamkirich.hospital.Web;


import com.lamkirich.hospital.Entities.Patient;
import com.lamkirich.hospital.Repositories.PatientRepository;
import com.lamkirich.hospital.Service.HospitalServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    PatientRepository patientRepository ;
    @Autowired
    HospitalServiceImp hospitalServiceImp ;


    @GetMapping("/all")
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return new ResponseEntity<List<Patient>>(patients, HttpStatus.OK);
    }

    @PostMapping("/addPatient")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient){
        Patient newPatient = patientRepository.save(patient);
        return new ResponseEntity<>(newPatient, HttpStatus.CREATED);
    }


}
