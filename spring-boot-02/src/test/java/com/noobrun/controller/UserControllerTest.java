package com.noobrun.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by lenovo on 2017/3/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void sayHello() throws Exception {

    }

    @Test
    public void userList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void addUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users").param("name","张三").param("age","11").param("address","广东深圳")).andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void findUser() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/user/402881355acc108b015acc1090f00000")).andExpect(MockMvcResultMatchers.status().isOk());
    }

}