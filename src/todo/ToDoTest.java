package todo;

public class ToDoTest {

    @ToDo(message = "if文が不要なので1行にまとめる", expiration = "20160211")
    public static boolean over5characters(String target) {
        if (target.length() > 5) {
            return true;
        }

        return false;
    }
}
