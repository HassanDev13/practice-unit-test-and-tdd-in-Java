package com.tp.tp4;

public class Foo {

    public static int foo(int[] inputs) {
        int x = 0; // Node 2: Initialization

        int index = 0;
        int y = inputs[index]; // 50

        // Node 4: While loop condition
        while (y > 100) {
            // Node 5: Inside while loop
            x = x + y; // 0+50

            // Node 6: Input y again
            if (index + 1 < inputs.length) {
                y = inputs[++index]; // Increment index first to move to next input
            } else {
                // Stop processing if no more inputs
                break;
            }
        }

        // Node 7: If condition
        if (y < 200) {
            // Node 8: Print x
            return x;
        } else {
            // Node 9: Print y
            return y;
        }
    }
}
