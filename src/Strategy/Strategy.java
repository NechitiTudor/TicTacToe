package Strategy;

import Logic.Board;
import Logic.Mark;

public interface Strategy
{
	String getName();
	
	int determineMove(Board board, Mark mark);
}
