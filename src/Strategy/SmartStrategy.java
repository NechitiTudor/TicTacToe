package Strategy;

import Logic.Board;
import Logic.Mark;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SmartStrategy implements Strategy
{
	private final String name;
	
	public SmartStrategy()
	{
		name = "Smart";
	}
	
	public String getName()
	{
		return name;
	}
	
	public int determineMove(Board board, Mark mark)
	{
		Board copyBoard = board.deepCopy();
		List<Integer> availableFields = new LinkedList<>();
		Random random = new Random();
		int choice;
		
		//create a list only with the empty fields
		for(int i = 0; i < board.SIZE * board.SIZE; i++)
		{
			if(board.isEmptyField(i))
			{
				availableFields.add(i);
			}
		}
		
		//if the middle field is empty, return it!
		if(board.isEmptyField((Board.SIZE * Board.SIZE) / 2))
		{
			return ((Board.SIZE * Board.SIZE)) / 2;
		}
		
		//if there is a field that guarantees a direct win, then that field is selected.
		for(Integer i : availableFields)
		{
			copyBoard.setField(i, mark);
				
			if(copyBoard.isWinner(mark))
			{
				return i;
			} else
			{
				copyBoard.setField(i, Mark.EMPTY);
			}
		}
		
		//check if the player can have a next-winning move, so that it can be blocked
		for(Integer i : availableFields)
		{
			copyBoard.setField(i, mark.other());
				
			if(copyBoard.isWinner(mark.other()))
			{
				return i;
			} else
			{
				copyBoard.setField(i, Mark.EMPTY);
			}
		}
		
		//if none of the cases above have been accessed, get the choice randomly from the available fields, same as in the 'naive strategy'
		choice = availableFields.get(random.nextInt(availableFields.size())); 
		return choice;
	}
}
