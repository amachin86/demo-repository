package com.example.springbootproject.service;


import com.example.springbootproject.dto.request.VisitaRequest;
import com.example.springbootproject.dto.response.EndVisita;
import com.example.springbootproject.dto.response.VisitaResponse;
import com.example.springbootproject.entity_dao.Visita;
import com.example.springbootproject.entity_dao.Visitante;
import com.example.springbootproject.repository.VisitaRepository;
import com.example.springbootproject.repository.VisitanteRepository;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class VisitaServiceImpl implements IVisitaService {
    @Autowired
    VisitaRepository visitaRepository;
    @Autowired
    VisitanteRepository visitanteRepository;

    @Autowired
    Mapper mapper;


    @Override
    public VisitaResponse saveVisita(VisitaRequest visitaRequest) {
        //obtiene el visitante a partir de su ci
        Visitante visitante = visitanteRepository.findByCi(visitaRequest.getCi());
        if (visitante == null) {
            throw new RuntimeException("Id de visitante no encontrado");
        }
        Visita visita = mapper.map(visitaRequest, Visita.class);
        visita.setPersona(visitante);
        visita.setInFecha(LocalDate.now());
        visita.setInHour(LocalTime.now());
        Visita updateVisita = visitaRepository.saveAndFlush(visita);
        //devuelve una instancia de la clase visita Response
        VisitaResponse visitaResponse = new VisitaResponse(visita);

        return visitaResponse;
    }
    @Override
    public EndVisita endVisita(int idVisita) {
        Visita visita = visitaRepository.findByIdVisita(idVisita);
        if (visita == null) {
            throw new RuntimeException("Id de visita no encontrado");
        }
        visita.setOutFecha(LocalDate.now());
        visita.setOutHour(LocalTime.now());
        Visita updateVisita = visitaRepository.saveAndFlush(visita);
        //devuelve una instancia de la clase visita Response
       EndVisita response = new EndVisita("Visita finalizada", idVisita, visita.getOutFecha(), visita.getOutHour());
        return response;
    }

    @Override
    public void deleteByCI(int idVisita) {
        visitaRepository.deleteByIdVisita(idVisita);
    }

}
