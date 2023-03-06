import java.io.Serializable;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class BoardSquare
    extends JPanel implements Serializable{
    private int            row;
    private int            col;
    private transient ChessGamePiece piece;
    private JLabel         imageLabel;
    
    public BoardSquare( int row, int col, ChessGamePiece piece ){
        super();
        this.row = row;
        this.col = col;
        this.piece = piece;
        updateImage();
    }
   
    private void updateImage(){
        if ( imageLabel != null ){
            removeAll();
        }
        if ( piece != null ){
            imageLabel = new JLabel();
            imageLabel.setIcon( piece.getImage() );
            add( imageLabel );     
        }
        revalidate(); 
    }
   
    public int getRow(){
        return row;
    }
    
    public int getColumn(){
        return col;
    }
    
    public ChessGamePiece getPieceOnSquare(){
        return piece;
    }
   
    public void setPieceOnSquare( ChessGamePiece p ){
        piece = p;
        updateImage();
    }
    // ----------------------------------------------------------
    /**
     * Clears this square, removing the icon and the piece.
     */
    public void clearSquare(){
        piece = null;
        removeAll();
    }
}
