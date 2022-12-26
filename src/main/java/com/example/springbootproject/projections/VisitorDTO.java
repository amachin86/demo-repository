package com.example.springbootproject.projections;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Using close interface projection
 * Los nombre de los campos en la projection  deben llamarse igual que en
 * la consulta
 *
 */
public interface VisitorDTO {
    String getName();

    String getApellidos();

    String getDeparment();

    String getVisit_person();

    LocalDate getinFecha();

    LocalDate getoutFecha();

    LocalTime getinHour();

    LocalTime getoutHour();
}