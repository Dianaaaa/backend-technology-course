package com.retell.wordladder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WordLadderApplicationTests {

    @Test
    public void fileRead() {
        ClassPathResource dictPath = new ClassPathResource("static/dictionary.txt");
        HashSet<String> dictSet = new HashSet<>();
        try {
            String dictFilePath = dictPath.getFile().getAbsolutePath();
            BufferedReader readfile = new BufferedReader(new FileReader(dictFilePath));
            String tempString = null;
            while ((tempString = readfile.readLine()) != null) {
                dictSet.add(tempString);
            }
            readfile.close();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(dictSet.isEmpty(), Boolean.FALSE);
    }

    @Test
    public void wordIsContained() {
        ClassPathResource dictPath = new ClassPathResource("static/dictionary.txt");
        Boolean result = Boolean.FALSE;
        try {
            String dictFilePath = dictPath.getFile().getAbsolutePath();
            Wordladder ladder = new Wordladder(dictFilePath);
            result = ladder.isContained("add");
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(result, Boolean.TRUE);

    }

    @Test
    public void ladderToString() {
        ClassPathResource dictPath = new ClassPathResource("static/dictionary.txt");
        String result = "";
        try {
            String dictFilePath = dictPath.getFile().getAbsolutePath();
            Wordladder ladder = new Wordladder(dictFilePath);
            Stack<String> stack = new Stack<>();
            stack.push("a");
            stack.push("b");
            result = ladder.ladderToString(stack);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(result,"b -> a");
    }

    @Test
    public void equal() {
        String word1 = "good";
        StringBuilder word2 = new StringBuilder(word1);
        assertEquals(word1, word2.toString());
    }

    @Test
    public void stackCopy() {
        Stack<String> intStack = new Stack<>();
        intStack.push("a");
        intStack.push("b");
        Stack<String> copiedStack = (Stack<String>)intStack.clone();
        for(int i = 0; i < intStack.size(); i++)
        {
            assertEquals(intStack.pop(), copiedStack.pop());
        }
    }

    @Test
    public void genLadder() {
        ClassPathResource dictPath = new ClassPathResource("static/dictionary.txt");
        String result = " ";
        try {
            String dictFilePath = dictPath.getFile().getAbsolutePath();
            Wordladder ladder = new Wordladder(dictFilePath);
            result = ladder.genLadder("data", "date");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(result, "data -> date");
    }

}
