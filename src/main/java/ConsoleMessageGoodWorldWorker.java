import org.apache.log4j.Logger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Evgeniy
 */
public class ConsoleMessageGoodWorldWorker {

    private static final Logger log = Logger.getLogger(ConsoleMessageGoodWorldWorker.class);
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

    private Date currentTime;
    private Date morning;
    private Date day;
    private Date evening;
    private Date night;
    private Date currentTimeDate;

    private Locale locale;

    public Locale getLocale() {
        return locale;
    }

    public ConsoleMessageGoodWorldWorker(){
        locale = Locale.getDefault();
        currentTimeDate = new Date();
    }

    public ConsoleMessageGoodWorldWorker(String event) throws ParseException{
        locale = Locale.getDefault();
        currentTimeDate = simpleDateFormat.parse(event);
    }

    public ConsoleMessageGoodWorldWorker(String event, Locale locale) throws ParseException{
        this.locale = locale;
        currentTimeDate = simpleDateFormat.parse(event);
    }

    public String getTime() throws ParseException{

        currentTime = simpleDateFormat.parse(simpleDateFormat.format(currentTimeDate));
        morning  = simpleDateFormat.parse(BorderCondition.MORNING.toString());
        day  = simpleDateFormat.parse(BorderCondition.DAY.toString());
        evening = simpleDateFormat.parse(BorderCondition.EVENING.toString());
        night = simpleDateFormat.parse(BorderCondition.NIGHT.toString());

        if(currentTime.after(morning) && currentTime.before(day)){
            log.info("Displays:  Good morning, World!");
            return "morning";
        }
        else if (currentTime.after(day) && currentTime.before(evening)){
            log.info("Displays:  Good day, World!");
            return "day";
        }
        else if (currentTime.after(evening) && currentTime.before(night)){
            log.info("Displays: Good evening, World!");
            return "evening";
        }
        else
            log.info("Displays: Good night, World!");
        return "night";

    }

}
