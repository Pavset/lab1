package lab1;

public class Matrix {

    private static final int ROWS = 4;
    private static final int COLS = 4;
    private static final long RAND_MIN = 0L;
    private static final long RAND_MAX = 50L;

    public static void main(String[] args) {
        try {
            System.out.println("Generating random matrix B...");
            MatrixUtils matrixB = MatrixUtils.random(ROWS, COLS, RAND_MIN, RAND_MAX);

            System.out.println("Matrix B:");
            matrixB.print();

            MatrixUtils matrixC = matrixB.transpose();

            System.out.println("\nMatrix C (Transposed B):");
            matrixC.print();

            long specialSum = matrixC.calculateSpecialSum();
            System.out.println("\nResult of the second operation:");
            System.out.println("Sum of max in even columns and min in odd columns of matrix C = " + specialSum);

        } catch (IllegalArgumentException e) {
            System.err.println("Data validation error: " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Array index out of bounds error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error occurred during execution: " + e.getMessage());
        }
    }
}