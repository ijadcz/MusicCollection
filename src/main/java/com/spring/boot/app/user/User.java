package com.spring.boot.app.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.boot.app.song.Song;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @Column(name = "user_id")
    private  long id;
    private String username;
    private String password;
    private String role;
/*
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "user_songs",
    joinColumns = {@JoinColumn(name = "id")},
    inverseJoinColumns = {@JoinColumn(name = "id")})*/
    @ManyToMany//( cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Set<Song> songs = new HashSet<>();

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }

    public void addProduct(Song p) {
        this.songs.add(p);
        p.getUsers().add(this);
    }

    public void removeProduct(Song p) {
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

    //@Override
    public String getUsername() {
        return username;
    }

}
