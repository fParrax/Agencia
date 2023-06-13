
package Clases;

import java.util.ArrayList;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;


public class Imprimir {
    
    
  
    
    public void enviarImpresion(int espaciosPrevios,String agencia,String fecha, String programa,String hora,
    String numTicket,String serial,String numJugadas,ArrayList<JugadasTicket> jugadas,double total){
       String espacios="";
        for(int i=0;i<espaciosPrevios;i++){
            espacios+="\n";
        }
       print(espacios);
       String texto =agencia+" "+fecha+" ("+programa+")\n" //Linea1
               + "Hora:"+hora+" TN:"+numTicket+" SN:"+serial+" NJ:"+numJugadas+"\n"//Linea2
               + "---------------------------";//Linea3
       
       String sorteoTemp="";
       double montoJugado=-1;
       int cont =0;
       int reps=1;
       for(JugadasTicket jugada:jugadas){
           if(montoJugado<0){
              montoJugado=jugada.getMonto(); 
           }
           if(!jugada.getSorteo().equals(sorteoTemp)){//DIFERENTE SORTEO
               texto+="\n    "+jugada.getSorteo()+"\n";
               if(jugada.getMonto()>montoJugado){
                      texto+="x"+montoJugado+" ";
                      texto+=jugada.getAnimal().substring(0, 4) +"-";
                      cont=0;
               }else{
                   if(cont>5){
                       texto+=jugada.getAnimal().substring(0, 4) +"\n";
                       cont=0;
                   }else{
                       texto+=jugada.getAnimal().substring(0, 4) +"-";
                       cont++;
                   }
               }
           }else{//ES EL MISMO SORTEO
               if(jugada.getMonto()>montoJugado){
                   texto+="x"+montoJugado+" ";
                 texto+=jugada.getAnimal().substring(0, 4) +"-";
                 cont=0;
               }else{
                   if(cont>5){
                       texto+=jugada.getAnimal().substring(0, 4) +"\n";
                       cont =0;
                   }else{
                       texto+=jugada.getAnimal().substring(0, 4) +"-";
                       cont++;
                   }
                   
               }
           }
           if(Float.compare(reps,6)==0 || Float.compare(reps,jugadas.size())==0){
               texto+=" x "+jugada.getMonto()+"";
           }
           reps++;
           montoJugado=jugada.getMonto();
           sorteoTemp=jugada.getSorteo();
       }
       
       texto+= "\n---------------------------\n"
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
