package lk.ijse.dbp.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.dbp.AppInitializer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterFormController {


    public TextField txtName;
    public TextField txtPassword;
    public TextField txtUserName;

    public void btnRegisterOnAction(ActionEvent actionEvent) throws SQLException {

        try(Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/firstProject",
                "root",
                "Ijse@123"
        )){
          String sql = "INSERT INTO LoginDetails  Values(?,?,?)";

            PreparedStatement pvsm = connection.prepareStatement(sql);

            pvsm.setObject(1,txtUserName.getText());
            pvsm.setObject(2,txtName.getText());
            pvsm.setObject(3,txtPassword.getText());

            int affected = pvsm.executeUpdate();
            System.out.println(affected);
            if (affected > 0) {
                new Alert(Alert.AlertType.CONFIRMATION,"Registration Successfully!").show();
                AppInitializer.stage2.setScene(AppInitializer.scene);

            }

        }



    }

    public void btnBackOnAction(ActionEvent actionEvent) {

       AppInitializer.stage2.setScene(AppInitializer.scene);
    }
}
