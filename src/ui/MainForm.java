package ui;

import business.ContactBusiness;
import entity.ContactEntity;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainForm extends JFrame {

    private JPanel rootPanel;
    private JButton buttonNewContact;
    private JButton buttonRemove;
    private JTable tableContacts;
    private JLabel labelContactCount;

    private ContactBusiness mContactBusiness;
    private String mName = "";
    private String mPhone = "";

    public MainForm() {

        // Configurando a janela do programa(MainForm) e a tornando visivel  (Setting the program Panel(MainForm) and making it visible)
        setContentPane(rootPanel);
        setSize(500,250);
        setVisible(true);

        // Colocando a janela(MainForm) no meio da tela (set the panel(MainForm) in middle of the screen)
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);

        // Comando para parar o programa depois de fechar a janela(Mainform) (comand for stop the program after close de panel(Mainform))
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // chamando função de configurar o clique dos botões (calling function to configure the click of buttons)
        setListeners();

        mContactBusiness = new ContactBusiness();
        loadContacts();
    }

    private void loadContacts(){

        List<ContactEntity> listContact = mContactBusiness.getListContact();

        String[] columnNames = {"nomme","telefone"};
        DefaultTableModel model = new DefaultTableModel(new Object[0][0], columnNames);

        for (ContactEntity contact : listContact){

            Object[] obj = new Object[2];

            obj[0] = contact.getName();
            obj[1] = contact.getPhone();

            model.addRow(obj);
        }

        tableContacts.clearSelection();
        tableContacts.setModel(model);

        labelContactCount.setText(mContactBusiness.getContactCountDescription());
    }

    private void setListeners(){

        // Criando a ação que será realizada ao clicar no botão de criar novo contato (Creating the action that will be performed when clicking the create new contact button)
        buttonNewContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Chamando a janela de cadastro de novo contato(ContactForm) (calling the panel of register new contact(ContactForm))
                new ContactForm();

                // Fechamdo a janela principal(MainForm) e deixando só a de criação de novo contato(ContactForm) Closing the main window (MainForm) and leaving only the new contact creation window (ContactForm)
                dispose();

            }
        });

        tableContacts.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(e.getValueIsAdjusting()){

                    if(tableContacts.getSelectedRow() != -1){
                        mName = tableContacts.getValueAt(tableContacts.getSelectedRow(), 0).toString();
                        mPhone = tableContacts.getValueAt(tableContacts.getSelectedRow(), 1).toString();
                    }

                }
            }
        });

        // Criando a ação que será realizada ao clicar no botão remover (Creating the action that will be performed when clicking the remove button)
        buttonRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    mContactBusiness.removeContact(mName, mPhone);
                    loadContacts();
                    mName = "";
                    mPhone = "";
                }catch (Exception excp){
                    JOptionPane.showMessageDialog(new JFrame(), excp.getMessage());
                }
            }
        });
    }
}
