package com.lamkirich.hospital;

import com.lamkirich.hospital.Entities.Consultation;
import com.lamkirich.hospital.Entities.Patient;
import com.lamkirich.hospital.Entities.RendezVous;
import com.lamkirich.hospital.Entities.StatusRDV;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Bean
    CommandLineRunner start() {
        return args -> {
            Patient patient1 = new Patient(null, "Lahcen Lamkirich", new Date(), false, null);
            Patient patient2 = new Patient(null, "Ahmed Samir", new Date(), true, null);
            DateFormat df = new SimpleDateFormat("dd-mm-yyyy");
            Date d1 = df.parse("01-06-2022");
            RendezVous rendezVous1 = new RendezVous(null, d1, StatusRDV.PENDING, null, null, null);
            Consultation consultation = new Consultation();
        };
    }

}
