package conexion;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cnk
 */
public class Pool implements Conexion {
    private Connection conn;
    private DataSource dataSource;
    private String db;  
    private String url;
    private String user;
    private String password;  
        
    public Pool(){
        this.conn = null;
        this.dataSource = null;
        this.db = "VendeYa";
        this.password = "Hola.hola1";
        this.url = "jdbc:mysql://localhost:3306/"+this.db;
        this.user = "developer";
        this.initDataSource();
    }
    
    @Override
    public void Conectar() {
        try {
            this.conn = this.dataSource.getConnection();
        } catch (Exception  e) {
            System.out.println("Error en Conexion[JDBC: " + e.getMessage());
        } 
    }

    @Override
    public Connection getConexion() {
        return this.conn;
    }

    @Override
    public void Desconectar() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            System.out.println("Error en Conexion[JDBC: " + e.getMessage());
        }
    }
    

    
    private void initDataSource(){
        BasicDataSource bDS = new BasicDataSource();
        bDS.setDriverClassName("com.mysql.jdbc.Driver");
        bDS.setUsername(user);
        bDS.setPassword(password);
        bDS.setUrl(url);
        bDS.setMaxActive(50);
        
        this.dataSource = bDS;
    }
}
