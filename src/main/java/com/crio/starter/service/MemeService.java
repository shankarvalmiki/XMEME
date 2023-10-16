package com.crio.starter.service;

import java.util.List;
import com.crio.starter.data.MemeEntity;
import com.crio.starter.exchange.memeRequest;
import com.crio.starter.exchange.memeResponse;
//import org.springframework.stereotype.Service;
//@Service
public interface MemeService {
    MemeEntity findById(int id);

    List<MemeEntity> getLatest100Memes();

    memeResponse saveMeme(memeRequest inout);

    boolean isAClone(memeRequest meme);
    
}
