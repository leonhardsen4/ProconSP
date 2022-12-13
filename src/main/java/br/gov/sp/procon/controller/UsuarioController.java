package br.gov.sp.procon.controller;

import br.gov.sp.procon.model.Usuario;
import br.gov.sp.procon.utils.ConnectionFactory;
import br.gov.sp.procon.utils.PasswordUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import java.util.List;
import java.util.ResourceBundle;

public class UsuarioController implements Initializable {
    @FXML public AnchorPane telaUsuarios;
    @FXML public TableView<Usuario> tblUsuarios;
    @FXML public TableColumn<Usuario, Integer> tcId;
    @FXML public TableColumn<Usuario, String> tcUsuario;
    @FXML public TableColumn<Usuario, String> tcNome;
    @FXML public TableColumn<Usuario, Integer> tcEditar;
    @FXML public TableColumn<Usuario, Integer> tcExcluir;
    @FXML public Button btnSalvar;
    @FXML public TextField txtId;
    @FXML public TextField txtUsuario;
    @FXML public TextField txtNome;
    @FXML public PasswordField txtSenha;
    ObservableList<Usuario> usuarioObservableList = FXCollections.observableArrayList();
    Connection conn;
    PreparedStatement stmt;
    ResultSet rs;
    String sql;

    static Usuario usr = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        conn = ConnectionFactory.getConnection();
        tcId.isSortable();
        tcUsuario.isSortable();
        tcNome.isSortable();
        adicionarBotaoEditar();
        adicionarBotaoExcluir();
        tcEditar.setStyle("-fx-alignment: CENTER");
        tcExcluir.setStyle("-fx-alignment: CENTER");
        String usuario = txtUsuario.getText().toUpperCase();
        String nome = txtNome.getText().toUpperCase();
        sql = "SELECT * FROM USUARIO WHERE USUARIO LIKE '%" + usuario + "%' OR NOME LIKE '%" + nome + "%';";
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("ID"));
                u.setUsuario(rs.getString("USUARIO"));
                u.setNome(rs.getString("NOME"));
                u.setSenha(rs.getString("SENHA"));
                usuarioObservableList.add(u);
            }
            tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
            tcUsuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
            tcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

            tblUsuarios.setItems(usuarioObservableList);

            FilteredList<Usuario> filteredData = new FilteredList<>(usuarioObservableList, o -> true);

            txtUsuario.textProperty().addListener((observable, oldValue, newValue) -> {
                try{
                    tblUsuarios.setItems(buscar(newValue));
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                    throw new RuntimeException(e);
                }
            });
            txtNome.textProperty().addListener((observable, oldValue, newValue) -> {
                try{
                    tblUsuarios.setItems(buscar(newValue));
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                    throw new RuntimeException(e);
                }
            });
            SortedList<Usuario> sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(tblUsuarios.comparatorProperty());
            tblUsuarios.setItems(sortedData);
            ConnectionFactory.closeConnection(conn, stmt, rs);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
            throw new RuntimeException(e);
        }
    }

    public void adicionar(Usuario u) {
        conn = ConnectionFactory.getConnection();
        sql = "INSERT INTO USUARIO VALUES(?, ?, ?, ?)";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(2, u.getUsuario());
            stmt.setString(3, u.getNome());
            stmt.setString(4, PasswordUtil.criptografa256(u.getSenha()));
            stmt.execute();
        } catch (SQLException ex){
            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setTitle("Erro");
            erro.setHeaderText("O usuário não foi salvo porque já existe no banco de dados.\n" +
                    "O sistema não permite a existência de registros duplicados.");
            erro.setContentText("Cadastro não permitido: " + u.getUsuario() + " - " + u.getNome());
            erro.showAndWait();
            txtId.setText("");
            txtUsuario.setText("");
            txtNome.setText("");
            txtSenha.setText("");
            txtUsuario.requestFocus();
            throw new RuntimeException(ex);
        }
        ConnectionFactory.closeConnection(conn, stmt);
    }

    public void editar(Usuario u) {
        conn = ConnectionFactory.getConnection();
        sql = "UPDATE USUARIO SET USUARIO = ?, NOME = ?, SENHA = ? WHERE ID = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, u.getUsuario());
            stmt.setString(2, u.getNome());
            stmt.setString(3, PasswordUtil.criptografa256(u.getSenha()));
            stmt.setInt(4, u.getId());
            stmt.execute();
        } catch (SQLException e) {
            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setTitle("Erro");
            erro.setHeaderText("O usuário não foi salvo porque já existe no banco de dados.\n" +
                    "O sistema não permite a existência de registros duplicados.");
            erro.setContentText("Cadastro não permitido: " + u.getUsuario() + " - " + u.getNome());
            erro.showAndWait();
            txtId.setText("");
            txtUsuario.setText("");
            txtNome.setText("");
            txtSenha.setText("");
            txtUsuario.requestFocus();
            throw new RuntimeException(e);
        }
        ConnectionFactory.closeConnection(conn, stmt);
    }

    public void remover(Usuario u) throws SQLException {
        conn = ConnectionFactory.getConnection();
        sql = "DELETE FROM USUARIO WHERE ID = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, u.getId());
        stmt.execute();
        stmt.close();
        ConnectionFactory.closeConnection(conn, stmt);
    }

    public ObservableList<Usuario> listarTodos() throws SQLException {
        conn = ConnectionFactory.getConnection();
        sql = "SELECT * FROM USUARIO ORDER BY ID";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        List<Usuario> listaUsuarios = new ArrayList<>();
        while(rs.next()){
            Usuario u = new Usuario();
            u.setId(rs.getInt("ID"));
            u.setUsuario(rs.getString("USUARIO"));
            u.setNome(rs.getString("NOME"));
            u.setSenha(rs.getString("SENHA"));
            listaUsuarios.add(u);
        }
        ConnectionFactory.closeConnection(conn, stmt, rs);
        return FXCollections.observableArrayList(listaUsuarios);
    }

    public ObservableList<Usuario> buscar(String string) throws SQLException {
        conn = ConnectionFactory.getConnection();
        sql = "SELECT * FROM USUARIO WHERE USUARIO LIKE '%" + string+ "%' OR NOME LIKE '%" + string + "%';";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        List<Usuario> listaUsuarios = new ArrayList<>();
        while(rs.next()){
            Usuario u = new Usuario();
            u.setId(rs.getInt("ID"));
            u.setUsuario(rs.getString("USUARIO"));
            u.setNome(rs.getString("NOME"));
            u.setSenha(rs.getString("SENHA"));
            listaUsuarios.add(u);
        }
        ConnectionFactory.closeConnection(conn, stmt, rs);
        return FXCollections.observableArrayList(listaUsuarios);
    }

    public void salvarUsuario() throws SQLException {
        String usuario = txtUsuario.getText();
        String nome = txtNome.getText();
        String senha = txtSenha.getText();
        if (usuario.isEmpty()) {
            btnSalvar.isDisabled();
            txtUsuario.requestFocus();
        } else {
            if (txtId.getText().isEmpty()) {
                Usuario u = new Usuario();
                u.setUsuario(usuario);
                u.setNome(nome);
                if(txtSenha.getText().isEmpty()){
                    u.setSenha("12345");
                }else{
                    u.setSenha(senha);
                }
                adicionar(u);
            } else {
                usr.setUsuario(usuario);
                usr.setNome(nome);
                if(txtSenha.getText().isEmpty()){
                    usr.setSenha("12345");
                }else{
                    usr.setSenha(senha);
                }
                editar(usr);
            }
            atualizarTabela();
            txtId.setText("");
            txtUsuario.setText("");
            txtNome.setText("");
            txtSenha.setText("");
            txtUsuario.requestFocus();
        }
    }

    public void editarUsuario(Usuario usuario) {
        txtId.setText(String.valueOf(usuario.getId()));
        txtUsuario.setText(usuario.getUsuario());
        txtNome.setText(usuario.getNome());
        txtUsuario.requestFocus();
    }

    public void atualizarTabela() throws SQLException {
        tblUsuarios.setItems(listarTodos());
    }

    public void adicionarBotaoEditar() {
        Callback<TableColumn<Usuario, Integer>, TableCell<Usuario, Integer>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Usuario, Integer> call(final TableColumn<Usuario, Integer> param) {
                return new TableCell<>() {
                    private final Button btnEditar = new Button("Editar");

                    {
                        btnEditar.setOnAction((ActionEvent event) -> {
                            usr = getTableView().getItems().get(getIndex());
                            editarUsuario(usr);
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

    public void adicionarBotaoExcluir() {
        Callback<TableColumn<Usuario, Integer>, TableCell<Usuario, Integer>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Usuario, Integer> call(final TableColumn<Usuario, Integer> param) {
                return new TableCell<>() {
                    private final Button btnExcluir = new Button("Excluir");

                    {
                        btnExcluir.setOnAction((ActionEvent event) -> {
                            Usuario u = getTableView().getItems().get(getIndex());
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Exclusão");
                            alert.setHeaderText("Tem certeza que deseja excluir o usuário selecionado?");
                            alert.setContentText("Usuário: "+ u.getUsuario() + " - Nome: " + u.getNome());
                            alert.showAndWait().ifPresent(response -> {
                                if (response == ButtonType.OK) {
                                    try {
                                        remover(u);
                                        txtId.setText("");
                                        txtUsuario.setText("");
                                        txtNome.setText("");
                                        txtSenha.setText("");
                                        txtUsuario.requestFocus();
                                        atualizarTabela();
                                    } catch (SQLException ex) {
                                        throw new RuntimeException(ex);
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

    public void focoNome(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            txtNome.requestFocus();
        }
    }

    public void focoSenha(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            txtSenha.requestFocus();
        }
    }

    public void focoBtnSalvar(KeyEvent keyEvent) throws SQLException {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            salvarUsuario();
        }
    }
}
