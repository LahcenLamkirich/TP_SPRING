package com.lamkirich.hospital.Web;


import com.lamkirich.hospital.Entities.RendezVous;
import com.lamkirich.hospital.Repositories.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rendezVous")
public class RendezVousController {

    @Autowired
    RendezVousRepository rendezVousRepository ;

    @GetMapping()
    public ResponseEntity<List<RendezVous>> getAllRDV(){
        List<RendezVous> rendezVousList = rendezVousRepository.findAll();
        return new ResponseEntity<>(rendezVousList, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<RendezVous> addRendezVous(@RequestBody RendezVous rendezVous) {
        RendezVous savedRendezVous = rendezVousRepository.save(rendezVous);
        return new ResponseEntity<>(savedRendezVous, HttpStatus.CREATED);
    }


}
