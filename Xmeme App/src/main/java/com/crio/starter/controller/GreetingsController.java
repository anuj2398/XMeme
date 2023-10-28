package com.crio.starter.controller;

import com.crio.starter.data.GreetingsEntity;
import com.crio.starter.exchange.GetMemesResponse;
import com.crio.starter.exchange.PostMemeResponse;
import com.crio.starter.service.GreetingsService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

  @Autowired
  private GreetingsService mservice;
  // @PostMapping
  // public ResponseEntity<PostMemeResponse> CheckEmptyData(@RequestBody(required = false) String requestBody){
  //   if (requestBody == null || requestBody.trim().isEmpty()) {
  //     // Send a bad request response
  //     return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  // } else{
  //   return new ResponseEntity<>(HttpStatus.OK);
  // }
  // }
  @PostMapping("/memes/")
  public ResponseEntity<PostMemeResponse> storeMeme(@Valid @RequestBody GreetingsEntity meme) {
    // Check if the meme object is null or if specific fields are empty
    if (meme == null || meme.getUrl() == null || meme.getUrl().isEmpty()) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    else{
    // Proceed with processing the request
    boolean isPresent = mservice.addMeme(meme);

    PostMemeResponse response = new PostMemeResponse(meme.getId());

    if (isPresent) {
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    } else {
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
  }
}


  @GetMapping("/memes/")
  public List<GreetingsEntity> GetAllMemes() {

    GetMemesResponse memelistobj = mservice.getMemes();

    return memelistobj.getMemelist();
    
  }

  
  @GetMapping("/memes/{id}")
  public ResponseEntity<GreetingsEntity> GetMemeById(@PathVariable String id) {

    Optional<GreetingsEntity> memeInfo = mservice.getMeme(id);

    if (memeInfo.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } else
      return new ResponseEntity<>(memeInfo.get(), HttpStatus.CREATED);
  }

}
