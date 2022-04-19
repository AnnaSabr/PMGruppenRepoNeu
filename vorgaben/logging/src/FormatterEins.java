import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

class FormatterEins extends SimpleFormatter {

    @Override
    public String format(LogRecord record) {
        return "------------\nLogger: " + record.getLoggerName() + "\nLevels: " + record.getLevel() +
            "\nClass: " + record.getSourceClassName() + "\nMethod: " + record.getSourceMethodName() +
            "Message: " + record.getMessage() + "------------\n";
    }
}
