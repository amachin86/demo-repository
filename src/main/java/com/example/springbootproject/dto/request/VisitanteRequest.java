package com.example.springbootproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitanteRequest {
    @NotNull(message = "El campo debe estar vacio")
    @NotBlank(message = "El campo no debe estar vacio")
    @Size(min = 5, max = 11, message = "El campo debe de tener como mínimo {min} y como máximo {max} caracteres")
    //el campo solo contiene número repetidos hasta 11 veces
    @Pattern(regexp = "^[0-9]{5,11}$", message = "El campo solo puede contener números")
    private String ci;

    @NotNull(message = "El campo nombre no debe estar vacio")
    //El nombre de empezar con una letra mayúscula, con más de letra minuscula un espacio
    @Pattern(regexp = "^([A-Z]{1}[a-z]+[ ]*){1,2}$", message = "El valor del campo es incorrecto")
    private String nombre;
    @NotNull(message = "El campo apellidos no debe estar vacio")
    @Pattern(regexp = "^([A-Z]{1}[a-z]+[ ]*){1,2}$", message = "El valor del campo es incorrecto")
    private String apellidos;
    private String direccion;
}
