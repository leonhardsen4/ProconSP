package br.gov.sp.procon.view;

import br.gov.sp.procon.utils.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class TelaLogin extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(TelaLogin.class.getResource("Login.fxml"));
        double width = Screen.getPrimary().getVisualBounds().getWidth();
        double height = Screen.getPrimary().getVisualBounds().getHeight();
        Scene scene = new Scene(fxmlLoader.load(), width, height);
        stage.setTitle("Login");
        stage.setMaximized(true);
        stage.setScene(scene);
        stage.show();
        Database.createTables();
    }

    public static void main(String[] args){
        launch();
    }

}