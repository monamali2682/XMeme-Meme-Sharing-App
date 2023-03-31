package com.crio.starter.exchange;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.crio.starter.Dto.Meme;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetMemeGivenIdResponse {
    Meme meme;
    
}
