package br.gov.sp.procon.controller;

import br.gov.sp.procon.Login;
import br.gov.sp.procon.model.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaPrincipalController implements Initializable{
    @FXML
    public BorderPane telaPrincipal;
    @FXML
    public ImageView proconSPLogoImage;
    @FXML
    public Button btnUsuarios;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File proconSPFile = new File("images/procon-sp-logo.png");
        Image proconSPLogo = new Image(proconSPFile.toURI().toString());
        proconSPLogoImage.setImage(proconSPLogo);
    }

    public void abrirUsuarios() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("Usuarios.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 354);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("USUÁRIOS");
        stage.setResizable(false);
        stage.show();
        Usuario usuario = LoginController.usuarioLogado;
        System.out.println("Tela Usuários - Usuário logado: ID: "
                + usuario.getId() + " - Usuário: "
                + usuario.getUsuario() + " - Nome: "
                + usuario.getNome());
    }
}
