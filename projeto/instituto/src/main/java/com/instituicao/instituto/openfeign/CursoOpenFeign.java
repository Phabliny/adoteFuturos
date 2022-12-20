package com.instituicao.instituto.openfeign;

import com.instituicao.instituto.model.Curso;
import com.instituicao.instituto.model.Instituicao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("curso")
public interface CursoOpenFeign {
    @PostMapping("/curso")
    Curso create(@RequestBody Curso curso);

    @GetMapping("/curso")
    List<Curso> findAll();

    @GetMapping("/curso/{id}")
    Curso findById(@PathVariable String id);

    @PutMapping("/curso/update")
    Curso update(@RequestBody Curso curso);

    @DeleteMapping("/curso/delete/{id}")
    void delete(@PathVariable String id);

    @GetMapping("/curso/instituicao/{id}")
    List<Curso> get(@PathVariable String id);

}
