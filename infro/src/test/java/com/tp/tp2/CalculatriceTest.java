package com.tp.tp2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;
import org.junit.rules.ExpectedException;

public class CalculatriceTest {

    @SuppressWarnings("deprecation")
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Calculatrice calculatrice;

    @Before
    public void setUp() {
        calculatrice = new Calculatrice();
        System.out.println("Début d'un test...");
    }

    @After
    public void tearDown() {
        System.out.println("Fin du test.\n");
    }

    @Test
    public void testRacinesCarrees() {
        double[] racines = calculatrice.racinesCarrees(1, 4);
        assertEquals(4, racines.length); // 1, 2, 3, 4 => 4 numbers
        assertEquals(1.0, racines[0], 0.001); // sqrt(1) = 1
        assertEquals(Math.sqrt(4), racines[3], 0.001); // sqrt(4) = 2
    }

    @Test
    public void testGenerateMatrix() {
        int M = 3, N = 3, A = 1, B = 5;
        int[][] matrix = calculatrice.generateMatrix(M, N, A, B);
        assertEquals(M, matrix.length);
        assertEquals(N, matrix[0].length);

        for (int[] row : matrix) {
            for (int value : row) {
                assertTrue("Value should be between A and B", value >= A && value <= B);
            }
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRacinesCarreesException() {
        calculatrice.racinesCarrees(5, 3);
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testGenerateMatrixException1() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(JUnitMatchers.containsString("M et N doivent être supérieurs à 0"));
        calculatrice.generateMatrix(-5, 3, 1, 3);
    }

    @SuppressWarnings("deprecation")
    @Test
    public void testGenerateMatrixException2() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(JUnitMatchers.containsString("A doit être inférieur à B"));
        calculatrice.generateMatrix(3, 3, 5, 3);
    }
}
