package br.fiap.connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
    private static String USER = "rm558539";
    private static String PASSWORD = "051105";

    private Conexao() {};

    public static java.sql.Connection conectar () {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("ERROR TO CONNECT DATA BASE: " + e);
        }
        return null;
    }
}
