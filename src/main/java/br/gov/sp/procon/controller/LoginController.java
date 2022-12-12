package br.gov.sp.procon.controller;

import br.gov.sp.procon.TelaPrincipal;
import br.gov.sp.procon.model.Usuario;
import br.gov.sp.procon.utils.ConnectionFactory;
import br.gov.sp.procon.utils.PasswordUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    public Button btnEntrar;
    @FXML
    public PasswordField txtSenha;
    @FXML
    public TextField txtUsuario;
    @FXML
    public BorderPane bpTelaLogin;
    @FXML
    private ImageView imageLogo;

    static Usuario usuarioLogado;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File proconSPFile = new File("images/procon-sp-logo.png");
        Image proconSPLogo = new Image(proconSPFile.toURI().toString());
        imageLogo.setImage(proconSPLogo);
    }

    public void login() {
        if(!txtUsuario.getText().isBlank() && !txtSenha.getText().isEmpty()){
            validarLogin();
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Atenção!");
            alert.setContentText("Ambos os campos usuário e senha precisam ser preenchidos.");
            alert.showAndWait();
            txtUsuario.setText("");
            txtSenha.setText("");
            txtUsuario.requestFocus();
        }
    }

    private void validarLogin() {
        Connection conn = ConnectionFactory.getConnection();
        String usuario = txtUsuario.getText();
        String senha = txtSenha.getText();
        String sql = "SELECT * FROM USUARIO WHERE USUARIO = " + usuario + " AND SENHA = " + senha + ";";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(!rs.next()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Atenção!");
                alert.setContentText("Um dos campos 'usuário' ou 'senha' (ou ambos) está incorreto.");
                alert.showAndWait();
                txtUsuario.setText("");
                txtSenha.setText("");
                txtUsuario.requestFocus();
            } else {
                usuarioLogado = new Usuario();
                usuarioLogado.setId(rs.getInt("ID"));
                usuarioLogado.setUsuario(rs.getString("USUARIO"));
                usuarioLogado.setNome(rs.getString("NOME"));
                usuarioLogado.setSenha(rs.getString("SENHA"));
                new TelaPrincipal(usuarioLogado);
                fecharLogin();
            }
            rs.close();
            stmt.close();
            ConnectionFactory.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    private void fecharLogin() {
        Stage stage = (Stage) bpTelaLogin.getScene().getWindow();
        stage.close();
    }


    public void focarSenha(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            txtSenha.requestFocus();
        }
    }

    public void cliqueBtnEntrar(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            login();
        }
    }
}