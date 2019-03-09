package com.retell.wordladder;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    public Boolean isContained(String word){
        return this.dictSet.contains(word);
    }

    public String ladderToString(Stack<String> ladder) {
        StringBuilder result = new StringBuilder();
        Stack<String> stack = (Stack<String>)ladder.clone();
        while(stack.size()!= 0){
            result.append(stack.pop());
            if (stack.size() == 0){
                break;
            }
            result.append(" -> ");
        }
        return result.toString();
    }

    public String genLadder(String word1, String word2) {
        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();
        if ((word1.length() == word2.length()) && (this.isContained(word1) && this.isContained(word2)) && (!word1.equals(word2))){
            Queue<Stack<String>> wordQue = new LinkedList<>();
            Stack<String> ladder = new Stack<>();
            HashSet<String> wordUsed = new HashSet<>();
            ladder.push(word2);

            wordQue.offer(ladder);
            wordUsed.add(word2);
            String curWord;
            Stack<String> resultLadder;
            while(Boolean.TRUE){
                if (wordQue.size() == 0) {
                    break;
                }
                for (int i=0; i<wordQue.size(); i++) {
                    ladder = wordQue.poll();
                    curWord = ladder.peek();
                    for (int j=0; j<curWord.length(); j++) {
                        for (char ch = 'a'; ch <= 'z'; ch++) {
                            StringBuilder wordBuilder = new StringBuilder(curWord);
                            wordBuilder.setCharAt(j, ch);
                            String newWord = wordBuilder.toString();
                            if (this.isContained(newWord) && (!wordUsed.contains(newWord))) {
                                wordUsed.add(newWord);
                                Stack<String> newLadder = (Stack<String>)ladder.clone();
                                newLadder.add(newWord);
                                wordQue.offer(newLadder);
                                if (newWord.equals(word1)) {
                                    resultLadder = newLadder;
                                    return ladderToString(resultLadder);
                                }
                            }
                        }
                    }
                }
            }
            return "Sorry, there is no such a ladder.";
        }
        else return "Invalid input";
    }

}
