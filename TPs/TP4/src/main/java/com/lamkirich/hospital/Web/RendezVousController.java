package com.lamkirich.hospital.Web;


import com.lamkirich.hospital.Dto.RendezVousDtoRequest;
import com.lamkirich.hospital.Dto.RendezVousDtoResponse;
import com.lamkirich.hospital.Entities.RendezVous;
import com.lamkirich.hospital.Repositories.RendezVousRepository;
import com.lamkirich.hospital.Service.HospitalImp2;
import com.lamkirich.hospital.Service.HospitalService;
import com.lamkirich.hospital.Service.HospitalServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rendezVous")
public class RendezVousController {

    @Autowired
    RendezVousRepository rendezVousRepository ;
    @Qualifier("hospitalImp")
    @Autowired
    HospitalService hospitalService ;
    @Autowired
    HospitalImp2 hospitalImp2 ;

    @GetMapping()
    public ResponseEntity<List<RendezVous>> getAllRDV(){
        List<RendezVous> rendezVousList = rendezVousRepository.findAll();
        return new ResponseEntity<>(rendezVousList, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<RendezVous> addRendezVous(@RequestBody RendezVous rendezVous) {
        RendezVous savedRendezVous = hospitalService.saveRendezVous(rendezVous);
        return new ResponseEntity<>(savedRendezVous, HttpStatus.CREATED);
    }

    @PostMapping("/add1")
    public RendezVousDtoResponse saveOne(@RequestBody RendezVousDtoRequest rendezVousDtoRequest){
        return hospitalImp2.saveRDV(rendezVousDtoRequest);
    }


}
