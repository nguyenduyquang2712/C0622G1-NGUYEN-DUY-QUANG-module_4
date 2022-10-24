package com.codegym.controller;

import com.codegym.dto.SongDto;
import com.codegym.model.Song;
import com.codegym.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {
    @Autowired
    ISongService songService;

    @GetMapping("")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("song/list");
        List<Song> songs = songService.findAll();
        modelAndView.addObject("songs", songs);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateSong() {
        ModelAndView modelAndView = new ModelAndView("song/create");
        modelAndView.addObject("songDto", new SongDto());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView creatForm(@ModelAttribute @Validated SongDto songDto, BindingResult bindingResult) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("song/create");
            return modelAndView;
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            songService.save(song);
            ModelAndView modelAndView = new ModelAndView("song/create");
            modelAndView.addObject("songDto", songDto);
            modelAndView.addObject("message", "Song created successfully");
            return modelAndView;
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showUpdateForm(@PathVariable int id) {
        Song song = songService.findById(id);
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(song, songDto);
        ModelAndView modelAndView = new ModelAndView("song/edit");
        modelAndView.addObject("songDto", songDto);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editForm(@ModelAttribute @Validated SongDto songDto, BindingResult bindingResult) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("song/edit");
            return modelAndView;
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            songService.save(song);
            ModelAndView modelAndView = new ModelAndView("song/edit");
            modelAndView.addObject("songDto", songDto);
            modelAndView.addObject("message", "Song edited successfully");
            return modelAndView;
        }
    }
}
