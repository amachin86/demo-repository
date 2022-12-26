package com.example.springbootproject.service;

import com.example.springbootproject.dto.request.VisitanteRequest;
import com.example.springbootproject.dto.response.VisitanteResponse;
import com.example.springbootproject.entity_dao.Visitante;
import com.example.springbootproject.projections.CantVisitanteDTO;
import com.example.springbootproject.projections.CantVisitantes;
import com.example.springbootproject.projections.VisitorDTO;
import com.example.springbootproject.repository.VisitanteRepository;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitanteServiceImpl implements IVisitanteService {
    @Autowired
    VisitanteRepository visitanteRepository;
    @Autowired
    Mapper mapper;

    @Override
    @Transactional
    public VisitanteResponse saveVisitor(VisitanteRequest visitanteRequest){
        Visitante visitante = mapper.map(visitanteRequest, Visitante.class);
        Visitante updateVisitante = visitanteRepository.saveAndFlush(visitante);
        VisitanteResponse visitanteResponse = mapper.map(updateVisitante, VisitanteResponse.class);
        return visitanteResponse;

    }

    @Override
    public List<VisitanteResponse> findAll() {
        return visitanteRepository.findAll().stream().map(VisitanteResponse::new).collect(Collectors.toList());
    }

    @Override
    public Page<VisitanteResponse> findAll(Pageable pageable){
        return visitanteRepository.findAll(pageable).map(VisitanteResponse::new);

    }

    @Override
    public VisitanteResponse deleteByCI(String ci) {
       Visitante deleteVisitante = visitanteRepository.deleteByCi(ci);
       VisitanteResponse visitanteResponse = mapper.map(deleteVisitante, VisitanteResponse.class);
       return visitanteResponse;

    }

    @Override
    public List<VisitorDTO> visitorList() {
        return visitanteRepository.visitorList();
    }

    @Override
    public CantVisitanteDTO cantVisitors(String dateStar, String dateEnd) {
        return visitanteRepository.cantVisitantes(dateStar, dateEnd);
    }

    @Override
    public CantVisitantes cantVisitorForRangeHours(String hStar, String hEnd) {
        return visitanteRepository.cantVisitForRangeHours(hStar, hEnd);
    }
    @Override
    public CantVisitantes cantVisitorForRangeHoursAndDates(String hourStar, String hourEnd,
                                                           String dateStar, String dateEnd) {
        return visitanteRepository.cantVisitForRangeHoursAndDates(hourStar, hourEnd, dateStar, dateEnd);
    }

    @Override
    public List<VisitorDTO> listVisitorRangeHour(String hourStar, String hourEnd) {
        return visitanteRepository.listVisitorRangeHour(hourStar, hourEnd);
    }

    @Override
    public List<VisitorDTO> listVisitorRangeDate(String dateStar, String dateEnd) {
        return visitanteRepository.listVisitorRangeDate(dateStar, dateEnd);
    }

    @Override
    public List<VisitorDTO> listVisitorRangeHourAndDate(String hourStar, String hourEnd, String dateStar, String dateEnd) {
        return visitanteRepository.listVisitorRangeHourAndDate(hourStar, hourEnd, dateStar, dateEnd);
    }
}
