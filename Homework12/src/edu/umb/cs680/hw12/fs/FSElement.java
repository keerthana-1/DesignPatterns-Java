package edu.umb.cs680.hw12.fs;

import edu.umb.cs680.hw12.fs.Directory;
import edu.umb.cs680.hw12.util.FSVisitor;

import java.time.LocalDateTime;

public abstract class FSElement {
    protected String name;
    protected int size;
    protected LocalDateTime creationTime;
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
    public abstract void accept(FSVisitor v);

}
