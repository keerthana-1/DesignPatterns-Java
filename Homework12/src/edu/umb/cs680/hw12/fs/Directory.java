package edu.umb.cs680.hw12.fs;

import edu.umb.cs680.hw12.AlphabeticalComparator;
import edu.umb.cs680.hw12.util.FSVisitor;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Directory extends FSElement {

    private LinkedList<FSElement> children;
    public static int size=0;
    public Directory(Directory parent, String name, int size,LocalDateTime creationTime){
        super(parent,name,size,creationTime);
        children = new LinkedList<>();
    }

    public LinkedList<FSElement> getChildren(){
        Collections.sort(this.children,new AlphabeticalComparator());
        return this.children;
    }

    public int countChildren(){
        return this.children.size();
    }

    public void appendChild(FSElement child){
        this.children.add(child);
        child.setParent(this);
        //Collections.sort(children,new AlphabeticalComparator());
    }

    public LinkedList<Directory> getSubDirectories(){
        LinkedList<Directory> subdirlist=new LinkedList<Directory>();
        int cnt=0;
        for(FSElement fs:getChildren()){
            if(fs.isDirectory()) {
                subdirlist.add((Directory) fs);
                //System.out.println(subdirlist.get(cnt).name);
                cnt++;
            }
        }
        return subdirlist;
    }

    public LinkedList<FSElement> getFiles(){
        LinkedList<FSElement> fileslist=new LinkedList<FSElement>();
        int cnt=0;
        for(FSElement fs:getChildren()){
            if(!fs.isDirectory()) {
                fileslist.add( fs);
               // System.out.println(fileslist.get(cnt).name);
                cnt++;
            }
        }
        return fileslist;
    }

    public int getTotalSize(){
        int total_size=0;
        for(FSElement f:getChildren()){
            if(f instanceof Directory) {
                total_size = total_size + ((Directory)f).getTotalSize();
            }
            else{
                total_size = total_size +f.getSize();
            }
        }
        return total_size;
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public void accept(FSVisitor v) {
        v.visit(this);
        for(FSElement e:children){
            e.accept(v);
        }
    }

    public LinkedList<FSElement> getChildren(Comparator<FSElement> comparator){
        Collections.sort(this.children,comparator);
        return this.children;
    }

    public LinkedList<File> getFiles(Comparator<FSElement> comparator){
        LinkedList<File> fileslist=new LinkedList<File>();
        int cnt=0;
        for(FSElement fs:getChildren()){
            if(!fs.isDirectory()) {
                fileslist.add((File) fs);
                // System.out.println(fileslist.get(cnt).name);
                cnt++;
            }
        }
        Collections.sort(fileslist,comparator);
        return fileslist;
    }

    public LinkedList<Directory> getSubDirectories(Comparator<FSElement> comparator){
        LinkedList<Directory> subdirlist=new LinkedList<Directory>();
        int cnt=0;
        for(FSElement fs:getChildren()){
            if(fs.isDirectory()) {
                subdirlist.add((Directory) fs);
                //System.out.println(subdirlist.get(cnt).name);
                cnt++;
            }
        }
        Collections.sort(subdirlist,comparator);
        return subdirlist;
    }



}
