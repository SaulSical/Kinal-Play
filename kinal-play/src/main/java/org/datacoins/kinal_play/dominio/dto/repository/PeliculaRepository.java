package org.datacoins.kinal_play.dominio.dto.repository;

import org.datacoins.kinal_play.dominio.dto.ModPeliculaDto;
import org.datacoins.kinal_play.dominio.dto.PeliculaDto;

import java.util.List;

public interface PeliculaRepository {
    //firmas del mantenimiento de DTO
    //1. Aqui se inicia
    List<PeliculaDto> obtenerTodo();
    PeliculaDto obtenerPeliculaPorCodido(Long codigo);
    PeliculaDto guardarPelicula(PeliculaDto peliculaDto);
    PeliculaDto modificarPelicula(Long codigo, ModPeliculaDto modPeliculaDto);
}
