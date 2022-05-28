package Logic;

import java.util.Arrays;

/**
 * Logic.Board for the Tic Tac Toe game
 */
public class Board
{
    public static final int SIZE = 3;
    private static final String[] NUMBERING = {" 0 | 1 | 2 ", "---+---+---",
        " 3 | 4 | 5 ", "---+---+---", " 6 | 7 | 8 "};
    private static final String LINE = NUMBERING[1];
    private static final String DELIM = "     ";

    /**
     * Fields of the Tic Tac Toe game board, with size*size
     */
    private  Mark[] fields;

    // -- Constructors -----------------------------------------------

    /**
     * Creates an empty board.
     */
    public Board()
    {
    	fields = new Mark[SIZE * SIZE];
    	Arrays.fill(fields, Mark.EMPTY);
    }

    /**
     * Creates a deep copy of this field.
     */
    public Board deepCopy()
    {	
    	Board newBoard = new Board();
    	System.arraycopy(this.fields, 0, newBoard.fields, 0, this.fields.length);
    	
        return newBoard;
    }

    /**
     * Calculates the index in the linear array of fields from a (row, col)
     * pair.
     * @return the index belonging to the (row,col)-field
     */
    public int index(int row, int col) 
    {
    	return row * SIZE + col;
    }

    /**
     * Returns true if index is a valid index of a field on the board.
     * @return true if 0 <= index < size*size
     */
    public boolean isField(int index)
    {
    	return (index >=0 && index < SIZE * SIZE);
    }

    /**
     * Returns the content of the field referred to by the (row,col) pair.
     */
    public Mark getField(int row, int col)
    {
    	int index = this.index(row,col);
    	
    	return fields[index];
    }

    /**
     * Returns true if the field i is empty.
     */
    public boolean isEmptyField(int i) 
    {
    	return(fields[i] == Mark.EMPTY);
    }

    /**
     * Tests if the whole board is full.
     */
    public boolean isFull()
    {
    	boolean isFull = true;
    	
       for(int i = 0; i < fields.length; i++)
       {
    	   if(isEmptyField(i))
    	   {
    		   isFull = false;
    		   break;
    	   }
       }
       
       return isFull;
    }

    /**
     * Returns true if the game is over. The game is over when there is a winner
     * or the whole board is full.
     */
    public boolean gameOver() 
    {
    	return(hasWinner() || isFull());
    }

    /**
     * Checks whether there exists a winning row
     */
    public boolean hasRow(Mark m) 
    {
    	for(int i = 0; i < SIZE; i++)
    	{
    		boolean won = true;
    		
    		for(int j = 0; j < SIZE; j++)
    		{
    			if(fields[i * SIZE + j] != m)
    			{
    				won = false;
    			}
    		}
    		
    		if(won)
    		{
    			return true;
    		}
    	}
    	
    	return false;
    }

    /**
        Check for a winning column
     */
    public boolean hasColumn(Mark m) 
    {
    	for(int i = 0; i < SIZE; i++)
    	{
    		boolean won = true;
    		
    		for(int j = 0; j < SIZE; j++)
    		{
    			if(fields[j * SIZE + i] != m)
    			{
    				won = false;
    			}
    		}
    		
    		if(won)
    		{
    			return true;
    		}
    	}
    	
    	return false;
    }

    /**
     * Check for winning diagonals
     */
    public boolean hasDiagonal(Mark m) 
    {
    	boolean leftDiag = true;
    	boolean rightDiag = true;
    	
    	for(int i = 0; i < SIZE; i++)
    	{	
    		if(this.getField(i,i) != m)
    		{
    			leftDiag = false;
    		}
    		
    		for(int j = 0; j < SIZE; j++)
    		{
    			if(i + j == SIZE - 1)
    			{
    				if(this.getField(i,j) != m)
    				{
    					rightDiag = false;
    				}
    			}
    		}
    	}
    	
    	return leftDiag || rightDiag;
    }

    /**
     * Checks for winner
     */
    public boolean isWinner(Mark m) 
    {
    	boolean hasWon = false;
    	
    	if(m != Mark.EMPTY)
    	{
    		if(hasRow(m) || hasColumn(m) || hasDiagonal(m))
    		{
    			hasWon = true;
    		}	
    	}
    	
    	return hasWon;
    }

    /**
     * Returns true if the game has a winner. This is the case when one of the
     * marks controls at least one row, column or diagonal.
     */
    public boolean hasWinner() 
    {
    	return (isWinner(Mark.X) || isWinner(Mark.O));
    }

    /**
     * Returns a String representation of this board. In addition to the current
     * situation, the String also shows the numbering of the fields.
     */
    public String toString() 
    {
        String s = "";
        for (int i = 0; i < SIZE; i++)
        {
            String row = "";
            for (int j = 0; j < SIZE; j++)
            {
                String val = getField(i, j).toString();
                if(val.equals("EMPTY"))
                    row = row + " " + " " + " ";
                else
                    row = row + " " + val + " ";
                if (j < SIZE - 1)
                {
                    row = row + "|";
                }
            }
            s = s + row + DELIM + NUMBERING[i * 2];
            if (i < SIZE - 1)
            {
                s = s + "\n" + LINE + DELIM + NUMBERING[i * 2 + 1] + "\n";
            }
        }
        return s;
    }

    /**
     * Empties all fields of this board (i.e., let them refer to the value
     * Logic.Mark.EMPTY).
     */
    public void reset()
    {
    	for(int i = 0; i < fields.length;i++)
    	{
    		fields[i] = Mark.EMPTY;
    	}
    }

    /**
     * Sets the content of field i to the mark m.
     */
    public void setField(int i, Mark m)
    {
    	fields[i] = m;
    }

}
