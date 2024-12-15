package com.tp.tp2;

import org.junit.Assert;
import org.junit.Test;

import com.tp.tp1.PorteMonnaie;
import com.tp.tp1.SommeArgent;

public class PorteMonnaieTest {
    
    @Test
    public void testAjouterSomme() {
        PorteMonnaie pm = new PorteMonnaie();
        SommeArgent sa = new SommeArgent(12, "EURO");
        pm.ajouterSomme(sa);
        
        //Assert.assertNotNull(pm.contenu.);
    }
}
