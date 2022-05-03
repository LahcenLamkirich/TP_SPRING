package com.lamkirich_orm.Repositories;

import com.lamkirich_orm.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findPatientByName(String name);
    Patient findByMaladeAndScoreLessThan(Boolean malade, double score);

    @Query("select p from Patient p where p.score = :score or p.name = :namePatient")
    List<Patient> chercherParScore(@Param("score") double score, @Param("namePatient") String name);

}
