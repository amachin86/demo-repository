package com.example.springbootproject.controllers;

import com.example.springbootproject.dto.request.VisitaRequest;
import com.example.springbootproject.dto.request.VisitanteRequest;
import com.example.springbootproject.dto.response.EndVisita;
import com.example.springbootproject.dto.response.VisitaResponse;
import com.example.springbootproject.dto.response.VisitanteResponse;
import com.example.springbootproject.projections.CantVisitanteDTO;
import com.example.springbootproject.projections.CantVisitantes;
import com.example.springbootproject.projections.VisitorDTO;
import com.example.springbootproject.service.IVisitaService;
import com.example.springbootproject.service.IVisitanteService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(path = "/demo")
@Validated
public class DemoController {

    private final IVisitaService visitService;
    private final IVisitanteService visitorService;

    @Autowired
    public DemoController(IVisitaService visitService, IVisitanteService visitorService) {
        this.visitService = visitService;
        this.visitorService = visitorService;
    }

    @PostMapping(path = "/registerVisitor", consumes = "application/json", produces = "application/json")
    public ResponseEntity<VisitanteResponse> registerVisitante(
            @Valid @NotNull @RequestBody VisitanteRequest visitanteRequest) {
        VisitanteResponse newVisitante = visitorService.saveVisitor(visitanteRequest);
        return new ResponseEntity<>(newVisitante, HttpStatus.CREATED);
    }

    @PostMapping(path = "/registerVisita", consumes = "application/json", produces = "application/json")
    public ResponseEntity<VisitaResponse> registerVisita(
            @Valid @NotNull @RequestBody VisitaRequest visitaRequest) {
        VisitaResponse newVisita = visitService.saveVisita(visitaRequest);
        return new ResponseEntity<>(newVisita, HttpStatus.CREATED);
    }

    @GetMapping(path = "endVisita/{idVisita}", produces = "application/json")
    public ResponseEntity<EndVisita> endVisita(@PathVariable("idVisita") int idVisita) {
        EndVisita endVisita = visitService.endVisita(idVisita);
        return new ResponseEntity<>(endVisita, HttpStatus.OK);
    }

    //resp - 1
    @GetMapping(path = "listVisitors", produces = "application/json")
    public ResponseEntity< List<VisitorDTO> > listVisitas() {
       List<VisitorDTO> visitas = visitorService.visitorList();
        return new ResponseEntity<>(visitas, HttpStatus.OK);
    }

    //resp - 2
    // postman localhost:8090/demo/cantVisitors?star=2022-11-30&end=2022-11-30
    @GetMapping(path = "cantVisitor", produces = "application/json")
    public ResponseEntity<CantVisitanteDTO> cantVisitantes(@RequestParam(name = "star") String dateStar, @RequestParam(name = "end") String dateEnd) {
        //LocalDate dateInicio = LocalDate.parse(dInicio);
        //LocalDate dateFin = LocalDate.parse(dFin);
        CantVisitanteDTO cantVisitanteDTO = visitorService.cantVisitors(dateStar, dateEnd);
        return new ResponseEntity<>(cantVisitanteDTO, HttpStatus.OK);
    }
   // localhost:8090/demo/visitRangeHour?star=10:59&end=12:00
    @GetMapping(path = "visitorRangeHour", produces = "application/json")
    public ResponseEntity<CantVisitantes> cantVisitForRangeHours(@RequestParam(name = "star") String hStar, @RequestParam(name = "end") String hEnd){
        CantVisitantes cantVisitantes = visitorService.cantVisitorForRangeHours(hStar, hEnd);
        return new ResponseEntity<>(cantVisitantes, HttpStatus.OK);
    }
    //localhost:8090/demo/cantVistHourDate?hStar=10:59&hEnd=12:00&dStar=2022-12-19&dEnd=2022-12-27
    @GetMapping(value = "cantVistorHourDate")
    public  ResponseEntity<CantVisitantes> cantVisitForRangeHoursAndDates(@RequestParam(name = "hStar")String hourStar, @RequestParam(name = "hEnd")String hourEnd,
                                                                          @RequestParam(name = "dStar")String dateStar, @RequestParam(name = "dEnd")String dateEnd){
        CantVisitantes cantVisitantes = visitorService.cantVisitorForRangeHoursAndDates(hourStar,hourEnd,dateStar,dateEnd);
        return new ResponseEntity<>(cantVisitantes, HttpStatus.OK);
    }
    //localhost:8090/demo/listVisitorRHour?hStar=10:59&hEnd=12:00
    @GetMapping(value = "listVisitorRHour")
    public ResponseEntity<List<VisitorDTO>> listVisitorRangeHour(@RequestParam(name = "hStar") String hourStar, @RequestParam(name ="hEnd") String hourEnd){
        List<VisitorDTO> visitorDTOList = visitorService.listVisitorRangeHour(hourStar, hourEnd);
        return new ResponseEntity<>(visitorDTOList, HttpStatus.OK);
    }

    //localhost:8090/demo/listVisitorRDate?dStar=2022-12-19&dEnd=2022-12-27
    @GetMapping(value = "listVisitorRDate")
    public ResponseEntity<List<VisitorDTO>> listVisitorRangeDate(@RequestParam(name = "dStar") String dateStar, @RequestParam(name = "dEnd") String dateEnd){
        List<VisitorDTO> visitorDTOList = visitorService.listVisitorRangeDate(dateStar, dateEnd);
        return new ResponseEntity<>(visitorDTOList, HttpStatus.OK);
    }
    //localhost:8090/demo/listVistorHourDate?hStar=10:59&hEnd=12:00&dStar=2022-12-19&dEnd=2022-12-27
    @GetMapping(value = "listVistorHourDate")
    public  ResponseEntity<List<VisitorDTO>> listVisitorRangeHourAndDate(@RequestParam(name = "hStar")String hourStar, @RequestParam(name = "hEnd")String hourEnd,
                                                                          @RequestParam(name = "dStar")String dateStar, @RequestParam(name = "dEnd")String dateEnd){
        List<VisitorDTO> visitorDTOList = visitorService.listVisitorRangeHourAndDate(hourStar,hourEnd,dateStar,dateEnd);
        return new ResponseEntity<>(visitorDTOList, HttpStatus.OK);
    }
}
