package memento;

import image.DefineImageButton;

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
    private Stack<History> histories;
    private DefineImageButton defineImageButton = new DefineImageButton();
    JButton undoButton, saveButton;

    public Undo(JTextPane textPane) {
        this.textPane = textPane;
        doc = new Originator(textPane.getText());
        histories = new Stack<>();
        createUndoButton();
    }

    private void createUndoButton() {
        undoButton = new JButton(defineImageButton.getUndoIcon());
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
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getUndoButton() {
        return undoButton;
    }

    public void undo() throws BadLocationException {
        System.out.println("復原動作");
        if (histories.empty()) {
            JOptionPane.showMessageDialog(textPane, "can't undo");
        }else {
            History history = histories.pop();
            doc.restoreHistory(history);
            textPane.setText(history.getText());
        }





    }


    @Override
    public void insertUpdate(DocumentEvent e) {


    }


    @Override
    public void removeUpdate(DocumentEvent e) {
backup();
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