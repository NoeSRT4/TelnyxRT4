/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rt4.telnyx.domain;

import java.io.Serializable;

/**
 *
 * @author noejs
 */
public class SeleccionarObject implements Serializable{
    private static final long serialVersionUID = 1L;
    
    
    String TYPE;
    String NUMTARJETA;    
    String SESSIONID;    
    String EXTENSION;

    public SeleccionarObject() {
    }

    public SeleccionarObject(String TYPE, String NUMTARJETA, String SESSIONID, String EXTENSION) {
        this.TYPE = TYPE;
        this.NUMTARJETA = NUMTARJETA;
        this.SESSIONID = SESSIONID;
        this.EXTENSION = EXTENSION;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public String getNUMTARJETA() {
        return NUMTARJETA;
    }

    public void setNUMTARJETA(String NUMTARJETA) {
        this.NUMTARJETA = NUMTARJETA;
    }

    public String getSESSIONID() {
        return SESSIONID;
    }

    public void setSESSIONID(String SESSIONID) {
        this.SESSIONID = SESSIONID;
    }

    public String getEXTENSION() {
        return EXTENSION;
    }

    public void setEXTENSION(String EXTENSION) {
        this.EXTENSION = EXTENSION;
    }

  
    
}
    
    


    