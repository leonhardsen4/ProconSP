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
                                                               
                """);
        stmt.close();
        ConnectionFactory.closeConnection(conn);
    }


}
