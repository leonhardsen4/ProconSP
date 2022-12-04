package br.gov.sp.procon.controller;

import br.gov.sp.procon.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface MetodosBasicos<T> {

    void adicionar(T t) throws SQLException;
    void editar(T t) throws SQLException;
    void remover (T t) throws SQLException;
    List<T> listarTodos() throws SQLException;
    List<T> buscar(String string) throws SQLException;
}
