package org.datacoins.kinal_play.dominio.dto;

import org.datacoins.kinal_play.dominio.Genre;

import java.time.LocalDate;

public record PeliculaDto(
        String name,
        Integer duration,
        Genre genre,
        LocalDate releaseDate,
        double rating
) {
}
