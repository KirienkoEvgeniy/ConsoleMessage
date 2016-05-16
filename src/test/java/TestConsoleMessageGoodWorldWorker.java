import org.junit.Assert;
import org.junit.Test;
import java.text.ParseException;
import java.util.Locale;

/**
 * Created by Evgeniy
 */
public class TestConsoleMessageGoodWorldWorker {
    private ConsoleMessageGoodWorldWorker consoleMessageGoodWorldWorker;

    @Test
    public void testGetEvent() throws ParseException {
        switch (consoleMessageGoodWorldWorker.getTime()) {
            case "morning":
                break;
            case "day":
                break;
            case "evening":
                break;
            case "night":
                break;
            default:
                Assert.fail();
        }
    }

    @Test
    public void testNightBorderConditionSecond() throws ParseException {
        consoleMessageGoodWorldWorker = new ConsoleMessageGoodWorldWorker("05:59:59");
        Assert.assertEquals(consoleMessageGoodWorldWorker.getTime(), "night");
    }

    @Test
    public void testMorningBorderConditionFirst() throws ParseException {
        consoleMessageGoodWorldWorker = new ConsoleMessageGoodWorldWorker("06:00:01");
        Assert.assertEquals(consoleMessageGoodWorldWorker.getTime(), "morning");
    }

    @Test
    public void testMorning() throws ParseException {
        consoleMessageGoodWorldWorker = new ConsoleMessageGoodWorldWorker("07:30:01");
        Assert.assertEquals(consoleMessageGoodWorldWorker.getTime(), "morning");
    }

    @Test
    public void testMorningBorderConditionSecond() throws ParseException {
        consoleMessageGoodWorldWorker = new ConsoleMessageGoodWorldWorker("08:59:59");
        Assert.assertEquals(consoleMessageGoodWorldWorker.getTime(), "morning");
    }

    @Test
    public void testDayBorderConditionFirst() throws ParseException {
        Locale localeRu = new Locale("ru", "RU");
        consoleMessageGoodWorldWorker = new ConsoleMessageGoodWorldWorker("09:01:01", localeRu);
        Assert.assertEquals(consoleMessageGoodWorldWorker.getTime(), "day");
    }

    @Test
    public void testDayBorderCondition() throws ParseException {
        Locale localeRu = new Locale("ru", "RU");
        consoleMessageGoodWorldWorker = new ConsoleMessageGoodWorldWorker("14:01:01", localeRu);
        Assert.assertEquals(consoleMessageGoodWorldWorker.getTime(), "day");
         }
    @Test
    public void testDayBorderConditionSecond() throws ParseException {
        Locale localeRu = new Locale("ru", "RU");
        consoleMessageGoodWorldWorker = new ConsoleMessageGoodWorldWorker("18:59:59", localeRu);
        Assert.assertEquals(consoleMessageGoodWorldWorker.getTime(), "day");
         }
    @Test
    public void testEveningBorderConditionFirst() throws ParseException {
        Locale localeRu = new Locale("ru", "RU");
        consoleMessageGoodWorldWorker = new ConsoleMessageGoodWorldWorker("19:01:01", localeRu);
        Assert.assertEquals(consoleMessageGoodWorldWorker.getTime(), "evening");
   }


    @Test
    public void testEvening() throws ParseException {
        consoleMessageGoodWorldWorker = new ConsoleMessageGoodWorldWorker("22:01:01");
        Assert.assertEquals(consoleMessageGoodWorldWorker.getTime(), "evening");
    }

    @Test
    public void testEveningBorderConditionSecond() throws ParseException {
        consoleMessageGoodWorldWorker = new ConsoleMessageGoodWorldWorker("22:59:59");
        Assert.assertEquals(consoleMessageGoodWorldWorker.getTime(), "evening");
    }

    @Test
    public void testNightBorderConditionFirst() throws ParseException {
        consoleMessageGoodWorldWorker = new ConsoleMessageGoodWorldWorker("23:00:01");
        Assert.assertEquals(consoleMessageGoodWorldWorker.getTime(), "night");
    }

    @Test
    public void testNight() throws ParseException {
        consoleMessageGoodWorldWorker = new ConsoleMessageGoodWorldWorker("03:30:01");
        Assert.assertEquals(consoleMessageGoodWorldWorker.getTime(), "night");
    }

}
