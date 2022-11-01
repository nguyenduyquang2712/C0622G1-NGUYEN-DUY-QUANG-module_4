package com.codegym.controller;

import com.codegym.model.Bloger;
import com.codegym.model.Category;
import com.codegym.service.IBlogerService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/blogers")
public class BlogerRestController {
    @Autowired
    private IBlogerService blogerService;
    @Autowired
    private ICategoryService categoryService;
//    @GetMapping
//    public ResponseEntity<List<Bloger>> getBlogList(){
//        List<Bloger> blogerList = blogerService.findAll();
//        if(blogerList.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(blogerList,HttpStatus.OK);
//    }
    @GetMapping("")
    public ResponseEntity<List<Bloger>> showBlogList(@PageableDefault(value = 3) Pageable pageable) {
        Page<Bloger> blogers = blogerService.findAll(pageable);
        if(blogers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogers.getContent(),HttpStatus.OK);
    }
    @GetMapping("/view-blog/{id}")
    public ResponseEntity<Bloger> getDetailBlog(@PathVariable int id){
    Bloger bloger = blogerService.findById(id);
        if (bloger==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
            return new ResponseEntity<>(bloger, HttpStatus.OK);

    }

    @GetMapping("/search-blog/{nameCategory}")
    public ResponseEntity<List<Bloger>> getBlogByCategory(@PathVariable String nameCategory){
        List<Bloger> blogerList = blogerService.findAllByCategory(nameCategory);
        if(blogerList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogerList,HttpStatus.OK);
    }
}