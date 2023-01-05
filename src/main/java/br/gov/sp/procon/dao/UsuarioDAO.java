package br.gov.sp.procon.dao;

import br.gov.sp.procon.model.Usuario;
import br.gov.sp.procon.utils.ConnectionFactory;
import br.gov.sp.procon.utils.PasswordUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends ConnectionFactory {

    Connection conn;
    String sql;
    PreparedStatement stmt;
    ResultSet rs;

    public void adicionar(Usuario usuario){
        try{
            conn = getConnection();
            sql = "INSERT INTO USUARIOS VALUES(?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(2, usuario.getUsuario());
            stmt.setString(3, PasswordUtil.criptografa256(usuario.getSenha()));
            stmt.setString(4, usuario.getNome());
            stmt.setString(5, usuario.getSobreNome());
            stmt.setString(6, usuario.getEmail());
            stmt.execute();
        } catch (SQLException ex){
            ex.printStackTrace();
            ex.getCause();
            throw new RuntimeException(ex.getMessage());
        }
        closeConnection(conn, stmt);
    }

    public void editar(Usuario usuario){
        try{
            conn = getConnection();
            sql = "UPDATE USUARIOS SET USUARIO = ?, SENHA = ?, NOME = ?, SOBRENOME = ?, EMAIL = ? WHERE ID = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, PasswordUtil.criptografa256(usuario.getSenha()));
            stmt.setString(3, usuario.getNome());
            stmt.setString(4, usuario.getSobreNome());
            stmt.setString(5, usuario.getEmail());
            stmt.setInt(6, usuario.getId());
            stmt.execute();
        } catch (SQLException ex){
            ex.printStackTrace();
            ex.getCause();
            throw new RuntimeException(ex.getMessage());
        }
        closeConnection(conn, stmt);
    }

    public void remover(Usuario usuario){
        try {
            conn = getConnection();
            sql = "DELETE FROM USUARIOS WHERE ID = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, usuario.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex){
            ex.printStackTrace();
            ex.getCause();
            throw new RuntimeException(ex.getMessage());
        }
        closeConnection(conn, stmt);
    }

    public ObservableList<Usuario> listar(){
        try {
            conn = getConnection();
            sql = "SELECT * FROM USUARIOS ORDER BY ID";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            List<Usuario> listaUsuarios = new ArrayList<>();
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("ID"));
                usuario.setUsuario(rs.getString("USUARIO"));
                usuario.setSenha(rs.getString("SENHA"));
                usuario.setNome(rs.getString("NOME"));
                usuario.setSobreNome(rs.getString("SOBRENOME"));
                usuario.setEmail(rs.getString("EMAIL"));
                listaUsuarios.add(usuario);
            }
            closeConnection(conn, stmt, rs);
            return FXCollections.observableArrayList(listaUsuarios);
        } catch (SQLException ex){
            ex.printStackTrace();
            ex.getCause();
            throw new RuntimeException(ex.getMessage());
        }
    }

    public ObservableList<Usuario> buscar(String string){
        try {
            conn = getConnection();
            sql = "SELECT * FROM USUARIOS " +
                    "WHERE USUARIO LIKE '%" + string+ "%' " +
                    "OR NOME LIKE '%" + string + "%' " +
                    "OR SOBRENOME LIKE '%" + string + "%';";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            List<Usuario> listaUsuarios = new ArrayList<>();
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("ID"));
                usuario.setUsuario(rs.getString("USUARIO"));
                usuario.setSenha(rs.getString("SENHA"));
                usuario.setNome(rs.getString("NOME"));
                usuario.setSobreNome(rs.getString("SOBRENOME"));
                usuario.setEmail(rs.getString("EMAIL"));
                listaUsuarios.add(usuario);
            }
            closeConnection(conn, stmt, rs);
            return FXCollections.observableArrayList(listaUsuarios);
        } catch (SQLException ex){
            ex.printStackTrace();
            ex.getCause();
            throw new RuntimeException(ex.getMessage());
        }
    }

}
