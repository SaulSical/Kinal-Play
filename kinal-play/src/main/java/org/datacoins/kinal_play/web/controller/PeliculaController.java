package org.datacoins.kinal_play.web.controller;

import org.datacoins.kinal_play.dominio.service.PeliculaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PeliculaController {
    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService, PeliculaService peliculaService1){

        this.peliculaService = peliculaService1;
    }
}
