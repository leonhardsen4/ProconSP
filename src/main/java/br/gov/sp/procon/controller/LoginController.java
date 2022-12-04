package br.gov.sp.procon.controller;


import br.gov.sp.procon.utils.ConnectionFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    Connection conn;
    PreparedStatement stmt;
    ResultSet rs;
    String sql;

    @FXML
    private Button btnEntrar;
    @FXML
    private Button btnCadastrar;
    @FXML
    private Label lblErroUsuario;
    @FXML
    private Label lblErroSenha;
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtSenha;

    public Boolean verifyUser(String usuario) throws SQLException{
        conn = ConnectionFactory.getConnection();
        sql = "SELECT * FROM USUARIOS WHERE USUARIO = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, usuario);
        rs = stmt.executeQuery();
        if(rs.next()){
            ConnectionFactory.closeConnection(conn, stmt, rs);
            lblErroUsuario.setVisible(false);
            return true;
        }else{
            ConnectionFactory.closeConnection(conn, stmt, rs);
            lblErroUsuario.setText("Usuário não encontrado");
            lblErroUsuario.setVisible(true);
            return false;
        }
    }

    public Boolean verifyPassword (String usuario, String senha) throws SQLException {
        if (verifyUser(usuario)) {
            conn = ConnectionFactory.getConnection();
            sql = "SELECT USUARIO FROM USUARIOS WHERE SENHA = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, senha);
            rs = stmt.executeQuery();
            if (rs.next()) {
                ConnectionFactory.closeConnection(conn, stmt, rs);
                lblErroSenha.setVisible(false);
                System.out.println("Login realizado com sucesso!");
                return true;
            }else{
                ConnectionFactory.closeConnection(conn, stmt, rs);
                lblErroSenha.setText("Senha incorreta");
                lblErroSenha.setVisible(true);
            }
        }
        return false;
    }

    public void verifyUser(ActionEvent actionEvent) throws SQLException {
        String usuario = txtUsuario.getText();
        String senha = txtSenha.getText();
        verifyPassword(usuario, senha);
    }

    public void closeWindow(){
        Stage stage = (Stage) btnCadastrar.getScene().getWindow();
        stage.close();
    }

    public void setFocusTxtSenha(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            txtSenha.requestFocus();
        }
    }

    public void setFocusBtnEntrar(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            btnEntrar.requestFocus();
        }
    }

    //    public void openCadastro(ActionEvent actionEvent) throws IOException {
//            FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("cadastro-view.fxml"));
//            Scene scene = new Scene(fxmlLoader.load(), 400, 400);
//            Stage stage = new Stage();
//            stage.setTitle("Cadastro");
//            stage.setScene(scene);
//            stage.show();
//    }
}