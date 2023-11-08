
package Clases;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;


public class Imprimir {
    
    
    public static void main(String[] args) {
        try {
            System.out.println(new EncriptadorAES().encriptar("123"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Imprimir.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Imprimir.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(Imprimir.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(Imprimir.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Imprimir.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(Imprimir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void enviarImpresion(int espaciosPrevios,String agencia,String fecha, String programa,String hora,
    String numTicket,String serial,String numJugadas,ArrayList<JugadasTicket> jugadas,double total){
       String espacios="";
        for(int i=0;i<espaciosPrevios;i++){
            espacios+="\n";
        }
       print(espacios);
       String texto =agencia+" "+fecha+" "+hora+"\n" //Linea1
               + ""+" TN:"+numTicket+" SN:"+serial.toUpperCase()+" "+" \n"//Linea2
               + "---------------------------";//Linea3
       
       String sorteoTemp="-";
       double montoJugado=-1;
       int cont =0;
       int reps=1;
       
        
       for(JugadasTicket jugada:jugadas){
          
           if(montoJugado<0){
              montoJugado=jugada.getMonto(); 
           }
           if(!jugada.getSorteo().equals(sorteoTemp)  ){//DIFERENTE SORTEO
               if(!sorteoTemp.equalsIgnoreCase("-")){
                   texto+="x"+montoJugado+" ";
               }
               
               texto+="\n    "+jugada.getSorteo()+"\n";
               texto+=jugada.getAnimal().substring(0, 4) +"-";
               cont=1;
               
               
           }else{//ES EL MISMO SORTEO
               if(jugada.getMonto()>montoJugado){
                   texto+="x"+montoJugado+" ";
                 texto+=jugada.getAnimal().substring(0, 4) +"-";
                 cont=0;
               }else{
                   if(cont>4){
                       texto+="\n"+jugada.getAnimal().substring(0, 4) ;
                       cont =0;
                   }else{
                       texto+=jugada.getAnimal().substring(0, 4) +"-";
                       cont++;
                   }
                   
               }
           }
           
           reps++;
           montoJugado=jugada.getMonto();
           sorteoTemp=jugada.getSorteo();
           
       }
        texto+="x"+montoJugado+" ";
    
       
       texto+= "\n-------------xpf------------\n"
               + "Total Bs: "+total;
       
       
       
       print(texto);
       print("\n\n\n\n");
    }
    
    
      private  void print(String cadena){
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
//Aqui selecciona tu impresora, el ejemplo tomará la impresora predeterminada.
        PrintService service = PrintServiceLookup.lookupDefaultPrintService();
        DocPrintJob pj = service.createPrintJob();
        byte[] bytes = cadena.getBytes();
        Doc doc = new SimpleDoc(bytes, flavor, null);
        try {
            pj.print(doc, null);
        } catch (PrintException e) {
            System.out.println(e);
        }
    }
}
