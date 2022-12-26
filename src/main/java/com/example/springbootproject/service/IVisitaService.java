package com.example.springbootproject.service;

import com.example.springbootproject.dto.request.VisitaRequest;
import com.example.springbootproject.dto.response.EndVisita;
import com.example.springbootproject.dto.response.VisitaResponse;

public interface IVisitaService {
    VisitaResponse saveVisita(VisitaRequest visitaRequest);
    EndVisita endVisita(int idVisita);
    void deleteByCI(int idVisita);

}
