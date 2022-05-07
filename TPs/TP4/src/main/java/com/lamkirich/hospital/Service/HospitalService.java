package com.lamkirich.hospital.Service;

import com.lamkirich.hospital.Dto.RendezVousDtoRequest;
import com.lamkirich.hospital.Dto.RendezVousDtoResponse;
import com.lamkirich.hospital.Entities.Consultation;
import com.lamkirich.hospital.Entities.Medecin;
import com.lamkirich.hospital.Entities.Patient;
import com.lamkirich.hospital.Entities.RendezVous;

public interface HospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRendezVous(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
    RendezVousDtoResponse saveRDV(RendezVousDtoRequest rendezVousDtoRequest);
}
