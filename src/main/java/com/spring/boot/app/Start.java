package com.spring.boot.app;

import com.spring.boot.app.music.Song;
import com.spring.boot.app.music.SongRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Start {

    private SongRepository songRepository;

private UserRepository userRepository;

    public Start(UserRepository userRepository, PasswordEncoder passwordEncoder, SongRepository songRepository) {
        this.userRepository=userRepository;


        User user = new User();
        user.setUsername("ania");
        user.setPassword(passwordEncoder.encode("ania"));
        user.setRole("ADMIN");
        userRepository.save(user);

User user2 = new User();
        user2.setUsername("user");
        user2.setPassword(passwordEncoder.encode("user"));
        user2.setRole("USER");
        userRepository.save(user2);

        Song song = new Song();
        song.setTitle("aaaa");
        song.setArtist("bbbbbbbbb");
        song.setId(1);
        songRepository.save(song);
    }
}
