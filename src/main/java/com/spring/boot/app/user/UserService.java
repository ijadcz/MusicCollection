package com.spring.boot.app.user;

import com.spring.boot.app.song.Song;
import com.spring.boot.app.song.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SongRepository songRepository;

    public UserService(UserRepository userRepository, SongRepository songRepository){
        this.userRepository=userRepository;
        this.songRepository=songRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
       UserDetailsCustom userDetailsCustom = new UserDetailsCustom(user);
       //TODO no user
        return userDetailsCustom;
    }


    public User loadUser(String s) throws UsernameNotFoundException {
       // User user = userRepository.findByUsername(s);
        // UserDetailsCustom userDetailsCustom = new UserDetailsCustom(user);
        //TODO no user
        return userRepository.findByUsername(s);
    }











    public Set<Song> getPlaylist(String username)  {
        User user = userRepository.findByUsername(username);



       // User user =userRepository.findByUsername(username);
//        System.out.println(user.getUsername());



       // for (int a=0; a<users.size();a++) {
       //    if( users.get(a).getUsername()== username){
        //       user= users.get(a);
       //    }
       // }
    Set<Song> songs = user.getSongs();




return songs;}}

