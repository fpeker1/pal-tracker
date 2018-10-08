package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class EnvController {

    public EnvController((@Value("${PORT:NOT SET}")String PORT, String s1, String s2, String s3) {

    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        return null;
    }
}
