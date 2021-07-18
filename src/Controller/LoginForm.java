package Controller;
import Controller.LoginController;
import Model.User;
import Model.UserHolder;
import _Services.CSV;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginForm implements Initializable {

    public Button submitButton;
    public TextField passwordField;
    public TextField usernameField;
    public Button registerButton;
    private Stage stage;
    private Scene scene;
    private Parent root;
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
                UserHolder holder = UserHolder.getInstance();

                holder.setUser(user);

                //System.out.println(getUsername());
                //move to next page
                reset(true);
                root = FXMLLoader.load(getClass().getResource("UserProfile.fxml"));
                stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
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
        root = FXMLLoader.load(getClass().getResource("RegisterForm.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
