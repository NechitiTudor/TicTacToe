package Player;

import Logic.*;

public abstract class Player
{
    private final String name;
    private final Mark mark;

    public Player(String name, Mark mark) 
    {
        this.name = name;
        this.mark = mark;
    }

    public String getName()
    {
        return name;
    }

    public Mark getMark() 
    {
        return mark;
    }

    /**
     * Determines the field for the next move.
     */
    public abstract int determineMove(Board board);

    /**
     * Makes a move on the board.
     */
    public void makeMove(Board board) 
    {
        int choice = determineMove(board);
        board.setField(choice, getMark());
    }

}
