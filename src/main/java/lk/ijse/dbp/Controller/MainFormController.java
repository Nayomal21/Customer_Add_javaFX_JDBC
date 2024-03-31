package lk.ijse.dbp.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.dbp.AppInitializer;
import lk.ijse.dbp.Connnection.Customer;

import java.sql.*;

public class MainFormController {
    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colTel;

    @FXML
    private TableView<Customer> tblCustomer;


    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtTel;

    public  void initialize() throws SQLException {
        loadAllCustomer();
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));

        colName.setCellValueFactory(new PropertyValueFactory<>("name"));

        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));

        colTel.setCellValueFactory(new PropertyValueFactory<>("tel"));




    }

    private void loadAllCustomer() throws SQLException {
        ObservableList<Customer> obList = FXCollections.observableArrayList();

        try(Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/firstProject",
                "root",
                "Ijse@123"
        )){
           String sql = "SELECT * FROM customers";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            int i=0;
            while (resultSet.next()){

                obList.add(new Customer((resultSet.getString("id")),(resultSet.getString("name")),(resultSet.getString("address")),(resultSet.getString("tel"))));



            }

            tblCustomer.setItems(obList);

        }


    }


    public void btnSaveOnAction(ActionEvent actionEvent) throws SQLException {

        try(Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/firstProject",
                "root",
                "Ijse@123"
        )){

            String sql = "INSERT INTO customers  Values(?,?,?,?)";

            PreparedStatement pvsm = connection.prepareStatement(sql);

            pvsm.setObject(1,txtId.getText());
            pvsm.setObject(2,txtName.getText());
            pvsm.setObject(3,txtAddress.getText());
            pvsm.setObject(4,txtTel.getText());

            int affected = pvsm.executeUpdate();
            System.out.println(affected);




        }

loadAllCustomer();



    }

    public void btnBackOnAction(ActionEvent actionEvent) {

        AppInitializer.stage2.setScene(AppInitializer.scene);
    }
}
