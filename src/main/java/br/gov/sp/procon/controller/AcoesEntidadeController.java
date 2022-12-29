package br.gov.sp.procon.controller;

import java.util.List;
import dev.pauloribeiro.cepcorreios.CepCorreio;
import dev.pauloribeiro.cepcorreios.CorreiosApiFactory;

import br.gov.sp.procon.model.*;
import br.gov.sp.procon.utils.ConnectionFactory;
import br.gov.sp.procon.utils.MaskFieldUtil;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.util.Callback;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
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
    @FXML public TableView<Unidade> tblUnidade;
    @FXML public TableColumn<Unidade, Integer> tcIdUnidade;
    @FXML public TableColumn<Unidade, String> tcUnidade;
    @FXML public TableColumn<Unidade, String> tcEnderecoUnidade;
    @FXML public TableColumn<Unidade, Integer> tcEditarUnidade;
    @FXML public TableColumn<Unidade, Integer> tcExcluirUnidade;
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
    @FXML public TableView<Servidor> tblPessoa;
    @FXML public TableColumn<Servidor, Integer> tcIdPessoa;
    @FXML public TableColumn<Servidor, String> tcNomePessoa;
    @FXML public TableColumn<Servidor, String> tcUnidadePessoa;
    @FXML public TableColumn<Servidor, Integer> tcEditarPessoa;
    @FXML public TableColumn<Servidor, Integer> tcExcluirPessoa;
    //Outras Variáveis
    Connection conn;
    PreparedStatement stmt;
    ResultSet rs;
    String sql;
    static Endereco end;

    public void adicionarEndereco(Endereco e) {
        conn = ConnectionFactory.getConnection();
        sql = "INSERT INTO ENDERECOS VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(2, e.getIdEntidade());
            stmt.setString(3, e.getCep());
            stmt.setString(4, e.getLogradouro());
            stmt.setString(5, e.getNumero());
            stmt.setString(6, e.getComplemento());
            stmt.setString(7, e.getBairro());
            stmt.setString(8, e.getMunicipio());
            stmt.setString(9, e.getUf());
            stmt.execute();
        } catch (SQLException ex) {
            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setTitle("Erro");
            erro.setContentText("O endereço não foi salvo pois existem campos obrigatórios em branco");
            erro.showAndWait();
            if(txtCEP.getText().isEmpty()){
                txtCEP.requestFocus();
            } else if (txtLogradouro.getText().isEmpty()){
                txtLogradouro.requestFocus();
            } else if (txtMunicipio.getText().isEmpty()){
                txtMunicipio.requestFocus();
            }else if (cmbUF.getSelectionModel().getSelectedItem().isEmpty()){
                cmbUF.requestFocus();
            }
            ex.printStackTrace();
            ex.getCause();
            throw new RuntimeException(ex.getMessage());
        }
        ConnectionFactory.closeConnection(conn, stmt);
    }

    public void adicionarUnidade(Unidade u) {
        conn = ConnectionFactory.getConnection();
        sql = "INSERT INTO UNIDADES VALUES(?, ?, ?, ?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(2, u.getIdEntidade());
            stmt.setInt(3, u.getIdEnderecoEntidade());
            stmt.setString(4, u.getUnidade());
            stmt.execute();
        } catch (SQLException ex) {
            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setTitle("Erro");
            erro.setContentText("A unidade não foi salva pois existem campos obrigatórios em branco");
            erro.showAndWait();
            if(txtUnidade.getText().isEmpty()){
                txtUnidade.requestFocus();
            } else if (cmbEnderecoUnidade.getSelectionModel().isEmpty()){
                cmbEnderecoUnidade.requestFocus();
            }
            ex.printStackTrace();
            ex.getCause();
            throw new RuntimeException(ex.getMessage());
        }
        ConnectionFactory.closeConnection(conn, stmt);
    }

    public void editarEndereco(Endereco e) {
        conn = ConnectionFactory.getConnection();
        sql = "UPDATE ENDERECOS SET " +
                "CEP = ?, " +
                "LOGRADOURO = ?, " +
                "NUMERO = ?, " +
                "COMPLEMENTO = ?, " +
                "BAIRRO = ?, " +
                "MUNICIPIO = ?, " +
                "UF = ? WHERE ID = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, e.getCep());
            stmt.setString(2, e.getLogradouro());
            stmt.setString(3, e.getNumero());
            stmt.setString(4, e.getComplemento());
            stmt.setString(5, e.getBairro());
            stmt.setString(6, e.getMunicipio());
            stmt.setString(7, e.getUf());
            stmt.setInt(8, e.getId());
            stmt.execute();
        } catch (SQLException ex) {
            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setTitle("Erro");
            erro.setContentText("O endereço não foi salvo pois existem campos obrigatórios em branco");
            erro.showAndWait();
            if(txtCEP.getText().isEmpty()){
                txtCEP.requestFocus();
            } else if (txtLogradouro.getText().isEmpty()){
                txtLogradouro.requestFocus();
            } else if (txtMunicipio.getText().isEmpty()){
                txtMunicipio.requestFocus();
            }else if (cmbUF.getSelectionModel().getSelectedItem().isEmpty()){
                cmbUF.requestFocus();
            }
            ex.printStackTrace();
            ex.getCause();
            throw new RuntimeException(ex.getMessage());
        }
        ConnectionFactory.closeConnection(conn, stmt);
    }

    public void editarUnidade(Unidade u) {
        conn = ConnectionFactory.getConnection();
        sql = "UPDATE UNIDADES SET UNIDADE = ?, ID_ENDERECO_ENTIDADE = ? WHERE ID = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, u.getUnidade());
            stmt.setInt(2, u.getIdEnderecoEntidade());
            stmt.setInt(3, u.getId());
            stmt.execute();
        } catch (SQLException ex) {
            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setTitle("Erro");
            erro.setContentText("A unidade não foi salva pois existem campos obrigatórios em branco");
            erro.showAndWait();
            if (txtUnidade.getText().isEmpty()) {
                txtUnidade.requestFocus();
            } else if (cmbEnderecoUnidade.getSelectionModel().isEmpty()) {
                cmbEnderecoUnidade.requestFocus();
            }
            ex.printStackTrace();
            ex.getCause();
            throw new RuntimeException(ex.getMessage());
        }
        ConnectionFactory.closeConnection(conn, stmt);
    }

    public void removerEndereco(Endereco e) {
        conn = ConnectionFactory.getConnection();
        sql = "DELETE FROM ENDERECOS WHERE ID = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, e.getId());
            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            ex.getCause();
            throw new RuntimeException(ex.getMessage());
        }
        ConnectionFactory.closeConnection(conn, stmt);
    }

    public void removerUnidade(Unidade u){
        conn = ConnectionFactory.getConnection();
        sql = "DELETE FROM UNIDADES WHERE ID = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, u.getId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
            throw new RuntimeException(e.getMessage());
        }
        ConnectionFactory.closeConnection(conn, stmt);
    }

    public ObservableList<Endereco> listarEnderecos() throws SQLException {
        int idEntidade = Integer.parseInt(txtIdEntidade.getText());
        conn = ConnectionFactory.getConnection();
        sql = "SELECT * FROM ENDERECOS WHERE ID_ENTIDADE = " + idEntidade + " ORDER BY ID";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        List<Endereco> listaEnderecos = new ArrayList<>();
        while (rs.next()) {
            Endereco e = new Endereco();
            e.setId(rs.getInt("ID"));
            e.setCep(rs.getString("CEP"));
            e.setLogradouro(rs.getString("LOGRADOURO"));
            e.setNumero(rs.getString("NUMERO"));
            e.setComplemento(rs.getString("COMPLEMENTO"));
            e.setBairro(rs.getString("BAIRRO"));
            e.setMunicipio(rs.getString("MUNICIPIO"));
            e.setUf(rs.getString("UF"));
            listaEnderecos.add(e);
        }
        ConnectionFactory.closeConnection(conn, stmt, rs);
        return FXCollections.observableArrayList(listaEnderecos);
    }

    public ObservableList<Endereco> buscarEnderecos(String string) throws SQLException {
        int idEntidade = Integer.parseInt(txtIdEntidade.getText());
        conn = ConnectionFactory.getConnection();
        sql = "SELECT * FROM ENDERECOS WHERE ID_ENTIDADE = '" + idEntidade + "' AND LOGRADOURO LIKE '%" + string + "%';";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        List<Endereco> listaEnderecos = new ArrayList<>();
        while (rs.next()) {
            Endereco e = new Endereco();
            e.setId(rs.getInt("ID"));
            e.setCep(rs.getString("CEP"));
            e.setLogradouro(rs.getString("LOGRADOURO"));
            e.setNumero(rs.getString("NUMERO"));
            e.setComplemento(rs.getString("COMPLEMENTO"));
            e.setBairro(rs.getString("BAIRRO"));
            e.setMunicipio(rs.getString("MUNICIPIO"));
            e.setUf(rs.getString("UF"));
            listaEnderecos.add(e);
        }
        ConnectionFactory.closeConnection(conn, stmt, rs);
        return FXCollections.observableArrayList(listaEnderecos);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtIdEntidade.setText(String.valueOf(EntidadeController.ent.getId()));
        txtEntidade.setText(EntidadeController.ent.getNome());
        MaskFieldUtil.numericField(txtCEP);
        tcID.setMinWidth(50.0);
        tcID.setMaxWidth(50.0);
        tcEndereco.setMinWidth(650.0);
        tcEndereco.setMaxWidth(650.0);
        tcEditar.setMinWidth(70.0);
        tcEditar.setMaxWidth(70.0);
        tcExcluir.setMinWidth(70.0);
        tcExcluir.setMaxWidth(70.0);
        tcEditar.setStyle("-fx-alignment: CENTER");
        tcExcluir.setStyle("-fx-alignment: CENTER");
        tcID.isSortable();
        tcEndereco.isSortable();
        cmbUF.setItems(listaUF());
        adicionarBotaoEditar();
        adicionarBotaoExcluir();
        tcID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcEndereco.setCellValueFactory(cellData -> Bindings.createStringBinding(
                () -> cellData.getValue().getLogradouro() + " "
                        + cellData.getValue().getNumero() + " "
                        + cellData.getValue().getComplemento() + " "
                        + cellData.getValue().getBairro() + " "
                        + cellData.getValue().getMunicipio() + " "
                        + cellData.getValue().getUf() + " "
                        + cellData.getValue().getCep()
        ));
        try {
            atualizarTabela();
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
            throw new RuntimeException(e.getMessage());
        }
    }

    private ObservableList<String> listaUF() {
        List<String> listagemUF = new ArrayList<>();
        listagemUF.add("AC");
        listagemUF.add("AL");
        listagemUF.add("AM");
        listagemUF.add("AP");
        listagemUF.add("BA");
        listagemUF.add("CE");
        listagemUF.add("DF");
        listagemUF.add("ES");
        listagemUF.add("GO");
        listagemUF.add("MA");
        listagemUF.add("MG");
        listagemUF.add("MS");
        listagemUF.add("MT");
        listagemUF.add("PA");
        listagemUF.add("PB");
        listagemUF.add("PE");
        listagemUF.add("PI");
        listagemUF.add("PR");
        listagemUF.add("RJ");
        listagemUF.add("RN");
        listagemUF.add("RO");
        listagemUF.add("RR");
        listagemUF.add("RS");
        listagemUF.add("SC");
        listagemUF.add("SE");
        listagemUF.add("SP");
        listagemUF.add("TO");
        return FXCollections.observableArrayList(listagemUF);
    }

    public void salvarEndereco() throws SQLException {
        if (txtCEP.getText().isEmpty()) {
            btnSalvarEndereco.isDisabled();
            txtCEP.requestFocus();
        } else {
            if (txtIdEndereco.getText().isEmpty()) {
                Endereco e = new Endereco();
                e.setIdEntidade(Integer.parseInt(txtIdEntidade.getText()));
                e.setCep(txtCEP.getText());
                e.setLogradouro(txtLogradouro.getText());
                e.setNumero(txtNumero.getText());
                e.setComplemento(txtComplemento.getText());
                e.setBairro(txtBairro.getText());
                e.setMunicipio(txtMunicipio.getText());
                e.setUf(cmbUF.getSelectionModel().getSelectedItem());
                adicionarEndereco(e);
            } else {
                end.setCep(txtCEP.getText());
                end.setLogradouro(txtLogradouro.getText());
                end.setNumero(txtNumero.getText());
                end.setComplemento(txtComplemento.getText());
                end.setBairro(txtBairro.getText());
                end.setMunicipio(txtMunicipio.getText());
                end.setUf(cmbUF.getSelectionModel().getSelectedItem());
                editarEndereco(end);
            }
            atualizarTabela();
            limparCampos();
            txtEntidade.requestFocus();
        }
    }

    public void adicionarBotaoEditar() {
        Callback<TableColumn<Endereco, Integer>, TableCell<Endereco, Integer>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Endereco, Integer> call(final TableColumn<Endereco, Integer> param) {
                return new TableCell<>() {
                    private final Button btnEditar = new Button("Editar");

                    {
                        btnEditar.setOnAction((ActionEvent event) -> {
                            end = getTableView().getItems().get(getIndex());
                            edicaoEndereco(end);
                        });
                    }

                    @Override
                    public void updateItem(Integer item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            btnEditar.setText("Editar");
                            btnEditar.setCursor(Cursor.HAND);
                            btnEditar.setBackground(Background.fill(Color.rgb(255, 140, 0)));
                            btnEditar.setStyle("-fx-text-fill: #FFFFFF");
                            setGraphic(btnEditar);
                        }
                    }
                };
            }
        };
        tcEditar.setCellFactory(cellFactory);
    }

    public void edicaoEndereco(Endereco endereco) {
        txtIdEndereco.setText(String.valueOf(endereco.getId()));
        txtCEP.setText(endereco.getCep());
        txtLogradouro.setText(endereco.getLogradouro());
        txtNumero.setText(endereco.getNumero());
        txtComplemento.setText(endereco.getComplemento());
        txtBairro.setText(endereco.getBairro());
        txtMunicipio.setText(endereco.getMunicipio());
        cmbUF.getSelectionModel().select(endereco.getUf());
    }

    public void adicionarBotaoExcluir() {
        Callback<TableColumn<Endereco, Integer>, TableCell<Endereco, Integer>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Endereco, Integer> call(final TableColumn<Endereco, Integer> param) {
                return new TableCell<>() {
                    private final Button btnExcluir = new Button("Excluir");

                    {
                        btnExcluir.setOnAction((ActionEvent event) -> {
                            Endereco e = getTableView().getItems().get(getIndex());
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Exclusão");
                            alert.setContentText("Tem certeza que deseja excluir o endereço selecionado?");
                            alert.showAndWait().ifPresent(response -> {
                                if (response == ButtonType.OK) {
                                    try {
                                        removerEndereco(e);
                                        limparCampos();
                                        txtCEP.requestFocus();
                                        atualizarTabela();
                                    } catch (SQLException ex) {
                                        ex.printStackTrace();
                                        ex.getCause();
                                        throw new RuntimeException(ex.getMessage());
                                    }
                                }
                            });
                        });
                    }

                    @Override
                    public void updateItem(Integer item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            btnExcluir.setText("Excluir");
                            btnExcluir.setCursor(Cursor.HAND);
                            btnExcluir.setBackground(Background.fill(Color.rgb(220, 20, 60)));
                            btnExcluir.setStyle("-fx-text-fill: #FFFFFF");
                            setGraphic(btnExcluir);
                        }
                    }
                };
            }
        };
        tcExcluir.setCellFactory(cellFactory);
    }

    public void buscaEndereco() {
        txtLogradouro.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                tblEndereco.setItems(buscarEnderecos(newValue));
            } catch (SQLException e) {
                e.printStackTrace();
                e.getCause();
                throw new RuntimeException(e.getMessage());
            }
        });
    }

    public void atualizarTabela() throws SQLException {
        tblEndereco.setItems(listarEnderecos());
    }

    public void limparCampos() {
        txtIdEndereco.setText("");
        txtCEP.setText("");
        txtLogradouro.setText("");
        txtNumero.setText("");
        txtComplemento.setText("");
        txtBairro.setText("");
        txtMunicipio.setText("");
        cmbUF.getSelectionModel().clearSelection();
        txtCEP.requestFocus();
    }

    public void buscarCep(KeyEvent keyEvent) throws InterruptedException {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            if(txtCEP.getText().length() == 8) {
                List<CepCorreio> CEP = CorreiosApiFactory.get().getCep(txtCEP.getText());
                if (CEP.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Erro");
                    alert.setContentText("CEP não encontrado");
                    alert.showAndWait();
                    txtLogradouro.requestFocus();
                } else {
                    txtLogradouro.setText(CEP.get(0).getLogradouro().toUpperCase());
                    txtBairro.setText(CEP.get(0).getBairro().toUpperCase());
                    txtMunicipio.setText(CEP.get(0).getCidade().toUpperCase());
                    cmbUF.getSelectionModel().select(CEP.get(0).getEstado().toUpperCase());
                    txtNumero.requestFocus();
                }
            }else if(txtCEP.getText().length() < 8){
                txtCEP.setText("");
            }
        }
    }

    public void focoNumero(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            txtNumero.requestFocus();
        }
    }

    public void focoComplemento(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            txtComplemento.requestFocus();
        }
    }

    public void focoBairro(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            txtBairro.requestFocus();
        }
    }

    public void focoMunicipio(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            txtMunicipio.requestFocus();
        }
    }

    public void focoUF(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            cmbUF.requestFocus();
        }
    }

    public void focoSalvar(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            btnSalvarEndereco.requestFocus();
        }
    }

    public void btnSalvarEndereco(KeyEvent keyEvent) throws SQLException {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            salvarEndereco();
        }
    }
}
