package br.gov.sp.procon.controller;

import br.gov.sp.procon.model.Usuario;
import br.gov.sp.procon.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioController implements MetodosBasicos<Usuario> {

    Connection conn;
    PreparedStatement stmt;
    ResultSet rs;
    String sql;

    @Override
    public void adicionar(Usuario u) throws SQLException {
        conn = ConnectionFactory.getConnection();
        sql = "INSERT INTO USUARIO VALUES(?, ?, ?, ?, ?)";
        stmt = conn.prepareStatement(sql);
        stmt.setString(2, u.getUsuario());
        stmt.setString(3, u.getSenha());
        stmt.setInt(4, u.getIdServidor());
        stmt.setInt(5, u.getAcesso());
        stmt.execute();
        stmt.close();
        ConnectionFactory.closeConnection(conn, stmt);
    }

    @Override
    public void editar(Usuario u) throws SQLException {
        conn = ConnectionFactory.getConnection();
        sql = "UPDATE USUARIO "
                + "USUARIO = ?, "
                + "SENHA = ?, "
                + "IDSERVIDOR = ?, "
                + "ACESSO = ? WHERE ID = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, u.getUsuario());
        stmt.setString(2, u.getSenha());
        stmt.setInt(3, u.getIdServidor());
        stmt.setInt(4, u.getAcesso());
        stmt.setInt(5, u.getId());
        stmt.execute();
        stmt.close();
        ConnectionFactory.closeConnection(conn, stmt);
    }

    @Override
    public void remover(Usuario u) throws SQLException {
        conn = ConnectionFactory.getConnection();
        sql = "DELETE FROM USUARIO WHERE ID = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1, u.getId());
        stmt.execute();
        stmt.close();
        ConnectionFactory.closeConnection(conn, stmt);
    }

    @Override
    public List<Usuario> listarTodos() throws SQLException {
        conn = ConnectionFactory.getConnection();
        sql = "SELECT * FROM USUARIO ORDER BY ID";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        List<Usuario> listaUsuarios = new ArrayList<>();
        while(rs.next()){
            Usuario u = new Usuario();
            u.setId(rs.getInt("ID"));
            u.setUsuario(rs.getString("USUARIO"));
            u.setSenha(rs.getString("SENHA"));
            u.setIdServidor(rs.getInt("IDSERVIDOR"));
            u.setAcesso(rs.getInt("ACESSO"));
            listaUsuarios.add(u);
        }
        ConnectionFactory.closeConnection(conn, stmt, rs);
        return listaUsuarios;
    }

    @Override
    public List<Usuario> buscar(String string) throws SQLException {
        conn = ConnectionFactory.getConnection();
        sql = "SELECT * FROM USUARIO WHERE USUARIO LIKE '%" + string + "%';";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();
        List<Usuario> listaUsuarios = new ArrayList<>();
        while(rs.next()){
            Usuario u = new Usuario();
            u.setId(rs.getInt("ID"));
            u.setUsuario(rs.getString("USUARIO"));
            u.setSenha(rs.getString("SENHA"));
            u.setIdServidor(rs.getInt("IDSERVIDOR"));
            u.setAcesso(rs.getInt("ACESSO"));
            listaUsuarios.add(u);
        }
        ConnectionFactory.closeConnection(conn, stmt, rs);
        return listaUsuarios;
    }
}
