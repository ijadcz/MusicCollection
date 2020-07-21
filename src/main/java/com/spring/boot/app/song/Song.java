package com.spring.boot.app.song;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.boot.app.user.User;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Song {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String artist;
    @JsonIgnore
    @ManyToMany(mappedBy = "songs")
    private Set<User> users= new HashSet<>();




    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }


    public Song() {
    }


    public Song( String title, String artist) {

        this.title = title;
        this.artist = artist;
    }




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }



    public void addUser(User p) {
        this.users.add(p);
        p.getSongs().add(this);
    }

    public void removeUser(User p) {
        this.users.remove(p);
        p.getSongs().remove(this);
    }
}

