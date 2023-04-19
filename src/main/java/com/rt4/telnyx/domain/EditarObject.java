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
public class EditarObject implements Serializable{
    private static final long serialVersionUID = 1L;
    
    String TYPE;
    String EDICION;    
    String SESSIONID;    
    String EXTENSION;
    String NUMTARJETA;

    public EditarObject() {
    }

    public EditarObject(String TYPE, String EDICION, String SESSIONID, String EXTENSION) {
        this.TYPE = TYPE;
        this.EDICION = EDICION;
        this.SESSIONID = SESSIONID;
        this.EXTENSION = EXTENSION;
    }

    public EditarObject(String TYPE, String EDICION, String SESSIONID, String EXTENSION, String NUMTARJETA) {
        this.TYPE = TYPE;
        this.EDICION = EDICION;
        this.SESSIONID = SESSIONID;
        this.EXTENSION = EXTENSION;
        this.NUMTARJETA = NUMTARJETA;
    }
    

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public String getEDICION() {
        return EDICION;
    }

    public void setEDICION(String EDICION) {
        this.EDICION = EDICION;
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

    public String getNUMTARJETA() {
        return NUMTARJETA;
    }

    public void setNUMTARJETA(String NUMTARJETA) {
        this.NUMTARJETA = NUMTARJETA;
    }
    
    

    
}
    
    


    