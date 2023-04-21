
package com.rt4.telnyx.service;

import com.rt4.telnyx.dao.MensajeDAO;
import com.rt4.telnyx.domain.Mensaje;
import java.util.List;


public class MensajeServicio {
    MensajeDAO mensajeDAO = new MensajeDAO();
    public List<Mensaje> getMensajes(String from, String to){
        return mensajeDAO.selectAllMensajes(from, to);
    }
    
    public void addMensaje(Mensaje msj){
         mensajeDAO.insertMensaje(msj);
    }
}
