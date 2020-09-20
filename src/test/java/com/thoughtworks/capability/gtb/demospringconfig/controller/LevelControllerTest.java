package com.thoughtworks.capability.gtb.demospringconfig.controller;


import com.thoughtworks.capability.gtb.demospringconfig.LevelController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class LevelControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  private LevelController levelController;

  @Test
  void should_return_basic_when_get_level_given_level_less_than_1() throws Exception {
    levelController.setLevelNumber(0);
    mockMvc.perform(get("/level"))
            .andExpect(jsonPath("$", is("basic")));
  }

  @Test
  void should_return_basic_when_get_level_given_level_equals_1() throws Exception {
    levelController.setLevelNumber(1);
    mockMvc.perform(get("/level"))
            .andExpect(jsonPath("$", is("advanced")));
  }

  @Test
  void should_return_advanced_when_get_level_given_level_greater_than_1() throws Exception {
    levelController.setLevelNumber(2);
    mockMvc.perform(get("/level"))
            .andExpect(jsonPath("$", is("advanced")));
  }


}
