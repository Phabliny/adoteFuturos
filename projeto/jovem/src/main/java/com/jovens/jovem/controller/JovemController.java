package com.jovens.jovem.controller;
import com.jovens.jovem.model.Jovem;
import com.jovens.jovem.service.JovemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jovem")
public class JovemController {
    @Autowired
    private JovemService jovemService;

    @PostMapping("/instituicao/{id}")
    private Jovem create(@RequestBody Jovem jovem, @PathVariable String id) {
        return jovemService.create(jovem, id);
    }

    @GetMapping
    private List<Jovem> findAll() {
        return jovemService.findAll();
    }

    @GetMapping("/{id}")
    private Jovem findById(@PathVariable String id) {
        return jovemService.findById(id);
    }

    @PutMapping("/update")
    private Jovem update(@RequestBody Jovem jovem) {
        return jovemService.update(jovem);
    }

    @DeleteMapping("/delete/{id}")
    private void delete(@PathVariable String id) {
        jovemService.delete(id);
    }

    @PutMapping("/apoiador")
    private Jovem updateApoiadorJovem(@RequestBody Jovem jovem){
        return jovemService.updateApoiadorJovem(jovem);
    }
}
