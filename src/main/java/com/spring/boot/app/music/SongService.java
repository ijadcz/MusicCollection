package com.spring.boot.app.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class SongService {


    @Autowired
    private SongRepository songRepository;

  // private List<Song> songs = new ArrayList<>(Arrays.asList( new Song(0, "aaaaaaaaaa", "bbbbb"), new Song(1, "ccccccccccc","ddddddd")));


    public SongService(SongRepository songRepository){
        this.songRepository=songRepository;
    }
public List<Song> getAllSongs()
{
//    return songs;
    List<Song> songs = new ArrayList<>();
    songRepository.findAll().forEach(songs::add);
    return songs;
}

public Optional<Song> getSong(long id){
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
