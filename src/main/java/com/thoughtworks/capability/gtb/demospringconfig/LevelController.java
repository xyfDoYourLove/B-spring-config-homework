package com.thoughtworks.capability.gtb.demospringconfig;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Objects;

@RestController
public class LevelController {

    private Environment env;

    public LevelController(Environment env) {
        this.env = env;
    }

    @GetMapping("/level")
    public String getLevel() {
        int levelNumber = Integer.parseInt(Objects.requireNonNull(env.getProperty("levelNumber")));
        return levelNumber < 1 ? "basic" : "advanced";
    }
}
