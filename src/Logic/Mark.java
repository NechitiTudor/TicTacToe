package Logic;

/**
 * Represents a mark in the Tic Tac Toe game. There three possible values:
 * Logic.Mark.X, Logic.Mark.O and Logic.Mark.EMPTY.
 **/

public enum Mark 
{
    
    EMPTY, X, O;

    /**
     * Returns the other mark.
     * @ensures that O is returned if this mark is X, that X is returned
     * 			when if mark is O and EMPTY otherwise
     * @return the other mark is this mark is not EMPTY or EMPTY
     */
    public Mark other()
    {
        if (this == X) 
        {
            return O;
        } else if (this == O) 
        {
            return X;
        } else 
        {
            return EMPTY;
        }
    }
}
