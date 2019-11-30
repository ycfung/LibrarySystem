package controller;

import controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginUI.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/AdminUI.fxml"));
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
        //Parent root = FXMLLoader.load(getClass().getResource("LoginUI.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/view/AdminUI.fxml"));
        Scene scene = new Scene(root);
        LoginController controller = fxmlLoader.getController();
        scene.getStylesheets().add(getClass().getResource("/view/styles/global.css").toExternalForm());
        stage.setResizable(false);
        stage.setTitle("Title");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
