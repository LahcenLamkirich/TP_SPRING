package com.lamkirich.hospital.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Consultation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private Date dateConsultation ;
    private String rappportConsultation ;

    @OneToOne
    private RendezVous rendezVous;
}
