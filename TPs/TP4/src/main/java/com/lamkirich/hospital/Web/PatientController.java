package com.lamkirich.hospital.Web;


import com.lamkirich.hospital.Entities.Patient;
import com.lamkirich.hospital.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    PatientRepository patientRepository ;

    @GetMapping
    List<Patient> allPatients(){
        return patientRepository.findAll();
    }
}
