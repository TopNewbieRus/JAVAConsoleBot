/**
 * Это задает пару вопрос и ответ
 */

public class Pair {
    private static String answer;
    private static String task;

    Pair(String a, String t){
        answer = a;
        task = t;
    }

    public String getAnswer(){ return answer;}
    public String getTask(){ return task; }
}
