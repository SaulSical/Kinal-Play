package org.datacoins.kinal_play.persistence;

import org.datacoins.kinal_play.dominio.dto.ModPeliculaDto;
import org.datacoins.kinal_play.dominio.dto.PeliculaDto;
import org.datacoins.kinal_play.dominio.dto.repository.PeliculaRepository;
import org.datacoins.kinal_play.persistence.crud.CrudPeliculaEntity;
import org.datacoins.kinal_play.persistence.entity.PeliculaEntity;
import org.datacoins.kinal_play.web.mapper.PeliculaMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class PeliculaEntityRepository implements PeliculaRepository {

    //Inyeccion de dependencias implicito: sin el @Autowire
    private final CrudPeliculaEntity crudPelicula;
    private final PeliculaMapper peliculaMapper;

    public PeliculaEntityRepository(CrudPeliculaEntity crudPelicula, PeliculaMapper peliculaMapper) {
        this.crudPelicula = crudPelicula;
        this.peliculaMapper = peliculaMapper;
    }

    // 3.

    @Override
    public List<PeliculaDto> obtenerTodo() {
        return this.peliculaMapper.toDto(this.crudPelicula.findAll());
    }

    @Override
    public PeliculaDto obtenerPeliculaPorCodido(Long codigo) {
        PeliculaEntity peliculaEntity = this.crudPelicula.findById(codigo).orElse(null);
        return this.peliculaMapper.toDto(this.crudPelicula.findById(codigo).orElse(null));
    }

    @Override
    public PeliculaDto guardarPelicula(PeliculaDto peliculaDto) {
        //Instanciar clase de entidad
        PeliculaEntity pelicula = new PeliculaEntity();
        //convertir DTO a entidad
        pelicula = this.peliculaMapper.toEntity(peliculaDto);
        pelicula.setEstado("D");
        //Guardar en la base de datos JPA
        this.crudPelicula.save(pelicula);
        //Retornar el valor guardado como DTO
        return this.peliculaMapper.toDto(pelicula);
    }

    @Override
    public PeliculaDto modificarPelicula(Long codigo, ModPeliculaDto modPeliculaDto) {
        //Obtenemos PeliculaEntity con el codigo
        PeliculaEntity pelicula = this.crudPelicula.findById(codigo).orElse(null);
        //Modificar atributos de ella con datos del mod
        pelicula.setNombre(modPeliculaDto.name());
        pelicula.setFechaEstreno(modPeliculaDto.releaseDate());
        pelicula.setCalificacion(BigDecimal.valueOf(modPeliculaDto.rating()));
        //Guardamos en la db
        //Retornamos el PeliculaDTO convertido de la entidad
        return null;
    }
}
