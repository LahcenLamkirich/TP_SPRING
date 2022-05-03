package com.lamkirich.hospital.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class RendezVous {

    @Id
    private String id ;
    @Temporal(TemporalType.DATE)
    private Date dateRendezVous;
    @Enumerated(EnumType.STRING)
    private StatusRDV status ;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Patient patient ;
    @ManyToOne
    private Medecin medecin ;
    @OneToOne(mappedBy = "rendezVous")
    private Consultation consultation ;

    @Override
    public String toString() {
        return "RendezVous{" +
                "id=" + id +
                ", dateRendezVous=" + dateRendezVous +
                ", status=" + status +
                ", patient=" + patient +
                ", medecin=" + medecin +
                '}';
    }
}
