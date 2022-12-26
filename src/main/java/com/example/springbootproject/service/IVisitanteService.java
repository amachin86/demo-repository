package com.example.springbootproject.service;

import com.example.springbootproject.dto.request.VisitanteRequest;
import com.example.springbootproject.dto.response.VisitanteResponse;
import com.example.springbootproject.projections.CantVisitanteDTO;
import com.example.springbootproject.projections.CantVisitantes;
import com.example.springbootproject.projections.VisitorDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IVisitanteService {

    VisitanteResponse saveVisitor(VisitanteRequest visitanteRequest);
    List<VisitanteResponse> findAll();
    Page<VisitanteResponse> findAll(Pageable pageable);
    VisitanteResponse deleteByCI(String ci);
    //report 1
    List<VisitorDTO> visitorList();
    CantVisitanteDTO cantVisitors(String dateStar, String dateEnd);
    CantVisitantes cantVisitorForRangeHours(String hStar, String hEnd);
    CantVisitantes cantVisitorForRangeHoursAndDates(String hourStar, String hourEnd,
                                                    String dateStar, String dateEnd);
    //Reporte3 - reporte 1 pero por rango de fecha y horas
    List<VisitorDTO> listVisitorRangeHour(String hourStar, String hourEnd);
    List<VisitorDTO> listVisitorRangeDate(String dateStar, String dateEnd);
    List<VisitorDTO> listVisitorRangeHourAndDate(String hourStar, String hourEnd,
                                                 String dateStar, String dateEnd);
}
