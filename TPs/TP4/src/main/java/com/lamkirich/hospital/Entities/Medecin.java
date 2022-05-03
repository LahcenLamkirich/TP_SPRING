package com.lamkirich.hospital.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Medecin {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String nom ;
    private String email ;
    private String specialite ;

    @OneToMany(mappedBy = "medecin", fetch = FetchType.LAZY)
    private List<RendezVous> rendezVous ;
}
