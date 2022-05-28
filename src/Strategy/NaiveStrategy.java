package Strategy;

import Logic.Board;
import Logic.Mark;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class NaiveStrategy implements Strategy
{
	private String name;
	
	public NaiveStrategy()
	{
		name = "Naive";
	}
	
	public String getName()
	{
		return name;
	}
	
	//implementing the "naive" strategy, where this function returns an arbitrary empty field on the board
	public int determineMove(Board board, Mark mark)
	{
		Random random = new Random();
		List<Integer> availableFields = new LinkedList<>();
	
		for(int i = 0; i < 9; i++)
		{
			if(board.isEmptyField(i))
			{
				availableFields.add(i);
			}
		}

		return availableFields.get(random.nextInt(availableFields.size()));
	}
}
