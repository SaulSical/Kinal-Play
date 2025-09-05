package org.datacoins.kinal_play.dominio.service;

import lombok.Data;
import org.datacoins.kinal_play.dominio.dto.PeliculaDto;
import org.datacoins.kinal_play.dominio.dto.repository.PeliculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PeliculaService {
    private final PeliculaRepository peliculaRepository;

    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    public List<PeliculaDto> obtenerTodo(){
        return this.peliculaRepository.obtenerTodo();
    }
}
