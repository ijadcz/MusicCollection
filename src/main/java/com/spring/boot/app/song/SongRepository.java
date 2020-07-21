package com.spring.boot.app.song;

import com.spring.boot.app.user.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
/*
    @Modifying
    @Override
    @Transactional
    void deleteById(Long id);

*/

}
