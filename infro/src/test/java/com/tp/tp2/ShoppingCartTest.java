package com.tp.tp2;

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.rules.ExpectedException;

public class ShoppingCartTest {

    private ShoppingCart cart;
    private Product product1;
    private Product product2;

    @SuppressWarnings("deprecation")
    @Rule
    public ExpectedException thrown = ExpectedException.none();

   
    @Before
    public void start() {
        cart = new ShoppingCart();
        product1 = new Product("Laptop", 50000);
        product2 = new Product("Phone", 40000);
    }

    @After
    public void clear() {
        cart.empty(); 
    }
    // 0 - Une fois cr´e´e, le panier contient 0 articles.
    @Test
    public void testInitialCartEmpty() {
        assertEquals("Cart should initially be empty", 0, cart.getItemCount());
        assertEquals("Initial balance should be zero", 0.00, cart.getBalance(), 0.01);
    }
    // 1 - Lorsqu’il est vide, le panier contient 0 articles.
    @Test
    public void testEmptyCart() {
        cart.addItem(product1);
        cart.addItem(product2);
        
        cart.empty();
        assertEquals("Cart should be empty after calling empty", 0, cart.getItemCount());
        assertEquals("Balance should be zero after emptying the cart", 0.00, cart.getBalance(), 0.01);
    }

    // 2 - Lorsqu’un nouveau produit est ajout´e, le nombre d’articles doit ˆetre incr´ement´
    @Test
    public void testAddItemIncrementsItemCount() {
        cart.addItem(product1);
        assertEquals("Cart should contain 1 item after adding a product", 1, cart.getItemCount());
    }

    // 3 - Lorsqu’un nouveau produit est ajout´e, le nouveau solde doit ˆetre la somme
    // des soldes pr´ec´edent plus le coˆut du nouveau produit.
    @Test
    public void testAddItemUpdatesBalance() {
        cart.addItem(product1);
        assertEquals("Balance should equal the price of the added product", 50000, cart.getBalance(), 0.01);
        
        cart.addItem(product2);
        assertEquals("Balance should be the sum of prices of added products", 90000, cart.getBalance(), 0.01);
    }

    // 4 - Lorsqu’un ´el´ement est supprim´e, le nombre d’´el´ements doit ˆetre r´eduit.
    @Test
    public void testRemoveItemDecrementsItemCount() throws ProductNotFoundException {
        cart.addItem(product1);
        cart.addItem(product2);
        
        cart.removeItem(product1);
        assertEquals("Cart should contain 1 item after removing one", 1, cart.getItemCount());
    }

    // 5 - Lorsqu’un produit qui n’est pas dans le panier est retir´e, un ProductNotFoundException doit ˆetre lev´e.
    @Test
    public void testRemoveNonExistentItemThrowsException() throws ProductNotFoundException {
        thrown.expect(ProductNotFoundException.class);        
        cart.removeItem(product1);
    }

   
}
