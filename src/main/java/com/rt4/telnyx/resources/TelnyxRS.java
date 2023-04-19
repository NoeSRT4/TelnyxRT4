package com.rt4.telnyx.resources;



import com.telnyx.sdk.model.InboundMessageEvent;
import com.telnyx.sdk.model.InboundMessagePayload;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLDecoder;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Properties;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.json.JSONObject;

@Path("/message")
public class TelnyxRS {

    public static Logger log = setLogger();
    static String msg;
    static String logNum;
    static String logLevel;

    static String AES_TLINK;
    static String AES_USER;
    static String AES_PASS;
    static String VDNConf;//EXTENSION

    @GET
    public Response ping() {
        log.info("ping");
        return Response
                .ok("ping : " + getPath())
                .build();
    }
    
    @POST
    @Path("/inbound")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response mesajeEntrada(String json){
        log.info("------------------------- INICIO -------------------------");
        
        
        log.info(json);
        log.info("-------------------------- FIN ---------------------------");
        return Response.ok().entity(json).build();
    }
    


//...............................................................  CONFIGURACION DE LOG Y CARGA DE PROPIEDADES
    public static Logger setLogger() {
        chargeProperties();
        System.setProperty("logFilePath", getPath());
        System.setProperty("logNumRecords", logNum);
        System.setProperty("logLevel", logLevel);

        return (Logger) LogManager.getLogger();
    }

    public static String getPath() {
        File currentJavaJarFile = new File(TelnyxRS.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        String currentJavaJarFilePath = currentJavaJarFile.getAbsolutePath();
        String currentRootDirectoryPath = currentJavaJarFilePath.replace(currentJavaJarFile.getName(), "");

        String path = "";

        try {
            path = URLDecoder.decode(currentRootDirectoryPath, "UTF-8");
        } catch (Exception ex) {

            ex.printStackTrace();
        }
        return path;
    }

    public static void chargeProperties() {
        String path = getPath();
        try {
            //File fileConf = new File("/home/CargaIniicaPeruProd/config.properties_dev");            
            File fileConf = new File(path + "/config.properties");
            //System.out.println("FileConfig " + fileConf);            
            FileInputStream fileInputConf = new FileInputStream(fileConf);
            Properties properties = new Properties();
            properties.load(fileInputConf);
            fileInputConf.close();

            //SERVER_DB = properties.getProperty("SERVER_DB");
            
            logLevel = properties.getProperty("LOG_LEVEL");
            logNum = properties.getProperty("LOG_NUM");
        } catch (Exception e) {
            e.printStackTrace(System.out);

        }
    }
    
    
   

}
