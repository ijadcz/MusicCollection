package com.spring.boot.app;


import com.spring.boot.app.song.Song;
import com.spring.boot.app.song.SongRepository;
import com.spring.boot.app.user.User;
import com.spring.boot.app.user.UserRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Start {

    private SongRepository songRepository;

    private UserRepository userRepository;

    public Start(UserRepository userRepository, PasswordEncoder passwordEncoder, SongRepository songRepository) {
        this.userRepository=userRepository;
        this.songRepository= songRepository;

        userRepository.deleteAll();
        songRepository.deleteAll();

        User user = new User();
        user.setUsername("ania");
        user.setPassword(passwordEncoder.encode("ania"));
        user.setRole("ADMIN");
        userRepository.save(user);

        User user2 = new User();
        user2.setUsername("user");
        user2.setPassword(passwordEncoder.encode("user"));
        user2.setRole("USER");
       // userRepository.save(user2);

        Song song = new Song();
        song.setTitle("aaaa");
        song.setArtist("bbbbbbbbb");
        Song song2 = new Song();
        song2.setTitle("yyyyy");
        song2.setArtist("yyyy");

        Song song3 = new Song();
        song3.setTitle("zzzzzz");
        song3.setArtist("zzzz");
        Song song4 = new Song();
        song4.setTitle("ooooooooo");
        song4.setArtist("ooooooo");
        songRepository.saveAndFlush(song);
        songRepository.saveAndFlush(song2);
        songRepository.saveAndFlush(song3);
        songRepository.saveAndFlush(song4);

       // user.addProduct(song);
        user.getSongs().add(song);
        user.getSongs().add(song2);
        //song.getUsers().add(user);
        userRepository.saveAndFlush(user);
        //songRepository.save(song);
        //song.addUser(user);
        //songRepository.save(song);
    }
}














/*package com.spring.boot.app;

import com.spring.boot.app.song.Song;
import com.spring.boot.app.song.SongRepository;
import com.spring.boot.app.user.User;
import com.spring.boot.app.user.UserDetailsCustom;
import com.spring.boot.app.user.UserRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class Start {
@Autowired
    private SongRepository songRepository;
@Autowired
    private UserRepository userRepository;


    public void Start(UserRepository userRepository, PasswordEncoder passwordEncoder, SongRepository songRepository) {
        this.userRepository = userRepository;
        this.songRepository = songRepository;

        User user = new User();
        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("user"));
        user.setRole("user");


        Song song = new Song();
        song.setTitle("aaaa");
        // song.setId(9);
        song.setArtist("bbbbbbbbb");
        song.addUser(user);
        songRepository.save(new Song(song));
       // userRepository.save(new User(user));
        user.getSongs().add(song);
        song.getUsers().add(user);
        songRepository.save(song);
        userRepository.save(user);
        userRepository.flush();
        songRepository.flush();

//songRepository.saveAndFlush(song);
    }}


/*

        User user2 = new User();
        user2.setUsername("user2");
        user2.setPassword(passwordEncoder.encode("user2"));
        user2.setRole("user");


        Song song = new Song();
        song.setTitle("aaaa");
       // song.setId(9);
        song.setArtist("bbbbbbbbb");

        Song song2 = new Song();
        song2.setTitle("00000000");
       // song2.setId(0);
        song2.setArtist("ooooooooooo");
       // songRepository.saveAndFlush(song2);
        //songRepository.saveAndFlush(song);
       // user.addProduct(song);
        //this.songRepository.save(song2);
        //this.userRepository.save(user);
        user.addProduct( song2);
        song2.addUser(user);
        //user2.getSongs().add(new Song(song2));
       // this.songRepository.save(song2);
       //this.userRepository.save(user);
       //this.songRepository.saveAndFlush(song2);
      // user2= userRepository.saveAndFlush(user2);
        //user.addProduct(song);
        //user= userRepository.saveAndFlush(user);
session.save(user);
session.save(song2);
tx.commit();
session.close();



        Song song2 = new Song();
        song2.setTitle("ccccc");
        song2.setArtist("dddd");
      //  Set<Song> playlist= new HashSet<>();
       // songRepository.save(song2);
        //playlist.add(song);
       // playlist.add(song2);

      User user2 = new User("user", passwordEncoder.encode("user"),"USER");
     user2.getSongs().add(song);
     user2.getSongs().add(song2);*/
    //   song.setUsers((Set<org.springframework.security.core.userdetails.User>) user2);
      // song.setUsers((Set<org.springframework.security.core.userdetails.User>) user2);

       //song2.setUsers((Set<org.springframework.security.core.userdetails.User>) user2);
       // user2.setUsername("user");
        //user2.setPassword(passwordEncoder.encode("user"));
        //user2.setRole("USER");
        //user2.getPlaylist().add(song);
        //user2.getPlaylist().add(song2);
       //user2.setPlaylist(playlist);
     // userRepository.save(user2);
        //user2.getSongs().add(song);
      //  userRepository.save(user2);
    //  songRepository.save(song);
     // songRepository.save(song2);

