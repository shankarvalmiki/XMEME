package com.crio.starter.controller;
import lombok.RequiredArgsConstructor;
import java.util.List;
import com.crio.starter.data.MemeEntity;
import com.crio.starter.exceptions.BadRequestException;
import com.crio.starter.exceptions.DuplicateMemeException;
import com.crio.starter.exceptions.MemeNotFoundException;
import com.crio.starter.exchange.memeRequest;
import com.crio.starter.exchange.memeResponse;
import com.crio.starter.service.MemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.crio.starter.exchange.memeRequest;


@RestController
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping //("/memes")
public class MemeController {
    @Autowired
    private MemeService memeService;
    // yen gotta maybe query parameter na memes?id=90 anta karitirtara but neenu pathVariable agi calll madtaidiya to get more idea about this springboot module nodu gottagutte ansutte or how to send GET query message in spring anta search madu.
    @GetMapping("/memes/{id}")
    public ResponseEntity<MemeEntity> getMemeFromId(@PathVariable String id){
        MemeEntity res = memeService.findById(Integer.parseInt(id));

        if(res==null){
            throw new MemeNotFoundException("nott found");
        }
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @GetMapping("/memes/")
    public List<MemeEntity> getLatest100Memes(){
        List<MemeEntity> res =memeService.getLatest100Memes();
        return res;
    }

    @PostMapping("/memes/")
    public memeResponse addMeme(@RequestBody(required = true) @Validated memeRequest inout){
        if(inout.getName()==null||inout.getCaption()==null||inout.getUrl()==null){
            throw new BadRequestException();
        }
        if(memeService.isAClone(inout)){
            //System.out.println("passed through here");
            throw new DuplicateMemeException();
        }
        //System.out.println("and then here or not");
        memeResponse res=memeService.saveMeme(inout);
        return res;
    }

    
    
}
