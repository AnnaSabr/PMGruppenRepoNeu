import java.io.File;
import java.io.IOException;
import java.io.ObjectInputFilter;
import java.util.logging.*;

public class Main {

    public static void main(String[] args) {
        Logger zwei = Logger.getLogger(Main.class.getName());
        //StreamHandler handlerB = new StreamHandler(new FileOutputStream(new File("log.csv"), true))
        ConsoleHandler handlerB = new ConsoleHandler();
        handlerB.setLevel(Level.ALL);
        handlerB.setFormatter(new FormatterZwei());
        zwei.addHandler(handlerB);
        zwei.setLevel(Level.FINEST);
        Ringbuffer buffer = new Ringbuffer(5);

        FileHandler fileH;

        try{
            fileH = new FileHandler("speicher.csv");
            fileH.setLevel(Level.WARNING);
            zwei.addHandler(fileH);
            fileH.setFormatter(new FormatterZwei());
        }
        catch(SecurityException a){
            zwei.warning(a.getMessage());
        }
        catch (IOException e){
            zwei.warning(e.getMessage());
        }

        try {
            buffer.remove();
        } catch (IllegalStateException stateException) {
            zwei.warning(stateException.getMessage());
        }
        buffer.add("First");
        zwei.finest("First element added succesfully");
        buffer.add("Second");
        zwei.finest("Second element added Succesfully");
        try {
            buffer.add("Third");
            zwei.finer("Third element added Succesfully");
        } catch (IllegalStateException stateException) {
            zwei.warning(stateException.getMessage());
        }
        String first = buffer.remove();
        zwei.info("The removed element is: %s"+ first);
    }
}
