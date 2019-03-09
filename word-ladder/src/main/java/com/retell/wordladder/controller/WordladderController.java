package com.retell.wordladder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ui.Model;

import java.io.*;

import com.retell.wordladder.Wordladder;


@Controller
public class WordladderController {
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("ladder", "Xingyue Qian");
        return "index";
    }

    @RequestMapping(value="/word-ladder",method= RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResponseEntity<String> outputWordLadder(String word1, String word2){
        String worldLadder =" ";
        ClassPathResource dictPath = new ClassPathResource("static/dictionary.txt");
        try {
            String dictFilePath = dictPath.getFile().getAbsolutePath();
            Wordladder ladder = new Wordladder(dictFilePath);
            worldLadder = ladder.genLadder(word1, word2);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<String>(worldLadder, HttpStatus.OK);
    }
}
