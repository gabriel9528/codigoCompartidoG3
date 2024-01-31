package com.relations.ManyToMany.repository;

import com.relations.ManyToMany.entity.Fiesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface FiestaRepository extends CrudRepository<Fiesta, Long> {
    Collection<Fiesta> findAll();
}
