package com.disaster.relief;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.awt.Desktop;
import java.net.URI;

@SpringBootApplication
public class DisasterReliefApplication {

    public static void main(String[] args) {
        // Prevents AWT headless exception on desktop platforms
        System.setProperty("java.awt.headless", "false");
        SpringApplication.run(DisasterReliefApplication.class, args);
    }

    // Listens for the ApplicationReadyEvent (triggered when server startup completes)
    @EventListener(ApplicationReadyEvent.class)
    public void openBrowserOnStartup() {
        String url = "http://localhost:8080/";
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Fallback for OS platforms where Java Desktop API is not available
            Runtime runtime = Runtime.getRuntime();
            try {
                String os = System.getProperty("os.name").toLowerCase();
                if (os.contains("win")) {
                    runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
                } else if (os.contains("mac")) {
                    runtime.exec("open " + url);
                } else if (os.contains("nix") || os.contains("nux")) {
                    runtime.exec("xdg-open " + url);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}