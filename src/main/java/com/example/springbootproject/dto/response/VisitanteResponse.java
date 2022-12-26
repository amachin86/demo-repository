package com.example.springbootproject.dto.response;

import com.example.springbootproject.entity_dao.Visitante;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VisitanteResponse {
    private String ci;
    private String nombre;
    private String apellidos;
    private String direccion;

    public VisitanteResponse(Visitante visitante) {
        this.ci = visitante.getCi();
        this.nombre = visitante.getNombre();
        this.apellidos = visitante.getApellidos();
        this.direccion = visitante.getDireccion();
    }
}
