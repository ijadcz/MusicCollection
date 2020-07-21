package com.spring.boot.app.song;

public class SongException extends RuntimeException
{

    public SongException( long id){
        super("Song id"+id+" not fund");


    }
}
