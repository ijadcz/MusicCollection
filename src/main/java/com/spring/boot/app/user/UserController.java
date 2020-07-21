package com.spring.boot.app.user;

import com.spring.boot.app.song.Song;
import com.spring.boot.app.song.SongService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Set;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private SongService songService;


    @RequestMapping("/{username}/playlist")
    public Set<Song> getPlaylist(@PathVariable  String username) {

       userService.validateUser(username);
    Set<Song> songs= userService.getPlaylist(username);
    ArrayList<String> titles= new ArrayList<>();

      return   songs;


    }





    @RequestMapping(method = RequestMethod.PUT, value = "/{username}/playlist/{id}")
    public void addSongToPlaylist(@PathVariable  String username,@PathVariable long id){
        userService.validateUser(username);

        User user = userService.loadUser(username);
        Song s =songService.getSong(id);


        user.getSongs().add(s);
        userService.updateUser(user);


    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{username}/playlist/{id}")
    public void deleteSongFromPlaylist(@PathVariable  String username,@PathVariable long id){
        userService.validateUser(username);

        User user = userService.loadUser(username);
        Song s =songService.getSong(id);
        user.getSongs().remove(s);


        userService.updateUser(user);


    }

}
