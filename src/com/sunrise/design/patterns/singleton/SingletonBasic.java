package com.sunrise.design.patterns.singleton;

// Eager initialization
// Instance created even when not needed
public class SingletonBasic {

    public static void main(String[] args) {
        SingletonOne singletonOne = SingletonOne.getInstance();
        SingletonOne singletonTwo = SingletonOne.getInstance();
        System.out.println(singletonOne); // both will print same hash value
        System.out.println(singletonTwo);
    }


}

class SingletonOne {
    private static SingletonOne instance = new SingletonOne();

    private SingletonOne() {}

    public static SingletonOne getInstance() {
        return instance;
    }
}