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
        Assert.assertEquals(mes, "Привет этот бот проверит как ты знаешь исторические даты \n" +
                " напиши номер задания с которого хочешь начать ");
    }

    /**
     * Проверка на /help
     */
    @Test
    public void helpTest() throws IOException {
        var mes = ConsoleBot.sendMassage("/help", Bot);
        Assert.assertEquals(mes, "Тебе понадобилась помощь ? Тогда вот список доступных команд \n /help - поможет еще раз \n /task - ты выберешь задание");
    }

    /**
     * Проверка на правильность работы в случае не правильных данных
     */
    @Test
    public void noComTest() throws IOException {
        var mes = ConsoleBot.sendMassage("blalbalbalbalbalb", Bot);
        Assert.assertEquals(mes, "Нет такой команды :(");
    }

    /**
     * Проверка правильности спрашиваемых вопросов
     */
    @Test
    public void noExTest() throws IOException {
        var mes = ConsoleBot.sendMassage("6", Bot);
        var mes1 = ConsoleBot.sendMassage("0", Bot);
        Assert.assertEquals(mes, "нет такого вопроса ");
        Assert.assertEquals(mes1, "нет такого вопроса ");
    }

}