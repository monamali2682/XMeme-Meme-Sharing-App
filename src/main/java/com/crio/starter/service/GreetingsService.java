package com.crio.starter.service;

import com.crio.starter.exchange.ResponseDto;
import com.crio.starter.repository.GreetingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GreetingsService {

  private final GreetingsRepository greetingsRepository;

  public ResponseDto getMessage(String id) {
    return new ResponseDto(greetingsRepository.findByExtId(id).getMessage());
  }

  // public ResponseDto getLatest() {
  //   Pageable pageable = PageRequest.of(0, 100, Sort.by("_id").descending());
  //   //Pageable pageable = PageRequest.of(0, 10);
  //   return new ResponseDto(greetingsRepository.findTop10By_id(pageable));
  // }
}
