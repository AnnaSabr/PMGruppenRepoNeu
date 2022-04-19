import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

/**
*   Ein Formatter, welcher den Text im Format:
*   ------------
*   Logger: record.getLoggerName()
*   Level: record.getLevel()
*   Class: record.getSourceClassName()
*   Method: record.getSourceMethodName()
*   Message: record.getMessage()
*   ------------
 */
class FormatterEins extends SimpleFormatter {

    @Override
    public String format(LogRecord record) {
        return "------------\nLogger: " + record.getLoggerName() + "\nLevels: " + record.getLevel() +
            "\nClass: " + record.getSourceClassName() + "\nMethod: " + record.getSourceMethodName() +
            "Message: " + record.getMessage() + "------------\n";
    }
}
