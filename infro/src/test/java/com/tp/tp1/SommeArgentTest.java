package com.tp.tp1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;

@RunWith(JUnit4.class)
public class SommeArgentTest {

    @Test
    public void testGet() {
        System.out.println("Running testGet...");
        assertEquals("Hello JUnit 5", SommeArgent.get());
    }

    @Test
    public void equals() {
        System.out.println("Running equals test...");
        SommeArgent m1 = new SommeArgent(12, "DINARS");
        SommeArgent m2 = new SommeArgent(14, "DINARS");
        SommeArgent expected = new SommeArgent(26, "DINARS");
        SommeArgent result = m1.add(m2); // (2)
        System.out.println("Expected: " + expected.getQuantite() + ", Result: " + result.getQuantite());
        Assert.assertTrue(expected.equals(result));
    }

    @Test
    public void testEquals(){
        SommeArgent m1 = new SommeArgent(12, "DINARS");
        SommeArgent m2 = new SommeArgent(14, "DINARS");
        SommeArgent m3 = new SommeArgent(14, "EURO");


        Assert.assertNotNull(m1);
        Assert.assertEquals(m1, m1);
        Assert.assertEquals(m1, new SommeArgent(12, "DINARS")); // (1)
        Assert.assertTrue(!m1.equals(m2));
        Assert.assertTrue(!m3.equals(m2));
    }
}
