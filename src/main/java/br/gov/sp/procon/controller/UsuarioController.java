package br.gov.sp.procon.controller;

import br.gov.sp.procon.model.Usuario;
import br.gov.sp.procon.utils.ConnectionFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UsuarioController implements Initializable {
    @FXML
    public AnchorPane telaUsuarios;
    @FXML
    public TableView<Usuario> tblUsuarios;
    @FXML
    public TableColumn<Usuario, Integer> tcId;
    @FXML
    public TableColumn<Usuario, String> tcUsuario;
    @FXML
    public TableColumn<Usuario, Integer> tcEditar;
    @FXML
    public TableColumn<Usuario, Integer> tcExcluir;
    @FXML
    public Button btnSalvar;
    @FXML
    public TextField txtUsuario;
    @FXML
    public PasswordField txtSenha;
    ObservableList<Usuario> usuarioObservableList = FXCollections.observableArrayList();

    Connection conn;
    PreparedStatement stmt;
    ResultSet rs;
    String sql;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        conn = ConnectionFactory.getConnection();
        String usuario = txtUsuario.getText();
        sql = "SELECT * FROM USUARIO WHERE USUARIO LIKE '%" + usuario + "%';";
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

//    @Override
//    public void adicionar(Usuario u) throws SQLException {
//        conn = ConnectionFactory.getConnection();
//        sql = "INSERT INTO USUARIO VALUES(?, ?, ?)";
//        stmt = conn.prepareStatement(sql);
//        stmt.setString(2, u.getUsuario());
//        stmt.setString(3, PasswordUtil.criptografa256(u.getSenha()));
//        stmt.execute();
//        stmt.close();
//        ConnectionFactory.closeConnection(conn, stmt);
//    }
//
//    @Override
//    public void editar(Usuario u) throws SQLException {
//        conn = ConnectionFactory.getConnection();
//        sql = "UPDATE USUARIO "
//                + "USUARIO = ?, "
//                + "SENHA = ? WHERE ID = ?";
//        stmt = conn.prepareStatement(sql);
//        stmt.setString(1, u.getUsuario());
//        stmt.setString(2, PasswordUtil.criptografa256(u.getSenha()));
//        stmt.setInt(3, u.getId());
//        stmt.execute();
//        stmt.close();
//        ConnectionFactory.closeConnection(conn, stmt);
//    }
//
//    @Override
//    public void remover(Usuario u) throws SQLException {
//        conn = ConnectionFactory.getConnection();
//        sql = "DELETE FROM USUARIO WHERE ID = ?";
//        stmt = conn.prepareStatement(sql);
//        stmt.setInt(1, u.getId());
//        stmt.execute();
//        stmt.close();
//        ConnectionFactory.closeConnection(conn, stmt);
//    }
//
//    @Override
//    public List<Usuario> listarTodos() throws SQLException {
//        conn = ConnectionFactory.getConnection();
//        sql = "SELECT * FROM USUARIO ORDER BY ID";
//        stmt = conn.prepareStatement(sql);
//        rs = stmt.executeQuery();
//        List<Usuario> listaUsuarios = new ArrayList<>();
//        while(rs.next()){
//            Usuario u = new Usuario();
//            u.setId(rs.getInt("ID"));
//            u.setUsuario(rs.getString("USUARIO"));
//            u.setSenha(rs.getString("SENHA"));
//            listaUsuarios.add(u);
//        }
//        ConnectionFactory.closeConnection(conn, stmt, rs);
//        return listaUsuarios;
//    }
//

    public ObservableList<Usuario> buscar(String string) throws SQLException {
        conn = ConnectionFactory.getConnection();
        sql = "SELECT * FROM USUARIO WHERE USUARIO LIKE '%" + string + "%';";
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

}
