import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException {
        ConsoleBot consoleBot = new ConsoleBot();
        Bot bot = new Bot();
        ConsoleBot.chatToUser(bot);
    }
}
