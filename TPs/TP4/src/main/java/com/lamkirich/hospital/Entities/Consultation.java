package com.lamkirich.hospital.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @Temporal(TemporalType.DATE)
    private Date dateConsultation ;
    private String rappportConsultation ;

    @OneToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private RendezVous rendezVous;
}
