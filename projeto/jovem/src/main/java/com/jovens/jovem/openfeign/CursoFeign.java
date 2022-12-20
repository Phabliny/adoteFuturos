package com.jovens.jovem.openfeign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("curso")
public interface CursoFeign {
}
