package com.log.log.repository;

import com.log.log.model.Action;
import com.log.log.model.Apoiador;
import com.log.log.model.Jovem;
import com.log.log.model.Log;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends MongoRepository<Log, String> {
    @Query("{action: ?0}")
    public List<Action> findByAction(String action);

    @Query("{nome: ?0}")
    public List<Jovem> findByJovemNome(String nome);

    @Query("{nome: ?0}")
    public List<Apoiador> findLogByApoiadorNome(String nome);

    @Query("{dataLog: ?0}")
    public List<Log> findLogByDataLog(String dataLog);
}
