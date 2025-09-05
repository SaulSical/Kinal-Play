package org.datacoins.kinal_play.dominio.dto;

import java.time.LocalDate;

public record PeliculaDto(
        String name,
        String duration,
        Genre genre,
        LocalDate releaseDate,
        double rating
) {
}
