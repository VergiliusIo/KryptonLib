package kryptonlib.abstraction;

import java.util.Arrays;

/**
 * Created by USER1 on 09.05.2017.
 */
public class Matrix {
    public char[][] matrix;
    private int m, n; //size of matrix MxN

    public Matrix(int m, int n) {
    	this.m = m; 
    	this.n = n;
        this.matrix = new char[m][n];
    }

    public Matrix(char[][] matrix, int m, int n) {
        processArguments(matrix, m, n);
        this.m = m; 
        this.n = n;
        this.matrix = new char[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                this.matrix[i][j] = matrix[i][j];
    }
    
    public String toString(Object o) {
    	return Arrays.deepToString(matrix);
    }

    private void processArguments(char[][] matrixString, int m, int n) {
        if (matrixString == null)
            throw new IllegalArgumentException("data");
        if (m <= 0 || n <= 0)
            throw new IllegalArgumentException("data");
        if (m > Integer.MAX_VALUE || n > Integer.MAX_VALUE)
            throw new IllegalArgumentException("data");
    }
    
    public Coordinate getCoordinate(char letter) {
    	//int x = 0, y = 0;
        for (int y = 0; y < this.m; y++) 
            for (int x = 0; x < this.n; x++) 
                if (matrix[y][x] == letter) 
                    return new Coordinate(x, y);
        throw new IllegalArgumentException("data");
    }

    public class Coordinate {
        private int x, y;

        private Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() { return x; }

        public int getY() { return y; }
    }
 
}


