package lk.ijse.dbp.Connnection;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class JDBC {
public  void  load(String username, String password,Stage stage) throws ClassNotFoundException, SQLException, IOException {
    System.out.println("hello");

    Class.forName("com.mysql.cj.jdbc.Driver");
    System.out.println("hello2");
    System.out.println(username+"-"+password);

    try(Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/firstProject",
            "root",
            "Ijse@123"
    )){

        String sql = "SELECT password FROM LoginDetails WHERE userName = ?";


        PreparedStatement pvsm = connection.prepareStatement(sql);

        pvsm.setObject(1, username);

        ResultSet resultSet = pvsm.executeQuery();
        if(!resultSet.next()) {
            System.out.println("if in");
            new Alert(Alert.AlertType.ERROR,"unknown username").show();
             return;
        }
        String pw = resultSet.getString(1);
        if (pw.equals(password)) {
            System.out.println("succesfull");

            AnchorPane rootNode = FXMLLoader.load(this.getClass().getResource("/main_form.fxml"));

            Scene scene = new Scene(rootNode);

            stage.setScene(scene);
            stage.setTitle("main Application");

            stage.show();


        } else   new Alert(Alert.AlertType.ERROR, "Login Failed").show();


    }
}



}
