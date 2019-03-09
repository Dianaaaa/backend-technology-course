package com.retell.wordladder;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.io.FileReader;

public class Wordladder {
    private String dictFilePath = null;
    private HashSet<String> dictSet = new HashSet<String>();
    public Wordladder(String dictFilePath){
        this.dictFilePath = dictFilePath;
        try {
            BufferedReader readfile = new BufferedReader(new FileReader(dictFilePath));
            String tempString = null;
            while ((tempString = readfile.readLine()) != null) {
                this.dictSet.add(tempString);
            }
            readfile.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

}
