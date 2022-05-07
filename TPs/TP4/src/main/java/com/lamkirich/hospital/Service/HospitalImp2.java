package com.lamkirich.hospital.Service;

import com.lamkirich.hospital.Dto.RendezVousDtoRequest;
import com.lamkirich.hospital.Dto.RendezVousDtoResponse;
import com.lamkirich.hospital.Entities.Consultation;
import com.lamkirich.hospital.Entities.Medecin;
import com.lamkirich.hospital.Entities.Patient;
import com.lamkirich.hospital.Entities.RendezVous;
import com.lamkirich.hospital.Repositories.RendezVousRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
@Qualifier("hospitalImp2")
public class HospitalImp2 implements HospitalService{

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    RendezVousRepository rendezVousRepository;

    @Override
    public Patient savePatient(Patient patient) {
        return null;
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return null;
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        return null;
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return null;
    }

    @Override
    public RendezVousDtoResponse saveRDV(RendezVousDtoRequest rendezVousDtoRequest) {
        RendezVous RDV = modelMapper.map(rendezVousDtoRequest, RendezVous.class);
        RDV.setId(UUID.randomUUID().toString());
        RendezVous savedRDV = rendezVousRepository.save(RDV);
        return modelMapper.map(savedRDV, RendezVousDtoResponse.class);
    }

}
