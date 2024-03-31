package lk.ijse.dbp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class AppInitializer extends Application {

  public   static Stage stage2;
  public  static  Scene scene;
    public static void main(String[] args) {

              launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {
        //load scene graph to our java method
        AnchorPane rootNode = FXMLLoader.load(this.getClass().getResource("/login_form.fxml"));
stage2=stage;
         scene = new Scene(rootNode);
        stage.setScene(scene);
        stage.setTitle("login Application");

        stage.show();
}}
