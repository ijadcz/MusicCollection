package com.spring.boot.app.user;

import com.spring.boot.app.song.Song;
import com.spring.boot.app.song.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
        return userDetailsCustom;
    }


    public User loadUser(String s) throws UsernameNotFoundException {

        return userRepository.findByUsername(s);
    }

    public void updateUser( User user){
        userRepository.saveAndFlush(user);
    }





    public Set<Song> getPlaylist(String username)  {
        User user = userRepository.findByUsername(username);

     // Set<Song> songs = user.getSongs();


    return user.getSongs();}


    public void validateUser(String username) {
        String name= SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(name);
        if (!username.equals(name)){
            throw new UserException();
        }

    }}

