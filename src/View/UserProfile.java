package View;

import Model.User;
import Model.UserHolder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class UserProfile implements Initializable {


    public TextField usernameField;
    public TextField firstNameField;
    public TextField lastNameField;
    public TextField passwordField;
    public Button cookbookButton;

    public void presentData(User user){

    }

    @FXML
    public void cookbookButtonHandler(ActionEvent actionEvent) {

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UserHolder holder = UserHolder.getInstance();
        User user = holder.getUser();
        String firstname = user.getFirstName();
        String lastname = user.getLastName();
        String username = user.getUsername();
        String password = user.getPassword();
        firstNameField.setText(firstname);
        lastNameField.setText(lastname);
        usernameField.setText(username);
        passwordField.setText(password);
    }
}
