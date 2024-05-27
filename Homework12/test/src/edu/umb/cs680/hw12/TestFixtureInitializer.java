package edu.umb.cs680.hw12;

import edu.umb.cs680.hw12.fs.Directory;
import edu.umb.cs680.hw12.fs.File;
import edu.umb.cs680.hw12.fs.FileSystem;
import edu.umb.cs680.hw12.fs.Link;

import java.time.LocalDateTime;

public class TestFixtureInitializer {

    public static FileSystem createFS(){
        FileSystem fs=FileSystem.getFileSystem();
        Directory prjRoot=new Directory(null,"prjRoot",0, LocalDateTime.now());
        Directory src=new Directory(prjRoot,"src",0,LocalDateTime.now());
        Directory lib=new Directory(prjRoot,"lib",0,LocalDateTime.now());
        Directory test=new Directory(prjRoot,"test",0,LocalDateTime.now());
        Directory test_src=new Directory(test,"test_src",0,LocalDateTime.now());
        File x= new File(prjRoot,"x",5,LocalDateTime.now());
        File a= new File(src,"a",5,LocalDateTime.now());
        File b= new File(src,"b",5,LocalDateTime.now());
        File c= new File(lib,"c",5,LocalDateTime.now());
        File d= new File(test_src,"d",10,LocalDateTime.now());

        fs.appendRoot(prjRoot);

        prjRoot.appendChild(src);
        prjRoot.appendChild(lib);
        prjRoot.appendChild(test);
        prjRoot.appendChild(x);
        src.appendChild(a);
        src.appendChild(b);
        lib.appendChild(c);
        test.appendChild(test_src);
        test_src.appendChild(d);

        Link y=new Link(prjRoot,"y",10,LocalDateTime.now(),test_src);
        prjRoot.appendChild(y);

        return fs;
    }


}
