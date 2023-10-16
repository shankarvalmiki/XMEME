package com.crio.starter.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//import java.util.Optional;
import com.crio.starter.data.MemeEntity;
import com.crio.starter.exceptions.MemeNotFoundException;
import com.crio.starter.exchange.memeRequest;
import com.crio.starter.exchange.memeResponse;
import com.crio.starter.repository.MemesRepository;
//import com.crio.starter.repositoryService.MemesRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemeServiceImpl implements MemeService {
    // @Autowired
    // private MemesRepositoryService memesRepositoryService;

	// @Override
	// public MemeEntity findById(int id) {
		
	// 	return memesRepositoryService.findById(id);
	// }

	// @Override
	// public List<MemeEntity> getLatest100Memes() {
	// 	List <MemeEntity> res=new ArrayList<>();
	// 	res=memesRepositoryService.getLatest100Memes();
	// 	return res;
	// }

	// @Override
	// public memeResponse saveMeme(memeRequest inout) {
	// 	memeResponse res=memesRepositoryService.saveMeme(inout);
	// 	return res;
		
	// }

	// @Override
	// public boolean isAClone(memeRequest meme) {
		
	// 	return memesRepositoryService.isAClone(meme);
	// }



	@Autowired
    private MemesRepository memesRepository;

	private int autoIncrement=0;

	@Override
	public MemeEntity findById(int id) {
		List<MemeEntity> res = new ArrayList<>();
        res=memesRepository.findAll();
		MemeEntity ans=null;

		for(MemeEntity meme:res) {
			if(meme.getId()==id){
				ans=meme;
				break;
			}
		}
        // Optional<MemeEntity> ans=memesRepository.findById(id);
		// if(ans.get()==null){
		// 	throw new MemeNotFoundException("nottt found");
		// }
		
		return ans;
	}

	@Override
	public List<MemeEntity> getLatest100Memes() {
		List<MemeEntity> res = new ArrayList<>();
        res=memesRepository.findAll();
		int size=res.size();
		if(size==0){
            return res;
		}
        if(size<=100){
            return res;
        }
        else{
			List<MemeEntity> ret= new ArrayList<>();
            for(int i=size-100;i<size;i++){
                ret.add(res.get(i));
            }
			Collections.reverse(ret);
			return ret;

        }
        //return res;
	}

	@Override
	public memeResponse saveMeme(memeRequest inout) {

		autoIncrement++;
		int id=autoIncrement;
		String name=inout.getName();
		String memeUrl=inout.getUrl();
		String caption=inout.getCaption();

		MemeEntity res= new MemeEntity(id, name, memeUrl, caption);
		MemeEntity ress=memesRepository.save(res);
		memeResponse ans=new memeResponse(Integer.toString(id));
		return ans;
		
	}

	@Override
	public boolean isAClone(memeRequest meme) {
		List<MemeEntity> res= new ArrayList<>();

		res = memesRepository.findAll();
		for(MemeEntity meme2:res){
			if(meme2.getName().equals(meme.getName())&&meme2.getCaption().equals(meme.getCaption())&&meme2.getUrl().equals(meme.getUrl())){
                return true;
            }
		}
		return false;
	}
	
    
}
