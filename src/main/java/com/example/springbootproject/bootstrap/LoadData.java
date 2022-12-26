package com.example.springbootproject.bootstrap;

import com.example.springbootproject.entity_dao.Visita;
import com.example.springbootproject.entity_dao.Visitante;
import com.example.springbootproject.repository.VisitaRepository;
import com.example.springbootproject.repository.VisitanteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Clase para la carga inicial de los datos en la BD
 */
@Component
@Slf4j
public class LoadData implements CommandLineRunner {
    //@Autowired
    VisitanteRepository visitanteRepository;
    VisitaRepository visitaRepository;

    public LoadData(VisitanteRepository visitanteRepository, VisitaRepository visitaRepository) {
        this.visitanteRepository = visitanteRepository;
        this.visitaRepository = visitaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        LoadVisita();
    }
    //crea los visitantes y la visita
       private void LoadVisita(){

        if (visitaRepository.count() == 0){
            log.info("Guardando visitas....");
           // Visitante visitante = visitanteRepository.findByCi("90031803490");
            Visitante visitante = Visitante.builder()
                    .ci("89983377373")
                    .nombre("Roxana")
                    .apellidos("Valdes")
                    .direccion("hsbhsbhwsb")
                    .build();

            Visita visita = Visita.builder().dpto("Transporte")
                    .namePerson("Yailin")
                    .motivo("Reunión de trabajo")
                    .inFecha(LocalDate.now())
                    .inHour(LocalTime.now())
                    .build();
           visita.setPersona(visitante);
            visitaRepository.saveAndFlush( visita );


            visitante = Visitante.builder()
                    .ci("90102277373")
                    .nombre("Danay")
                    .apellidos("Garcia")
                    .direccion("Ave 20 calle 13 No 1234")
                    .build();
            visita = Visita.builder().dpto("Informática")
                    .namePerson("Albert")
                    .motivo("Reunión de trabajo")
                    .inFecha(LocalDate.now().minusWeeks(1))
                    .inHour(LocalTime.now().plusHours(1))
                    .build();
            visita.setPersona(visitante);
            visitaRepository.save( visita );


            log.info("Visitas guardadas correctamente.");

        }
    }
}
