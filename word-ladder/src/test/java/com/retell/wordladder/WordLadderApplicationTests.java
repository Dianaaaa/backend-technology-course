package com.retell.wordladder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WordLadderApplicationTests {

    @Test
    public void fileRead() {
        ClassPathResource dictPath = new ClassPathResource("static/dictionary.json");
        HashSet<String> dictSet = new HashSet<>();
        try {
            String dictFilePath = dictPath.getFile().getAbsolutePath();
            BufferedReader readfile = new BufferedReader(new FileReader(dictFilePath));
            String tempString = null;
            while ((tempString = readfile.readLine()) != null) {
                dictSet.add(tempString);
            }
            readfile.close();
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(dictSet.isEmpty(), Boolean.FALSE);
    }

//    @Test
//    public void fileRead

}
