/**
 * This task was created by Niv Seker (https://github.com/sekerniv)
 *
 * For any questions or further assistance, feel free to reach out!
 */

// Leave this import as it is. You'll need it
import assignmentfiles.*;

public class GameEngine {
    private String targetWord;
    private int attemptsLeft;
    private boolean isWin;
    public GameEngine(String targetWord) {
        this.targetWord = targetWord;
        this.attemptsLeft = 6;
        this.isWin = false;// note
    }

    public String playGuess(String guess) {
        attemptsLeft--;
        String feedback = evaluateGuess(targetWord, guess);

        if (feedback.equals("*".repeat(targetWord.length()))) {
            isWin = true;
        }

        return feedback;
    }

    public static void main(String[] args) {

    }

    /**
     * Compares the player's guess to the target word and returns feedback.
     * For each character in the guess:
     * - '*' if the character is in the correct position.
     * - '+' if the character is in the target word but in the wrong position.
     * - '-' if the character is not in the target word.
     *
     * The comparison is done up to the length of the shorter word, ignoring any extra characters.
     * Example:
     * targetWord = "taper", guess = "water"
     * Returns: "-*+**"
     **/
    public static String evaluateGuess(String targetWord, String guess) {
        StringBuilder feedback = new StringBuilder();
        int minLength = Math.min(targetWord.length(), guess.length());

        for (int i = 0; i < minLength; i++) {
            char guessChar = guess.charAt(i);
            if (targetWord.charAt(i) == guessChar) {
                feedback.append('*');
            } else if (targetWord.contains(Character.toString(guessChar))) {
                feedback.append('+');
            } else {
                feedback.append('-');
            }
        }
        return feedback.toString();
    }

    public boolean isGameOver() {
        return isWin || attemptsLeft <= 0;
    }

    public boolean isWin() {
        return isWin;
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }
}
