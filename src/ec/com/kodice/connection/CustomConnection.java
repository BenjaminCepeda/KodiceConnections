/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ec.com.kodice.connection;

import java.sql.*;

/**
 * Esta clase permite la conexión a Base de Datos
 * @author Benjamin Cepeda
 * @version v1.0
 * @date 2020/12/03 
 */
public class CustomConnection {
    private static String driverClass = "com.mysql.jdbc.Driver";
    private static String hostName= "localhost";
    private static String userName="rapiperchaUser";
    private static String password="rapiperchaPassword";
    private static String dataBaseName="rapiperchaDB";
    private static String url= "jdbc:mysql://" +hostName + "/" + dataBaseName;

    private static Connection connection = null;

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
      if (connection == null) {
         try {
            Class.forName(driverClass);
            connection = DriverManager.getConnection(url, userName, password);
         } catch (SQLException e) {
            throw new SQLException(e);
         } catch (ClassNotFoundException e) {
            throw new ClassCastException(e.getMessage());
         }
      }
      return connection;
    }
    
    public static void close() throws SQLException {
      if (connection != null) {
         try {
             connection.close();
         } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
   }
    
}
