package br.gov.sp.procon;

import br.gov.sp.procon.model.Usuario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class TelaPrincipal extends Application {

    public TelaPrincipal(){
    }
    public TelaPrincipal(Usuario usuario) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("TelaPrincipal.fxml"));
        double width = Screen.getPrimary().getVisualBounds().getWidth();
        double height = Screen.getPrimary().getVisualBounds().getHeight();
        Scene scene = new Scene(fxmlLoader.load(), width, height);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("PROCON.SP/NCA");
        stage.show();
        System.out.println("Tela Principal - Usuário logado: ID: "
                + usuario.getId() + " - Usuário: "
                + usuario.getUsuario() + " - Nome: "
                + usuario.getNome());
    }

    public static void main(String[] args){
        launch(TelaPrincipal.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("TelaPrincipal.fxml"));
        double width = Screen.getPrimary().getVisualBounds().getWidth();
        double height = Screen.getPrimary().getVisualBounds().getHeight();
        Scene scene = new Scene(fxmlLoader.load(), width, height);
        stage.setScene(scene);
        stage.setTitle("PROCON.SP/NCA");
        stage.show();
    }
}
