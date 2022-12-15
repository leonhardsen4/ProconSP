package br.gov.sp.procon.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaAcoesEntidade extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(TelaLogin.class.getResource("AcoesEntidade.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 500);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Ações de Entidade");
        stage.show();
    }

}
