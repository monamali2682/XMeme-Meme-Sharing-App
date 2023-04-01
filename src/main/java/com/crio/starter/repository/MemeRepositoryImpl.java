package com.crio.starter.repository;

import java.util.List;
import com.crio.starter.Dto.Meme;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.crio.starter.Models.MemeEntity;
// import com.mongodb.internal.inject.Provider;
//import javax.inject.Provider;
import org.modelmapper.ModelMapper;
//import org.modelmapper.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.Arrays;
import com.crio.starter.DAO.MemeDao;


@Repository
public class MemeRepositoryImpl implements MemeRepository {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    MemeDao memeDao;

    @Override
    public List<Meme> findLatestMemes(){
        Pageable pageable = PageRequest.of(0, 100, Sort.by("id").descending());
        List<MemeEntity> allMemes=memeDao.findAll(pageable).getContent();
        if(allMemes.isEmpty()) return new ArrayList<>();
        Meme[] memes= modelMapper.map(allMemes, Meme[].class);
        return Arrays.asList(memes);
        //PageRequest request = new PageRequest(0, 100, new Sort(Direction.DESC, "created"));
        
    }

    @Override
    public Meme findMemeGivenId(String id) {
        MemeEntity memeEntity= memeDao.findById(id).orElse(null);
        if(memeEntity==null) return null;
        return modelMapper.map(memeEntity, Meme.class);
    }

    @Override
    public Meme isMemeDuplicate(String name, String url, String caption){
        MemeEntity memeEntity= memeDao.isDuplicateEntry(name, url, caption);
        if(memeEntity==null) return null;
        return modelMapper.map(memeEntity, Meme.class);
    }

    @Override
    public Meme saveMeme(MemeEntity memeEntity) {
        MemeEntity memeSaved= memeDao.save(memeEntity);
        return modelMapper.map(memeSaved, Meme.class);
    }
    
}
