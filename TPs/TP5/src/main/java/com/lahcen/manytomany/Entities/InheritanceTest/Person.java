package com.lahcen.manytomany.Entities.InheritanceTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", length = 4)
public abstract class Person {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerson ;
    private String name ;
    private int age ;
}
