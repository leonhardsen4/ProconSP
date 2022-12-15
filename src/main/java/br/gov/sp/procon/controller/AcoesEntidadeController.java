package br.gov.sp.procon.controller;

import br.gov.sp.procon.model.Endereco;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class AcoesEntidadeController implements Initializable {

    @FXML public AnchorPane telaAcoesEntidade;
    @FXML public TextField txtIdEntidade;
    @FXML public TextField txtEntidade;
    @FXML public TextField txtID;
    @FXML public TextField txtCEP;
    @FXML public TextField txtLogradouro;
    @FXML public TextField txtNumero;
    @FXML public TextField txtComplemento;
    @FXML public TextField txtBairro;
    @FXML public TextField txtMunicipio;
    @FXML public ComboBox<String> cmbUF;
    @FXML public Button btnSalvar;
    @FXML public TableView<Endereco> tblEndereco;
    @FXML public TableColumn<Endereco, Integer> tcID;
    @FXML public TableColumn<Endereco, String> tcEndereco;
    @FXML public TableColumn<Endereco, Integer> tcEditar;
    @FXML public TableColumn<Endereco, Integer> tcExcluir;

    public void adicionar() throws SQLException {
        
    }

    public void editar() throws SQLException {

    }

    public void remover() throws SQLException {

    }

    public List<Endereco> listarTodos() throws SQLException {
        return null;
    }

    public List<Endereco> buscar() throws SQLException {
        return null;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtIdEntidade.setText(String.valueOf(EntidadeController.ent.getId()));
        txtEntidade.setText(EntidadeController.ent.getNome());
    }
}
