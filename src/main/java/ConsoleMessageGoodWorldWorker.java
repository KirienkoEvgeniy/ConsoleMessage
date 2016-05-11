import org.apache.log4j.Logger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    private ConsoleMessageGoodWorldWorker(){
         currentTimeDate = new Date();
    }
    private ConsoleMessageGoodWorldWorker(String event) throws ParseException{
        currentTimeDate = simpleDateFormat.parse(event);
    }

    public String getTime() throws ParseException{

        currentTime = simpleDateFormat.parse(simpleDateFormat.format(currentTimeDate));

        morning  = simpleDateFormat.parse(BorderCondition.MORNING.toString());
        day  = simpleDateFormat.parse(BorderCondition.DAY.toString());
        evening = simpleDateFormat.parse(BorderCondition.EVENING.toString());
        night = simpleDateFormat.parse(BorderCondition.NIGHT.toString());
        System.out.println(currentTime);
        System.out.println(currentTimeDate);

        if(currentTime.after(morning) && currentTime.before(day)){
            log.info("Displays:  Good morning, World!");
            return "MORNING";
        }
        else if (currentTime.after(day) && currentTime.before(evening)){
            log.info("Displays:  Good day, World!");
            return "DAY";
        }
        else if (currentTime.after(evening) && currentTime.before(night)){
            log.info("Displays: Good evening, World!");
            return "EVENING";
        }
        else
            log.info("Displays: Good night, World!");
        return "NIGHT";

    }

    public static Builder newBuilder(){
        return new ConsoleMessageGoodWorldWorker().new Builder();
    }
    public static Builder newBuilder(String event)throws ParseException{
        return new ConsoleMessageGoodWorldWorker(event).new Builder();
    }

    public class Builder{

        public Builder() {

        }

        public ConsoleMessageGoodWorldWorker build(){
            return ConsoleMessageGoodWorldWorker.this;
        }

    }


}
