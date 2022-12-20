package com.instituicao.instituto.openfeign;

import com.instituicao.instituto.model.Jovem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("jovem")
public interface JovemFeign {
    @GetMapping
    List<Jovem> findAll();
}
