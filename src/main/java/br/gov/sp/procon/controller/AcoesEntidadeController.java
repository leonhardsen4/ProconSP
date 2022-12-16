package br.gov.sp.procon.controller;

import br.gov.sp.procon.model.Cargo;
import br.gov.sp.procon.model.Endereco;
import br.gov.sp.procon.model.Servidor;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class AcoesEntidadeController implements Initializable {

    @FXML public AnchorPane telaAcEntidade;
    //INFORMAÇÕES DA ENTIDADE
    @FXML public TextField txtIdEntidade;
    @FXML public TextField txtEntidade;
    //TAB ENDEREÇO
    @FXML public Tab tabEndereco;
    @FXML public TextField txtIdEndereco;
    @FXML public TextField txtCEP;
    @FXML public TextField txtLogradouro;
    @FXML public TextField txtNumero;
    @FXML public TextField txtComplemento;
    @FXML public TextField txtBairro;
    @FXML public TextField txtMunicipio;
    @FXML public ComboBox<String> cmbUF;
    @FXML public Button btnSalvarEndereco;
    @FXML public Button btnLimparEndereco;
    //TABELA ENDEREÇO
    @FXML public TableView<Endereco> tblEndereco;
    @FXML public TableColumn<Endereco, Integer> tcID;
    @FXML public TableColumn<Endereco, String> tcEndereco;
    @FXML public TableColumn<Endereco, Integer> tcEditar;
    @FXML public TableColumn<Endereco, Integer> tcExcluir;
    //TAB UNIDADE
    @FXML public Tab tabUnidade;
    @FXML public Button btnCriarUnidade;
    @FXML public TextField txtIdUnidade;
    @FXML public TextField txtUnidade;
    @FXML public ComboBox<Endereco> cmbEnderecoUnidade;
    @FXML public Button btnSalvarUnidade;
    @FXML public Button btnLimparUnidade;
    //TABELA UNIDADE
    @FXML public TableView tblUnidade;
    @FXML public TableColumn tcIdUnidade;
    @FXML public TableColumn tcUnidade;
    @FXML public TableColumn tcEnderecoUnidade;
    @FXML public TableColumn tcEditarUnidade;
    @FXML public TableColumn tcExcluirUnidade;
    //TAB PESSOA
    @FXML public Tab tabPessoa;
    @FXML public Button btnAdicionarPessoa;
    @FXML public TextField tctIdPessoa;
    @FXML public TextField txtNomePessoa;
    @FXML public TextField txtTelefonePessoa;
    @FXML public TextField txtEmailPessoa;
    @FXML public ComboBox<Cargo> cmbCargo;
    @FXML public ComboBox<Servidor> cmbUnidadePessoa;
    @FXML public Button btnSalvarPessoa;
    @FXML public Button btnLimparPessoa;
    //TABELA PESSOA
    @FXML public TableView tblPessoa;
    @FXML public TableColumn tcIdPessoa;
    @FXML public TableColumn tcNomePessoa;
    @FXML public TableColumn tcUnidadePessoa;
    @FXML public TableColumn tcEditarPessoa;
    @FXML public TableColumn tcExcluirPessoa;

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
