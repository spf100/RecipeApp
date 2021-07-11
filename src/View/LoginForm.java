package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginForm extends JPanel {

    private JTextField usernameField;
    private JTextField passwordField;

    private JButton loginButton;

    public LoginForm(){

        JLabel usernameLabel = new JLabel("Username: ");
        JLabel passwordLabel = new JLabel("Password: ");

        usernameField = new JTextField(30);
        passwordField = new JTextField(30);

        loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(278, 40));


        Insets fieldsInset = new Insets(0,0,10,0);
        Insets buttonInset = new Insets(20, 0, 0, 0);


    }

    public String getUsername(){
        return usernameField.getText();
    }
    public String getPassword(){
        return passwordField.getText();
    }
    public void submitUserData(ActionListener actionListener){
        loginButton.addActionListener(actionListener);
    }

    public void reset(boolean bool){
        if(bool){
            usernameField.setText("");
            passwordField.setText("");
        }
    }

}
