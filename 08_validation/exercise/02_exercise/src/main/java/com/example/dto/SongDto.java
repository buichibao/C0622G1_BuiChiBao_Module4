package com.example.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDto implements Validator {

    private Integer id;

    @NotBlank(message = "Tên bài hát không được để trống")
    @Size(max = 300,message = "Tên bài hát không quá 300 kí tự")
    @Pattern(regexp = "^[a-zA-Z0-9]*$",message = "Tên bài hát không được chứa kí tự đặc biệt @ , !, #")
    private String nameSong;

    @NotBlank(message = "Tên ca sĩ không được để trống")
    @Size(max = 800,message = "Tên ca sĩ không quá 300 kí tự")
    @Pattern(regexp = "^[a-zA-Z0-9]*$",message = "Tên ca sĩ không được chứa kí tự đặc biệt @ , !, #")
    private String singer;

    @NotBlank(message = "Tên thể loại không được để trống")
    @Size(max = 1000,message = "Tên thể loại không quá 300 kí tự")
    @Pattern(regexp = "^[,a-zA-Z0-9]*$",message = "Tên thể loại không được chứa kí tự đặc biệt @ , !, #")
    private String category;

    public SongDto() {
    }

    public SongDto(Integer id, String nameSong, String singer, String category) {
        this.id = id;
        this.nameSong = nameSong;
        this.singer = singer;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
         SongDto songDto = (SongDto) target;
    }
}
