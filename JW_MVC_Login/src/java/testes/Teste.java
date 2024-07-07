/**
 * @author Marcos Melo
 */

package testes;


import java.sql.Connection;
import java.sql.SQLException;
import models.Conexao;

public class Teste {
    
    public static void main(String[] args) {

        try {
            Conexao conexao = new Conexao();
            Connection con = null;
              con = conexao.conexao();
            System.out.println(con.isClosed()); // false tem conexão.
            
            conexao.desligarConexao(con);
            System.out.println(con.isClosed()); // true conexão fechada.
            
        } catch (SQLException ex) {
        }
        
        /*
        DaoUser daoUser = new DaoUser();
        for (UserModel user : daoUser.getAllUsers()) {
            System.out.println(user.getIdUser());
            System.out.println(user.getUserName());
            System.out.println(user.getCreatedAt());
        }
        */
        


    }
    
}
