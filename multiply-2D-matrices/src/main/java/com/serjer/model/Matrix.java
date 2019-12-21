package com.serjer.model;
import java.util.concurrent.Callable;

public class Matrix implements Callable<Integer> {
	

    private int a[][];
    private int b[][];
    private int cell;
    private int i;
    private int j;


    public Matrix(int a[][], int b[][], int i , int j ) {
            this.a = a;
            this.b = b;
            this.i = i;
            this.j = j;
     }

	@Override
	public Integer call() throws Exception {
		 for (int k = 0; k < a[0].length; k++)
             cell += a[i][k] * b[k][j];
         return cell;
	}

}