package com.lamkirich.hospital.Service;

import com.lamkirich.hospital.Entities.Consultation;
import com.lamkirich.hospital.Entities.Medecin;
import com.lamkirich.hospital.Entities.Patient;
import com.lamkirich.hospital.Entities.RendezVous;
import com.lamkirich.hospital.Repositories.ConsultationRepository;
import com.lamkirich.hospital.Repositories.MedecinRepository;
import com.lamkirich.hospital.Repositories.PatientRepository;
import com.lamkirich.hospital.Repositories.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class HospitalServiceImp implements HospitalService{
    @Autowired
    PatientRepository patientRepository ;
    @Autowired
    MedecinRepository medecinRepository ;
    @Autowired
    RendezVousRepository rendezVousRepository ;
    @Autowired
    ConsultationRepository consultationRepository ;


    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        String idRDV = UUID.randomUUID().toString();
        rendezVous.setId(idRDV);
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
