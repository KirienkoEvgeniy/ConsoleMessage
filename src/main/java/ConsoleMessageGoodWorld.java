import org.apache.log4j.Logger;
import java.text.ParseException;
import java.util.ResourceBundle;

/**
 * Created by Evgeniy
 */
public class ConsoleMessageGoodWorld {
    private static final Logger log = Logger.getLogger(ConsoleMessageGoodWorld.class);

    public static void main(String[] args) {
        String event = null;
        try {
            ConsoleMessageGoodWorldWorker consoleMessageGoodWorldWorker = new ConsoleMessageGoodWorldWorker();
            event = consoleMessageGoodWorldWorker.getTime();
            ResourceBundle resourceBundle = ResourceBundle.getBundle("bundle", consoleMessageGoodWorldWorker.getLocale());
            System.out.println(resourceBundle.getString(event));
        } catch (ParseException e) {
            log.error("Parse error", e);
        }
    }
}
