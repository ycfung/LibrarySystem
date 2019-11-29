package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField textField;

    @FXML
    private JFXPasswordField passwordField;

    @FXML
    private JFXButton LoginBtn;

    @FXML
    void initialize() {
        assert textField != null : "fx:id=\"textField\" was not injected: check your FXML file 'LoginUI.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'LoginUI.fxml'.";
        assert LoginBtn != null : "fx:id=\"LoginBtn\" was not injected: check your FXML file 'LoginUI.fxml'.";

        System.out.println("Login UI Initialized");

    }
}
