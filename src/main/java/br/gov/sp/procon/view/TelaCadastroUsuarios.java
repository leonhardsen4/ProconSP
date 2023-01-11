package br.gov.sp.procon.view;

import br.gov.sp.procon.controller.CadastroUsuarioController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaCadastroUsuarios extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(TelaLogin.class.getResource("TelaCadastroUsuario.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 356, 225);
        stage.setScene(scene);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.setTitle("CADASTRO DE USUÁRIOS");
        stage.setResizable(false);
        stage.show();
    }

}
