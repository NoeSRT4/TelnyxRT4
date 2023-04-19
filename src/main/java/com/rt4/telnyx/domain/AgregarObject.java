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
public class AgregarObject implements Serializable{
    private static final long serialVersionUID = 1L;
    
    
    String TYPE;
    String AGREGAR;    
    String SESSIONID;    
    String EXTENSION;

    public AgregarObject() {
    }

    public AgregarObject(String TYPE, String AGREGAR, String SESSIONID, String EXTENSION) {
        this.TYPE = TYPE;
        this.AGREGAR = AGREGAR;
        this.SESSIONID = SESSIONID;
        this.EXTENSION = EXTENSION;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public String getAGREGAR() {
        return AGREGAR;
    }

    public void setAGREGAR(String AGREGAR) {
        this.AGREGAR = AGREGAR;
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
    
    


    