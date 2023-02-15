import java.util.Random;
import java.util.Scanner;

/**
 * MasterMind in the command line
 * 
 * Using letters abcdef, the computer generates a 4 letter code. 
 * It is your job to guess the code.
 * Enter your guess, and the computer responds with:
 *  +  If you guessed one position correctly
 *  ?  If you guessed a letter that is in the code but at a different position.
 * You have 12 tries to find the right answer. 
 * Enter q to quit.
 */
public class MasterMind {

    /**
     * Creates a random 4 letter code consisting of letters abcdef.
     * @return the random code
     */
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

    /**
     * Checks input against the answer.
     * 
     * User input is checked first for which positions match the answer code.
     * Then correct letters in wrong locations are checked, but skipping
     * the positions that are already matching.
     * Feedback is given with + and ?. ++++ indicates a perfect match, and
     * the player wins. ???? indicates all letters are in the wrong position.
     * ++?? indicates 2 letters in the right position, and 2 in the wrong
     * position, but does not give information about which letters are correct.
     * Can return an empty string if the guess has no overlap with the code.
     * 
     * @param code the code to guess
     * @param input the players guess
     * @return feedback: + is correct, ? is wrong position.
     */
    static String check_code(String code, String input) {
        int[] checked_code = {0, 0, 0, 0};
        int[] checked_input = {0, 0, 0, 0};
        String right_string = "";
        String wrong_string = "";
        // Determine correct color at correct position
        for (int i = 0; i < 4; i++) {
            if (code.charAt(i) == input.charAt(i)) {
                checked_code[i] = 1;
                checked_input[i] = 1;
                right_string += "+";
            }
        }
        // Check for right color but wrong position
        for (int i = 0; i < 4; i++) {
            if (checked_input[i] == 1) {
                continue;
            }
            for (int j = 0; j < 4; j++) {
                // Don't want positions that are already accounted for
                // i == j covered by correct color at correct position
                if (i == j || checked_code[j] == 1) {
                    continue;
                }
                if (code.charAt(j) == input.charAt(i)) {
                    wrong_string += "?";
                    checked_code[j] = 1; // Prevents double counting.
                    break;
                }
            }   
        }
    String output = right_string + wrong_string;
    return output;
    }

    /**
     * Executes MasterMind
     * 
     * Handles system input and output, looping for 12 iterations,
     * and exiting if player wins or if q is entered.
     * @param args does nothing
     */
    public static void main(String[] args) {
        System.out.println("Start game");
        char quit = 'q';
        Scanner sc = new Scanner(System.in);
        String code = generate_code();
        
        for (int i = 0; i < 12; i++) {
            System.out.println("Enter input:");
            String inputString = sc.nextLine();
            if (inputString.charAt(0) == quit) {
                System.out.println("You entered q, quitting!");
                System.exit(0);
            } else {
                String output = check_code(code, inputString);
                System.out.println("Your try: " + inputString + " Reply: " + output);
                if (output.equals("++++")) {  // output == "++++" doesn't work because it checks reference, not value
                    System.out.println("You guessed the right code, congratulations!");
                    System.exit(0);
                }
            }
        }
    }
}