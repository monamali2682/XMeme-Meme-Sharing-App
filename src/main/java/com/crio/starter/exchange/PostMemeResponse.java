package com.crio.starter.exchange;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class PostMemeResponse {
    
    @JsonProperty("id")
    String id;

    @JsonIgnore
    boolean isDuplicate;
    
}
