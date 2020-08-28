package edu.eci.arep.microspringboot.testframework;

import java.lang.reflect.Method;

public class RunTests {

    public static void main(String[] args) throws Exception {

        int passed = 0, failed = 0;
        //Cargo la calse a partir del argumento y obtengo los metodos, con eso voy a iterar metodo or metodo
        for (Method m : Class.forName(args[0]).getMethods()) {
            // Si ese metodo tiene la anotacion del tipo de test (@Interface)
            if (m.isAnnotationPresent(Test.class)) {

                try {
                    //Invocar un metodo, como no le meto objeto es metodo es estático
                    m.invoke(null);
                    passed++;
                } catch (Throwable ex) {
                    System.out.printf("Test %s failed: %s %n", m, ex.getCause());
                    failed++;

                }}}
        //Decide cuantas pasan y cuantas pierde
        System.out.printf("Passed: %d, Failed %d%n", passed, failed);

    }}