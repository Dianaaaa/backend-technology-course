package com.retell.login;


import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.element.NestingKind;

@CrossOrigin(origins = "http://0.0.0.0:3000")
@RestController
public class LoginController {

    @Autowired
    AskService service;

    @RequestMapping(value="/ask/{word1}/{word2}", method= RequestMethod.GET)
    @ResponseBody
    public JSONObject ask(@PathVariable String word1, @PathVariable String word2) {
        JSONObject result = service.askWordLadder(word1, word2);
        return result;
    }

    @RequestMapping(value="/msg", method= RequestMethod.GET)
    public JSONObject msg() {
        JSONObject result = new JSONObject();
        result.put("msg","msg");
        return result;
    }
}
