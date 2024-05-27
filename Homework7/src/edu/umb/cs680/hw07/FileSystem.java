package edu.umb.cs680.hw07;

import java.util.LinkedList;

public class FileSystem {

    LinkedList<Directory> rootdirs=new LinkedList<Directory>();

    private static FileSystem instance=null;
    private FileSystem(){

    }

    public static FileSystem getFileSystem(){
        if(instance==null){
            instance=new FileSystem();
        }
        return instance;
    }

    public LinkedList<Directory> getRootDirs(){
        return rootdirs;
    }

    public void appendRoot(Directory root){
        if(root.parent==null)
            rootdirs.add(root);
    }


}
