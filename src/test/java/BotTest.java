import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class BotTest {

    ConsoleBot consoleBot = new ConsoleBot();
    Bot Bot = new Bot();

    /**
     * Проверка стартовых задач правильный отклик на /start
     */
    @Test
    public void startTest() throws IOException {
        var mes = ConsoleBot.sendMassage("/start", Bot);
        Assert.assertEquals(mes, Bot.START);
    }

    @Test
    public void helpTest() throws IOException {
        var mes = ConsoleBot.sendMassage("/help", Bot);
        Assert.assertEquals(mes, Bot.HELP);
    }

    @Test
    public void noComTest() throws IOException {
        var mes = ConsoleBot.sendMassage("blalbalbalbalbalb", Bot);
        Assert.assertEquals(mes, Bot.FALSE_ANSWER);
    }

    @Test
    public void noExTest() throws IOException {
        var mes = ConsoleBot.sendMassage("6", Bot);
        var mes1 = ConsoleBot.sendMassage("0", Bot);
        Assert.assertEquals(mes, Bot.FALSE_ANSWER);
        Assert.assertEquals(mes1, Bot.FALSE_ANSWER);
    }

}