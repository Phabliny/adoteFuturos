package com.cursos.curso.repository;

import com.cursos.curso.model.Curso;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends MongoRepository<Curso, String> {
    @Query("{instituicoes.id: ?0}")
    List<Curso> getAllCursosDeUmaInstituição(String id);
}

