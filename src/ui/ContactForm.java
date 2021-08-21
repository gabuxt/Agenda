package ui;

import javax.swing.*;

public class ContactForm extends JFrame {

    private JPanel rootPanel;
    private JLabel lbl;
    private JTextField textName;
    private JLabel lbl1;
    private JTextField textPhone;
    private JButton buttonCancel;
    private JButton buttonSave;

    public ContactForm() {

        setContentPane(rootPanel);
        setSize(500,250);
        setVisible(true);

    }

}
