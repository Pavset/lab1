package lab1;

import java.util.Random;

public class MatrixUtils {

    private final long[][] data;
    private final int rows;
    private final int cols;

    public MatrixUtils(long[][] data) {
        if (data == null || data.length == 0 || data[0].length == 0) {
            throw new IllegalArgumentException("Matrix cannot be null or empty.");
        }

        this.rows = data.length;
        this.cols = data[0].length;
        this.data = new long[rows][cols];

        for (int i = 0; i < rows; i++) {
            if (data[i] == null) {
                throw new IllegalArgumentException("Matrix row cannot be null.");
            }
            if (data[i].length != cols) {
                throw new IllegalArgumentException("Matrix must be rectangular (all rows must have the same length).");
            }
            System.arraycopy(data[i], 0, this.data[i], 0, cols);
        }
    }

    public static MatrixUtils random(int rows, int cols, long min, long max) {
        if (min > max) {
            throw new IllegalArgumentException("Minimum value cannot be greater than maximum value.");
        }
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Matrix dimensions must be greater than zero.");
        }

        Random random = new Random();
        long[][] randomData = new long[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                randomData[i][j] = min + (Math.abs(random.nextLong()) % (max - min + 1));
            }
        }
        return new MatrixUtils(randomData);
    }

    public MatrixUtils transpose() {
        long[][] transposedData = new long[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedData[j][i] = this.data[i][j];
            }
        }
        return new MatrixUtils(transposedData);
    }

    public long calculateSpecialSum() {
        long totalSum = 0;

        for (int j = 0; j < cols; j++) {
            if (j % 2 == 0) {
                long max = data[0][j];
                for (int i = 1; i < rows; i++) {
                    if (data[i][j] > max) {
                        max = data[i][j];
                    }
                }
                totalSum += max;
            } else {
                long min = data[0][j];
                for (int i = 1; i < rows; i++) {
                    if (data[i][j] < min) {
                        min = data[i][j];
                    }
                }
                totalSum += min;
            }
        }
        return totalSum;
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%5d ", data[i][j]);
            }
            System.out.println();
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public long get(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        return data[row][col];
    }
}