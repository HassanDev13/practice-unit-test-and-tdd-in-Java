package com.tp.tp4;

import static org.junit.Assert.assertEquals;
import org.junit.*;

public class FooTest {

    // Test Case 1: Basic Test with One Input (y = 50)
    @Test
    public void testCase1() {
        int[] inputs = { 50 };
        int result = Foo.foo(inputs);
        assertEquals(0, result); // Should return 0 since y is less than 100
    }

    // Test Case 2: Input Where y is Greater Than 100 but Less Than 200 (y = 150)
    @Test
    public void testCase2() {
        int[] inputs = { 150 };
        int result = Foo.foo(inputs);
        assertEquals(150, result); // Should return 150 as x is updated with y = 150
    }

    // Test Case 3: Input Where y is Greater Than 200 (y = 250)
    @org.junit.Test
    public void testCase3() {
        int[] inputs = { 250 };
        int result = Foo.foo(inputs);
        org.junit.Assert.assertEquals(250, result); // Should return 250 as y is greater than 200
    }

    @org.junit.Test
    public void testCase4() {
        int[] inputs = { 150, 50 };
        int result = Foo.foo(inputs);
        org.junit.Assert.assertEquals(150, result); // x becomes 150 after first iteration, then breaks loop
    }

    // Test Case 5: Input with a Sequence of Numbers Leading to the Break Condition
    // (y = 200, 50, 75)
    @org.junit.Test
    public void testCase5() {
        int[] inputs = { 200, 50, 75 };
        int result = Foo.foo(inputs);
        org.junit.Assert.assertEquals(200, result); // x becomes 200 after the first iteration, then returns 250
    }
}