package com.example.springbootproject.entity_dao;

import com.example.springbootproject.projections.CantVisitanteDTO;
import lombok.*;

import javax.persistence.*;



//utilizando la refexión named query
@NamedNativeQuery(
        name = "r2CantVisitantesNameQuery",
        query = "SELECT COUNT(*) AS count" +
                " FROM visitantes v INNER JOIN visitas visit ON v.ci = visit.fk_visitante" +
                " WHERE visit.in_fecha >= :inicio AND  visit.out_fecha <= :fin",
        resultSetMapping = "mappingResult"
)
@SqlResultSetMapping(
        name =  "mappingResult",
        classes = @ConstructorResult(
                targetClass = CantVisitanteDTO.class,
                columns = {
                      @ColumnResult(name = "count",  type = Integer.class)
                }
        )

)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "visitantes")
public class Visitante {
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    //  private int idVisitante;

    @Id
    @Column(name = "ci", length = 12)
    private String ci;

    @Column(name = "name", columnDefinition = "VARCHAR(20) NOT NULL")
    private String nombre;

    @Column(name = "lastName", length = 150)
    private String apellidos;

    @Column(name = "direcc", columnDefinition = "VARCHAR(100)")
    private String direccion;
}
