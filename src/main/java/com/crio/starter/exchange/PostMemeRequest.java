package com.crio.starter.exchange;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.mongodb.lang.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostMemeRequest {
    @NonNull
    private String name;
    @NonNull
    private String url;
    @NonNull
    private String caption;
}
