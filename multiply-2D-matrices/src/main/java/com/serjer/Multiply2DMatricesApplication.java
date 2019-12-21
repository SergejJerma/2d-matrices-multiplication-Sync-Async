package com.serjer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Multiply2DMatricesApplication {

	public static void main(String[] args) {
		SpringApplication.run(Multiply2DMatricesApplication.class, args);
	}
	
	@Bean("fixedThreadPool")
    public ExecutorService fixedThreadPool() {
        return Executors.newFixedThreadPool(8);
    }

}
