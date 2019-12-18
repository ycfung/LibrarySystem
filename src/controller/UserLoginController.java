package controller;

import com.jfoenix.controls.*;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class UserLoginController {
    //controllerType can be user or admin
    String controllerType = "user";

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

    void showFailedDialog() {
        JFXDialogLayout content = new JFXDialogLayout();
        content.setHeading(new Text("错误"));
        content.setBody(new Text("用户名或密码错误，请重新输入"));
        JFXDialog dialog = new JFXDialog(stackpane, content, JFXDialog.DialogTransition.CENTER);
        JFXButton OK = new JFXButton("确定");
        OK.setOnAction(event -> dialog.close());
        content.setActions(OK);
        dialog.show();
    }

    @FXML
    void initialize() {
        assert textField != null : "fx:id=\"textField\" was not injected: check your FXML file 'AdminLoginUI.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file 'AdminLoginUI.fxml'.";
        assert LoginBtn != null : "fx:id=\"LoginBtn\" was not injected: check your FXML file 'AdminLoginUI.fxml'.";
        assert stackpane != null : "fx:id=\"stackpane\" was not injected: check your FXML file 'AdminLoginUI.fxml'.";

        stackpane.setOnKeyPressed(event -> {
            if (event.getCode().toString().equals("ENTER"))
                LoginBtn.fire();
        });
        LoginBtn.setOnAction(event -> {
            LoginBtn.setOpacity(0.67);
            textField.setDisable(true);
            passwordField.setDisable(true);
            new Thread(() -> {
                String passwd;
                Login.user_id = textField.getText();
                MainAdmin.user_id = Login.user_id;
                passwd = passwordField.getText();
                Boolean log = false;
                System.out.println(Login.user_id);
                System.out.println(passwd);
                log = LibraryBorrower.login(Login.user_id, passwd);
                if (log) {
                    //切换到用户界面
                    try {
                        Platform.runLater(() -> {
                            try {
                                stage.close();
                                if (controllerType.equals("user")) {
                                    second_main second = new second_main();
                                    second.showWindow();
                                } else if (controllerType.equals("admin")) {
                                    Second second = new Second();
                                    second.showWindow();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    Platform.runLater(() -> {
                        //JOptionPane.showMessageDialog(null, "用户名或者密码错误请重新输入", "提示", JOptionPane.WARNING_MESSAGE);
                        showFailedDialog();
                        textField.setDisable(false);
                        passwordField.setDisable(false);
                        LoginBtn.setOpacity(1);
                    });

                }

            }).start();


        });

    }
}