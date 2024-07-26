package pe.pcs.mysqlbasicoyt.data.dao

import java.sql.Connection
import java.sql.DriverManager


/**
 * An "object" is used to declare a class that has a single instance.
 * In other words, MySqlConexion is a singleton, which means that there is only
 * one instance of this class in the entire application.
 */
object MySqlConexion {
    /**
     * Connection is a Java Database Connectivity (JDBC) interface
     * that represents a connection to a database.
     */
    fun getConexion(): Connection {
        Class.forName("com.mysql.jdbc.Driver")

        return DriverManager.getConnection(
            "jdbc:mysql://172.24.112.1:3306/testprogramacion",
            "admin",
            "admin"
        )
    }
}