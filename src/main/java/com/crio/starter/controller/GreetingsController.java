package com.crio.starter.controller;


import com.crio.starter.exchange.ResponseDto;

import com.crio.starter.service.GreetingsService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GreetingsController {
  
  private final GreetingsService greetingsService;

  @GetMapping("/say-hello")
  public ResponseDto sayHello(@RequestParam String messageId) {
    return greetingsService.getMessage(messageId);
  }

    // @Autowired
    // private MemeService memeService;

    // @GetMapping("/memes/{id}")
    // public ResponseEntity<MemeEntity> getMemeFromId(@PathVariable String id){
    //     MemeEntity res = memeService.findById(Integer.parseInt(id));

    //     if(res==null){
    //         throw new MemeNotFoundException();
    //     }
    //     return new ResponseEntity<>(res,HttpStatus.OK);
    // }

    // @GetMapping("/memes/")
    // public List<MemeEntity> getLatest100Memes(){
    //     List<MemeEntity> res =memeService.getLatest100Memes();
    //     return res;
    // }

    // @PostMapping("/memes/")
    // public memeResponse addMeme(@RequestBody memeRequest inout){
    //     if(memeService.isAClone(inout)){
    //         throw new DuplicateMemeException();
    //     }

    //     memeResponse res=memeService.saveMeme(inout);
    //     return res;
    // }

    

}
