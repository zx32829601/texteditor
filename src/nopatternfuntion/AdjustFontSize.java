package nopatternfuntion;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;

public class AdjustFontSize {
    JComboBox comboBox;
    Integer[] ITEMS = { 9, 10, 11, 12, 14, 16, 18, 20, 24, 32 };

    public AdjustFontSize(){
        comboBox = new JComboBox(ITEMS);
        addFunction();
        adjustBoxSize();
    }
    public void addFunction(){
        comboBox.addActionListener(e -> {

            int size = (Integer) comboBox.getSelectedItem();

            Action fontAction = new StyledEditorKit.FontSizeAction(String

                    .valueOf(size), size);

            fontAction.actionPerformed(e);

        });
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public void adjustBoxSize(){
        comboBox.setMaximumSize(comboBox.getPreferredSize());
        comboBox.setMaximumRowCount(8);
    }
}
