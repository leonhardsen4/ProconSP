package br.gov.sp.procon.controller;


import br.gov.sp.procon.view.TelaUsuarios;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaPrincipalController implements Initializable{
    @FXML public BorderPane telaPrincipal;
    @FXML public ImageView proconSPLogoImage;
    @FXML public Button btnUsuarios;
    @FXML public Label lblUsuario;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File proconSPFile = new File("images/procon-sp-logo.png");
        Image proconSPLogo = new Image(proconSPFile.toURI().toString());
        proconSPLogoImage.setImage(proconSPLogo);
        lblUsuario.setText("Olá, " + LoginController.uLogado.getNome() + "!");
    }

    public void abrirUsuarios() throws Exception {
        TelaUsuarios telaUsuarios = new TelaUsuarios();
        telaUsuarios.start(new Stage());
        System.out.println("O usuário " + LoginController.uLogado.getUsuario() + " entrou na tela de usuários.");

    }
}
