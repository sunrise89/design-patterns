package com.sunrise.design.patterns.singleton;

// Lazy initialization
// Instance created when needed
// Thread Safe
public class SingletonLazyInitializationThreadSafeDoubleCheck {

    public static void main(String[] args) {
        // Thread Safety check
        new Thread(() -> {
            SingletonLazyDoubleCheck singletonThree = SingletonLazyDoubleCheck.getInstance();
            System.out.println(singletonThree); // Will initialize a different instance
        }).start();
        new Thread(() -> {
            SingletonLazyDoubleCheck singletonFour = SingletonLazyDoubleCheck.getInstance();
            System.out.println(singletonFour); // Will initialize a different instance
        }).start();
    }


}

class SingletonLazyDoubleCheck {
    private static SingletonLazyDoubleCheck instance ;

    private SingletonLazyDoubleCheck() {
        try {
            System.out.println("Initializing Singleton");
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SingletonLazyDoubleCheck getInstance() {
        if (null == instance) {
            synchronized (SingletonLazyDoubleCheck.class) {
                // If we do not apply double check and constructor takes time to initialize
                // other threads might again do the initialization
                if (null == instance) {
                    instance = new SingletonLazyDoubleCheck();
                }
            }
        }
        return instance;
    }
}