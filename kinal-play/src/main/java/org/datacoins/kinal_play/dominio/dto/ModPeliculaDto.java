package org.datacoins.kinal_play.dominio.dto;

import java.time.LocalDate;

public record ModPeliculaDto(
        String name,
        LocalDate releaseDate,
        Integer rating
) {
}
