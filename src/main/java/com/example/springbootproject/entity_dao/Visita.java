package com.example.springbootproject.entity_dao;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "visitas")
public class Visita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVisita;

    @Column(name = "deparment", length = 50)
    private String dpto;

    @Column(name = "name_visit_person", length = 50)
    private String namePerson;

    @Column(length = 100)
    private String motivo;

    @Column(columnDefinition = "DATE")
    @NotNull
    private LocalDate inFecha;
    @Column(columnDefinition = "DATE")
    private LocalDate outFecha;

    @Column(columnDefinition = "TIME")
    @NotNull
    private LocalTime inHour;
    @Column(columnDefinition = "TIME")
    private LocalTime outHour;


    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade= CascadeType.PERSIST)
    @JoinColumn(name = "fk_visitante")
    Visitante persona;

}
