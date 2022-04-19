import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;


/**
*   Ein Formatter, welcher den Text im CSV-Format ausgibt.
 */
public class FormatterZwei extends SimpleFormatter {

    @Override
    public String format(LogRecord record) {
        return record.getLoggerName() + "," + record.getLevel() +
            "," + record.getSourceClassName() + "," + record.getSourceMethodName() +
            "," + record.getMessage() + ",";
    }
}
