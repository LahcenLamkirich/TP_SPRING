package com.lamkirich.hospital.Web;


import com.lamkirich.hospital.Entities.Consultation;
import com.lamkirich.hospital.Entities.RendezVous;
import com.lamkirich.hospital.Repositories.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultation")

public class ConsultationController {

    @Autowired
    ConsultationRepository consultationRepository;

    @GetMapping("")
    public ResponseEntity<List<Consultation>> getAllConsultation() {
        List<Consultation> consultations = consultationRepository.findAll();
        return new ResponseEntity<>(consultations, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Consultation> addConsultation(@RequestBody Consultation consultation) {
        Consultation savedConsultation = consultationRepository.save(consultation) ;
        return new ResponseEntity<>(savedConsultation, HttpStatus.CREATED) ;
    }
}
