package Clases;

import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Actualizar extends Propiedades{

     double versionActual,versionServer;
    
     public Actualizar(){
         super();
         versionActual = Double.parseDouble(getVersionLocal());
         versionServer = Double.parseDouble(getVersionServer().replace("version=", ""));
     }

    public void checkUpdate(){
        if(!idUpdated()){
            descargar("Updatter");
            setNewVersion(String.valueOf(versionServer));
        }
        /*
        else{
           openExcecutable();
        }
        System.exit(0);
        */
        
    }

    private String obtenerContenidoURL(String url) {
        String contenido = "error";
        
        try {
            URL myUrl = new URL(url);
            URLConnection con = myUrl.openConnection();
            con.connect();
             
            Scanner scanner = new Scanner(myUrl.openStream()).useDelimiter("\\Z");
            contenido = scanner.next();
            //System.out.println(contenido);
            return contenido;
        } catch (IOException ex) {
            Logger.getLogger(Actualizar.class.getName()).log(Level.SEVERE, null, ex);
            return contenido;
        }

    }

    private String getVersionLocal() {
        
        File temp = new File(LOCATE_PATCH+"\\"+PROPERTIES_NAME_FILE);
        if(!temp.exists()){
             descargar("properties");
             descargar("Updatter");
        }
        
        if(!myProperties.isEmpty()){
            return getPropiedad("version");
        }else{
            openProperties();
            return getPropiedad("version");
        }
        
    }
    
    public String getVersionServer(){
        return obtenerContenidoURL(URL_Properties_Cloud);
    }
    
    private void setNewVersion(String version){
       setPropert("version", version);
    }
    
    public void downloadUpdate(){
        downloadExecutable();
        setNewVersion(String.valueOf(versionServer));
        //openExcecutable();
    }
    
    private void downloadExecutable(){
        try {
            URL url = new URL(URL_Updatter_Cloud);
            File file = new File(LOCATE_PATCH+NAME_UPDATTER);
            /*
            String username = "siaceces";
            String password = "107swUPRu2";
            Authenticator.setDefault(new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password.toCharArray());
                }
            });
            */
            
            
        URLConnection connection = url.openConnection();
        long size = connection.getContentLengthLong();
        InputStream inputStream = connection.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        FileOutputStream outputStream = new FileOutputStream(file);
        byte[] bytes = new byte[1024];
        int bytesRead;
        while ((bytesRead = bufferedInputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, bytesRead);
        }
        outputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(Actualizar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void downloadConfigDB(){
        try {
            URL url = new URL(URL_DB_Cloud);
            File file = new File(LOCATE_PATCH+"/config.db");
            /*
            String username = "siaceces";
            String password = "107swUPRu2";
            Authenticator.setDefault(new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password.toCharArray());
                }
            });
            */
            
            
            
        URLConnection connection = url.openConnection();
        long size = connection.getContentLengthLong();
        InputStream inputStream = connection.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        FileOutputStream outputStream = new FileOutputStream(file);
        byte[] bytes = new byte[1024];
        int bytesRead;
        while ((bytesRead = bufferedInputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, bytesRead);
        }
        outputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(Actualizar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private boolean idUpdated(){
        return versionServer>versionActual
                ? false
                : true;
    }

    public void openExcecutable() {
        
        File file_Excecutable = new File(LOCATE_PATCH + NAME_UPDATTER);
        if (!file_Excecutable.exists()) {
            downloadExecutable();
            openFile(LOCATE_PATCH + NAME_UPDATTER);
        } else {
            openFile(LOCATE_PATCH + NAME_UPDATTER);
        }
    }
    protected void openFile(String URL) {
        try {
            File file = new File(URL);
            if(!file.exists()){
                downloadExecutable();
                Desktop.getDesktop().open(file);
            }else{
                Desktop.getDesktop().open(file);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
