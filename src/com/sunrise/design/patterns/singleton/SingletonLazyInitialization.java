package com.sunrise.design.patterns.singleton;

// Lazy initialization
// Instance created when needed
// Not thread Safe
public class SingletonLazyInitialization {

    public static void main(String[] args) {
        SingletonLazy singletonOne = SingletonLazy.getInstance();
        SingletonLazy singletonTwo = SingletonLazy.getInstance();
        System.out.println(singletonOne); // both will print same hash value
        System.out.println(singletonTwo);

        // Thread Safety check
        new Thread(() -> {
            SingletonLazy singletonThree = SingletonLazy.getInstance();
            System.out.println(singletonThree); // Will initialize a different instance
        }).start();
        new Thread(() -> {
            SingletonLazy singletonFour = SingletonLazy.getInstance();
            System.out.println(singletonFour); // Will initialize a different instance
        }).start();
    }


}

class SingletonLazy {
    private static SingletonLazy instance ;

    private SingletonLazy() {
        try {
            System.out.println("Initializing Singleton");
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SingletonLazy getInstance() {
        if (null == instance) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}