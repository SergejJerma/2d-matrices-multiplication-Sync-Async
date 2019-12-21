package com.serjer;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.serjer.service.MatrixService;


@SpringBootTest
class MatrixServiceTests {
	
	@Autowired
	private MatrixService matrixService;
	
	private static int [][] a = {{1,2,3},{4,5,6},{7,8,9}};
	private static int [][] b = {{1,2,3},{4,5,6},{7,8,9}};
	private static int [][] expected = {{30,36,42},{66,81,96},{102,126,150}};	
	private static int size = a.length;
	
	@Test
    public void testSyncMethod() {
		assertArrayEquals(expected, matrixService.multiplyMatricesSync(a, b, size));
    }
	
	@Test
    public void testAsync1Method() throws InterruptedException, ExecutionException {
		assertArrayEquals(expected, matrixService.multiplyMatricesAsync1(a, b, size));
    }
	
	@Test
    public void testAsync2Method() throws InterruptedException {
		assertArrayEquals(expected, matrixService.multiplyMatricesAsync2(a, b, size));
    }
	
	@Test
    public void testGenerateMethod() throws InterruptedException {
		assertEquals(size, matrixService.generateMatrix(size).length);
		assertEquals(size, matrixService.generateMatrix(size)[0].length);
    }
	
}
