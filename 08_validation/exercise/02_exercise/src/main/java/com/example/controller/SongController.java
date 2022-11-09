package com.example.controller;

import com.example.dto.SongDto;
import com.example.model.Song;
import com.example.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {

    @Autowired
    private ISongService iSongService;

    @GetMapping("/")
    public String listSong(@PageableDefault(value = 10)Pageable pageable,
                           @RequestParam (value = "nameSong",defaultValue = "")String nameSong,
                           Model model){
        model.addAttribute("nameSong",nameSong);
        model.addAttribute("songList",iSongService.findAllByNameSongContaining(pageable,nameSong));
        return "/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("songDto",new SongDto());
        return "/create";
    }

    @PostMapping("/create")
    public String saveSong(@Validated @ModelAttribute SongDto songDto,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){
        if(bindingResult.hasFieldErrors()){
            return "/create";
        }else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto,song);
            iSongService.save(song);
            redirectAttributes.addFlashAttribute("messCreate","Tao moi thanh cong"+song.getNameSong());
            return "redirect:/";
        }

    }

    @GetMapping("/{id}-update")
    private String showFormUpdate(@PathVariable int id, Model model){
        model.addAttribute("songDto",iSongService.findById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String saveSongUpdate(@Validated @ModelAttribute SongDto songDto,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){
        if(bindingResult.hasFieldErrors()){
            return "/update";
        }else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto,song);
            iSongService.save(song);
            redirectAttributes.addFlashAttribute("messUpdate","update thanh cong"+song.getNameSong());
            return "redirect:/";
        }

    }
}
