package com.crio.starter.Models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.redis.core.RedisHash;

@Data
@Document(collection = "greetings")
@NoArgsConstructor
@RedisHash
public class GreetingsEntity {

  private String extId;

  private String message;

}
