package com.sunrise.design.patterns.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// Reflection can be used to destroy singleton classes by making the constructor accessible
public class DestroySingletonReflection {
    public static void main(String[] args) {
        try {
            WeakSingleton instance1 = WeakSingleton.getInstance();
            WeakSingleton instance2 = null;
            Constructor[] constructors = WeakSingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                constructor.setAccessible(true);
                // invoking the constructor via reflection
                // in order to protect the singleton we must use ENUMS for instance
                // but ENUMs do not provide option for lazy initialization
                instance2 = (WeakSingleton) constructor.newInstance();
            }
            System.out.println(instance1); // separate hashes
            System.out.println(instance2);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


}

class WeakSingleton {
    private static WeakSingleton instance = new WeakSingleton();

    private WeakSingleton() {

    }

    public static WeakSingleton getInstance() {
        return instance;
    }
}
