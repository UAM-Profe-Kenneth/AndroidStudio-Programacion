package pe.pcs.mysqlbasicoyt.data.dao

import java.sql.Connection
import java.sql.DriverManager

object MySqlConexion {
    fun getConexion(): Connection {
        Class.forName("com.mysql.jdbc.Driver")

        return DriverManager.getConnection(
            "jdbc:mysql://172.24.112.1:3306/testprogramacion",
            "admin",
            "admin"
        )
    }
}