package Controller;

import javax.swing.*;
import Controller.RegisterController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RegisterForm extends JPanel {

    private Stage stage;
    private Scene scene;
    private Parent root;
    public Button cancelButton;
    public Button registerButton;
    public PasswordField passwordField;
    public PasswordField confirmPassword;
    public TextField usernameField;
    public TextField firstNameField;
    public TextField lastNameField;

    public RegisterForm(){



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

    public void submitUserData(ActionEvent actionEvent) throws IOException {
        if(!getUsername().equals("") && !getPassword().equals("") && !getConfirmPassword().equals("")){
            if(getPassword().equals(getConfirmPassword())){
                if(RegisterController.submitUserData(getUsername(), getPassword(), getFirstName(), getLastName())){
                    //move to next page;
                    reset(true);
                    root = FXMLLoader.load(getClass().getResource("LoginForm.fxml"));
                    stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
            }
        }
        //alert user
    }

    public void reset(boolean bool){
        if(bool){
            usernameField.setText("");
            passwordField.setText("");
            confirmPassword.setText("");
            firstNameField.setText("");
            lastNameField.setText("");
        }
    }

    public void cancelButtonHandler(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("LoginForm.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void registerButtonHandler(ActionEvent actionEvent) throws IOException {
        submitUserData(actionEvent);
    }
}
