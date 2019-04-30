package com.retell.wordladder;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
//import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.retell.wordladder.controller.WordladderController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= WordLadderApplication.class)
@ContextConfiguration(classes = WordladderController.class)
public class WordLadderAdminAPItests {
    protected MockMvc mockMvc;
    private MockHttpSession session;
//    @Autowired
//    private FilterChainProxy springSecurityFilterChain;

    @Autowired
    protected WebApplicationContext wac;
//    @Before
//    public void before() throws Exception {
//        MockitoAnnotations.initMocks(this);
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).addFilters(this.springSecurityFilterChain).build();
//        MvcResult result = mockMvc.perform(
//                MockMvcRequestBuilders.post("/login").content("username=admin&password=654321")
//                        .header("Content-Type", "application/x-www-form-urlencoded")
//        ).andReturn();
//        session = (MockHttpSession)result.getRequest().getSession();
//    }

    @Test
    public void testActuator() throws Exception{
        mockMvc.perform(get("/monitor/health").session(session))
                .andExpect(status().isOk());

        mockMvc.perform(get("/monitor/info").session(session))
                .andExpect(status().isOk());

        mockMvc.perform(get("/monitor/beans").session(session))
                .andExpect(status().isOk());


        mockMvc.perform(get("/monitor/mappings").session(session))
                .andExpect(status().isOk());

        mockMvc.perform(post("/monitor/shutdown").session(session))
                .andExpect(status().isOk());
    }
}

