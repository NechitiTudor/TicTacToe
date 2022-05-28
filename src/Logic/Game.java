package Logic;
import Player.*;
import java.util.Scanner;

public class Game
{
    public static final int NUMBER_PLAYERS = 2;
    private final Board board;
    private final Player[] players;
    private int current;

    /**
     * Creates a new Logic.Game object.
     */
    public Game(Player s0, Player s1)
    {
        board = new Board();
        players = new Player[NUMBER_PLAYERS];
        players[0] = s0;
        players[1] = s1;
        current = 0;
    }

    /**
     * Starts the Tic Tac Toe game.
     * Asks after each ended game if the user want to continue. Continues until
     * the user does not want to play anymore.
     */
    public void start()
    {
        Scanner in = new Scanner(System.in);
        boolean continueGame = true;

        while (continueGame)
        {
            play();
            System.out.println("\n> Play another time? (y/n)?");
            continueGame = Boolean.parseBoolean(in.nextLine());
        }
    }

    /**
     * Resets the game. <br>
     * The board is emptied and player[0] becomes the current player.
     */
    private void reset()
    {
        current = 0;
        board.reset();
    }

    /**
     * Plays the Tic Tac Toe game. <br>
     * First the (still empty) board is shown. Then the game is played
     * until it is over. Players can make a move one after the other. 
     * After each move, the changed game situation is printed.
     */
    private void play() 
    {
    	reset();
     	
    	while(!board.gameOver())
    	{
    		update();
    		
    		if(current == 0)
    		{
    			players[0].makeMove(board);
    			current = 1;
    		} else if (current == 1)
    		{
    			players[1].makeMove(board);
    			current = 0;
    		}
    	}
    	
    	printResult();
    }

    /**
     * Prints the game situation.
     */
    private void update()
    {
        System.out.println("\ncurrent game situation: \n\n" + board.toString() + "\n");
    }

    /**
     * Prints the result of the last game. <br>
     * @requires the game to be over
     */
    private void printResult() 
    {
    	update();
    	
        if (board.hasWinner()) 
        {
            Player winner = board.isWinner(players[0].getMark()) ? players[0] : players[1];
            System.out.println("Player " + winner.getName() + " ("  + winner.getMark().toString() + ") has won!");
        } else
        {
            System.out.println("Draw. There is no winner!");
        }
    }
}
