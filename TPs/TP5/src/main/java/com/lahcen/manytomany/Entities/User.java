package com.lahcen.manytomany.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String username ;
    private String password ;

    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    List<Groupe> groupes = new ArrayList<>();
}
