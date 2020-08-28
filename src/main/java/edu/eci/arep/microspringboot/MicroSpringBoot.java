package edu.eci.arep.microspringboot;
import edu.eci.arep.microspringboot.annotations.RequestMapping;
import edu.eci.arep.microspringboot.httpserver.HttpServer;



import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Hello world!
 */
public class MicroSpringBoot {
    public static void main(String[] args) throws IOException {
        //DBConnection db = new DBConnection();
        HttpServer serv = new HttpServer();
        serv.start();

        int passed = 0, failed = 0;
        //Cargo la calse a partir del argumento y obtengo los metodos, con eso voy a iterar metodo or metodo
        try {
            for (Method m : Class.forName(args[0]).getMethods()) {
                // Si ese metodo tiene la anotacion del tipo de RequestMapping (@Interface)
                if (m.isAnnotationPresent(RequestMapping.class)) {
                    // Voy a tomar el valor de lo que se paso entre los parentesis del requestMapping Ej @RequestMapping("/test")
                    RequestMapping annotation = m.getAnnotation(RequestMapping.class);
                    String val = annotation.value();

                    sparkD.get(val, ((request, response) -> {
                        try {
                            return m.invoke(null).toString();
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                        return "Something Went wrong :O";
                    }));
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
