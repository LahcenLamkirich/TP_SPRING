package com.lamkirich.hospital;

import com.lamkirich.hospital.Entities.*;
import com.lamkirich.hospital.Repositories.ConsultationRepository;
import com.lamkirich.hospital.Repositories.MedecinRepository;
import com.lamkirich.hospital.Repositories.PatientRepository;
import com.lamkirich.hospital.Repositories.RendezVousRepository;
import com.lamkirich.hospital.Service.HospitalServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;


@SpringBootApplication
public class HospitalApplication {
    @Autowired
    PatientRepository patientRepository ;
    @Autowired
    MedecinRepository medecinRepository ;
    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Bean
    CommandLineRunner start(HospitalServiceImp hospitalServiceImp) {
        return args -> {
            // Ajout d'un patient
            Stream.of("Lahcen", "Hassan", "Nouhaila")
                    .forEach(name -> {
                        Patient patient = new Patient(null, name, new Date(), false, null);
                        Patient savedPatient = hospitalServiceImp.savePatient(patient);
                    });
            // Ajout d'un medecin
            Stream.of("Abdo", "Yasser", "Yassmine")
                    .forEach(nameMedecin -> {
                        Medecin medecin = new Medecin();
                        medecin.setNom(nameMedecin);
                        medecin.setEmail(nameMedecin + "@gmail.com");
                        medecin.setSpecialite(Math.random()>0.5? "Dentiste": "Pediatre");
                        Medecin savedMedecin = hospitalServiceImp.saveMedecin(medecin);
                    });

                Patient p1 = patientRepository.findPatientByNom("Lahcen");
                Medecin m1 = medecinRepository.findByNom("Yassmine");

                // Ajout d'un rendez vous
                RendezVous rendezVous = new RendezVous();
                DateFormat df = new SimpleDateFormat("dd-mm-yyyy");
                Date d1 = df.parse("08-08-2022");
                rendezVous.setDateRendezVous(d1);
                rendezVous.setStatus(StatusRDV.PENDING);
                rendezVous.setPatient(p1);
                rendezVous.setMedecin(m1);

               RendezVous savedRDV =  hospitalServiceImp.saveRendezVous(rendezVous);

                //Ajout d'une consultation :
                Consultation consultation = new Consultation();
                consultation.setDateConsultation(rendezVous.getDateRendezVous());
                consultation.setRendezVous(rendezVous);
                consultation.setRappportConsultation("Le rapport de la consultation ... ");

                Consultation savedConsultation = hospitalServiceImp.saveConsultation(consultation);

        };
    }

}
