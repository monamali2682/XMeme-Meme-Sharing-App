package com.crio.starter.service;

import com.crio.starter.exchange.GetMemeGivenIdResponse;
import com.crio.starter.exchange.GetMemesResponse;
import com.crio.starter.exchange.PostMemeRequest;
import com.crio.starter.exchange.PostMemeResponse;

public interface MemeService {
    /**
   * Get all the latest 100 memes
   * @return GetMemesResponse object containing a list of memes or an
   *     empty list if no memes present.
   */
  GetMemesResponse findLatest100Memes();

   /**
   * Get all meme with given Id
   * @param id of meme
   * @return meme with given Id
   */
  GetMemeGivenIdResponse findMemeGivenId(String id);

  /**
   * Add the meme if not duplicate content
   * @param PostMemeRequest 
   * @return PostMemeResponse
   */
  PostMemeResponse addMeme(PostMemeRequest postMemeRequest);
  }
