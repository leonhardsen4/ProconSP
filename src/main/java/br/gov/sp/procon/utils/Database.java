package br.gov.sp.procon.utils;

import java.sql.*;

public class Database {

    static Connection conn;

    public static void createTables() throws SQLException {
        conn = ConnectionFactory.getConnection();
        Statement stmt = conn.createStatement();
        stmt.execute("""
                --TABELA USUARIO--
                CREATE TABLE USUARIO (
                    ID      INTEGER PRIMARY KEY AUTOINCREMENT,
                    USUARIO TEXT    NOT NULL,
                    NOME            NOT NULL,
                    SENHA   TEXT    NOT NULL
                                    DEFAULT (12345)
                );
                                                               
                """);
        ConnectionFactory.closeConnection(conn, stmt);
    }


}
