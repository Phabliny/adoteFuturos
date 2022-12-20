package com.jovens.jovem.repository;

import com.jovens.jovem.model.Jovem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JovemRepository extends MongoRepository<Jovem, String> {
}

