package com.crio.starter.controller;

import com.crio.starter.exchange.GetMemeGivenIdResponse;
import com.crio.starter.exchange.GetMemesResponse;
import com.crio.starter.exchange.PostMemeRequest;
import com.crio.starter.exchange.PostMemeResponse;
import com.crio.starter.service.MemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class MemeController {
  
  public static final String POST_MEME_API = "/memes/";
  public static final String GET_MEMES_API = "/memes/";
  public static final String GET_MEMES_ID_API = "/memes/{id}";

  @Autowired
  private MemeService memeService;

  @GetMapping(GET_MEMES_API)
  public ResponseEntity<GetMemesResponse> getMemes() {
      //log.info("getRestaurants called with {}", getRestaurantsRequest);
      GetMemesResponse getMemesResponse;
      //CHECKSTYLE:OFF
      getMemesResponse = memeService.findLatest100Memes();
      //log.info("getRestaurants returned {}", getRestaurantsResponse);
      return ResponseEntity.ok().body(getMemesResponse);
      //CHECKSTYLE:ON
  }

  @GetMapping(GET_MEMES_ID_API)
  public ResponseEntity<GetMemeGivenIdResponse> getMemeGivenId(@PathVariable String id){
    GetMemeGivenIdResponse getMemeGivenIdResponse = memeService.findMemeGivenId(id);
    if(getMemeGivenIdResponse.getMeme()==null){
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Meme with given Id not found!");
    }
    else{
      return ResponseEntity.ok().body(getMemeGivenIdResponse);
    }
  }

  @PostMapping(POST_MEME_API)
  public ResponseEntity<PostMemeResponse> addMeme(@RequestBody PostMemeRequest postMemeRequest){
    PostMemeResponse postMemeResponse = memeService.addMeme(postMemeRequest);
    if(postMemeResponse.isDuplicate()==true){
      throw new ResponseStatusException(HttpStatus.CONFLICT, "Duplicate meme!");
    }
    return ResponseEntity.ok().body(postMemeResponse);
  }


}
