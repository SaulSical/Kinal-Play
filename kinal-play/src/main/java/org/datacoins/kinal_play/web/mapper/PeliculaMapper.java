package org.datacoins.kinal_play.web.mapper;

import org.datacoins.kinal_play.dominio.dto.PeliculaDto;
import org.datacoins.kinal_play.persistence.entity.PeliculaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {GenreMapper.class})
public interface PeliculaMapper {
    //firmas de metodos: toDto -> convertir a Dto
    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "duracion", target = "duration")
    @Mapping(source = "genero", target = "genre", qualifiedByName = "generarGenre")
    @Mapping(source = "fechaEstreno", target = "releaseDate")
    @Mapping(source = "calificacion", target = "rating")
    public PeliculaDto toDto(PeliculaEntity entity);
    public List<PeliculaDto> toDto(Iterable<PeliculaEntity> entities);
}