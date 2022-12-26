package com.example.springbootproject.repository;

import com.example.springbootproject.entity_dao.Visitante;
import com.example.springbootproject.projections.CantVisitanteDTO;
import com.example.springbootproject.projections.CantVisitantes;
import com.example.springbootproject.projections.VisitorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Consultas
 * -- Uses AdventureWorks
 *
 * SELECT e.FirstName, e.LastName, ep.Rate
 * FROM HumanResources.vEmployee e
 * JOIN HumanResources.EmployeePayHistory ep
 *     ON e.BusinessEntityID = ep.BusinessEntityID
 * WHERE ep.Rate NOT BETWEEN 27 AND 30
 * ORDER BY ep.Rate;
 *
 * -- Uses AdventureWorks
 *
 * SELECT BusinessEntityID, RateChangeDate
 * FROM HumanResources.EmployeePayHistory
 * WHERE RateChangeDate BETWEEN '20011212' AND '20020105';
 *
 */
public interface VisitanteRepository extends JpaRepository<Visitante, String> {

    Visitante findByCi(String ci);
    Visitante deleteByCi(String ci);

    /** REPORTE 1
     * Using close interface projection
     * Los nombre de los campos en la projection deben llamarse igual que en
     * la consulta (name, apellidos, deparment ...)
     * @return interface projection
     */
    @Query(value = "SELECT v.name, v.last_name AS apellidos, visit.deparment AS deparment, " +
            "visit.name_visit_person AS visit_person," +
            " visit.in_fecha AS inFecha," +
            " visit.out_fecha AS outFecha, " +
            "visit.in_hour AS inHour, visit.out_hour AS outHour \n" +
            "FROM visitantes v INNER JOIN visitas visit ON v.ci = visit.fk_visitante", nativeQuery = true)
    public List<VisitorDTO> visitorList();


    /**
     * using name query
     * Hay que colocarla sobre una clase entity o dao
     * @return
     */
    @Query(name = "r2CantVisitantesNameQuery", nativeQuery = true)
    public CantVisitanteDTO cantVisitantes(@Param("inicio") String dateStar, @Param("fin") String dateEnd);

    //cantidad de visitantes por rango de horas
    @Query(value = "SELECT COUNT(*) AS count " +
            "FROM visitantes v " +
            "INNER JOIN visitas visit ON " +
            "v.ci = visit.fk_visitante  WHERE visit.in_hour >= :hInicio AND  visit.out_hour <= :hFin ", nativeQuery = true)
    public CantVisitantes cantVisitForRangeHours(@Param("hInicio") String hourStar, @Param("hFin") String hourEnd);

    //cantidad de visitantes por rango de horas y fechas
    @Query(value = "SELECT COUNT(*) AS count " +
            "FROM visitantes v " +
            "INNER JOIN visitas visit ON " +
                        "v.ci = visit.fk_visitante  WHERE (visit.in_hour >= :hInicio AND  visit.out_hour <= :hFin) \n" +
                                            "AND (visit.in_fecha >= :dInicio AND visit.out_fecha <= :dFin)", nativeQuery = true)
    public CantVisitantes cantVisitForRangeHoursAndDates(@Param("hInicio") String hourStar, @Param("hFin") String hourEnd,
                                                         @Param("dInicio") String dateStar, @Param("dFin") String dateEnd);

    //Report 3
    @Query(value = "SELECT v.name, v.last_name AS apellidos, visit.deparment AS deparment, " +
            "visit.name_visit_person AS visit_person," +
            " visit.in_fecha AS inFecha," +
            " visit.out_fecha AS outFecha, " +
            "visit.in_hour AS inHour, visit.out_hour AS outHour \n" +
            "FROM visitantes v INNER JOIN visitas visit ON v.ci = visit.fk_visitante "
            + "WHERE visit.in_hour >= :hInicio AND  visit.out_hour <= :hFin ", nativeQuery = true)
    public List<VisitorDTO> listVisitorRangeHour(@Param("hInicio") String hourStar, @Param("hFin") String hourEnd);

    @Query(value = "SELECT v.name, v.last_name AS apellidos, visit.deparment AS deparment, " +
            "visit.name_visit_person AS visit_person," +
            " visit.in_fecha AS inFecha," +
            " visit.out_fecha AS outFecha, " +
            "visit.in_hour AS inHour, visit.out_hour AS outHour \n" +
            "FROM visitantes v INNER JOIN visitas visit ON v.ci = visit.fk_visitante "
            + "WHERE visit.in_fecha >= :dInicio AND visit.out_fecha <= :dFin ", nativeQuery = true)
    List<VisitorDTO> listVisitorRangeDate(@Param("dInicio") String dateStar, @Param("dFin") String dateEnd);

    @Query(value = "SELECT v.name, v.last_name AS apellidos, visit.deparment AS deparment, " +
            "visit.name_visit_person AS visit_person," +
            " visit.in_fecha AS inFecha," +
            " visit.out_fecha AS outFecha, " +
            "visit.in_hour AS inHour, visit.out_hour AS outHour \n" +
            "FROM visitantes v INNER JOIN visitas visit ON v.ci = visit.fk_visitante " +
            "WHERE (visit.in_hour >= :hInicio AND  visit.out_hour <= :hFin) " +
            "AND (visit.in_fecha >= :dInicio AND visit.out_fecha <= :dFin)", nativeQuery = true)
    List<VisitorDTO> listVisitorRangeHourAndDate(@Param("hInicio") String hourStar, @Param("hFin") String hourEnd,
                                                 @Param("dInicio") String dateStar, @Param("dFin") String dateEnd);



    /**
     * Reporte 3
     * SELECT * FROM `visitas` WHERE in_fecha BETWEEN '2022-11-23' AND '2022-11-30'
     *
     *
     * SELECT v.name, v.last_name, visit.deparment, visit.name_person, visit.in_fecha, visit.out_fecha, visit.in_hour, visit.out_hour
     *       FROM visitantes v INNER JOIN visitas visit ON v.ci = visit.fk_visitante WHERE visit.in_fecha BETWEEN ':inicio' AND ':fin'
     */



}
