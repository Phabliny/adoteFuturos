package com.apoiadores.apoiador.repository;

import com.apoiadores.apoiador.model.Apoiador;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApoiadorRepository extends MongoRepository<Apoiador, String> {
}

