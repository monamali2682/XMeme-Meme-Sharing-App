package com.crio.starter.repository;

import java.util.List;
import com.crio.starter.Dto.Meme;
import com.crio.starter.Models.MemeEntity;

public interface MemeRepository {
    /**
   * Get the list of all the latest 100 memes
   * @return list of the latest 100 memes or
   *     empty list if there is none
   */
  List<Meme> findLatestMemes();



   /**
   * Get the list of meme with given id
   * @param id of the Meme
   * @return Meme with given Id
   */
  Meme findMemeGivenId(String id);

  /**
   * return if meme with duplicate already present
   * @param name
   * @param url
   * @param caption
   * @return boolean
   */

  Meme isMemeDuplicate(String name, String url, String caption);



  Meme saveMeme(MemeEntity memeEntity);

}
