package com.spring.boot.app.song;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class SongController {

    @Autowired
    private SongService songService;



    @RequestMapping("/songs")
    public List<Song> getAllSongs(){
        return songService.getAllSongs();
    }
    @RequestMapping("/songs/{id}")
    public Song getSong (@PathVariable long id){

        return songService.getSong(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/songs/add")
    public void addSong(@RequestBody Song song){
        songService.addSong(song);

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/songs/{id}")
    public void updateSong(@RequestBody Song song, @PathVariable long id){
        songService.updateSong(id, song);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/songs/{id}")
    public void deleteSong(/*@RequestBody Song song,*/@PathVariable long id){
        songService.removeSong(id);

    }

}


