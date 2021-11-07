import java.util.ArrayList;

public class MainMovie {

    public static void main(String[] args) {
        GuessTheMovie a = new GuessTheMovie();
        ArrayList<String> movies = a.fileMovie("./movies/movies.txt");
        a.game(movies);
    }

}
