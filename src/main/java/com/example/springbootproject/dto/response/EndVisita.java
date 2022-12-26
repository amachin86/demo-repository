package com.example.springbootproject.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class EndVisita {
    private String mensaje;
    private int idVisita;
    private LocalDate outfecha;
    private LocalTime outHour;


}
