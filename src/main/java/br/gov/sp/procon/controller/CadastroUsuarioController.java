package br.gov.sp.procon.controller;

import br.gov.sp.procon.dao.UsuarioDAO;
import br.gov.sp.procon.model.Usuario;
import br.gov.sp.procon.utils.Alertas;
import br.gov.sp.procon.view.TelaCadastroUsuarios;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.net.URL;
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
    Usuario usuario = new Usuario();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtUsuario.requestFocus();
        setEditarUsuario();
        txtID.setDisable(true);
    }


    public void salvarUsuario1(){
        if(txtUsuario.getText().isEmpty()){
            Alertas.alertaCuidado("Atenção", "O campo 'Usuário' é de preenchimento obrigatório.");
            txtUsuario.requestFocus();
        } else if (txtSenha.getText().isEmpty()){
            Alertas.alertaCuidado("Atenção", "O campo 'Senha' é de preenchimento obrigatório. Se você não escolher uma senha, o sistema adotará a senha padrão '12345'.");
            txtSenha.setText("12345");
            txtSenha.requestFocus();
        } else if (txtNome.getText().isEmpty()){
            Alertas.alertaCuidado("Atenção", "O campo 'Nome' é de preenchimento obrigatório.");
            txtNome.requestFocus();
        } else{
            if(txtID.getText().isEmpty()){
                usuario.setUsuario(txtUsuario.getText().toUpperCase());
                usuario.setSenha(txtSenha.getText());
                usuario.setNome(txtNome.getText().toUpperCase());
                usuario.setSobreNome(txtSobrenome.getText().toUpperCase());
                usuario.setEmail(txtEmail.getText().toLowerCase());
                usuarioDAO.adicionar(usuario);
                fecharTela();
            }else{
                usuario.setId(Integer.parseInt(txtID.getText()));
                usuario.setUsuario(txtUsuario.getText().toUpperCase());
                usuario.setSenha(txtSenha.getText());
                usuario.setNome(txtNome.getText().toUpperCase());
                usuario.setSobreNome(txtSobrenome.getText().toUpperCase());
                usuario.setEmail(txtEmail.getText().toLowerCase());
                usuarioDAO.editar(usuario);
                fecharTela();
            }
        }
    }

    public void salvarUsuario2(KeyEvent keyEvent){
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            salvarUsuario1();
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

    public void editarUsuario() throws Exception {
        TelaCadastroUsuarios telaCadastroUsuarios = new TelaCadastroUsuarios();
        telaCadastroUsuarios.start(new Stage());
    }

    public void setEditarUsuario(){
        if(UsuarioController.usr !=null){
            txtID.setText(String.valueOf(UsuarioController.usr.getId()));
            txtUsuario.setText(UsuarioController.usr.getUsuario());
            txtNome.setText(UsuarioController.usr.getNome());
            txtSobrenome.setText(UsuarioController.usr.getSobreNome());
            txtEmail.setText(UsuarioController.usr.getEmail());
        }

    }

    public void fecharTela(){
        Stage stage = (Stage) btnFechar.getScene().getWindow();
        stage.close();
    }


}
