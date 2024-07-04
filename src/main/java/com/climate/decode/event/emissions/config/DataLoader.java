package com.climate.decode.event.emissions.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.climate.decode.event.emissions.dashboard.service.PreloadService;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private PreloadService preloadService;

    @Override
    public void run(String... args) throws Exception {
        preloadService.preloadData();
    }
}
