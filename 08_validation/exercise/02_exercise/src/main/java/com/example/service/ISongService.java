package com.example.service;

import com.example.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISongService {

    void update(Song song);

    void save(Song song);

    Page<Song> findAllByNameSongContaining(Pageable pageable,String nameSong);

    Song findById(int id);

}
