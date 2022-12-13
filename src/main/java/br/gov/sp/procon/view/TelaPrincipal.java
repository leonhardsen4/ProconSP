package br.gov.sp.procon.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class TelaPrincipal extends Application {

    public static void main(String[] args){
        launch(TelaPrincipal.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(TelaLogin.class.getResource("TelaPrincipal.fxml"));
        double width = Screen.getPrimary().getVisualBounds().getWidth();
        double height = Screen.getPrimary().getVisualBounds().getHeight();
        Scene scene = new Scene(fxmlLoader.load(), width, height);
        stage.setScene(scene);
        stage.setTitle("PROCON.SP/NCA");
        stage.setMaximized(true);
        stage.show();
    }
}
