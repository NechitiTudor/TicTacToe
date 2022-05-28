package Logic;

import java.util.Scanner;
import Player.*;
import Strategy.*;

public class TicTacToe
{
	public static void main(String[] args)
	{
		String firstPlayer = null;
		String secondPlayer = null;
		Scanner in = new Scanner(System.in);

		Game gameManager = null;
		ComputerPlayer computerPlayer = null;

		boolean playerVsComputer = false;
		boolean computerVsComputer = false;

		//checks whether there are any run configuration arguments given
		if(args.length > 0)
		{
			firstPlayer = args[0];
			secondPlayer = args[1];

			if(firstPlayer.equals("-N") && secondPlayer.equals("-S")) //the game can be played between computers each one using a different strategy
			{
				gameManager = new Game(new ComputerPlayer(Mark.X), new ComputerPlayer(Mark.O, new SmartStrategy()));
				computerVsComputer = true;
			} else if(secondPlayer.equals("-N")) //the computer will use the Naive Strategy vs a player
			{
				computerPlayer = new ComputerPlayer(Mark.O);
				playerVsComputer = true;
			} else if(secondPlayer.equals("-S")) //the computer will use Smart Strategy vs a player
			{
				computerPlayer = new ComputerPlayer(Mark.O, new SmartStrategy());
				playerVsComputer = true;
			}
		} else //in case there's no run configuration arguments given, the game will be played between 2 human players
		{
			System.out.print("------------Welcome to TicTacToe Game!------------\n"
					+"Please enter your names:\nPlayer1: ");
			firstPlayer = in.nextLine();

			System.out.print("Player2: ");
			secondPlayer = in.nextLine();
		}

		//checks if the game will be played as player vs computer which has a certain strategy, or between 2 human players
		if(playerVsComputer)
		{
			gameManager = new Game(new HumanPlayer(firstPlayer, Mark.X), computerPlayer);
		} else if(!playerVsComputer && !computerVsComputer)
		{
			gameManager = new Game(new HumanPlayer(firstPlayer, Mark.X), new HumanPlayer(secondPlayer, Mark.O));
		}

		gameManager.start();
	}
}
