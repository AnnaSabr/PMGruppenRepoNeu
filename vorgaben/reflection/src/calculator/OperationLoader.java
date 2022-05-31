package calculator;

import operations.AOperationForCalculatorUI;
import operations.IOperation;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class OperationLoader {

    /**
     * Loads the operation classes from a directory.
     *
     * @param directory the directory to search for operation classes
     * @return a map with the operations and their names, or an empty map if none were found
     */
    public static Map<String, IOperation> loadOperations(File directory) {

        HashMap<String, IOperation> operations = new HashMap<>();
        if(directory.isDirectory()){
            try {
                String cName;
                Class<?> c;
                URL[] ua = new URL[]{directory.toURI().toURL()};
                URLClassLoader ucl = URLClassLoader.newInstance(ua);
                for(File file : directory.listFiles()) {
                    cName = file.getName();
                    if(cName.endsWith("Operation.class")) {
                        cName = cName.replace(".class", "");
                        c = Class.forName(cName, true, ucl);
                        if(c.isAnnotationPresent(AOperationForCalculatorUI.class)) {                  
                            operations.put(c.getAnnotation(AOperationForCalculatorUI.class).value()
                                            , (IOperation) c.getDeclaredConstructor().newInstance());
                        }
                    }
                }
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException | NoSuchMethodException | SecurityException | ClassNotFoundException | MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return operations;

    }
}
