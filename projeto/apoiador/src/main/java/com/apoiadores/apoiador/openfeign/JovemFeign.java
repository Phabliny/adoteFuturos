package com.apoiadores.apoiador.openfeign;

import com.apoiadores.apoiador.model.Jovem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("jovem")
public interface JovemFeign {

    @GetMapping("/jovem/{id}")
    Jovem findById(@PathVariable String id);

    @PutMapping("/apoiador")
    Jovem updateApoiadorJovem(@RequestBody Jovem jovem);
}
