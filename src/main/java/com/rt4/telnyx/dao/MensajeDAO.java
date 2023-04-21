/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rt4.telnyx.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.rt4.telnyx.domain.Mensaje;
import java.util.ArrayList;
public class MensajeDAO {
    
        final private String INSERT_MENSAJE_QUERY = "INSERT INTO public.mensajes_poc_volkswagen (\"to\", \"from\", body, \"time\") VALUES(?, ?, ?, now());";
        final private String SELECT_ALL_MENSAJE_QUERY = "select * from mensajes_poc_volkswagen A where A.\"to\" = ? AND A.\"from\" = ? or A.\"from\" = ? AND A.\"to\" = ? order by A.\"time\" desc;";
    ConexionDB conndb = new ConexionDB();

    public void insertMensaje( Mensaje msj) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = conndb.conectarBD();
            ps = conn.prepareStatement(INSERT_MENSAJE_QUERY);
            ps.setString(1, msj.getTo());
            ps.setString(2, msj.getTo());
            ps.setString(3, msj.getBody());
            ps.executeUpdate();
            //LiverpoolRS.log.info("Registro insertado: " );
        } catch (SQLException ex) {
            //LiverpoolRS.log.info("Error al INSERTAR a la base de datos : " );
        } finally {
            conndb.close(ps);
            conndb.close(conn);
        }

    }
    
        public List<Mensaje> selectAllMensajes( String from , String to) {
        List<Mensaje> mensajes = new ArrayList<>();
        
        Connection conn = null;        
        PreparedStatement ps = null;
            ResultSet rs = null;
        try {
            conn = conndb.conectarBD();
            ps = conn.prepareStatement(SELECT_ALL_MENSAJE_QUERY);
            ps.setString(1, to);
            ps.setString(2, from);
            ps.setString(3, from);
            ps.setString(4, to);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                Mensaje msj = new Mensaje();
                msj.setId(rs.getInt("id"));
                msj.setFrom(rs.getString("from"));
                msj.setTo(rs.getString("to"));
                msj.setBody(rs.getString("body"));
                msj.setDirection(rs.getString("direction"));
                msj.setTime(rs.getTimestamp("time").toLocalDateTime());
                mensajes.add(msj);
                
            }
            //LiverpoolRS.log.info("Registro insertado: " );
        } catch (SQLException ex) {
            //LiverpoolRS.log.info("Error al INSERTAR a la base de datos : " );
        } finally {
            conndb.close(rs);
            conndb.close(ps);
            conndb.close(conn);            
        }
        return mensajes;

    }
     
    
}
