package br.gov.sp.procon.utils;

import java.sql.*;

public class Database {

    static Connection conn;

    public static void createTables() throws SQLException {
        conn = ConnectionFactory.getConnection();
        Statement stmt = conn.createStatement();
        stmt.execute("""
                --TABELA USUARIO--
                CREATE TABLE IF NOT EXISTS USUARIOS (
                      ID      INTEGER   PRIMARY KEY AUTOINCREMENT,
                      USUARIO TEXT      NOT NULL
                                        UNIQUE ON CONFLICT ROLLBACK,
                      NOME              NOT NULL
                                        UNIQUE ON CONFLICT ROLLBACK,
                      SENHA   TEXT (64) NOT NULL
                                        DEFAULT (12345)
                  );
                  
                  --TABELA ENTIDADES--
                  CREATE TABLE IF NOT EXISTS ENTIDADES (
                      ID   INTEGER PRIMARY KEY AUTOINCREMENT,
                      NOME TEXT    UNIQUE ON CONFLICT ROLLBACK
                                   NOT NULL
                  );
                  
                  --TABELA ENDEREÇOS--
                  CREATE TABLE IF NOT EXISTS ENDERECOS (
                      ID          INTEGER PRIMARY KEY AUTOINCREMENT,
                      ID_ENTIDADE  INTEGER REFERENCES ENTIDADES (ID)
                                          NOT NULL ON CONFLICT ROLLBACK,
                      CEP         TEXT    NOT NULL ON CONFLICT ROLLBACK,
                      LOGRADOURO  TEXT    NOT NULL ON CONFLICT ROLLBACK,
                      NUMERO      TEXT,
                      COMPLEMENTO TEXT,
                      BAIRRO      TEXT,
                      MUNICIPIO   TEXT    NOT NULL ON CONFLICT ROLLBACK,
                      UF          TEXT    NOT NULL ON CONFLICT ROLLBACK
                  );
                  
                  --TABELA UNIDADES__
                  CREATE TABLE IF NOT EXISTS UNIDADES (
                      ID                   INTEGER PRIMARY KEY AUTOINCREMENT,
                      ID_ENTIDADE          INTEGER REFERENCES ENTIDADES (ID)
                                                   NOT NULL ON CONFLICT ROLLBACK,
                      ID_ENDERECO_ENTIDADE INTEGER REFERENCES ENDERECOS (ID)
                                                   NOT NULL ON CONFLICT ROLLBACK,
                      UNIDADE              TEXT    NOT NULL ON CONFLICT ROLLBACK
                  );
                  
                  --TABELA SERVIDORES--
                  CREATE TABLE IF NOT EXISTS SERVIDORES (
                      ID         INTEGER PRIMARY KEY AUTOINCREMENT,
                      NOME       TEXT    NOT NULL ON CONFLICT ROLLBACK,
                      TELEFONE   TEXT,
                      EMAIL      TEXT,
                      ID_UNIDADE INTEGER REFERENCES UNIDADES (ID)
                                         NOT NULL ON CONFLICT ROLLBACK,
                      CARGO      TEXT
                  );
                                                               
                """);
        stmt.close();
        ConnectionFactory.closeConnection(conn);
    }


}
