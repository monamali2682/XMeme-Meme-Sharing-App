package com.crio.starter.exchange;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.mongodb.lang.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostMemeRequest {
    @NotNull
    @NotBlank
    @NotEmpty
    private String name;

    @NotNull
    @NotBlank
    @NotEmpty
    private String url;

    @NotNull
    @NotBlank
    @NotEmpty
    private String caption;
}
