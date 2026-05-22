package lab1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MatrixUtilsTest {

    @Test
    void constructor_validData_storesCorrectDimensions() {
        long[][] data = {{1L, 2L}, {3L, 4L}};
        MatrixUtils m = new MatrixUtils(data);

        assertEquals(2, m.getRows());
        assertEquals(2, m.getCols());
    }

    @Test
    void constructor_validData_storesCorrectValues() {
        long[][] data = {{5L, 10L}, {15L, 20L}};
        MatrixUtils m = new MatrixUtils(data);

        assertEquals(5L, m.get(0, 0));
        assertEquals(10L, m.get(0, 1));
        assertEquals(15L, m.get(1, 0));
        assertEquals(20L, m.get(1, 1));
    }

    @Test
    void constructor_mutatingOriginalArray_doesNotAffectMatrix() {
        long[][] data = {{1L, 2L}, {3L, 4L}};
        MatrixUtils m = new MatrixUtils(data);


        data[0][0] = 99L;


        assertEquals(1L, m.get(0, 0));
    }

    @Test
    void transpose_squareMatrix_isCorrect() {
        long[][] data = {
                {1L, 2L},
                {3L, 4L}
        };
        MatrixUtils m = new MatrixUtils(data);
        MatrixUtils t = m.transpose();

        assertEquals(1L, t.get(0, 0));
        assertEquals(3L, t.get(0, 1));
        assertEquals(2L, t.get(1, 0));
        assertEquals(4L, t.get(1, 1));
    }

    @Test
    void calculateSpecialSum_validMatrix_calculatesCorrectly() {

        long[][] data = {
                {5L, 8L, 3L},
                {7L, 2L, 9L},
                {1L, 6L, 4L}
        };
        MatrixUtils m = new MatrixUtils(data);

        assertEquals(18L, m.calculateSpecialSum());
    }
}