package Controller;

import _Services.CSV;
import javafx.event.ActionEvent;
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
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class RecipeListController implements Initializable {
    public Button recipe1;
    public Button recipe5;
    public Button recipe2;
    public Button recipe3;
    public Button recipe4;
    public TextField searchField;
    public Button searchButton;
    public Button randomButton;
    public Button logoutButton;
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void recipeHandler(ActionEvent actionEvent) {
    }

    public void searchButtonHandler(ActionEvent actionEvent) {
    }

    public void createList(){
        List<String[]> recipeList = new ArrayList<>();
        try {
            recipeList = CSV.returnData(2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int low = 1;
        int high = recipeList.size()-1;

        Random r = new Random();
        int result;
        String[] array;
        for(int i = 0; i < 5; i++){
            result = r.nextInt(high-low) + low;
            array = recipeList.get(result);
            switch(i){
                case 0:
                    recipe1.setText(array[0]);
                    break;
                case 1:
                    recipe2.setText(array[0]);
                    break;
                case 2:
                    recipe3.setText(array[0]);
                    break;
                case 3:
                    recipe4.setText(array[0]);
                    break;
                case 4:
                    recipe5.setText(array[0]);
                    break;
            }
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       createList();
    }

    public void randomButtonHandler(ActionEvent actionEvent) {
        createList();
    }
    public void logoutButtonHandler(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("LoginForm.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
    
}
