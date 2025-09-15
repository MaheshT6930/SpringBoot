package org.example.abstraction;

abstract class PizzaMaker {


    final public void makePizza() {
        prepareDough();
        addToppings();
        bake();
        System.out.println("Pizza is ready");
    }

    public void prepareDough() {
        System.out.println("Dough is prpared");
    }

    abstract public void addToppings();

    abstract public void bake();

}

class VegPizza extends PizzaMaker{

    @Override
    public void addToppings() {
        System.out.println("veg toppings are addeed...!!1");

    }

    @Override
    public void bake() {
        System.out.println("Baking at 180c");
    }

}

class MeatPizza extends PizzaMaker {
    @Override
    public void addToppings() {
        System.out.println("Adding meat topping");
    }

    @Override
    public void bake() {
        System.out.println("Baking Meat Pizza at 200°C");
    }
}

class CheeseBurstPizza extends PizzaMaker {
    @Override
    public void addToppings() {
        System.out.println("Adding extra cheese burst toppings");
    }

    @Override
    public void bake() {
        System.out.println("Baking Cheese Burst Pizza at 190°C");
    }
}


