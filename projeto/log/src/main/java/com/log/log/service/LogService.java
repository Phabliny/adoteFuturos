package com.log.log.service;

import com.log.log.model.Action;
import com.log.log.model.Apoiador;
import com.log.log.model.Jovem;
import com.log.log.model.Log;
import com.log.log.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    public Log createLogInstituicao(Log log) {
        return logRepository.save(log);
    }

    public Log createLogJovem(Log log) {
        return logRepository.save(log);
    }

    public Log createLogApoiador(Log log) {
        return logRepository.save(log);
    }

    public Log createLogCurso(Log log) {
        return logRepository.save(log);
    }

    public Log find(String id) {
        return logRepository.findById(id).get();
    }

    public List<Log> findAll() {
        return logRepository.findAll();
    }

    public List<Action> findByAction(Action action) {
        return logRepository.findByAction(action.toString());
    }

    public List<Jovem> findByJovemNome(String nome) {
        return logRepository.findByJovemNome(nome);
    }

    public List<Log> findLogByDataLog(String dataLog) {
        return logRepository.findLogByDataLog(dataLog);
    }

    public List<Apoiador> findLogByApoiadorNome(String nome) {
        return logRepository.findLogByApoiadorNome(nome);
    }
}
