package com.spring.boot.app.user;

import com.spring.boot.app.song.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/{username}/playlist")
    public List<String> getPlaylist(@PathVariable  String username)throws Exception {
    Set<Song> songs= userService.getPlaylist(username);
    ArrayList<String> titles= new ArrayList<>();

  for(Song s: songs){
     titles.add( s.getTitle());
  }






      return   titles;


    }
    /*
    @RequestMapping("/playlist")
    public Set<Song> getPlaylist(UserService userService){
            String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof User) {
             username = ((UserDetails)principal).getUsername();
        } else {
             username = principal.toString();
        }
       return userService.getPlaylist(username);
    }


*/

}
