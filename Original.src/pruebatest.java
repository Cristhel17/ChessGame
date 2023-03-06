import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class pruebatest {

    private ChessGameBoard gameBoard;

    @BeforeEach
    public void setUp() {
        gameBoard = new ChessGameBoard();
    }

    @Test
    public void testGetCells() {
        // Ensure that the chessCells variable is not null
        assertNotNull(gameBoard.getCells());
    }

    @Test
    public void testGetCell() {
        // Ensure that getting a valid cell returns a BoardSquare object
        assertNotNull(gameBoard.getCell(0, 0));
        assertNotNull(gameBoard.getCell(7, 7));

        // Ensure that getting an invalid cell returns null
        assertNull(gameBoard.getCell(-1, -1));
        assertNull(gameBoard.getCell(8, 8));
    }
    
    @Test
    public void testGetCelll() {
        int row = 5;
        int col = 2;
        BoardSquare square = gameBoard.getCell(row, col);
        assertNotNull(square);
        assertEquals(row, square.getRow());
    }
    
    @Test
    public void testClearCell() {
        int row = 3;
        int col = 4;
        gameBoard.clearCell(row, col);
        assertNull(gameBoard.getCell(row, col).getPieceOnSquare());
    }

}