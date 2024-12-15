package com.tp.tp1;

public class SommeArgent {
    private int quantite;
    private String unite;

    public static String get() {
        return "Hello JUnit 5";
    }

    public SommeArgent(int amount, String currency) {
        quantite = amount;
        unite = currency;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getUnite() {
        return unite;
    }

    public SommeArgent add(SommeArgent m) {
        return new SommeArgent(getQuantite() + m.getQuantite(), getUnite());
    }

    @Override
    public boolean equals(Object obj) {
      
        if(obj instanceof SommeArgent) {
            SommeArgent m = (SommeArgent) obj;
            return getQuantite() == m.getQuantite() && getUnite().equals(m.getUnite());
        };
        return false;
       
    }
    
}
