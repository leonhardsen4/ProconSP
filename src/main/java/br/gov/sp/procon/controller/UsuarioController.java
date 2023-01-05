package br.gov.sp.procon.controller;

import br.gov.sp.procon.dao.UsuarioDAO;
import br.gov.sp.procon.model.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class UsuarioController {

    @FXML
    public TextField txtId;
    @FXML
    public TextField txtUsuario;
    @FXML
    public PasswordField txtSenha;
    @FXML
    public TextField txtNome;
    @FXML
    public TextField txtSobrenome;
    @FXML
    public TextField txtEmail;
    @FXML
    public Button btnSalvar;
    @FXML
    public Button btnLimpar;


    @FXML private void salvarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setUsuario(txtUsuario.getText().toUpperCase());
        usuario.setSenha(txtSenha.getText());
        usuario.setNome(txtNome.getText().toUpperCase());
        usuario.setSobreNome(txtSobrenome.getText().toUpperCase());
        usuario.setEmail(txtEmail.getText().toUpperCase());
        UsuarioDAO.getInstance().persist(usuario);
        limparCampos();
    }

    @FXML private void removerUsuario() {
        UsuarioDAO.getInstance().removeById(Integer.parseInt(txtId.getText()));
        limparCampos();
    }

    @FXML private void buscarUsuario(){
        int id = Integer.parseInt(txtId.getText());
        Usuario usuario = UsuarioDAO.getInstance().getById(id);
        txtUsuario.setText(usuario.getUsuario());
        txtSenha.setText(usuario.getSenha());
        txtNome.setText(usuario.getNome());
        txtSobrenome.setText(usuario.getSobreNome());
        txtEmail.setText(usuario.getEmail());
    }

    @FXML private void limparCampos(){
        txtUsuario.setText("");
        txtSenha.setText("");
        txtNome.setText("");
        txtSobrenome.setText("");
        txtEmail.setText("");
        txtUsuario.requestFocus();
    }

}
