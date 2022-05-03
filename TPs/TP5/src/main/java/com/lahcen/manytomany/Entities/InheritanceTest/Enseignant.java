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
@DiscriminatorValue("PROF")
public class Enseignant extends Person{
    private String matiere ;
}
