package Controller;

import Model.User;
import Model.UserHolder;
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

public class UserProfileController implements Initializable {


    public TextField usernameField;
    public TextField firstNameField;
    public TextField lastNameField;
    public TextField passwordField;
    public Button cookbookButton;
    public Button recipeButton;
    public Button logoutButton;
    private Stage stage;
    private Scene scene;
    private Parent root;
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

    public void recipeListButtonHandler(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../View/RecipeList.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void logoutButtonHandler(ActionEvent actionEvent) throws IOException{
        root = FXMLLoader.load(getClass().getResource("LoginForm.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
