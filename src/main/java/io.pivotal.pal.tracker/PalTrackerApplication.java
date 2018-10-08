package io.pivotal.pal.tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PalTrackerApplication {

    private static Logger logger = LoggerFactory.getLogger(PalTrackerApplication.class);
    public static void main(String[] args) {
        logger.info("I am inside the main class");
        SpringApplication.run(PalTrackerApplication.class, args);

    }
}
