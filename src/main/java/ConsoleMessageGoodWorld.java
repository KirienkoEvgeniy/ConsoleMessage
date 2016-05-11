import org.apache.log4j.Logger;

import java.text.ParseException;
import java.util.Locale;
import java.util.ResourceBundle;


/**
 * Created by Evgeniy
 */
public class ConsoleMessageGoodWorld {
    private static final Logger log = Logger.getLogger(ConsoleMessageGoodWorld.class);

    public static void main(String[] args) {
        Locale.getDefault();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("bundle");

        ConsoleMessageGoodWorldWorker consoleMessageGoodWorldWorker = ConsoleMessageGoodWorldWorker.newBuilder().build();

        String events = null;
        try {
            events = consoleMessageGoodWorldWorker.getTime();
            System.out.println(events);
        }catch (ParseException e){
            log.error("Parse error", e);
        }


        if (events != null){
            switch (events) {
                case "MORNING":
                    System.out.println(resourceBundle.getString("morning"));
                    log.info("Print morning message");
                    break;
                case "DAY":
                    System.out.println(resourceBundle.getString("day"));
                    log.info("Print day message");
                    break;
                case "EVENING":
                    System.out.println(resourceBundle.getString("evening"));
                    log.info("Print evening message");
                    break;
                case "NIGHT":
                    System.out.println(resourceBundle.getString("night"));
                    log.info("Print night message");
                    break;
            }
        }else log.warn("Events is null");

    }
}
