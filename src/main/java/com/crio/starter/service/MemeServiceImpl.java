package com.crio.starter.service;


import java.util.List;
import com.crio.starter.Dto.Meme;
import com.crio.starter.Models.MemeEntity;
import com.crio.starter.exchange.GetMemeGivenIdResponse;
import com.crio.starter.exchange.GetMemesResponse;
import com.crio.starter.exchange.PostMemeRequest;
import com.crio.starter.exchange.PostMemeResponse;
import com.crio.starter.repository.MemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemeServiceImpl implements MemeService{
    @Autowired
    private MemeRepository memeRepository;
    

    @Override
    public GetMemesResponse findLatest100Memes() {
        List<Meme> memes = memeRepository.findLatestMemes();
        return new GetMemesResponse(memes);  
    }


    @Override
    public GetMemeGivenIdResponse findMemeGivenId(String id) {
        Meme meme = memeRepository.findMemeGivenId(id);
        return new GetMemeGivenIdResponse(meme);
    }


    @Override
    public PostMemeResponse addMeme(PostMemeRequest postMemeRequest) {
        String name=postMemeRequest.getName();
        String url =postMemeRequest.getUrl();
        String caption = postMemeRequest.getCaption();
        Meme memeFromRepo=memeRepository.isMemeDuplicate(name, url, caption);
        if(memeFromRepo!=null) return new PostMemeResponse(null,true);
        Meme meme = memeRepository.saveMeme(new MemeEntity(name,url,caption));
        return new PostMemeResponse(meme.getId(),false);
    }

     
    
}
