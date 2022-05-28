package Player;

import java.util.Scanner;
import Logic.*;

public class HumanPlayer extends Player
{
    public HumanPlayer(String name, Mark mark)
    {
        super(name, mark);
    }

    /**
     * Asks the user to input the field where to place the next mark. This is
     * done using input from console.
     */
    public int determineMove(Board board)
    {
        Scanner in = new Scanner(System.in);

        String prompt = "> " + getName() + " (" + getMark().toString() + ")"
                + ", what is your choice?";

        System.out.println(prompt);
        int choice = Integer.parseInt(in.nextLine());

        boolean valid = board.isField(choice) && board.isEmptyField(choice);
        while (!valid)
        {
            System.out.println("ERROR: field " + choice
                    + " is no valid choice.\n");
            System.out.println(prompt);
            choice = Integer.parseInt(in.nextLine());
            valid = board.isField(choice) && board.isEmptyField(choice);
        }

        return choice;
    }

}
