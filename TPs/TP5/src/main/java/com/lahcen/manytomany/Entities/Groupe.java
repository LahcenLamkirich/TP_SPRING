package com.lahcen.manytomany.Entities;

import lombok.*;
import org.apache.catalina.LifecycleState;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Groupe {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String groupeName ;
    @ManyToMany(fetch = FetchType.LAZY)
    List<User> users = new ArrayList<>();

    @Override
    public String toString() {
        return "Groupe{" +
                "id=" + id +
                ", groupeName='" + groupeName + '\'' +
                '}';
    }
}
