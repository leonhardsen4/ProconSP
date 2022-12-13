package br.gov.sp.procon.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaUsuarios extends Application {

    public static void main(String[] args){
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(TelaLogin.class.getResource("Usuarios.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 354);
        stage.setScene(scene);
        stage.setTitle("USUÁRIOS");
        stage.setResizable(false);
        stage.show();
    }

}
