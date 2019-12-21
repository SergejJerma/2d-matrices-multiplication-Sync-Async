package com.serjer.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.serjer.model.Matrix;

@Service
public class MatrixService {

	@Autowired
	@Qualifier("fixedThreadPool")
	private ExecutorService executor;

	public int[][] generateMatrix(int size) {
		int[][] matrix = new int[size][size];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = (int) (Math.random() * 10);
			}
		}
		return matrix;
	}

	public int[][] multiplyMatricesSync(int[][] a, int[][] b, int size) {

		final int[][] result = new int[size][size];

		for (int i = 0; i < a.length; ++i) {
			for (int j = 0; j < b[0].length; ++j) {
				for (int k = 0; k < a[0].length; ++k) {
					result[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		return result;
	}

	public int[][] multiplyMatricesAsync1(int[][] a, int[][] b, int size)
			throws InterruptedException, ExecutionException {
		
		final int[][] result = new int[size][size];

		Future<Integer> future[][] = new Future[size][size];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				future[i][j] = executor.submit(new Matrix(a, b, i, j));
			}
		}

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				result[i][j] = future[i][j].get();
			}
		}
		return result;
	}

	public int[][] multiplyMatricesAsync2(int[][] a, int[][] b, int size) 
			throws InterruptedException {
	
		final int[][] result = new int[size][size];

		for (int i = 0; i < a.length; ++i) {
			final int fi = i;
			executor.execute(() -> {
				for (int j = 0; j < b[0].length; ++j) {
					for (int k = 0; k < a[0].length; ++k) {
						result[fi][j] += a[fi][k] * b[k][j];
					}
				}
			});
		}
		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.DAYS);
		return result;
	}
}