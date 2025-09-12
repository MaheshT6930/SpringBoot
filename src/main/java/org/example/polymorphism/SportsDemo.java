package org.example.polymorphism;

public class SportsDemo {
    public static void main(String[] args) {
        Sports sport1 = new Scoccer();
        Sports sport2 = new Cricket();
        Sports sport3 = new Basketball();

        System.out.println(sport1.getRules());
        System.out.println(sport1.play());
        System.out.println(sport2.getRules());
        System.out.println(sport2.play());
        System.out.println(sport3.getRules());
        System.out.println(sport3.play());
    }
}
