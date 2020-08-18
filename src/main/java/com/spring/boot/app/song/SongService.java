package com.spring.boot.app.song;

import com.spring.boot.app.user.User;
import com.spring.boot.app.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SongService {


    @Autowired
    private SongRepository songRepository;
    @Autowired
    private UserRepository userRepository;




    public SongService(SongRepository songRepository, UserRepository userRepository) {
        this.songRepository = songRepository;
        this.userRepository = userRepository;
    }

    public List<Song> getAllSongs() {
//    return songs;
        List<Song> songs = new ArrayList<>();
        songRepository.findAll().forEach(songs::add);

        return songs;
    }

    public Song getSong(long id) {
        return songRepository.findById(id).orElseThrow(() -> new SongException(id));
    }




    public void addSong(Song song) {

        songRepository.save(song);
    }


    public void updateSong(long id, Song song) {


        Song song2 = songRepository.findById(id).get();
        song2.setArtist(song.getArtist());
        song2.setTitle(song.getTitle());
        songRepository.save(song2);



    }

/*
    public void deleteSong(long id) {

        songRepository.deleteById(id);
        songRepository.flush();
        userRepository.flush();

        // songs.removeIf(s -> s.getId()==id);
    }
*/
    public void removeSong(long id){
    Song song = new Song();

        song=songRepository.findById(id).orElse(song);

    System.out.println(song.getId());
    System.out.println(id);



    for (User user : song.getUsers()) {
        user.removeSong(song);



    }


        songRepository.delete(song);
    songRepository.flush();
        userRepository.flush();

    }

}

