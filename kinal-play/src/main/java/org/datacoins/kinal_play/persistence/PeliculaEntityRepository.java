package org.datacoins.kinal_play.persistence;

import org.datacoins.kinal_play.dominio.dto.PeliculaDto;
import org.datacoins.kinal_play.dominio.repository.PeliculaRepository;
import org.datacoins.kinal_play.persistence.crud.CrudPeliculaEntity;
import org.datacoins.kinal_play.web.mapper.PeliculaMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PeliculaEntityRepository implements PeliculaRepository {
    private final CrudPeliculaEntity crudPeliculaEntity;
    private final PeliculaMapper peliculaMapper;

    public PeliculaEntityRepository(CrudPeliculaEntity crudPeliculaEntity, PeliculaMapper peliculaMapper) {
        this.crudPeliculaEntity = crudPeliculaEntity;
        this.peliculaMapper = peliculaMapper;
    }

    @Override
    public List<PeliculaDto> obtenerTodo() {
        return this.peliculaMapper.toDto(this.crudPeliculaEntity.findAll());
    }
}
