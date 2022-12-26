package com.example.springbootproject.repository;

import com.example.springbootproject.entity_dao.Visita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitaRepository extends JpaRepository<Visita, Long> {

    public Visita findByIdVisita(int id);
    Visita deleteByIdVisita(int id);
}
