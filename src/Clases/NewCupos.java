

package Clases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


public class NewCupos {
        static String hoy ="";
        static String fechaUsar ="";
        static int iterador = 0;
        static int minutes = 0;

    

    
        Date fechaTomanda = new Date();
    public NewCupos iniciar(){
        
        System.out.println("Iniciando Sistema...");
             setFecha();
             new  Thread(()->{
                    validarRecorrido();
             }).start();
             
            new Thread(() -> {
                 boolean flag=true;
            while (flag) {
                System.out.println("Recorriendo Sistema");
                if (sameDay()) {

                } else {
                    if (new Agencia().haveCuposIngresados(fechaUsar)) {
                        System.out.println("Ya tiene Cupos ingresados, iniciando espera...");
                        flag=false;
                        break;
                        //esperar(60);
                    } else {
                        if (new Agencia().crearCupos()) {
                            System.out.println("Los cupos fueron ingresados correctamente.");
                            esperar(1320);
                        } else {
                            System.out.println("Parece que hubo un problema para ingresar los cupos.");
                            esperar(2);
                        }
                    }
                }
            }
        }).start();
            return this;
    }
    public static void main(String[] args) {
       
             
             
    }
    
    
    
    
    private static void esperar (int newValue){
        minutes = newValue;     
        System.out.println("Empezamos a esperar "+minutes+" minutos");
            try {
                for (iterador = 0; iterador < minutes; iterador++) {
                    System.out.println("proceso espera "+iterador+"/"+minutes+"...");
                    Thread.sleep(60000);
                }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(NewCupos.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    private static void setFecha(){
        fechaUsar = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        hoy = "2024-01-01";
    }
    
    private static void validarRecorrido() {
         
            
                    
    }
    public static String sumarDiasFecha(String fechax, int dias) {
        Calendar calendar = Calendar.getInstance();
        try {

            Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechax);
            calendar.setTime(fecha);
            calendar.add(Calendar.DAY_OF_YEAR, dias);
        } catch (ParseException ex) {
            Logger.getLogger(NewCupos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
    }
    public static Date sumarDiasFechaDate(Date fechax, int dias) {
        Calendar calendar = Calendar.getInstance();
        //Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechax);
        calendar.setTime(fechax);
        calendar.add(Calendar.DAY_OF_YEAR, dias);
        return calendar.getTime();
    }
    public static int restarMinutos(Date horaInicial, Date horaFinal) {
    int rsp=0;   
        long diff = horaFinal.getTime() - horaInicial.getTime();
        //System.out.println("dif: "+diff);
        long days = diff / (1000 * 60 );//Horas(1000 * 60*60 )//dias(1000 * 60*60*24 )
        rsp =(int)days;
        return rsp;
    }
    public static long diferenciaFecha(String fecha01, String fecha02){
        long diffrence=0;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date firstDate = sdf.parse(fecha01);
            Date secondDate = sdf.parse(fecha02);
            
            long diff = secondDate.getTime() - firstDate.getTime();
            
            TimeUnit time = TimeUnit.DAYS;
             diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
            
            
        } catch (ParseException ex) {
            Logger.getLogger(NewCupos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return diffrence; 
    }
    private static boolean sameDay() {
        fechaUsar = new SimpleDateFormat("yyyy-MM-dd").format(new Date());  
        int diferencia = (int) diferenciaFecha(hoy,fechaUsar);  
          if(diferencia < 0 || diferencia > 0){
              hoy = new SimpleDateFormat("yyyy-MM-dd").format(new Date());  
              return false;
          }else{
              return true;
          }
    }
}
