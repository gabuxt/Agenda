package ui;

import business.ContactBusiness;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame {

    private JPanel rootPanel;
    private JLabel lbl;
    private JTextField textName;
    private JLabel lbl1;
    private JTextField textPhone;
    private JButton buttonCancel;
    private JButton buttonSave;

    private ContactBusiness mContactBusiness;

    public ContactForm() {

        // Configurando a janela do programa(ContactForm) e a tornando visivel  (Setting the program Panel(ContactForm) and making it visible)
        setContentPane(rootPanel);
        setSize(500,250);
        setVisible(true);

        // Colocando a janela(ContactForm) no meio da tela (set the panel(ContactForm) in middle of the screen)
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);

        // Comando para parar o programa depois de fechar a janela(ContactForm) (comand for stop the program after close de panel(ContactForm))
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mContactBusiness = new ContactBusiness();

        // chamando função de configurar o clique dos botões (calling function to configure the click of buttons)
        setListeners();

    }

    private void setListeners() {

        // Criando a ação que será realizada ao clicar no botão Salvar (Creating the action that will be performed when clicking the Save button)
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    String name = textName.getText();
                    String phone = textPhone.getText();

                    mContactBusiness.saveNewContact(name, phone);

                    // Chamando a janela de de listagem de contatos(MainForm) (Calling the Contact List panel(MainForm))
                    new MainForm();

                    // Fechamdo a janela de criação de novo contado(ContactForm) e deixando só a janela de listagem de contatos(MainForm) (Closing the panel for creating a new contact(ContactForm) and leaving only the panel for listing contacts(MainForm))
                    dispose();

                }catch (Exception excp){
                    JOptionPane.showMessageDialog(new JFrame(), excp.getMessage());
                }
            }
        });

        // Criando a ação que será realizada ao clicar no botão Cancelar (Creating the action that will be performed when clicking the cancel button)
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Chamando a janela de de listagem de contatos(MainForm) (Calling the Contact List panel(MainForm))
                new MainForm();

                // Fechamdo a janela de criação de novo contado(ContactForm) e deixando só a janela de listagem de contatos(MainForm) (Closing the panel for creating a new contact(ContactForm) and leaving only the panel for listing contacts(MainForm))
                dispose();

            }
        });

    }
    }

