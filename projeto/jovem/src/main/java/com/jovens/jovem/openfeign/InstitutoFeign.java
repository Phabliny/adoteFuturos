package com.jovens.jovem.openfeign;

import com.jovens.jovem.model.Instituicao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("instituto")
public interface InstitutoFeign {

    @GetMapping("/instituicao")
    List<Instituicao> findAlll();

    @GetMapping("/instituicao/{id}")
    Instituicao findById(@PathVariable String id);

    @PutMapping("/instituicao/update")
    Instituicao update(@RequestBody Instituicao instituicao);
}
