import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Bot {
    protected static final String START = "/start";
    protected static final String HELP = "/help";
    protected static final String TASK = "/task";
    protected static final String TASK_NUMBER = "Введите номер задания";
    protected static final String TRUE_ANSWER = "Правильный ответ!";
    protected static final String FALSE_ANSWER = "Правильный ответ: ";
    protected static final String STOP = "Ты закончил тест";

    public static Pair sendTask(int number) throws IOException {
        if (number > 0 && number < 6) {
            var path = String.valueOf(Paths.get("").toAbsolutePath().resolve("src/main/Tasks/task"
                    + number + ".txt"));
            try (BufferedReader in = new BufferedReader(new FileReader(path))) {
                String line;
                StringBuilder ts = new StringBuilder();
                ArrayList<String> task = new ArrayList<>();
                while ((line = in.readLine()) != null){
                    task.add(line);
                }
                var answer = task.remove(task.size() - 1);
                for (String s : task) {
                    ts.append(s);
                    ts.append('\n');
                }
                return new Pair(answer, ts.toString());
            }
        }
        else return new Pair("нет такого вопроса ", " ");
    }


    public Boolean compareAnswer(String answer){
        Scanner text = new Scanner(System.in);
        String str = text.nextLine();
        return str.equals(answer);
    }
}

