package com.spring.boot.app.user;

import com.spring.boot.app.song.Song;
import javax.persistence.*;
import java.util.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String username;
    private String password;
    private String role;

    @ManyToMany
    private Set<Song> songs = new HashSet<>();

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }

    public void addSong(Song p) {
        this.songs.add(p);
        p.getUsers().add(this);
    }

    public void removeSong(Song p) {
        this.songs.remove(p);
        p.getUsers().remove(this);
    }


    public User(){}

    public User( String username, String password, String role){

        this.username= username;
        this.password=password;
        this.role= role;
       // this.id= getId();


    }

    public long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }


  public String getPassword() {
        return password;
    }


    public String getUsername() {
        return username;
    }

}
