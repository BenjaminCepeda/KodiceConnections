/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.kodice.connection;

import java.sql.*;

/**
 * Esta clase permite la conexión a Base de Datos
 *
 * @author Benjamin Cepeda
 * @version v1.0
 * @date 2020/12/03
 */
public class CustomConnection {

    private static String driverClass = "com.mysql.cj.jdbc.Driver";
    private static String hostName = "localhost";
    private static String port = "3306";
    private static String userName = "rapiperchauser";
    private static String password = "rapiperchapassword";
    private static String dataBaseName = "rapiperchadb";
    private static String url = "jdbc:mysql://" + hostName + ":" + port
            + "/" + dataBaseName + "?serverTimezone=UTC";
    private static String thisClassName = "CustomConnection";
    private static Connection connection = null;

    public static Connection getConnection() throws Exception {
        if (connection == null) {
            try {
                Class.forName(driverClass);
                connection = DriverManager.getConnection(url, userName, password);
            } catch (SQLException e) {
                throw new Exception("[" + thisClassName + "] " + e.getMessage());
            } catch (ClassNotFoundException e) {
                throw new Exception("[" + thisClassName + "] " + e.getMessage());
            }
        }
        return connection;
    }

    public static void close() throws Exception {
        if (connection != null) {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new Exception("[" + thisClassName + "] " + e.getMessage());
            }
            finally{
                connection = null;                        
            }
        }
    }

}
