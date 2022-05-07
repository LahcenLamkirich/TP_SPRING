package com.lamkirich.hospital.Web;


import com.lamkirich.hospital.Entities.Medecin;
import com.lamkirich.hospital.Repositories.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("medecin")
public class MedecinController {

    @Autowired
    MedecinRepository medecinRepository ;

    @GetMapping()
    public ResponseEntity<List<Medecin>> getAllMedecins(){
        List<Medecin> medecins = medecinRepository.findAll();
        return new ResponseEntity<>(medecins, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Medecin> addMedecin(@RequestBody Medecin medecin){
        Medecin savedMedecin = medecinRepository.save(medecin);
        return new ResponseEntity<>(savedMedecin, HttpStatus.CREATED);
    }
}

