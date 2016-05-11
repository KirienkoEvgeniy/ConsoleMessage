import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;

/**
 * Created by Evgeniy
 */
public class TestConsoleMessageGoodWorldWorker {
    private ConsoleMessageGoodWorldWorker consoleMessageGoodWorldWorker;

    @Test
    public void testGetEvent() throws ParseException {
        consoleMessageGoodWorldWorker = ConsoleMessageGoodWorldWorker.newBuilder().build();
        switch (consoleMessageGoodWorldWorker.getTime()) {
            case "MORNING":
                break;
            case "DAY":
                break;
            case "EVENING":
                break;
            case "NIGHT":
                break;
            default:
                Assert.fail();
        }
    }

    @Test
    public void testNightBorderConditionSecond() throws ParseException {
        consoleMessageGoodWorldWorker = ConsoleMessageGoodWorldWorker.newBuilder("05:59:59").build();
        Assert.assertEquals(consoleMessageGoodWorldWorker.getTime(), "NIGHT");
    }

    @Test
    public void testMorningBorderConditionFirst() throws ParseException {
        consoleMessageGoodWorldWorker = ConsoleMessageGoodWorldWorker.newBuilder("06:00:01").build();
        Assert.assertEquals(consoleMessageGoodWorldWorker.getTime(), "MORNING");
    }

    @Test
    public void testMorning() throws ParseException {
        consoleMessageGoodWorldWorker = ConsoleMessageGoodWorldWorker.newBuilder("07:30:01").build();
        Assert.assertEquals(consoleMessageGoodWorldWorker.getTime(), "MORNING");
    }

    @Test
    public void testMorningBorderConditionSecond() throws ParseException {
        consoleMessageGoodWorldWorker = ConsoleMessageGoodWorldWorker.newBuilder("08:59:59").build();
        Assert.assertEquals(consoleMessageGoodWorldWorker.getTime(), "MORNING");
    }

    @Test
    public void testDayBorderConditionFirst() throws ParseException {
        consoleMessageGoodWorldWorker = ConsoleMessageGoodWorldWorker.newBuilder("09:00:01").build();
        Assert.assertEquals(consoleMessageGoodWorldWorker.getTime(), "DAY");
    }

    @Test
    public void testDay() throws ParseException {
        consoleMessageGoodWorldWorker = ConsoleMessageGoodWorldWorker.newBuilder("14:01:01").build();
        Assert.assertEquals(consoleMessageGoodWorldWorker.getTime(), "DAY");
    }

    @Test
    public void testDayBorderConditionSecond() throws ParseException {
        consoleMessageGoodWorldWorker = ConsoleMessageGoodWorldWorker.newBuilder("18:59:59").build();
        Assert.assertEquals(consoleMessageGoodWorldWorker.getTime(), "DAY");
    }

    @Test
    public void testEveningBorderConditionFirst() throws ParseException {
        consoleMessageGoodWorldWorker = ConsoleMessageGoodWorldWorker.newBuilder("19:00:01").build();
        Assert.assertEquals(consoleMessageGoodWorldWorker.getTime(), "EVENING");
    }

    @Test
    public void testEvening() throws ParseException {
        consoleMessageGoodWorldWorker = ConsoleMessageGoodWorldWorker.newBuilder("22:01:01").build();
        Assert.assertEquals(consoleMessageGoodWorldWorker.getTime(), "EVENING");
    }

    @Test
    public void testEveningBorderConditionSecond() throws ParseException {
        consoleMessageGoodWorldWorker = ConsoleMessageGoodWorldWorker.newBuilder("22:59:59").build();
        Assert.assertEquals(consoleMessageGoodWorldWorker.getTime(), "EVENING");
    }

    @Test
    public void testNightBorderConditionFirst() throws ParseException {
        consoleMessageGoodWorldWorker = ConsoleMessageGoodWorldWorker.newBuilder("23:00:01").build();
        Assert.assertEquals(consoleMessageGoodWorldWorker.getTime(), "NIGHT");
    }

    @Test
    public void testNight() throws ParseException {
        consoleMessageGoodWorldWorker = ConsoleMessageGoodWorldWorker.newBuilder("03:30:01").build();
        Assert.assertEquals(consoleMessageGoodWorldWorker.getTime(), "NIGHT");
    }
}
