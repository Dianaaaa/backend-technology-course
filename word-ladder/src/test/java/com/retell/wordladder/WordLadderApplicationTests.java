package com.retell.wordladder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WordLadderApplicationTests {
    private Wordladder ladder;

    public WordLadderApplicationTests() {
        ClassPathResource dictPath = new ClassPathResource("static/dictionary.txt");
        try {
            String dictFilePath = dictPath.getFile().getAbsolutePath();
            ladder = new Wordladder(dictFilePath);
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testConstruct() {
        Boolean result = Boolean.FALSE;
        if (ladder != null) {
            result = Boolean.TRUE;
        }
        assertEquals(result, Boolean.TRUE);
    }

    @Test
    public void testIsContained() {
        Boolean result = Boolean.FALSE;
        result = ladder.isContained("add");
        assertEquals(result, Boolean.TRUE);
        result = ladder.isContained("jieojwooi");
        assertEquals(result, Boolean.FALSE);
    }

    @Test
    public void testLadderToString() {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        String result = ladder.ladderToString(stack);
        assertEquals(result,"b -> a");
    }

    @Test
    public void testGenLadder() {
        String result = " ";
        result = ladder.genLadder("data", "date");
        assertEquals(result, "data -> date");
    }

}
