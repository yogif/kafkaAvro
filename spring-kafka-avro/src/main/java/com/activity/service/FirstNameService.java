package com.activity.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FirstNameService {

    public void callService(String name) {
        if (name.equals("*")) {
            log.info("FirstNameService All : ");
        } else {
            // get access token
            if (name.equalsIgnoreCase("Basant")) {
                log.info("FirstNameService Basant : ");
            } else if (name.equalsIgnoreCase("James")) {
                log.info("FirstNameService James : ");
            } else if (name.equalsIgnoreCase("Kent")) {
                log.info("FirstNameService Kent : ");
            } else {
                throw new IllegalArgumentException("Invalid name: [" + name + "]");
            }
        }
    }


}
