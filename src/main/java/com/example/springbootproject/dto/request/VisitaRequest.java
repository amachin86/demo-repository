package com.example.springbootproject.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitaRequest {
    @NotNull(message = "Este campo no puede estar vacio")
    @NotBlank(message = "Este campo no puede estar vacio")
    private String dpto;
    @NotNull(message = "Este campo no puede estar vacio")
    @NotBlank(message = "Este campo no puede estar vacio")
    private String namePerson;
    @NotNull(message = "Este campo no puede estar vacio")
    @NotBlank(message = "Este campo no puede estar vacio")
    private String motivo;
    @NotNull(message = "Este campo no puede estar vacio")
    private String ci;

}
