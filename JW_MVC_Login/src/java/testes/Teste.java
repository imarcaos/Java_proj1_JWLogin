/**
 * @author Marcos Melo
 */

package testes;


import dao.DaoUser;
import java.sql.Connection;
import java.sql.SQLException;
import models.Conexao;
import models.UserModel;

public class Teste {
    
    public static void main(String[] args) {
// teste 1
//        try {
//            Conexao conexao = new Conexao();
//            Connection con = null;
//              con = conexao.conexao();
//            System.out.println(con.isClosed()); // false tem conex√£o.
//            
//            conexao.desligarConexao(con);
//            System.out.println(con.isClosed()); // true conex√£o fechada.
//            
//        } catch (SQLException ex) {
//        }
//  teste 2              
//        DaoUser daoUser = new DaoUser();
//        for (UserModel user : daoUser.getAllUsers()) {
//            System.out.println(user.getIdUser());
//            System.out.println(user.getUserName());
//            System.out.println(user.getCreatedAt());
//        }        
// teste 3
          UserModel userModel = new UserModel();
          userModel.setUserName("Margarida");
          userModel.setUserEmail("margarida@email.com");
          DaoUser daoUser = new DaoUser();
          boolean result = daoUser.createUser(userModel);
          if(result) {
              System.out.println("Registo Inserido com Sucesso!");
          } else {
              System.out.println("Erro na InserÁ„o do Registo");
          }

    }
    
}
