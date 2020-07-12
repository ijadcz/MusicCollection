package com.spring.boot.app;

import com.spring.boot.app.music.Song;
import com.spring.boot.app.music.SongService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController {


    @RequestMapping("/hello")
    public String sayHi(){
        return "hello";
    }

}
