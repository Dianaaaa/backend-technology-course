package com.retell.login;

import com.fasterxml.jackson.annotation.JsonAlias;
import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AskService {

    public JSONObject askWordLadder(String word1, String word2)

    {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "http://wordladder:8080/word-ladder/"+word1+"/"+word2;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        JSONObject strbody = restTemplate.exchange(uri, HttpMethod.GET, entity, JSONObject.class).getBody();
        return strbody;
    }
}
