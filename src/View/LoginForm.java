package View;
import Controller.LoginController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoginForm extends JPanel {

    public Button submitButton;
    public TextField passwordField;
    public TextField usernameField;
    public Button registerButton;

    public String getUsername(){
        return usernameField.getText();
    }
    public String getPassword(){
        return passwordField.getText();
    }



    public void submitUserData(ActionEvent actionEvent) throws IOException {
        if(!getUsername().equals("") && !getPassword().equals("")){
            if(LoginController.submitUserData(getUsername(), getPassword())){
                //move to next page
            }
        }
        //else provide user an alert

    }

    public void reset(boolean bool){
        if(bool){
            usernameField.setText("");
            passwordField.setText("");
        }
    }

    public void buttonHandler(ActionEvent actionEvent) throws IOException {
        submitUserData(actionEvent);
    }
    public void registerbuttonHandler(ActionEvent actionEvent) throws IOException {
       //move to register page
    }
}
