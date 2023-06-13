package Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Actualizar {

    String carpetaDownnload = "C:\\DataCaps\\";
    static String urlProyecto ="https://github.com/fParrax/CapsPacientes2022/raw/main/";
    static final String nameDataFile ="data.properties";
    //int len = carpetaDownnload.length();
     boolean llaveVersion=false;
     
     
     
    public void descargar(String URLx, String nameArchivox) {
        //carpetaDownnload = carpetaDownnload.substring(0, len - 1);
        String nameArchivo = nameArchivox;

        try {
            // Url con la foto
            URL url = new URL(URLx);

            // establecemos conexion
            URLConnection urlCon = url.openConnection();

            // Sacamos por pantalla el tipo de fichero
            System.out.println(urlCon.getContentType());

            // Se obtiene el inputStream de la foto web y se abre el fichero
            // local.
            InputStream is = urlCon.getInputStream();
            FileOutputStream fos = new FileOutputStream(carpetaDownnload + nameArchivo);

            // Lectura de la foto de la web y escritura en fichero local
            byte[] array = new byte[1000]; // buffer temporal de lectura.
            int leido = is.read(array);
            while (leido > 0) {
                fos.write(array, 0, leido);
                leido = is.read(array);
            }

            // cierre de conexion y fichero.
            is.close();
            fos.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error descargando actualización \n" + e);
        }

    }

    public boolean verificarConexión(String urlx) {
        try {

            URL urlxx = new URL(urlx);
            URLConnection con = urlxx.openConnection();
            con.connect();
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error descargando actualización \n" + e);
            return false;
        }
    }

    public String getVersion() {
        try {
            URL url = new URL("https://raw.githubusercontent.com/fParrax/CapsPacientes2022/main/version.txt");

            URLConnection con = url.openConnection();
            con.connect();
            return obtenerContenidoURL(url);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error descargando actualización \n" + e);
            return "-";
        }
    }

    public String obtenerContenidoURL(URL url) {
        String a = "-";
        try {
            Scanner s = new Scanner(url.openStream()).useDelimiter("\\Z");
            a = s.next();
            return a;
        } catch (IOException ex) {
            Logger.getLogger(Actualizar.class.getName()).log(Level.SEVERE, null, ex);
            return a;
        }

    }

    public String getVersionActual() {
       // carpetaDownnload = carpetaDownnload.substring(0, len - 1);
        String archivo = carpetaDownnload+"data.properties";
        FileReader f = null;
        String cadena = "";
        String valor = "";
        try {

            File temp = new File(archivo);
            if(!temp.exists()){
                crearVersion();
            }
            
            
            f = new FileReader(archivo);
            
            BufferedReader b = new BufferedReader(f);
            while ((cadena = b.readLine()) != null) {
                valor = cadena;
                if(valor.contains("version")){
                    break;
                }
            }
            b.close();

        } catch (FileNotFoundException ex) {
            
            if(llaveVersion == false){
                crearVersion();
                getVersionActual();
                llaveVersion=true;
            }else{
                Logger.getLogger(Actualizar.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(Actualizar.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(f!=null){
                    f.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Actualizar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valor;
    }
   
    private void crearVersion(){
         try {
        //carpetaDownnload = carpetaDownnload.substring(0, len - 1);
        String archivo = carpetaDownnload+"data.properties";
            //String contenido = "0.1";
            File file = new File(archivo);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                descargar(urlProyecto+nameDataFile, nameDataFile);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void setNewVersion(String version){
        
        /*
        Properties p = new Properties();
        String rutaArchivos= "C:\\DataCaps\\";
        
        File temp = new File(rutaArchivos + "version.txt");
        if (temp.exists()) {
            try {
                p.load(new FileReader(rutaArchivos + "version.txt"));
                p.setProperty("version", version);
                p.store(new FileWriter(rutaArchivos +"version.txt"),"Guardado");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex);
            }
        } else {
           // obtenerPropierties(rutaArchivos);
        }
        */
        
        
        
        
    }

}
