import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionDemo {

    public static void main(String[] args) {

        try {

            // Load class dynamically
            Class<?> cls = Class.forName("Student");

            System.out.println("Class Name: " + cls.getName());

            // Print all methods
            Method[] methods = cls.getDeclaredMethods();

            System.out.println("\nMethods:");

            for (Method method : methods) {

                System.out.println("Method Name: "
                        + method.getName());

                Parameter[] params =
                        method.getParameters();

                for (Parameter p : params) {
                    System.out.println("Parameter Type: "
                            + p.getType().getSimpleName());
                }
            }

            // Create object dynamically
            Object obj =
                    cls.getDeclaredConstructor()
                       .newInstance();

            // Invoke display()
            Method displayMethod =
                    cls.getMethod("display");

            displayMethod.invoke(obj);

            // Invoke greet(String)
            Method greetMethod =
                    cls.getMethod(
                            "greet",
                            String.class);

            greetMethod.invoke(obj, "Pranavi");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}