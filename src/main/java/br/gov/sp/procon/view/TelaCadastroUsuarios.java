package br.gov.sp.procon.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaCadastroUsuarios extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(TelaLogin.class.getResource("TelaCadastroUsuario.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 356, 225);
        stage.setScene(scene);
        stage.setTitle("CADASTRO DE USUÁRIOS");
        stage.setResizable(false);
        stage.show();
    }
}
