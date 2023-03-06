import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import java.util.Date;

//Patron de diseño observer
public class ChessGameLog extends JScrollPane implements Serializable {
    private JTextArea textArea;
    transient private ArrayList<LogObserver> observers;

    public ChessGameLog() {
        super(new JTextArea("", 5, 30),
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        textArea = ((JTextArea) this.getViewport().getView());
        observers = new ArrayList<LogObserver>();
    }

    public void addToLog(String s) {
        if (textArea.getText().length() > 0) {
            textArea.setText(textArea.getText() + "\n" + new Date() + " - " + s);
        } else {
            textArea.setText(new Date() + " - " + s);
        }
        notifyObservers(s);
    }

    public void clearLog() {
        textArea.setText("");
        notifyObservers("");
    }

    public String getLastLog() {
        int indexOfLastNewLine = textArea.getText().lastIndexOf("\n");
        if (indexOfLastNewLine < 0) {
            return textArea.getText();
        }
        return textArea.getText().substring(indexOfLastNewLine + 1);
    }

    // attach an observer
    public void attach(LogObserver observer) {
        observers.add(observer);
    }

    // detach an observer
    public void detach(LogObserver observer) {
        observers.remove(observer);
    }

    // notify all observers
    private void notifyObservers(String message) {
        for (LogObserver observer : observers) {
            observer.update(message);
        }
    }
}

// The LogObserver interface
interface LogObserver {
    public void update(String message);
}
