import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException {
        System.out.println(BotInfo.Info());
        Bot bot = new Bot();
        ConsoleBot.chatToUser(bot);
    }
}
