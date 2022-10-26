import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Undo implements DocumentListener, ActionListener {
    JTextPane textPane;
    private Originator doc;
    private List<History> histories;
    private DefineImageButton defineImageButton = new DefineImageButton();
    JButton undoButton, saveButton;
    private int historyPosition = 0;

    public Undo(JTextPane textPane) {
        this.textPane = textPane;
        doc = new Originator(textPane.getText());
        histories = new ArrayList<>();
        backup();
        createUndoButton();
    }

    private void createUndoButton() {
        undoButton = new JButton(defineImageButton.undoIcon);
        undoButton.setToolTipText("undo");
        undoButton.setText("undo");
        undoButton.setFont(new Font("bold", 0, 0));
        undoButton.addActionListener(this);
        saveButton = new JButton("save");
        saveButton.setToolTipText("save");
        saveButton.addActionListener(this);
        textPane.getDocument().addDocumentListener(this);
    }

    public void backup() {
        doc.setText(textPane.getText());
        histories.add(doc.createHistory());
        historyPosition++;
    }

    public void undo() throws BadLocationException {
        System.out.println("復原動作");
        if (historyPosition == 0) {
            JOptionPane.showMessageDialog(textPane, "can't undo");
        }
        historyPosition--;
        History history = histories.get(historyPosition);
        doc.restoreHistory(history);
        System.out.println(historyPosition);
        System.out.println(history.getText());
        System.out.println(doc.getText());
        textPane.setText(history.getText());


    }


    @Override
    public void insertUpdate(DocumentEvent e) {



    }


    @Override
    public void removeUpdate(DocumentEvent e) {


    }

    @Override
    public void changedUpdate(DocumentEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("undo")) {
            try {
                undo();
            } catch (BadLocationException ex) {
                throw new RuntimeException(ex);
            }

        } else if (s.equals("save")) {
            System.out.println("save");
            backup();

        }
    }
}