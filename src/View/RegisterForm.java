package View;

import javax.swing.*;
import Controller.RegisterController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegisterForm extends JPanel {

    private JTextField usernameField;
    private JTextField passwordField;
    private JTextField confirmPasswordField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JButton submitButton;
    private JButton cancelButton;

    public RegisterForm(){

        JLabel usernameLabel = new JLabel("Username: ");
        JLabel passwordLabel = new JLabel("Password: ");
        JLabel firstNameLabel = new JLabel("First Name:");
        JLabel lastNameLabel = new JLabel("Last Name");

        usernameField = new JTextField(30);
        passwordField = new JTextField(30);
        firstNameField = new JTextField(30);
        lastNameField = new JTextField(30);
        confirmPasswordField = new JTextField(30);


        submitButton = new JButton("Login");
        submitButton.setPreferredSize(new Dimension(278, 40));
        cancelButton = new JButton("Register");
        cancelButton.setPreferredSize(new Dimension(278, 40));

        Insets fieldsInset = new Insets(0,0,10,0);
        Insets buttonInset = new Insets(20, 0, 0, 0);


    }

    public String getUsername(){
        return usernameField.getText();
    }
    public String getPassword(){
        return passwordField.getText();
    }
    public String getConfirmPassword(){return passwordField.getText();}
    public String getFirstName(){ return firstNameField.getText();}
    public String getLastName(){return lastNameField.getText();}
    public void submitUserData(ActionListener actionListener){
        submitButton.addActionListener(actionListener);
    }

    public void reset(boolean bool){
        if(bool){
            usernameField.setText("");
            passwordField.setText("");
        }
    }

}
