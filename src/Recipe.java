import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Recipe extends Application {

    public static void main(String[] args)  {
        // runs in AWT thread
       launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try{
            Parent root =  FXMLLoader.load(getClass().getResource("View/LoginForm.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch(Exception e){
            e.printStackTrace();
        }


    }

}
