package com.crio.starter.Models;

import lombok.Data;
import lombok.NoArgsConstructor;
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
@Document(collection = "memes")
@NoArgsConstructor
@RedisHash
public class MemeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @NonNull
  @NotNull
    @NotBlank
    @NotEmpty
  private String id;

  @NonNull
  @NotNull
    @NotBlank
    @NotEmpty
  private String name;

  @NonNull
  @NotNull
    @NotBlank
    @NotEmpty
  private String url;

  @NonNull
  @NotNull
    @NotBlank
    @NotEmpty
  private String caption;

  public MemeEntity(String name, String url, String caption) {
    this.name=name;
    this.url=url;
    this.caption=caption;
  }

}
