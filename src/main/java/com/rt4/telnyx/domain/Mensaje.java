
package com.rt4.telnyx.domain;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class Mensaje {
    
    private int id;
    private String from;
    private String to;
    private String direction;
    private String body ;
    private LocalDateTime time;
    
    public Mensaje(){}
    
    public Mensaje(String to, String body){
        this.to = to;
        this.body = body;        
    }
    public Mensaje(String to, String from, String body, String direcction){
        this.to = to;
        this.from = from;
        this.direction = direcction;
        this.body = body;        
    }
    

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Mensaje{" + "from=" + from + ", to=" + to + ", direction=" + direction + ", body=" + body + ", time=" + time + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
