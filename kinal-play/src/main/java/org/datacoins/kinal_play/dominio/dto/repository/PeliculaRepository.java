package org.datacoins.kinal_play.dominio.dto.repository;

import org.datacoins.kinal_play.dominio.dto.PeliculaDto;

import java.util.List;

public interface PeliculaRepository {
    //firmas del mantenimiento de DTO
    List<PeliculaDto> obtenerTodo();

}
