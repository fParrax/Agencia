
package Clases;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScrapResultados {
	
    public static final String url = "https://www.tuazar.com/loteria/animalitos/resultados/";
    public static final String urlRD = "https://loteriadehoy.com/animalito/lottoactivordominicana/resultados/";//agregar fecha
    public static final String urlInternacional = "https://centrodeapuestaselrey.com.ve/resultados/lotto-activo-rd";
    public static final int maxPages = 20;
	
    
    public JsonArray getResultados(){
        JsonArray resultados = new JsonArray();
        
          // Compruebo si me da un 200 al hacer la petición
            if (getStatusConnectionCode(url) == 200) {
				
                // Obtengo el HTML de la web en un objeto Document2
                Document document = getHtmlDocument(url);
				
                // Busco todas las historias de meneame que estan dentro de: 
                Elements entradas = document.select("div.col-md-8.col-sm-12.resultados");
               // Elements entradas = document.select(".row.resultado");
				            
                // Paseo cada una de las entradas
                for (Element elem : entradas) {
                    String titulo = elem.getElementsByClass("col-xs-6 col-sm-3").text();
                   
                    if(titulo.contains("Lotto Activo") ){//|| titulo.contains("La Granjita")
                        String separador = Pattern.quote("Animalito Lotto Activo ");
                        String[] arreglo = titulo.split(separador);
                        for(String valor : arreglo){
                            if(!valor.contains("- - -")){
                                /*
                                    Valor Imprime: 20 - CERDO 09:00
                                        #Animal - NombreAnimal - HoraSorteo
                                
                                    Resultado Imprime: 
                                    [0]=Animal=20
                                    [1]=Separador=-
                                    [2]=TextoAnimal=CERDO
                                    [3]=HoraSorteo=09:00
                                */
                                
                                String separador2 = Pattern.quote(" ");
                                String[] resultado = valor.split(separador2);
                                if(resultado.length > 1){
                                    String numAnimal = resultado[0];
                                    int myAnimal = Integer.parseInt(numAnimal);
                                    numAnimal = myAnimal>=1 && myAnimal<=9 && numAnimal.length()==1? "0"+numAnimal:numAnimal;
                                    String horaSorteo = resultado[3];
                                    //System.out.println("Lotto Activo Salió el "+numAnimal+" para las "+horaSorteo);
                                     JsonObject myResultado = new JsonObject();
                                    myResultado.addProperty("animal", numAnimal);
                                    myResultado.addProperty("programa", "LottoActivo");
                                    myResultado.addProperty("horaSorteo", horaSorteo);
                                   // System.out.println(myResultado.toString());
                                    resultados.add(myResultado);
                                }
                            }
                        }
                    }else if(titulo.contains("La Granjita") ){
                        String separador = Pattern.quote("Animalito La Granjita ");
                        String[] arreglo = titulo.split(separador);
                        for(String valor : arreglo){
                            if(!valor.contains("- - -")){
                                /*
                                    Valor Imprime: 20 - CERDO 09:00
                                        #Animal - NombreAnimal - HoraSorteo
                                
                                    Resultado Imprime: 
                                    [0]=Animal=20
                                    [1]=Separador=-
                                    [2]=TextoAnimal=CERDO
                                    [3]=HoraSorteo=09:00
                                */
                                
                                String separador2 = Pattern.quote(" ");
                                String[] resultado = valor.split(separador2);
                                if(resultado.length > 1){
                                    String numAnimal = resultado[0];
                                    int myAnimal = Integer.parseInt(numAnimal);
                                    numAnimal = myAnimal>=1 && myAnimal<=9 && numAnimal.length()==1? "0"+numAnimal:numAnimal;
                                    String horaSorteo = resultado[3];
                                    //System.out.println("Granjita Salió el "+numAnimal+" para las "+horaSorteo);
                                     JsonObject myResultado = new JsonObject();
                                     
                                     myResultado.addProperty("animal", numAnimal);
                                     myResultado.addProperty("programa", "Granjita");
                                    myResultado.addProperty("horaSorteo", horaSorteo);
                                    resultados.add(myResultado);
                                }
                            }
                        }
                    }
                    //System.out.println("titulo: "+titulo);
					
					
                }
		//agregar aqui según la ultima entrada 
            }else{
                System.out.println("El Status Code no es OK es: "+getStatusConnectionCode(url));
            }
        
            
           
           
        return resultados;
    }
     //col-md-2col-xs-6
     public JsonArray getResultadosInternacional(){
         String separador = Pattern.quote("_");
         JsonArray resultados = new JsonArray();
          if (getStatusConnectionCode(urlInternacional) == 200) {
              Document document = getHtmlDocument(urlInternacional);
              String fechaServidor = new SimpleDateFormat("dd/MM/yyyy").format(new Date()).toString();
              String fechaPagina = document.getElementById("result_date").val();
              
              if(fechaServidor.equals(fechaPagina)){//Mismo dia
                Elements entradas = document.select("div.thumbnail");
                // Paseo cada una de las entradas
                for (Element elem : entradas) {  
                    JsonObject myResultado = new JsonObject();
                    String hora = elem.getElementsByClass("hora").text().toUpperCase();
                    String animalString = elem.getElementsByClass("text").text();
                    
                    String animalInteger = elem.getElementsByClass("img-thumbnail")
                            .attr("src")
                            .replace(
                                "https://centrodeapuestaselrey.com.ve/img/lotto_activo_rd/",
                                ""
                            )
                            .split(separador)[0];
                    
                    
                                     
                    myResultado.addProperty("animal", animalInteger+animalString);
                    myResultado.addProperty("programa", "LottoInternacional");
                    myResultado.addProperty("horaSorteo", hora);
                    
                    if(!animalString.equals("-")){
                       resultados.add(myResultado);
                    }
                    
                    
                   
                }    
              }
          }
         return resultados;
     }
     
     private  String getAnimal(String numero) {
        String animal = "";

        if (true) {
            switch (numero) {
                case "0":animal = "Delfín";break;
                case "00":animal = "Ballena";break;
                case "01":animal = "Carnero";break;
                case "1":animal = "Carnero";break;
                case "02":animal = "Toro";break;
                case "2":animal = "Toro";break;
                case "03":animal = "Ciempies";break;
                case "3":animal = "Ciempies";break;
                case "04":animal = "Alacrán";break;
                case "4":animal = "Alacrán";break;
                case "05":animal = "León";break;
                case "5":animal = "León";break;
                case "06":animal = "Rana";break;
                case "6":animal = "Rana";break;
                case "07":animal = "Perico";break;
                case "7":animal = "Perico";break;
                case "08":animal = "Ratón";break;
                case "8":animal = "Ratón";break;
                case "09":animal = "Águila";break;
                case "9":animal = "Águila";break;
                case "10":animal = "Tigre";break;
                case "11":animal = "Gato";break;
                case "12":animal = "Caballo";break;
                case "13":animal = "Mono";break;
                case "14":animal = "Paloma";break;
                case "15":animal = "Zorro";break;
                case "16":animal = "Oso";break;
                case "17":animal = "Pavo";break;
                case "18":animal = "Burro";break;
                case "19":animal = "Chivo";break;
                case "20":animal = "Cochino";break;
                case "21":animal = "Gallo";break;
                case "22":animal = "Camello";break;
                case "23":animal = "Cebra";break;
                case "24":animal = "Iguana";break;
                case "25":animal = "Gallina";break;
                case "26":animal = "Vaca";break;
                case "27":animal = "Perro";break;
                case "28":animal = "Zamuro";break;
                case "29":animal = "Elefante";break;
                case "30":animal = "Caimán";break;
                case "31":animal = "Lapa";break;
                case "32":animal = "Ardilla";break;
                case "33":animal = "Pescado";break;
                case "34":animal = "Venado";break;
                case "35":animal = "Jirafa";break;
                case "36":animal = "Culebra";break;
            }
        }
        
        return animal;
    }
     
     
     public JsonArray getResultadosRD(){
         JsonArray resultados = new JsonArray();
         String fechaServidor = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString();
         String url = urlRD+fechaServidor+"/";
         if (getStatusConnectionCode(url) == 200) {
             Document document = getHtmlDocument(url);
             
             Elements entradas = document.getElementsByClass("col-sm-6 col-md-4 col-lg-16 mb-5");
             for (Element elem : entradas) { 
                  JsonObject myResultado = new JsonObject();
                 String encontrados = elem.getElementsByClass("circle-legend").get(0).text();
                 String separador = Pattern.quote(" ");
                 String[] separado = encontrados.split(separador);

                 String numAnimal = separado[0];
                 int myAnimal = Integer.parseInt(numAnimal);
                 numAnimal = myAnimal>=1 && myAnimal<=9 && numAnimal.length()==1
                         ? "0" + numAnimal
                         :numAnimal;
                 String animalCompleto = numAnimal+getAnimal(numAnimal);               
                 
                 String horaSorteo = separado[5]
                     .substring(0,1)
                     .equals("0")
                     ? separado[5]
                         .substring(
                                 1,
                                 separado[5].length()
                         )
                     :separado[5];
                 
                 
                 
                 String sorteo = horaSorteo+" "+separado[6];
                 myResultado.addProperty("animal", animalCompleto);
                 myResultado.addProperty("programa", "LottoRD");
                 myResultado.addProperty("horaSorteo", sorteo);
                 
                 System.out.println(myResultado.toString());
                resultados.add(myResultado);
             }
             
         }
         
         
         
         return resultados;
     }
    public boolean isSameDay(){
            if (getStatusConnectionCode(url) == 200 ||
                 getStatusConnectionCode(urlInternacional) == 200  ) {
				
                Document documentTuAzar = getHtmlDocument(url);
                Document documentInternacional = getHtmlDocument(urlInternacional);
                String fechaInternacional = parsearStringFecha(documentInternacional.getElementById("result_date").val(), "/");
                Elements entradas = documentTuAzar.select("time");
                String fechaPagina ="";
                for (Element elem : entradas) {
	            fechaPagina = elem.attr("datetime");break;
                }
                String fechaServidor = new ConectarDBCloud().tomarFecha();
                System.out.println("FechaServidor: "+fechaServidor+" y fechaPagina: "+fechaPagina + " y fechaInternacional: "+fechaInternacional);
                return fechaServidor.equalsIgnoreCase(fechaPagina) && 
                        fechaServidor.equalsIgnoreCase(fechaInternacional)?true:false;
		
            }else{
               return false;
            }
    }
    
    private String parsearStringFecha(String fecha, String sep){
        String separador = Pattern.quote(sep);
        String[] fec = fecha.split(separador);
        return fec[2]+"-"+fec[1]+"-"+fec[0];
    }
    
    
	
    /**
     * Con esta método compruebo el Status code de la respuesta que recibo al hacer la petición
     * EJM:
     * 		200 OK			300 Multiple Choices
     * 		301 Moved Permanently	305 Use Proxy
     * 		400 Bad Request		403 Forbidden
     * 		404 Not Found		500 Internal Server Error
     * 		502 Bad Gateway		503 Service Unavailable
     * @param url
     * @return Status Code
     */
    public static int getStatusConnectionCode(String url) {
		
        Response response = null;
		
        try {
            response = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
        } catch (IOException ex) {
            System.out.println("Excepción al obtener el Status Code: " + ex.getMessage());
        }
        return response.statusCode();
    }
	
	
    /**
     * Con este método devuelvo un objeto de la clase Document con el contenido del
     * HTML de la web que me permitirá parsearlo con los métodos de la librelia JSoup
     * @param url
     * @return Documento con el HTML
     */
    public static Document getHtmlDocument(String url) {

        Document doc = null;

        try {
            doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).get();
        } catch (IOException ex) {
            System.out.println("Excepción al obtener el HTML de la página" + ex.getMessage());
        }

        return doc;

    }
}