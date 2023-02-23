import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.util.Date;
import javax.swing.ScrollPaneConstants;

    public class ChessGameLog extends JScrollPane {

        private JTextArea textArea;

        public ChessGameLog() {
            super(new JTextArea("", 5, 30),
                  ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                  ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
            textArea = ((JTextArea) this.getViewport().getView());
        }

        public void addToLog(String s) {
            if (textArea.getText().length() > 0) {
                textArea.setText(textArea.getText() + "\n" + new Date() + " - " + s);
            } else {
                textArea.setText(new Date() + " - " + s);
            }
        }
    
    /**
     * Clears the log.
     */
    public void clearLog(){
        textArea.setText( "" );
    }
    // ----------------------------------------------------------
    /**
     * Gets the most recent statement added to the log.
     * 
     * @return String the most recent log statement
     */
    public String getLastLog(){
        int indexOfLastNewLine = textArea.getText().lastIndexOf( "\n" );
        if ( indexOfLastNewLine < 0 ){
            return textArea.getText();
        }
        return textArea.getText().substring( indexOfLastNewLine + 1 );
    }
}
