package com.lamkirich.hospital.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Medecin {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String nom ;
    private String email ;
    private String specialite ;

    @OneToMany(mappedBy = "medecin", fetch = FetchType.LAZY)
    private List<RendezVous> rendezVous ;


    @Override
    public String toString() {
        return "Medecin{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", specialite='" + specialite + '\'' +
                '}';
    }
}
