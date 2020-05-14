package com.young;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sun.misc.Launcher;

import java.net.URL;

@SpringBootApplication
public class Run {

    public static void main(String[] args) {
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println(url);
        }
        SpringApplication.run(Run.class, args);
    }

}

