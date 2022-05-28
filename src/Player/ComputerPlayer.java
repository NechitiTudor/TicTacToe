package Player;
import Strategy.*;
import Logic.*;

public class ComputerPlayer extends Player
{
	Strategy strategy;
	
	public ComputerPlayer(Mark mark, Strategy strategy)
	{
		super(strategy.getName() + "-" + mark.toString(), mark);
		this.strategy = strategy;
	}
	
	//constructor for a computer player with given mark and Naive Strategy.Strategy
	public ComputerPlayer(Mark mark)
	{
		this(mark, new NaiveStrategy());
	}
	
	public Strategy getStrategy()
	{
		return strategy;
	}
	
	public void setStrategy(Strategy strategy)
	{
		this.strategy = strategy;
	}

	public int determineMove(Board board)
	{
		return strategy.determineMove(board, this.getMark());
	}
}
