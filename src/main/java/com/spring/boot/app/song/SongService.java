package com.spring.boot.app.song;

import com.spring.boot.app.user.User;
import com.spring.boot.app.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SongService {


    @Autowired
    private SongRepository songRepository;
    @Autowired
    private UserRepository userRepository;

    // private List<Song> songs = new ArrayList<>(Arrays.asList( new Song(0, "aaaaaaaaaa", "bbbbb"), new Song(1, "ccccccccccc","ddddddd")));


    public SongService(SongRepository songRepository, UserRepository userRepository) {
        this.songRepository = songRepository;
        this.userRepository= userRepository;
    }

    public List<String> getAllSongs() {
//    return songs;
        List<Song> songs = new ArrayList<>();
        songRepository.findAll().forEach(songs::add);
        List<String> titles= new ArrayList<>();
        for(int a=0; a<songs.size();a++) {
            titles.add(songs.get(a).getTitle());
        }
        return titles;
    }

    public Optional<Song> getSong(long id) {
        return songRepository.findById(id);
        //return songs.stream().filter(s -> s.getId()==id).findFirst().get();


    }

    public void addSong(Song song) {

        //songs.add(song);
        songRepository.save(song);
    }


    public void updateSong(long id, Song song) {
        songRepository.save(song);
    /*
        for (int a=0; a< songs.size(); a++) {
            if(songs.get(a).getId()==id){
                songs.set(a,song);
            }
        }*/
    }


    public void deleteSong(long id) {

        songRepository.deleteById(id);

        // songs.removeIf(s -> s.getId()==id);
    }


}

