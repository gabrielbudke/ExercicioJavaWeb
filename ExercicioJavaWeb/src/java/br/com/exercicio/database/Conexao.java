package br.com.exercicio.database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Gabriel Budke
 */
public class Conexao {

    private static String HOST = "jdbc:mysql://localhost/alunos_web";
    private static String USER = "root";
    private static String PASSWORD = "";
    private static String CLASS = "com.mysql.jdbc.Driver";
    private static Connection conexao;

    public static Connection obterConexao() {
        try {
            Class.forName(CLASS);
            conexao = DriverManager.getConnection(HOST, USER, PASSWORD);
            return conexao;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void fecharConexao() {
        try {
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /*public static void main(String[] args) {
        Conexao.obterConexao();
    }
    */
}
