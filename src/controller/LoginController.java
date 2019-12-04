package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.io.Closeable;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class LoginController {

    @FXML
    private StackPane stackpane;

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

    static public Stage stage;

    public void set_stage(Stage s) {
        stage = s;
    }

    @FXML
    void initialize() {
        assert textField != null : "fx:id=\"textField\" was not injected: check your FXML file 'LoginUI.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'LoginUI.fxml'.";
        assert LoginBtn != null : "fx:id=\"LoginBtn\" was not injected: check your FXML file 'LoginUI.fxml'.";
        assert stackpane != null : "fx:id=\"stackpane\" was not injected: check your FXML file 'LoginUI.fxml'.";
        LoginBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String passwd;
                Login.user_id = textField.getText();
                passwd = passwordField.getText();
                Boolean log = false;
                log = LibraryAdministrator.login(Login.user_id, passwd);
                if (log) {
                    //切换到用户界面
                    stage.close();
                    Second second = new Second();
                    try {
                        second.showWindow();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "用户名或者密码错误请重新输入",
                            "提示", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

    }
}