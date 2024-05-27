package edu.umb.cs680.hw12.fs;

import edu.umb.cs680.hw12.fs.Directory;
import edu.umb.cs680.hw12.fs.FSElement;
import edu.umb.cs680.hw12.util.FSVisitor;

import java.time.LocalDateTime;

public class Link extends FSElement {

    FSElement target;
    public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target){
        super(parent,name,size,creationTime);
        this.target=target;
    }

    public FSElement getTarget(){
        return this.target;
    }
    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public void accept(FSVisitor v) {
        v.visit(this);
    }
}
