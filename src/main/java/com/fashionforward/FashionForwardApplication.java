

package com.fashionforward; // Ensure this package matches your structure

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.fashionforward") // Ensures all sub-packages are scanned
public class FashionForwardApplication {
    public static void main(String[] args) {
        SpringApplication.run(FashionForwardApplication.class, args);
    }
}
