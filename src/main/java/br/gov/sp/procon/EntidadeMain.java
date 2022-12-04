package br.gov.sp.procon;

import br.gov.sp.procon.utils.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

public class EntidadeMain extends Application {
        public static void main(String[] args) throws SQLException {
            launch(EntidadeMain.class);
            Database database = new Database();
            database.createTables();
        }

        @Override
        public void start(Stage stage) throws Exception {
            FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("entidade.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 770, 600);
            stage.setScene(scene);
            stage.setTitle("Entidade");
            stage.show();
        }
    }

