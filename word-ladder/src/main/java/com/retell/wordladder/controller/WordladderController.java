package com.retell.wordladder.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.ClassPathResource;

import org.json.simple.JSONObject;

import java.io.*;

import com.retell.wordladder.Wordladder;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
public class WordladderController {
    @RequestMapping(value="/user", method=RequestMethod.GET)
    public String getUsers() {
        return "Hello Spring Security";
    }

    @RequestMapping(value="/word-ladder/{word1}/{word2}",method= RequestMethod.GET)
    public JSONObject outputWordLadder(@PathVariable String word1,@PathVariable String word2){
        String worldLadder =" ";
        ClassPathResource dictPath = new ClassPathResource("static/dictionary.txt");
        try {
            Wordladder ladder = new Wordladder(dictPath.getInputStream());
            worldLadder = ladder.genLadder(word1, word2);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

        JSONObject result = new JSONObject();
        result.put("wordladder", worldLadder.toString());
        return result;
    }

    /********Template solution*****************/
//    @RequestMapping(value="/", method=RequestMethod.GET)
//    public String index(Model model){
//        model.addAttribute("ladder", "Xingyue Qian");
//        return "index";
//    }
//
//    @RequestMapping(value="/word-ladder",method= RequestMethod.GET)
//    public String outputWordLadder(String word1, String word2, Model model){
//        String worldLadder =" ";
//        ClassPathResource dictPath = new ClassPathResource("static/dictionary.txt");
//        try {
//            String dictFilePath = dictPath.getFile().getAbsolutePath();
//            Wordladder ladder = new Wordladder(dictFilePath);
//            worldLadder = ladder.genLadder(word1, word2);
//        }
//        catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//        model.addAttribute("ladder", worldLadder.toString());
//        return "index";
//    }

}
