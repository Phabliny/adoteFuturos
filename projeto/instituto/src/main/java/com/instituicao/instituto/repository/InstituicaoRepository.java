package com.instituicao.instituto.repository;

import com.instituicao.instituto.model.Instituicao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituicaoRepository extends MongoRepository<Instituicao, String> {
}
