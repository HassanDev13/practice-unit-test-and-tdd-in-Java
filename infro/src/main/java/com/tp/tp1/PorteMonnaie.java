package com.tp.tp1;

import java.util.HashMap;

public class PorteMonnaie {
    HashMap<String, Integer> contenu;

    public HashMap<String, Integer> getContenu() {
        return contenu;
    }

    public PorteMonnaie() {
        contenu = new HashMap<String, Integer>();
    }

    public void ajouterSomme(SommeArgent sa) {
        contenu.put(sa.getUnite(), sa.getQuantite());
    }
}
