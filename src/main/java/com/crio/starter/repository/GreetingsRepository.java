package com.crio.starter.repository;

import java.util.List;
import com.crio.starter.Models.GreetingsEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface GreetingsRepository extends MongoRepository<GreetingsEntity, String> {
  GreetingsEntity findByExtId(String extId);

  // @Query(sort = "{ id : -1 }" )
  // List<GreetingsEntity> findGreetings(String extId);

  // List<GreetingsEntity> findTop10By_id(Pageable pageable);
}
