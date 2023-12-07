package Clases;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
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

    public void enviarImpresion(int espaciosPrevios, String agencia, String fecha, String hora,
            String numTicket, String serial, ArrayList<JugadasTicket> jugadas, double total) {

        double montoJugado = -1;
        int cont = 0, reps = 1;
        String espacios = "", sorteoTemp = "-", texto = "",programas="";

        //for(int i=0;i<espaciosPrevios;i++){
        for (int i = 0; i < espaciosPrevios - 1; i++) {
           // espacios += "\n";
        }
        print(espacios);
        texto = agencia + " " + fecha + " " + hora + "\n" //Linea1
                + "" + " TN:" + numTicket + " SN:" + serial.toUpperCase() + " " + " \n"//Linea2
                + "---------------------------";//Linea3

        
        ArrayList<JugadasTicket> lotto = new ArrayList();
        ArrayList<JugadasTicket> granja = new ArrayList();
        ArrayList<String> programasJugados = (ArrayList)jugadas
                .stream()
                .map(JugadasTicket::getPrograma)
                .distinct()
                .collect(Collectors.toList());
        
        for(String programa : programasJugados){
            programas += programa+" ";
            if(programa.equalsIgnoreCase("lottoactivo")){
                lotto = (ArrayList) jugadas
                        .stream()
                        .filter( t->t.getPrograma().equalsIgnoreCase(programa))
                        .collect(Collectors.toList());
            }else{
                granja  = (ArrayList) jugadas
                        .stream()
                        .filter( t->t.getPrograma().equalsIgnoreCase(programa))
                        .collect(Collectors.toList());
            }
            
        }
        
        if (granja.containsAll(lotto) && Float.compare(lotto.size(),granja.size())==0) {
            String separador = Pattern.quote(" ");
            String [] separado = new String[3];
            for (JugadasTicket jugada : granja) {
                
                if (montoJugado < 0) {
                    montoJugado = jugada.getMonto();
                }

                if (!jugada.getSorteo().equals(sorteoTemp)) {//DIFERENTE SORTEO
                    separado = jugada.getSorteo().split(separador);
                    if (!sorteoTemp.equalsIgnoreCase("-")) {
                        texto += "x" + montoJugado + " ";
                    }
                    texto += "\n    " + programas + separado[1]+" "+ separado[2] + "\n";
                    texto += jugada.getAnimal().substring(0, 4) + "-";
                    cont = 1;
                } else {//ES EL MISMO SORTEO
                    if (jugada.getMonto() > montoJugado) {
                        texto += "x" + montoJugado + " ";
                        texto += jugada.getAnimal().substring(0, 4) + "-";
                        cont = 0;
                    } else {
                        if (cont > 4) {
                            texto += "\n" + jugada.getAnimal().substring(0, 4);
                            cont = 0;
                        } else {
                            texto += jugada.getAnimal().substring(0, 4) + "-";
                            cont++;
                        }

                    }
                }

                reps++;
                montoJugado = jugada.getMonto();
                sorteoTemp = jugada.getSorteo();

            }
            texto += "x" + montoJugado + " ";
        } else {
            for (JugadasTicket jugada : jugadas) {

                if (montoJugado < 0) {
                    montoJugado = jugada.getMonto();
                }

                if (!jugada.getSorteo().equals(sorteoTemp)) {//DIFERENTE SORTEO
                    if (!sorteoTemp.equalsIgnoreCase("-")) {
                        texto += "x" + montoJugado + " ";
                    }
                    texto += "\n    " + jugada.getSorteo() + "\n";
                    texto += jugada.getAnimal().substring(0, 4) + "-";
                    cont = 1;
                } else {//ES EL MISMO SORTEO
                    if (jugada.getMonto() > montoJugado) {
                        texto += "x" + montoJugado + " ";
                        texto += jugada.getAnimal().substring(0, 4) + "-";
                        cont = 0;
                    } else {
                        if (cont > 4) {
                            texto += "\n" + jugada.getAnimal().substring(0, 4);
                            cont = 0;
                        } else {
                            texto += jugada.getAnimal().substring(0, 4) + "-";
                            cont++;
                        }

                    }
                }

                reps++;
                montoJugado = jugada.getMonto();
                sorteoTemp = jugada.getSorteo();

            }
            texto += "x" + montoJugado + " ";
        }

        texto += "\n----------------------------\n"
                + "Total Bs: " + total;

        print(texto);
        print("\n\n\n\n");
    }

    private void print(String cadena) {
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

    private boolean isSamePlays(ArrayList<JugadasTicket> jugadas) {
        ArrayList<JugadasTicket> lotto = new ArrayList();
        ArrayList<JugadasTicket> granja = new ArrayList();
        ArrayList<String> programasJugados = (ArrayList)jugadas
                .stream()
                .map(JugadasTicket::getPrograma)
                .distinct()
                .collect(Collectors.toList());
        
        for(String programa : programasJugados){
            if(programa.equalsIgnoreCase("lottoactivo")){
                lotto = (ArrayList) jugadas
                        .stream()
                        .filter( t->t.getPrograma().equalsIgnoreCase(programa))
                        .collect(Collectors.toList());
            }else{
                granja  = (ArrayList) jugadas
                        .stream()
                        .filter( t->t.getPrograma().equalsIgnoreCase(programa))
                        .collect(Collectors.toList());
            }
            
        }
        
        System.out.println("isSamePlays: "+granja.containsAll(lotto));

        return false;
    }
}
