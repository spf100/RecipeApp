package Controller;

import Model.RecipeList;
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
import java.util.*;

public class RecipeListController implements Initializable {
    public Button recipe1;  public Button recipe2;  public Button recipe3;
    public Button recipe4;  public Button recipe5;

    public TextField searchField;

    public Button searchButton; public Button randomButton; public Button logoutButton;
    public Button backButton;   public Button nextButton;   public Button mainListButton;
    public Button cookbookButton;
    public Button profileButton;
    private Stage stage;    private Scene scene;    private Parent root;
    private Integer count = 1;

    List<String[]> searchList = new ArrayList<String[]>();
    List<String[]> mainList;
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
        List<String[]> list = new ArrayList<>();
        searchList = list;
        try {
            mainList = CSV.returnData(2);
        } catch (IOException e) {
            e.printStackTrace();
        }
       // System.out.println(Arrays.toString(mainList.get(1)));
    }

    public void randomButtonHandler(ActionEvent actionEvent) {
        createList();
    }
    public void mainListButtonHandler(ActionEvent actionEvent){
        List<String[]> list = new ArrayList<>();
        searchList = list;
        count = 1;
        createRecipeList(mainList);
    }
    public void logoutButtonHandler(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../View/LoginForm.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void searchButtonHandler(ActionEvent actionEvent) throws IOException {
        String input = searchField.getText();
        count = 0;
        searchList = CSV.SearchRecipes(input);
       // System.out.println("CHECK SIZE IN CONTROLLER");
        //System.out.println(searchList.size());
        if(searchList.size() != 0){
            createRecipeList(searchList);
        }else{
            //alert user there is nothing in search
        }
    }
    public void createRecipeList(List<String[]> givenList){
        RecipeList list = new RecipeList(givenList);
        if(list.size() != 0){
            int recipes = 0;
            String[] recipeList = new String[5];
           // System.out.println(count);
           // System.out.println(list.size());
            //System.out.println(list.getIndex(count, 0));

            while(count < list.size()){
                if(recipes > 4){
                    break;
                }
                recipeList[recipes] = list.getIndex(count, 0);
                count++;
                recipes++;
            }
            while(recipes < 5){
                recipeList[recipes] = "";
                count++;
                recipes++;
            }
            recipe1.setText(recipeList[0]);
            recipe2.setText(recipeList[1]);
            recipe3.setText(recipeList[2]);
            recipe4.setText(recipeList[3]);
            recipe5.setText(recipeList[4]);
        }else{
            //alert user there is nothing in search
        }
    }
    public void nextButtonHandler(ActionEvent actionEvent) throws IOException{
        if(searchList.size() != 0) {
            if (count < searchList.size()) {
                createRecipeList(searchList);
            }
        }
        else {
            if (count < mainList.size()) {
                createRecipeList(mainList);
            }
        }
    }
    public void backButtonHandler(ActionEvent actionEvent) throws IOException{
            count = count - 10;
            if(count < 1){
                count = 1;
            }
            if(searchList.size() != 0){
                createRecipeList(searchList);
            }
             else{
                createRecipeList(mainList);
            }
    }
    public void profileButtonHandler(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../View/UserProfile.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void cookbookButtonHandler(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../View/CookbookView.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void recipeHandler(){

    }
}
