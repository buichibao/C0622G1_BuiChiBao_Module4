package com.example.service.impl;

import com.example.model.Song;
import com.example.repository.ISongRepository;
import com.example.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SongService implements ISongService {

    @Autowired
    private ISongRepository iSongRepository;

    @Override
    public void update(Song song) {
        iSongRepository.save(song);
    }

    @Override
    public void save(Song song) {
        iSongRepository.save(song);
    }

    @Override
    public Page<Song> findAllByNameSongContaining(Pageable pageable, String nameSong) {
        return iSongRepository.findAllByNameSongContaining(pageable,nameSong);
    }

    @Override
    public Song findById(int id) {
        return iSongRepository.findById(id);
    }

}
