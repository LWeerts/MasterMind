import java.util.Scanner;

/**
 * main
 */
public class MasterMind {

    public static void main(String[] args) {
        System.out.println("Start game");
        char quit = 'q';
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter input:");
        String inputString = sc.nextLine();
        System.out.println("Your input was: " + inputString);
        
        for (int i = 0; i < 100; i++) {
            System.out.println("Enter input:");
            inputString = sc.nextLine();
            if (inputString.charAt(0) == quit) {
                System.out.println("You entered q, quitting!");
                System.exit(0);
            } else {
                System.out.println("Your input was: " + inputString);
            }
        }
        
    }
}