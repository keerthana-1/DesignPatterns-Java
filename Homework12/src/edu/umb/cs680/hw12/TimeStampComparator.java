package edu.umb.cs680.hw12;

import edu.umb.cs680.hw12.fs.FSElement;

import java.util.Comparator;

public class TimeStampComparator implements Comparator<FSElement>{
    @Override
    public int compare(FSElement f1, FSElement f2) {
        return f1.getCreationTime().compareTo(f2.getCreationTime());
    }
}
