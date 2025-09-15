package org.example.abstraction;

public class PizzaTest {

    public static void main(String[] args) {
        PizzaMaker veg = new VegPizza();
        veg.makePizza();

        PizzaMaker meat = new MeatPizza();
        meat.makePizza();

        PizzaMaker cheese = new CheeseBurstPizza();
        cheese.makePizza();
    }
}
