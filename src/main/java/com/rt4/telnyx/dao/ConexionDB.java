/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rt4.telnyx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author noejs
 */
public class ConexionDB {
         public Connection conectarBD() throws SQLException {
        InitialContext initContext;
        Connection cn = null;
        try {
            initContext = new InitialContext();
            DataSource ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/basePostgresql");
            cn = ds.getConnection();
            System.out.println("Se ha conectado a la base de datos");
        } catch (NamingException ex) {
            //LiverpoolRS.log.info("NO HAY CONEXION A LA BASE DE DATOS");
            //LiverpoolRS.log.info(ex.getMessage());
        } catch (SQLException ex) {
            //LiverpoolRS.log.info("NO HAY CONEXION A LA BASE DE DATOS");
            //LiverpoolRS.log.info(ex.getMessage());
        } catch (Exception ex) {
            //LiverpoolRS.log.info("NO HAY CONEXION A LA BASE DE DATOS");
            //LiverpoolRS.log.info(ex.getMessage());
        }
        if ((cn == null) || cn.isClosed()) {
            //LiverpoolRS.log.info("NO HAY CONEXION A LA BASE DE DATOS");
            throw new SQLException("NO HAY CONEXION A LA BASE DE DATOS basePostgresql");
        }
        return cn;
    }
     
      protected void close(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                
            }
        }
    }

    protected  void close(ResultSet rs, PreparedStatement ps) {
        close(rs);
             try {
                 ps.close();
             } catch (SQLException ex) {
                 Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
             }
    }

    protected  void close(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ex) {
                //LiverpoolRS.log.info(ex);
            }
        }
    }

    protected  void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                //LiverpoolRS.log.info( ex);
            }
        }
    }
    
}
