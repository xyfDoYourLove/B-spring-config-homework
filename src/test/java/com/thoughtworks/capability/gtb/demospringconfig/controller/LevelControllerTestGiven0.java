package com.thoughtworks.capability.gtb.demospringconfig.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(properties = {"levelNumber=0"})
@AutoConfigureMockMvc
class LevelControllerTestGiven0 {

  @Autowired
  MockMvc mockMvc;

  @Test
  void should_return_basic_when_get_level_given_level_less_than_1() throws Exception {
    mockMvc.perform(get("/level"))
            .andExpect(jsonPath("$", is("basic")));
  }

}
