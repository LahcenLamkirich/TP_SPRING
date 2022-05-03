package com.lamkirich_orm;

import com.lamkirich_orm.Entities.Patient;
import com.lamkirich_orm.Repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@SpringBootApplication

public class Tp3OrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tp3OrmApplication.class, args);
    }

    @Bean
    CommandLineRunner start(PatientRepository patientRepository) {
        return args -> {
            patientRepository.save(new Patient(null, "lahcen", 21, new Date(), false, 240));
            patientRepository.save(new Patient(null, "Hamid", 24, new Date(), true, 450));
            patientRepository.save(new Patient(null, "Reda", 25, new Date(), false, 142));
            patientRepository.save(new Patient(null, "Khaled", 18, new Date(), false, 523));
            // get all the patients :

            patientRepository.findAll().forEach(patient -> {
                System.out.println(patient.getId() + " " + patient.getName() + " " + patient.getAge() +
                        " " + patient.getDateNaissance() + " " + patient.isMalade() + " " + patient.getScore());
            });

            Patient p = patientRepository.findPatientByName("lahcen");
            System.out.println(p);
            System.out.println("**");
            Patient p1 = patientRepository.findByMaladeAndScoreLessThan(true, 500);
            System.out.println(p1);

            System.out.println("Get Patient par score or name");

            List<Patient> p0 = patientRepository.chercherParScore(450, "lahcen");
            p0.forEach(patient -> {
                System.out.println(patient);
            });

        };
    }
}
