package View;
import Controller.LoginController;
import Model.User;
import _Services.CSV;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginForm implements Initializable {

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
                String[] userArray = CSV.returnUser(getUsername());
                User user = new User(userArray[1], userArray[2], userArray[3], userArray[4]);
                //move to next page
                reset(true);
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

    @FXML
    public void buttonHandler(ActionEvent actionEvent) throws IOException {
        submitUserData(actionEvent);
    }
    public void registerbuttonHandler(ActionEvent actionEvent) throws IOException {
       //move to register page

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
