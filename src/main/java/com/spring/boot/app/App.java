package com.spring.boot.app;
import com.spring.boot.app.song.Song;
import com.spring.boot.app.song.SongRepository;
import com.spring.boot.app.user.User;
import com.spring.boot.app.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class App {

public static void main(String[] args) {
    SpringApplication.run(App.class, args);
}
}
