package com.rt4.telnyx.resources;

import com.rt4.telnyx.domain.Mensaje;
import com.rt4.telnyx.service.MensajeServicio;


import java.io.File;
import java.io.FileInputStream;
import java.net.URLDecoder;
import java.util.List;



import java.util.Properties;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.json.JSONObject;


@Path("/message")
public class TelnyxRS {
    MensajeServicio mensajeServicio = new MensajeServicio();
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
    @Path("outbound")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response enviarMensaje(Mensaje msj){
        //ENVIAR MENSAJE
        //GUARDAR MENSAJE EN DB
    
        return null;
    }
    
    @GET
    @Path("get/{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerMensajes(@PathParam("from") String from,@PathParam("to") String to){
        log.info("------------------------- INICIO get/{from}/{to}-------------------------");
        log.info("from:" + from);
        log.info("to:" + to);
        log.info("Obteniendo mensajes");
        List<Mensaje> listaMensajes = mensajeServicio.getMensajes(from, to);
        JSONObject mensajesJSON = new JSONObject(listaMensajes);
        
        log.info("-------------------------   FIN  get/{from}/{to}-------------------------");
        return Response.ok().entity(mensajesJSON.toString()).build();
        
    }
    
    
    @POST
    @Path("/inbound")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response mesajeEntrada(String jsonString){
        log.info("------------------------- INICIO /inbound-------------------------");
        log.info(jsonString);
        JSONObject json = new JSONObject(jsonString);
        String to = json.getJSONObject("data").getJSONObject("payload").getJSONObject("from").getString("phone_number");
        String from = json.getJSONObject("data").getJSONObject("payload").getJSONArray("to").getJSONObject(0).getString("phone_number");
        String body = json.getJSONObject("data").getJSONObject("payload").getString("text");
        String direction = json.getJSONObject("data").getJSONObject("payload").getString("direction");
        Mensaje msj = new Mensaje(to,from,body,direction);        
        log.info("Añadiendo mensaje");
        log.info(msj.toString());
        mensajeServicio.addMensaje(msj);
        log.info("-------------------------- FIN /inbound---------------------------");
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
