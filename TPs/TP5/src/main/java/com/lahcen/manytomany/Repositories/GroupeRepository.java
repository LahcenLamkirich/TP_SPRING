package com.lahcen.manytomany.Repositories;

import com.lahcen.manytomany.Entities.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupeRepository extends JpaRepository<Groupe, Long> {
    Groupe findByGroupeName(String groupeName);
}
