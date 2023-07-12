import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Appli {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("1 or 2 players?");
        String Joueurs = keyboard.nextLine();

        String mot;

        if (Joueurs.equals("1")) {
            Scanner scanner = new Scanner(new File("C:\\Users\\LENOVO\\Downloads\\words\\words.txt"));
            List<String> mots = new ArrayList<>();

            while (scanner.hasNext()) {
                mots.add(scanner.nextLine());
            }

            Random rand = new Random();
            mot = mots.get(rand.nextInt(mots.size()));
        } else {
            System.out.println("Joueur 1, entre ton mot:");
            mot = keyboard.nextLine();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Bonne chance à toi joueur 2 :) !!!!");
        }

        //System.out.println(word);

        List<Character> playerGuesses = new ArrayList<>();

        Integer wrongCount = 0;

        while (true) {
            printHangedMan(wrongCount);

            if (wrongCount >= 6) {
                System.out.println("T'AS PERDU AHAHAHAH");
                System.out.println("Le mot etait " + mot);
                break;
            }

            printWordState(mot, playerGuesses);
            if (!getPlayerGuess(keyboard, mot, playerGuesses)) {
                wrongCount++;
            }

            if (printWordState(mot, playerGuesses)) {
                System.out.println("TROP FORT BV !!");
                break;
            }

            System.out.println("Entre ton guess bg : ");
            if (keyboard.nextLine().equals(mot)) {
                System.out.println("TROP FORT BV !");
                break;
            } else {
                System.out.println("Trop null! try again");
            }
        }
    }

    private static void printHangedMan(Integer wrongCount) {
        System.out.println(" -------");
        System.out.println(" |     |");
        if (wrongCount >= 1) {
            System.out.println(" O");
        }

        if (wrongCount >= 2) {
            System.out.print("\\ ");
            if (wrongCount >= 3) {
                System.out.println("/");
            } else {
                System.out.println("");
            }
        }

        if (wrongCount >= 4) {
            System.out.println(" |");
        }

        if (wrongCount >= 5) {
            System.out.print("/ ");
            if (wrongCount >= 6) {
                System.out.println("\\");
            } else {
                System.out.println("");
            }
        }
        System.out.println("");
        System.out.println("");
    }

    private static boolean getPlayerGuess(Scanner keyboard, String word, List<Character> playerGuesses) {
        System.out.println("Entre une lettre stp :");
        String letterGuess = keyboard.nextLine();
        playerGuesses.add(letterGuess.charAt(0));

        return word.contains(letterGuess);
    }

    private static boolean printWordState(String word, List<Character> playerGuesses) {
        int correctCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (playerGuesses.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
                correctCount++;
            } else {
                System.out.print("-");
            }


        }

        return false;
    }
}