package plantaplus.plantaplus.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GeraConexao {

    private static final String USUARIO = "";
    private static final String SENHA = "";
    private static final String DATABASE = "plantaplus";
    private static final String DRIVER_CONEXAO = "com.mysql.jdbc.Driver";
    private static final String STR_CONEXAO = "jdbc:mysql://172.16.105.142:3306/";

    private static Connection conn;

    public static Connection getConexao() {
//

        conn = null;
        try {
            Class.forName(DRIVER_CONEXAO);
            setConexao(DriverManager.getConnection(STR_CONEXAO + DATABASE, USUARIO, SENHA));

            System.out.println("DEU CERTO");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver MySQL não foi encontrado " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com a base de dados " + e.getMessage());
        } catch (Exception e) {
            System.out.println("DEU PAU " + e.getMessage());
        }

        return conn;
    }

    public static void fechaConexao(Connection conn) {

        try {
            if (conn != null) {
                conn.close();
                System.out.println("Fechada a conexão com o banco de dados");
            }

        } catch (Exception e) {
            System.out.println("Não foi possível fechar a conexão com o banco de dados " + e.getMessage());
        }
    }

    public static void fechaConexao(Connection conn, PreparedStatement stmt) {

        try {
            if (conn != null) {
                fechaConexao(conn);
            }
            if (stmt != null) {
                stmt.close();
                System.out.println("Statement fechado com sucesso");
            }

        } catch (Exception e) {
            System.out.println("Não foi possível fechar o statement " + e.getMessage());
        }
    }

    public static void fechaConexao(Connection conn, PreparedStatement stmt, ResultSet rs) {

        try {
            if (conn != null || stmt != null) {
                fechaConexao(conn, stmt);
            }
            if (rs != null) {
                rs.close();
                System.out.println("ResultSet fechado com sucesso");
            }

        } catch (Exception e) {
            System.out.println("Não foi possível fechar o ResultSet " + e.getMessage());
        }
    }

    public static void setConexao(Connection connection){
        conn = connection;
    }
}
