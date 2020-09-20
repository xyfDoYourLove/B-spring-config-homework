package com.thoughtworks.capability.gtb.demospringconfig.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class LevelControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  private ConfigurableEnvironment configEnv;

  @Test
  void should_return_basic_when_get_level_given_level_less_than_1() throws Exception {
    MutablePropertySources propertySources = configEnv.getPropertySources();
    Map<String, Object> map = Collections.singletonMap("levelNumber", 0);
    propertySources.addFirst(new MapPropertySource("new", map));
    mockMvc.perform(get("/level"))
            .andExpect(jsonPath("$", is("basic")));
  }

  @Test
  void should_return_basic_when_get_level_given_level_equals_1() throws Exception {
    MutablePropertySources propertySources = configEnv.getPropertySources();
    Map<String, Object> map = Collections.singletonMap("levelNumber", 0);
    propertySources.addFirst(new MapPropertySource("new", map));
    mockMvc.perform(get("/level"))
            .andExpect(jsonPath("$", is("advanced")));
  }

  @Test
  void should_return_advanced_when_get_level_given_level_greater_than_1() throws Exception {
    MutablePropertySources propertySources = configEnv.getPropertySources();
    Map<String, Object> map = Collections.singletonMap("levelNumber", 0);
    propertySources.addFirst(new MapPropertySource("new", map));
    mockMvc.perform(get("/level"))
            .andExpect(jsonPath("$", is("advanced")));
  }


}
