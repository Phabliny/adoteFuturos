package com.log.log.controller;

import com.log.log.model.Action;
import com.log.log.model.Apoiador;
import com.log.log.model.Jovem;
import com.log.log.model.Log;
import com.log.log.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogService logService;

    @GetMapping("/{id}")
    private Log find(@PathVariable String id){
        return logService.find(id);
    }

    @GetMapping
    private List<Log> findAll(){
        return logService.findAll();
    }

    @GetMapping("/action/{action}")
    public List<Action> findByAction(@PathVariable String action) {
        return logService.findByAction(Action.valueOf(action));
    }

    @GetMapping("/jovem/{nome}")
    public List<Jovem> findByJovemNome(@PathVariable String nome) {
        return logService.findByJovemNome(nome);
    }

    @GetMapping("/data/{dataLog}")
    public List<Log> findLogByDataLog(@PathVariable String dataLog) {
        return logService.findLogByDataLog(dataLog);
    }

    @GetMapping("/apoiador/{nome}")
    public List<Apoiador> findLogByApoiadorNome(@PathVariable String nome) {
        return logService.findLogByApoiadorNome(nome);
    }
}
