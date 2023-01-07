package br.gov.sp.procon.controller;

import br.gov.sp.procon.dao.UsuarioDAO;
import br.gov.sp.procon.model.Usuario;
import br.gov.sp.procon.utils.PasswordUtil;
import br.gov.sp.procon.view.TelaCadastroUsuarios;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CadastroUsuarioController implements Initializable {

    @FXML public TextField txtID;
    @FXML public TextField txtUsuario;
    @FXML public PasswordField txtSenha;
    @FXML public TextField txtNome;
    @FXML public TextField txtSobrenome;
    @FXML public TextField txtEmail;
    @FXML public Button btnLimpar;
    @FXML public Button btnSalvar;
    @FXML public Button btnFechar;

    UsuarioDAO usuarioDAO = new UsuarioDAO();
    UsuarioController usuarioController = new UsuarioController();
    Usuario usuario = new Usuario();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtID.isDisabled();
        txtUsuario.requestFocus();
    }


    public void salvarUsuario() {
        if(txtUsuario.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Atenção!");
            alert.setContentText("O campo 'Usuário' é de preenchimento obrigatório.");
            alert.showAndWait();
            limparCampos();
        } else if (txtSenha.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Atenção!");
            alert.setContentText("O campo 'Senha' é de preenchimento obrigatório.");
            alert.showAndWait();
            limparCampos();
        } else if (txtNome.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Atenção!");
            alert.setContentText("O campo 'Nome' é de preenchimento obrigatório.");
            alert.showAndWait();
            limparCampos();
        } else{
            if(txtID.getText().isEmpty()){
                usuario.setUsuario(txtUsuario.getText());
                usuario.setSenha(PasswordUtil.criptografa256(txtSenha.getText()));
                usuario.setNome(txtNome.getText());
                usuario.setSobreNome(txtSobrenome.getText());
                usuario.setEmail(txtEmail.getText());
                usuarioDAO.adicionar(usuario);
            }else{
                usuario.setUsuario(txtUsuario.getText());
                usuario.setSenha(PasswordUtil.criptografa256(txtSenha.getText()));
                usuario.setNome(txtNome.getText());
                usuario.setSobreNome(txtSobrenome.getText());
                usuario.setEmail(txtEmail.getText());
                usuarioDAO.editar(usuario);
            }
            fecharTela();
        }
    }

    public void salvarUsuario(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            salvarUsuario();
        }
    }

    public void limparCampos() {
        txtUsuario.setText("");
        txtSenha.setText("");
        txtNome.setText("");
        txtSobrenome.setText("");
        txtEmail.setText("");
        txtUsuario.requestFocus();
    }

    public void focoSenha(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            txtSenha.requestFocus();
        }
    }

    public void focoNome(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            txtNome.requestFocus();
        }
    }

    public void focoSobreNome(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            txtSobrenome.requestFocus();
        }
    }

    public void focoEmail(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            txtEmail.requestFocus();
        }
    }

    public void focoBtnSalvar(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            btnSalvar.requestFocus();
        }
    }

    public void chamarTelaCadastroUsuario() throws Exception {
        TelaCadastroUsuarios telaCadastroUsuarios = new TelaCadastroUsuarios();
        telaCadastroUsuarios.start(new Stage());
    }

    public void editarUsuario(Usuario usuario) throws Exception {
        TelaCadastroUsuarios telaCadastroUsuarios = new TelaCadastroUsuarios();
        telaCadastroUsuarios.start(new Stage());
        txtID.setText(String.valueOf(usuarioController.usr.getId()));
    }

    public void fecharTela() {
        try {
            usuarioController.atualizarTabela();
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex.getCause();
            throw new RuntimeException(ex.getMessage());
        }
        Stage stage = (Stage) btnFechar.getScene().getWindow();
        stage.close();
    }


}
