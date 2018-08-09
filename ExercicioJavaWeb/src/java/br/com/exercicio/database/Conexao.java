package br.com.exercicio.database;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Gabriel Budke
 */
public class Conexao {

    private static String HOST ="jdbc:mysql//localhost/alunos_web";
    private static String USER = "root";
    private static String PASSWORD = "";
    private static String CLASS = "com.mysql.jdbc.Driver";
    private static Connection conexao;
    
    
    public static Connection obterConexao(){
        try{
            conexao = DriverManager.getConnection(HOST, USER, PASSWORD);
        }catch(Exception e){
            
        }
    }
    
    
}
