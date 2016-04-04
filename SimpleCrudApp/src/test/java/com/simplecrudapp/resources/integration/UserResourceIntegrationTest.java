package com.simplecrudapp.resources.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.simplecrudapp.config.SimpleCrudAppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SimpleCrudAppConfig.class})
@WebAppConfiguration
public class UserResourceIntegrationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    
    private MockMvc mockMvc;
 
    @Before
    public void initializate(){
    	mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    
    @Test
    public void shouldGetListAndStatus204() throws Exception {
    	mockMvc.perform(get("/user")).andExpect(status().is2xxSuccessful());
    }

    @Test
    public void shouldCreateUserAndStatus201Created() throws Exception {
    	mockMvc.perform(
    			post("/user/").contentType(MediaType.APPLICATION_JSON_UTF8).content("{\"name\":\"nameUser\"}")).andExpect(status().is(201));
    }

    @Test
    public void shouldCreateUserAndGetByIdAndReturnStatus200Ok() throws Exception {
    	mockMvc.perform(
    			post("/user/").contentType(MediaType.APPLICATION_JSON_UTF8).content("{\"name\":\"nameUser\"}")).andExpect(status().is(201));
    	mockMvc.perform(get("/user/2")).andExpect(status().isOk());
    }

    @Test
    public void shouldCreateUserAndUpdateAndReturnStatus200Ok() throws Exception {
    	mockMvc.perform(
    			post("/user/").contentType(MediaType.APPLICATION_JSON_UTF8).content("{\"name\":\"nameUser\"}")).andExpect(status().is(201));
    	mockMvc.perform(
    			put("/user/3").contentType(MediaType.APPLICATION_JSON_UTF8).content("{\"name\":\"nameUserNew\"}")).andExpect(status().isOk());
    }

    @Test
    public void shouldCreateUserAndDeleteReturnStatus200NoContent() throws Exception {
    	mockMvc.perform(
    			post("/user/").contentType(MediaType.APPLICATION_JSON_UTF8).content("{\"name\":\"nameUser\"}")).andExpect(status().is(201));
    	mockMvc.perform(
    			delete("/user/1").contentType(MediaType.APPLICATION_JSON_UTF8).content("{\"name\":\"nameUserNew\"}")).andExpect(status().is(204));
    }
}
