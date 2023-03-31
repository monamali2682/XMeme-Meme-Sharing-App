package com.crio.starter.Models;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "memes")
@NoArgsConstructor
public class MemeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private String id;

  private String name;

  private String url;

  private String caption;

  public MemeEntity(String name, String url, String caption) {
    this.name=name;
    this.url=url;
    this.caption=caption;
  }

}
