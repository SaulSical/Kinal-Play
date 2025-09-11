package org.kaven.kinal_play.web.controller;

import org.kaven.kinal_play.dominio.dto.ModPeliculaDto;
import org.kaven.kinal_play.dominio.dto.PeliculaDto;
import org.kaven.kinal_play.dominio.service.PeliculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/peliculas")
public class PeliculaController {
    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping
    public ResponseEntity<List<PeliculaDto>> obtenerTodo(){
        // 200: OK, todo funciono correctamente
        // 404: No lo encuentra, no existe, mal nombre
        // 500: Interno del servidor, error de lógica
        // 405: Método de solicitud incorrecto
        return ResponseEntity.ok(this.peliculaService.obtenerTodo());
    }

    // 4
    @GetMapping("{codigo}")
    public ResponseEntity<PeliculaDto> obtenerPeliculaPorCodigo(@PathVariable Long codigo){
        return  ResponseEntity.ok(this.peliculaService.obtenerPeliculaPorCodigo(codigo));
    }

    // Guardar película
    @PostMapping
    public ResponseEntity<PeliculaDto>guardarPelicula
    (@RequestBody PeliculaDto peliculaDto){
        // return this.peliculaService.guardarPelicula(peliculaDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.peliculaService.guardarPelicula(peliculaDto));
    }

    // Modificar película
    @PutMapping("{codigo}")
    public ResponseEntity<PeliculaDto> modificarPelicula
    (@PathVariable Long codigo, @RequestBody ModPeliculaDto modPeliculaDto){
        return ResponseEntity.ok(this.peliculaService.modificarPelicula(codigo, modPeliculaDto));
    }

    // Eliminar película
    @DeleteMapping("{codigo}")
    public ResponseEntity<PeliculaDto> eliminarPelicula(@PathVariable Long codigo){
        this.peliculaService.eliminarPelicula(codigo);
        return ResponseEntity.ok().build();
    }

    // exception - PeliculaNoExisteException, PeliculaYaExisteException

    // Consulta a la IA
    // Validaciones (dependencias)
    // Documentación (dependencias)
}
