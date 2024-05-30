package Clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;

public class Imprimir {

    String textoImprimir="";
    
    static class SortByHoraSorteo implements Comparator<JugadasTicket> {
        @Override
        public int compare(JugadasTicket a, JugadasTicket b) {
            if( a.getHoraSorteoDouble2() - b.getHoraSorteoDouble2() < 0 ) return -1;
            if( a.getHoraSorteoDouble2() - b.getHoraSorteoDouble2() > 0 ) return 1;
            return 0;
        }
}
    
    static class SortByPrograma implements Comparator<JugadasTicket> {
    @Override
    public int compare(JugadasTicket a, JugadasTicket b) {
        return a.getPrograma().compareTo(b.getPrograma());
    }
}



    public void send(String nombreAgencia,String fecha, String hora, String numTicket,String serialTicket,ArrayList<JugadasTicket> jugadas, double total){
        jugadas = ordenarJugadas(jugadas);
        addInfo(nombreAgencia+" ");
        addInfo(fecha+" ");
        addInfo("TN:"+numTicket);
        addInfo(" SN:"+serialTicket);
        addSeparador();
        
        String programaTemp="",animalTemp="",horaTemp="";
        
        jugadas.forEach(jugada ->{
            
        });
        
        //ArrayList<JugadasTicket> jugadasRepetidas = jugadas.stream().filter(predicate)
        
        
        
        
        //print(textoImprimir);
        System.out.println(textoImprimir);
        print("\n\n\n\n");
    }
    
    private String addInfo(String valor){
         return textoImprimir+=valor;
    }
    private void addSeparador(){
        textoImprimir+="\n---------------------------\n";
    }
    
    public ArrayList<JugadasTicket> ordenarJugadas ( ArrayList<JugadasTicket> jugadas){

        ArrayList<JugadasTicket> temp = new ArrayList();
        
        jugadas.stream()
            .collect(
        Collectors.groupingBy(
                        JugadasTicket::getHoraSorteoDouble, 
               Collectors.groupingBy(JugadasTicket::getAnimal)    
                    )
            ).forEach((hora, mapaAnimales) -> { 
           
                mapaAnimales.forEach((sorteo, listaJugadas) -> {

                    temp.addAll( 
                      listaJugadas.stream()
                            .sorted(Comparator.comparing(JugadasTicket::getPrograma))
                            .collect( Collectors.toList())
                    );

                });
        
            });
        
        Collections.sort(temp, new SortByHoraSorteo());
        
        return temp;
    }
    
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
        ArrayList<JugadasTicket> rd = new ArrayList();
        ArrayList<JugadasTicket> internacional = new ArrayList();
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
            }else if(programa.equalsIgnoreCase("granjita")){
                granja  = (ArrayList) jugadas
                        .stream()
                        .filter( t->t.getPrograma().equalsIgnoreCase(programa))
                        .collect(Collectors.toList());
            }else if(programa.equalsIgnoreCase("lottord")){
                rd  = (ArrayList) jugadas
                        .stream()
                        .filter( t->t.getPrograma().equalsIgnoreCase(programa))
                        .collect(Collectors.toList());
            }
            
        }
        
        if (granja.containsAll(lotto) && granja.containsAll(rd) &&
                Float.compare(lotto.size(),granja.size())==0 && 
                Float.compare(rd.size(),granja.size())==0) {
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
        System.out.println(texto);
        print("\n\n\n\n");
    }

    private void print(String cadena) {
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
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
