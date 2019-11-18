/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;



/**
 *
 * @author cnk
 */
public interface Conexion {
    public void Conectar();
    public Connection getConexion();
    public void Desconectar();
}
