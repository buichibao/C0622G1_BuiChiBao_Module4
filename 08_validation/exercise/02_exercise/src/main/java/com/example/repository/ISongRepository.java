package com.example.repository;

import com.example.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song,Integer> {
   Page<Song> findAllByNameSongContaining(Pageable pageable,String nameSong);

   Song findById(int id);
}
