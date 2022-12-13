package br.gov.sp.procon.view;

import br.gov.sp.procon.utils.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

public class TelaEntidade extends Application {
        public static void main(String[] args) throws SQLException {
            launch(TelaEntidade.class);
            Database.createTables();
        }

        @Override
        public void start(Stage stage) throws Exception {
            FXMLLoader fxmlLoader = new FXMLLoader(TelaLogin.class.getResource("Entidade.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 770, 600);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Entidade");
            stage.show();
        }
    }

