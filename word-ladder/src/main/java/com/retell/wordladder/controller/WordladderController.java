package com.retell.wordladder.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import com.retell.wordladder.Wordladder;

@RestController
public class WordladderController {
    @RequestMapping(value="/",method= RequestMethod.GET)
    public ResponseEntity<String> outputWordLadder(){
        String hello="hello wordladder";
        ClassPathResource dictFilePath = new ClassPathResource("static/small.json");
//        File dictFile = dictFilePath.getFile();

//        if (dictFile.isFile() && dictFile.exists()) {
////            InputStreamReader dictRead = new InputStreamReader(new FileInputStream(dictFile), "utf-8");
//            System.out.println("good");
//            hello = "hello wordladder good";
//        }
//        else {
//            System.out.println("ohmy");
//            hello = "hello wordladder bad";
//        }tFile.isFile() && dictFile.exists()) {
////            InputStreamReader dictRead = new InputStreamReader(new FileInputStream(dictFile), "utf-8");
//            System.out.println("good");
//            hello = "hello wordladder good";
//        }
//        else {
//            System.out.println("ohmy");
//            hello = "hello wordladder bad";
//        }

        return new ResponseEntity<String>(hello, HttpStatus.OK);
    }
}
