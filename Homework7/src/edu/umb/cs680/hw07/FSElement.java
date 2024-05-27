package edu.umb.cs680.hw07;

import java.time.LocalDateTime;

public abstract class FSElement {
    private String name;
    private int size;
    private LocalDateTime creationTime;
    protected Directory parent;

    public FSElement(Directory parent, String name, int size,LocalDateTime creationTime ){
        this.name=name;
        this.size=size;
        this.creationTime=creationTime;
        this.parent =parent;
    }

    public Directory getParent(){
        return this.parent;
    }

    public void setParent(Directory d){
        this.parent=d;
    }

    public int getSize(){
        return this.size;
    }

    public String getName(){
        return this.name;
    }

    public LocalDateTime getCreationTime(){return this.creationTime;}


    public abstract boolean isDirectory();


}