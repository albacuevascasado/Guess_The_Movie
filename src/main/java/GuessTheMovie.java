import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GuessTheMovie {
    /*
    length of the array[] in this case = 3 movies fixed size
     */
    private ArrayList<String> movies = new ArrayList<String>();

    public ArrayList<String> fileMovie(String pathFile) {

        File file = new File(pathFile);
        try {
            Scanner movie = new Scanner(file);
            while(movie.hasNext()) {
                String line = movie.nextLine();
                this.movies.add(line);
            //System.out.println(line); //movie
            //System.out.println(i); //index
            }
            movie.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return this.movies;
    }

    public void game(ArrayList<String> movies){
        /*
        size starts with index = 1 but the Math.random() gives values between 0 and < 1
         */
        int e = (int) (((Math.random())*(this.movies.size())));

        StringBuilder word = new StringBuilder();
        for (int j=0; j<this.movies.get(e).length(); j++) {
            word.append("_");
            word.toString();
        }
        System.out.println("Length of the word: " + word.length());
        System.out.println("Guess the movie: " + word);

        int attempt = 1;
        Scanner scanner = new Scanner(System.in);
        //Generate an empty string (letter) where the characters are going to be added
        String letter = " ";
        while (attempt <= 10) {
            System.out.println("Write a letter: ");
            String guessing = scanner.next();
            //If the guessing has not been repeated
            if(!(letter.contains(guessing))) {

                if (this.movies.get(e).contains(guessing)) {
                    //NO CASE-SENSITIVE
                    int index = this.movies.get(e).indexOf(guessing);
                    System.out.println("You guess one!!");
                    word.setCharAt(index, movies.get(e).charAt(index));
                    System.out.println(word);

                } else {
                    System.out.println("Wrong guess!!");
                }
                System.out.println(attempt);
                attempt ++;
            }

            if (letter.contains(guessing)){
                System.out.print("Character already chosen. ");
                System.out.println("Write a new one!!");
                System.out.println(attempt);
            }

            letter += guessing;
            System.out.println("Letter: " + letter);

            if (this.movies.get(e).equals(word.toString())) {
                System.out.print("The player guessed the movie. ");
                System.out.println("CONGRATULATIONS!!!");
                break;
            }

            //attempt==11 because you are STILL PLAYING with attempt=10
            if (attempt == 11) {
                System.out.println("You lost the game!!");
            }
        }

    }
}
