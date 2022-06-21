package desktop;

import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

/**
 * formatiert die logger Nachrichten um nur den Inhalt auszugeben
 */
public class DialogFormatter extends SimpleFormatter {

    @Override
    public String format(LogRecord record){
        return record.getMessage();
    }
}
