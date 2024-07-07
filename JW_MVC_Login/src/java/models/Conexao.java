/**
 * @author Marcos Melo
 */

package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
    
    private final String classDriver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost/proj1_java";
    private final String user = "root";
    private final String pass = "";

    public Connection conexao() {

        Connection con = null;

        try {
            // carregar o driver
            Class.forName(classDriver);

            // Obter a liga��o
            con = DriverManager.getConnection(url, user, pass);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao Abrir Conex�o: " + e.getMessage());

        }
        return con;
    }

    public void desligarConexao(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro ao Fechar Conex�o: " + e.getMessage());
        }
    }
}
