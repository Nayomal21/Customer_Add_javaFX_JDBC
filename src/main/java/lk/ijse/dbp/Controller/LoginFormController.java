package lk.ijse.dbp.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dbp.AppInitializer;
import lk.ijse.dbp.Connnection.JDBC;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {
    public TextField txtUserName;
    public TextField txtPassword;

    public void btnLoginOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {

       String userName=  txtUserName.getText();
        String pw = txtPassword.getText();


        JDBC jdbc = new JDBC();
        jdbc.load(userName,pw, AppInitializer.stage2);

    }


    public void btnRegisterOnAction(ActionEvent actionEvent) throws IOException {
        System.out.println("in 1");
        AnchorPane rootNode = FXMLLoader.load(this.getClass().getResource("/register_form.fxml"));
        System.out.println("in 2");
        Scene scene = new Scene(rootNode);
        Stage stage = AppInitializer.stage2;

        stage.setScene(scene);
        stage.setTitle("register Application");

        //stage.show();





    }
}
