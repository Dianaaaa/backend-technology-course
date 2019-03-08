package com.retell.wordladder;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Wordladder {
    @RequestMapping(value="/wordladder",method= RequestMethod.GET)
    public String outputWordLadder(){
        return "hello wordladder";
    }
}
