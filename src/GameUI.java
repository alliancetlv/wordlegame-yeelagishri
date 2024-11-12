import java.util.Scanner;
public class GameUI {
    private Scanner input;

    public GameUI(){
        this.input = new Scanner(System.in);//note
    }

    public String readUserGuess(){
        System.out.print("Enter your guess: ");
        return input.nextLine();
    }

    public void displayResult(String feedback, String guess, int attemptsLeft){
        System.out.println("You have " + attemptsLeft + " attempts left.");
        System.out.println("Your guess: " + guess);
        System.out.println("Feedback: " + feedback);
    }

    public void displayWin(){
        System.out.println("Congratulations, YOU WIN!");
    }

    public void displayLoss(String targetWord) {
        System.out.println("Game over! The word was: " + targetWord);
    }
}
