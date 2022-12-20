package com.apoiadores.apoiador.controller;
import com.apoiadores.apoiador.model.Apoiador;
import com.apoiadores.apoiador.service.ApoiadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apoiador")
public class ApoiadorController {
    @Autowired
    private ApoiadorService apoiadorService;

    @PostMapping
    private Apoiador create(@RequestBody Apoiador apoiador) {
        return apoiadorService.create(apoiador);
    }

    @GetMapping
    private List<Apoiador> findAll() {
        return apoiadorService.findAll();
    }

    @GetMapping("/{id}")
    private Apoiador findById(@PathVariable String id) {
        return apoiadorService.findById(id);
    }

    @PutMapping("/update")
    private Apoiador update(@RequestBody Apoiador apoiador) {
        return apoiadorService.update(apoiador);
    }

    @DeleteMapping("/delete/{id}")
    private void delete(@PathVariable String id) {
        apoiadorService.delete(id);
    }

    @PutMapping("/apoiar/jovem/{id}")
    private Apoiador apoiarJovem(@RequestBody Apoiador apoiador, @PathVariable String id){
        return apoiadorService.apoiarJovemComCurso(apoiador, id);
    }
}
