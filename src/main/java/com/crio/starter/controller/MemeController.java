package com.crio.starter.controller;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import com.crio.starter.Dto.EmptyJson;
import com.crio.starter.Dto.Meme;
import com.crio.starter.exchange.GetMemeGivenIdResponse;
import com.crio.starter.exchange.GetMemesResponse;
import com.crio.starter.exchange.PostMemeRequest;
import com.crio.starter.exchange.PostMemeResponse;
import com.crio.starter.service.MemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@Validated
public class MemeController {
  
  public static final String POST_MEME_API = "/memes/";
  public static final String GET_MEMES_API = "/memes/";
  public static final String GET_MEMES_ID_API = "/memes/{id}";

  @Autowired
  private MemeService memeService;

  @GetMapping(GET_MEMES_API)
  public ResponseEntity getMemes() {
      HttpHeaders headers = new HttpHeaders();
      headers.add("Content-Type", "application/json");
      //log.info("getRestaurants called with {}", getRestaurantsRequest);
      //CHECKSTYLE:OFF
      GetMemesResponse getMemesResponse = memeService.findLatest100Memes();
      if(getMemesResponse.getMemes().isEmpty()) return new ResponseEntity<>(new EmptyJson(), HttpStatus.OK); ;
      //log.info("getRestaurants returned {}", getRestaurantsResponse);
      return new ResponseEntity<>(getMemesResponse.getMemes(), headers, HttpStatus.OK);
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
  public ResponseEntity<PostMemeResponse> addMeme(@Valid @RequestBody PostMemeRequest postMemeRequest){
    //if(postMemeRequest==null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data can not be empty!");
    PostMemeResponse postMemeResponse = memeService.addMeme(postMemeRequest);
    if(postMemeResponse.isDuplicate()==true){
      throw new ResponseStatusException(HttpStatus.CONFLICT, "Duplicate meme!");
    }
    return ResponseEntity.ok().body(postMemeResponse);
  }


}
