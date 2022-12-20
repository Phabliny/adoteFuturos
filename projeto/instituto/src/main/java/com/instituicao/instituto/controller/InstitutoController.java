package com.instituicao.instituto.controller;

import com.instituicao.instituto.model.Curso;
import com.instituicao.instituto.model.Instituicao;
import com.instituicao.instituto.service.InstitutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instituicao")
public class InstitutoController {
    @Autowired
    private InstitutoService institutoService;

    @PostMapping
    private Instituicao create(@RequestBody Instituicao instituicao) {
        return institutoService.create(instituicao);
    }

    @GetMapping
    private List<Instituicao> findAlll() {
        return institutoService.findAlll();
    }

    @GetMapping("/{id}/cursos")
    private List<Instituicao> findAll(@PathVariable String id) {
        return institutoService.findAll(id);
    }

    @GetMapping("/{id}")
    private Instituicao findById(@PathVariable String id) {
        return institutoService.findById(id);
    }

    @PutMapping("/update")
    private Instituicao update(@RequestBody Instituicao instituicao) {
        return institutoService.update(instituicao);
    }

    @DeleteMapping("/delete/{id}")
    private void delete(@PathVariable String id) {
        institutoService.delete(id);
    }

    @PostMapping("/{id}/adicionar/curso")
    private Instituicao createCurso(@PathVariable String id, @RequestBody Curso curso){
        return institutoService.createCurso(id, curso);
    }

    @DeleteMapping("/{idInstituto}/deletar/curso/{idCurso}")
    private Instituicao deletarCurso(@PathVariable String idInstituto, @PathVariable String idCurso){
        return institutoService.deleteCurso(idInstituto, idCurso);
    }

    @PutMapping("/{id}/update/curso")
    private Instituicao updateCurso(@PathVariable String id, @RequestBody Curso curso){
        return institutoService.updateCurso(id, curso);
    }

}
