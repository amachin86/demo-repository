package com.example.springbootproject.dto.response;


import com.example.springbootproject.entity_dao.Visita;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VisitaResponse {
    private int idVisita;
    private String dpto;
    private String namePerson;
    private String motivo;
    private LocalDate infecha;
    private LocalDate outfecha;
    private LocalTime inHour;
    private LocalTime outHour;
    private String ci;

    public VisitaResponse(Visita visita){
        this.idVisita = visita.getIdVisita();
        this.dpto = visita.getDpto();
        this.namePerson = visita.getNamePerson();
        this.motivo = visita.getMotivo();
        this.infecha = visita.getInFecha();
        this.outfecha = visita.getOutFecha();
        this.inHour = visita.getInHour();
        this.outHour = visita.getOutHour();
        this.ci = visita.getPersona().getCi();
    }
}
