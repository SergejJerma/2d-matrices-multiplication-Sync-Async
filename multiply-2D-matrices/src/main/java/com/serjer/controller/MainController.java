package com.serjer.controller;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.serjer.service.MatrixService;



@Controller
public class MainController {
	
	@Autowired
	private MatrixService matrixService;
	
	@GetMapping("/")
	public String main(Model model) {
	
	return "input";
	}
	
	@PostMapping("/")
	public String inputText(Model model, @RequestParam int size) throws InterruptedException, ExecutionException {
		model.addAttribute("size", size);
		String message;
	 	int[][] a = matrixService.generateMatrix(size);
	 	int[][] b = matrixService.generateMatrix(size);
	 	
	 	
		long startTime = System.currentTimeMillis();
		int [][] mSync = matrixService.multiplyMatricesSync(a, b, size);
		long estimatedTime = System.currentTimeMillis() - startTime;
		model.addAttribute("time", estimatedTime);
			
		long startTime1 = System.currentTimeMillis();
		int [][] mAsync1 = matrixService.multiplyMatricesAsync1(a, b, size);
		long estimatedTime1 = System.currentTimeMillis() - startTime1;
		model.addAttribute("time1", estimatedTime1);
		
		long startTime2 = System.currentTimeMillis();
		int [][] mAsync2 = matrixService.multiplyMatricesAsync2(a, b, size);
		long estimatedTime2 = System.currentTimeMillis() - startTime2;
		model.addAttribute("time2", estimatedTime2);
		
		if (Arrays.deepEquals(mSync, mAsync1) && Arrays.deepEquals(mSync, mAsync2)) message = "SYNC and ASYNC1/ASYNC2 matrices are equals";
		else message = "!error! SYNC and ASYNC1/ASYNC2 matrices aren't equals!";
		model.addAttribute("message", message);
		
	return "input";
	}
}