package com.crio.starter.DAO;


import javax.persistence.Entity;
import com.crio.starter.Models.MemeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Entity
public interface MemeDao extends MongoRepository<MemeEntity,String> {
    
    // findAll() method is already there 

    // findById() method is already defined

    // @Query("{id: ?0}")
    // List<MemeEntity> findmemeById(String id);

    @Query("{$and : [{$and :[{name:?0},{url:?1}]},{caption:?2}]}")
    MemeEntity isDuplicateEntry(String name, String url, String caption);
}
