package br.gov.sp.procon.utils;

import java.sql.*;

public class Database {

    Connection conn;

    public void createTables() throws SQLException {
        conn = ConnectionFactory.getConnection();
        Statement stmt = conn.createStatement();
        stmt.execute("""
                --TABELA USUARIO--
                CREATE TABLE IF NOT EXISTS USUARIO (
                    ID         INTEGER PRIMARY KEY AUTOINCREMENT,
                    USUARIO    TEXT    NOT NULL,
                    SENHA      TEXT    NOT NULL,
                    IDSERVIDOR         REFERENCES SERVIDOR (ID) NOT NULL,
                    ACESSO     TEXT    NOT NULL
                );
                
                --TABELA SERVIDOR--
                CREATE TABLE IF NOT EXISTS SERVIDOR (
                    ID       INTEGER PRIMARY KEY AUTOINCREMENT,
                    NOME     TEXT    NOT NULL,
                    TELEFONE TEXT,
                    EMAIL    TEXT,
                    IDSETOR          REFERENCES SETOR (ID),
                    CARGO    TEXT
                );
                
                --TABELA ENTIDADE--
                CREATE TABLE ENTIDADE (
                    ID   INTEGER PRIMARY KEY AUTOINCREMENT,
                    NOME TEXT    NOT NULL
                                 UNIQUE ON CONFLICT ROLLBACK
                );
                
                --TABELA SETOR--
                CREATE TABLE IF NOT EXISTS SETOR (
                    ID                 INTEGER PRIMARY KEY AUTOINCREMENT,
                    IDENTIDADE                 REFERENCES ENTIDADE (ID),
                    IDENDERECOENTIDADE INT,
                    SETOR              TEXT    NOT NULL,
                    SIGLA              TEXT
                );
                
                --TABELA ENDEREÇO--
                CREATE TABLE ENDERECO (
                    ID          INTEGER PRIMARY KEY AUTOINCREMENT,
                    LOGRADOURO  TEXT,
                    NUMERO      TEXT,
                    COMPLEMENTO TEXT,
                    BAIRRO      TEXT,
                    MUNICIPIO   TEXT,
                    UF          TEXT,
                    OBSERVACOES TEXT,
                    IDENTIDADE  INTEGER REFERENCES ENTIDADE (ID)
                );
                
                """);
        ConnectionFactory.closeConnection(conn, stmt);
    }


}
