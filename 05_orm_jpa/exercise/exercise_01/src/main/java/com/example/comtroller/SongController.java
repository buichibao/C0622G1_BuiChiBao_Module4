package com.example.comtroller;

import com.example.model.Song;
import com.example.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/song")
public class SongController {

    @Autowired
    private ISongService iSongService;

    @GetMapping("")
    public  String list(Model model){
        model.addAttribute("songList",iSongService.findAll());
        return "/list";
    }

    @GetMapping("/{id}-delete")
    public String showFormdelete(@PathVariable int id,Model model){
        model.addAttribute("song",iSongService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String deleteSong(@ModelAttribute Song song, RedirectAttributes redirectAttributes){
        iSongService.delete(song.id);
        redirectAttributes.addFlashAttribute("messDelete","Xoa thanh cong");
        return "redirect:/song";
    }

    @GetMapping("/{id}-delete")
    public String showFormView(@PathVariable int id,Model model){
        model.addAttribute("song",iSongService.findById(id));
        return "/view";
    }
}
