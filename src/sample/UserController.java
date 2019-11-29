package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;

public class UserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Tab searchTab;

    @FXML
    private JFXComboBox<String> searchComboBox;

    @FXML
    private JFXTextField searchTextField;

    @FXML
    private JFXButton searchSearchBtn;

    @FXML
    private JFXTreeTableView<?> searchTableView;

    @FXML
    private JFXButton searchBorrowBtn;

    @FXML
    private Tab BorrowTab;

    @FXML
    private JFXTextField borrowTextField;

    @FXML
    private JFXButton borrowSearchBtn;

    @FXML
    private JFXButton borrowResetBtn;

    @FXML
    private JFXButton borrowBorrowBtn;

    @FXML
    private JFXButton borrowRenewBtn;

    @FXML
    private JFXTextArea borrowTextArea;

    @FXML
    private JFXTextField returnTextField;

    @FXML
    private JFXButton returnSearchBtn;

    @FXML
    private JFXButton returnResetBtn;

    @FXML
    private JFXButton returnReturnBtn;

    @FXML
    private JFXTextArea returnTestArea;

    @FXML
    private Tab historyTab;

    @FXML
    private JFXTreeTableView<?> historyTableView;

    @FXML
    private JFXButton historyRefreshBtn;

    @FXML
    private Tab InfoTab;

    @FXML
    private JFXTextField infoName;

    @FXML
    private JFXTextField infoID;

    @FXML
    private JFXTextField infoBalance;

    @FXML
    private JFXTextField infoBorrowCount;

    @FXML
    void initialize() {
        assert searchTab != null : "fx:id=\"searchTab\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert searchComboBox != null : "fx:id=\"searchChoiceBox\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert searchTextField != null : "fx:id=\"searchTextField\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert searchSearchBtn != null : "fx:id=\"searchSearchBtn\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert searchTableView != null : "fx:id=\"searchTableView\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert searchBorrowBtn != null : "fx:id=\"searchBorrowBtn\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert BorrowTab != null : "fx:id=\"BorrowTab\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert borrowTextField != null : "fx:id=\"borrowTextField\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert borrowSearchBtn != null : "fx:id=\"borrowSearchBtn\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert borrowResetBtn != null : "fx:id=\"borrowResetBtn\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert borrowBorrowBtn != null : "fx:id=\"borrowborrowBtn\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert borrowRenewBtn != null : "fx:id=\"borrowRenewBtn\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert borrowTextArea != null : "fx:id=\"borrowTextArea\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert returnTextField != null : "fx:id=\"returnTextField\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert returnSearchBtn != null : "fx:id=\"returnSearchBtn\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert returnResetBtn != null : "fx:id=\"returnResetBtn\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert returnReturnBtn != null : "fx:id=\"returnReturnBtn\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert returnTestArea != null : "fx:id=\"returnTestArea\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert historyTab != null : "fx:id=\"historyTab\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert historyTableView != null : "fx:id=\"historyTableView\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert historyRefreshBtn != null : "fx:id=\"historyRefreshBtn\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert InfoTab != null : "fx:id=\"InfoTab\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert infoName != null : "fx:id=\"infoName\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert infoID != null : "fx:id=\"infoID\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert infoBalance != null : "fx:id=\"infoBalance\" was not injected: check your FXML file 'UserUI.fxml'.";
        assert infoBorrowCount != null : "fx:id=\"infoBorrowCount\" was not injected: check your FXML file 'UserUI.fxml'.";


        searchComboBox.setItems(FXCollections.observableArrayList("按标题","按xx","按yy"));
        System.out.println("User UI Initialized");

    }
}
