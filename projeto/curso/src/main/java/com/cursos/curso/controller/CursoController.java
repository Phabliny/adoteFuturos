package com.cursos.curso.controller;
import com.cursos.curso.model.Curso;
import com.cursos.curso.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @PostMapping
    private Curso create(@RequestBody Curso curso) {
        return cursoService.create(curso);
    }

    @GetMapping
    private List<Curso> findAll() {
        return cursoService.findAll();
    }

    @GetMapping("/{id}")
    private Curso findById(@PathVariable String id) {
        return cursoService.findById(id);
    }

    @PutMapping("/update")
    private Curso update(@RequestBody Curso curso) {
        return cursoService.update(curso);
    }

    @DeleteMapping("/delete/{id}")
    private void delete(@PathVariable String id) {
        cursoService.delete(id);
    }

    @GetMapping("/instituicao/{id}")
    private List<Curso> get(@PathVariable String id){
        return cursoService.listCursos(id);
    }
}
