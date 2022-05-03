package com.lamkirich.hospital.Repositories;

import com.lamkirich.hospital.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {}
