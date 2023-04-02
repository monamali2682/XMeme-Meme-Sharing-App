package com.crio.starter.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.mongodb.lang.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.redis.core.RedisHash;

@Data
@AllArgsConstructor
@Entity
@Document(collection = "memes")
@NoArgsConstructor
//@RedisHash
public class MemeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private String id;

  @NonNull
  @NotNull
  @NotBlank(message = "meme name is required")
  @NotEmpty
  private String name;

  @NonNull
  @NotNull
  @NotBlank(message = "Meme image url is required")
  @NotEmpty
  private String url;

  @NonNull
  @NotNull
  @NotBlank(message = "Meme caption is required")
  @NotEmpty
  private String caption;

  public MemeEntity(String name, String url, String caption) {
    this.name=name;
    this.url=url;
    this.caption=caption;
  }

}
