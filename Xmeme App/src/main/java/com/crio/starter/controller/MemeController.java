// package com.crio.starter.controller;

// import java.util.Collections;
// import java.util.HashMap;
// import java.util.List;
// import javax.validation.ConstraintViolationException;
// import com.crio.starter.data.Meme;
// import com.crio.starter.exceptions.*;
// import com.crio.starter.service.MemeService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PatchMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// public class MemeController {
//     @Autowired
//     MemeService memeService;

//     @GetMapping("/memes")
//     public ResponseEntity<?>getLatestMemes() {
//         try {
//             List<Meme> memeList = memeService.getMemes();
//             return new ResponseEntity<>(memeList, memeList.size() > 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT);
            
//         } catch (Exception exception) {
//             return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);  
//         }
       
//     }
    
   
//     @GetMapping("/memes/{memeId}")
//     public ResponseEntity<?>getSingleMeme(@PathVariable String memeId) {
//         try {
//             Meme requiredMeme = memeService.getMeme(memeId);
//             return new ResponseEntity<Meme>(requiredMeme, HttpStatus.OK);

//         } catch (MemeCollectionException exception) {
//             return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);

//         }
//         catch (Exception exception) {
//             return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);  
//         }
        
//     }

//     @PostMapping("/memes")
//     public ResponseEntity<?> createMeme(@RequestBody Meme meme) {
//         try {
//             ResponseEntity<?>response = this.memeService.createMeme(meme);
//             return response;
            
//         } catch(ConstraintViolationException exception) {
//             return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);

//         } catch(MemeCollectionException exception) {
//             return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);

//         } catch (InvalidUrlException exception) {
//             return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        
//         } catch (Exception exception) {
//             return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

//         }
//     }

    
//     @PatchMapping("/memes/{memeId}")
//     public ResponseEntity<?> patchMeme(@RequestBody HashMap<String, String>newValues, @PathVariable String memeId) {
//         try {
//             memeService.updateMeme(newValues, memeId);
//             return new ResponseEntity<String>(String.valueOf(HttpStatus.OK.value()), HttpStatus.OK);

//         } catch(MemeWrongUpdateException exception) {
//             return new ResponseEntity<>(exception.getMessage(), HttpStatus.FORBIDDEN);

//         } catch(MemeCollectionException exception) {
//             return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        
//         } catch (InvalidUrlException exception) {
//             return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        
//         } catch (Exception exception) {
//             return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        
//         }

//     }

// }
