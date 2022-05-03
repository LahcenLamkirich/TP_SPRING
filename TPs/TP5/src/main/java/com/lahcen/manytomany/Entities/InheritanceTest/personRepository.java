package com.lahcen.manytomany.Entities.InheritanceTest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface personRepository extends JpaRepository<Person, Long> {
}
