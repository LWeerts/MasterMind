import java.util.Random;
import java.util.Scanner;

/**
 * main
 */
public class MasterMind {

    static String generate_code() {
        Random rand = new Random();
        String code = "";
        String all_letters = "abcdef";
        for (int i = 0; i < 4; i++) {
            int random_int = rand.nextInt(6);
            code = code + all_letters.charAt(random_int);
        }
        return code;
    }

    public static void main(String[] args) {
        System.out.println("Start game");
        char quit = 'q';
        Scanner sc = new Scanner(System.in);
        String code = generate_code();
        
        for (int i = 0; i < 100; i++) {
            System.out.println("Enter input:");
            String inputString = sc.nextLine();
            if (inputString.charAt(0) == quit) {
                System.out.println("You entered q, quitting!");
                System.exit(0);
            } else {
                System.out.println("Your input was: " + inputString);
                if (inputString.charAt(0) == code.charAt(0)) {
                    System.out.println("You guessed the right first letter");
                    System.out.println("The code is: " + code);
                    System.exit(0);
                } else {
                    System.out.println("You guessed the wrong first letter");
                }
            }
        }
        
    }
}