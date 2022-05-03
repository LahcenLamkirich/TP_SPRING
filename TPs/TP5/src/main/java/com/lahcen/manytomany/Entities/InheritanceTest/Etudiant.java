package com.lahcen.manytomany.Entities.InheritanceTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@DiscriminatorValue("ETUD")
public class Etudiant extends Person{
    private double note ;
}
