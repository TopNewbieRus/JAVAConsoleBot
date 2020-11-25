import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ConsoleBot {
    public static void chatToUser(Bot Bot) throws IOException {
        System.out.println("Если ты готов начать напиши '/start' ");
        while (true) {
            Scanner text = new Scanner(System.in);
            String str = text.nextLine();
            System.out.println(sendMassage(str,Bot));
        }
    }

    public static String sendMassage(String command, Bot bot) throws IOException {
        if(Pattern.matches("-?\\d+", command)) {
            var mes = Bot.sendTask(Integer.parseInt(command));
            System.out.println(mes.getTask());
            if (mes.getTask().equals(" "))
                return mes.getAnswer();
            else if (bot.compareAnswer(mes.getAnswer()))
                return Bot.TRUE_ANSWER;
            else
                return Bot.FALSE_ANSWER + mes.getAnswer();
        }
        else if (command.equals(Bot.START))
            return "Привет этот бот проверит как ты занешь исторические даты \n напиши номер задания с которого хочешь начать ";
        else  if (command.equals(Bot.HELP))
            return "Тебе понадоилась помощь ? Тогда вот список доступных комманд \n /help - поможет еще раз \n /task - ты выберешь задание";
        else if (command.equals(Bot.TASK))
            return Bot.TASK_NUMBER;
        else
            return ("Нет такой команды, думай лучше чем что-то писать ");
    }
}
