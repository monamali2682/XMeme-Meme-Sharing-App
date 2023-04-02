package com.crio.starter.exchange;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.mongodb.lang.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostMemeRequest {
    @NotNull
    @NotBlank
    @NotEmpty
    @Valid
    private String name;

    @NotNull
    @NotBlank
    @NotEmpty
    @Valid
    private String url;

    @NotNull
    @NotBlank
    @NotEmpty
    @Valid
    private String caption;
}
