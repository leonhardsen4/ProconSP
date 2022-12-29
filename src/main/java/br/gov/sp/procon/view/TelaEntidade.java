package br.gov.sp.procon.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaEntidade extends Application {

        public static void main(String[] args) {
            launch(TelaEntidade.class);
        }
        @Override
        public void start(Stage stage) throws Exception {
            FXMLLoader fxmlLoader = new FXMLLoader(TelaLogin.class.getResource("Entidade.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 770, 600);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("ENTIDADE");
            stage.show();
        }
    }

