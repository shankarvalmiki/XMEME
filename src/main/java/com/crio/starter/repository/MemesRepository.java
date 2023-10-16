package com.crio.starter.repository;

import com.crio.starter.data.MemeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MemesRepository extends MongoRepository<MemeEntity,Integer> {
    
}
