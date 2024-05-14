
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class GrupoResultado {

    int  numGrupo=0;
    String nombresLotterias;
    ArrayList<String> loterias = new ArrayList();
    ArrayList<String> horasSorteo = new ArrayList();
    String sql;
    PreparedStatement pst;
    ResultSet rs;
    
    
    
    public GrupoResultado() {
    }

    public GrupoResultado( int numGrupo,String nombresLotterias) {
        this.numGrupo = numGrupo;
        this.nombresLotterias = nombresLotterias;
        String separador = Pattern.quote(",");
        String[] separado = nombresLotterias.split(separador);
        loterias.clear();
        for(String lot : separado){
            loterias.add(lot);
        }
    }

    
    
    public ArrayList<GrupoResultado> getGruposConResultados() {
        ArrayList<GrupoResultado> arreglo = new ArrayList();
        GrupoResultado my = new GrupoResultado();

        sql = "call `sp.getLoteriasCompleto` ()";
        
        try (Connection con = new ConectarDBCloud("ag").getCon()) {
           
            pst = con.prepareCall(sql);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                String tempMombresLoterias = rs.getString("nombres");
                String tempHoraSorteo = rs.getString("horaSorteo");
                int tempNumGrupo =rs.getInt("num_grupo");
                
                   if(my.isEmpty()){
                       my = new GrupoResultado(
                               tempNumGrupo,
                               tempMombresLoterias
                       );
                       my.addHoraSorteo(tempHoraSorteo);
                   }else{
                       if(my.isSameGrupo(tempNumGrupo)){
                           my.addHoraSorteo(tempHoraSorteo); 
                       }else{
                           arreglo.add(my);
                           my = new GrupoResultado(
                               tempNumGrupo,
                               tempMombresLoterias
                       );
                       my.addHoraSorteo(tempHoraSorteo);
                       }
                   }
            }
             arreglo.add(my);
        } catch (Exception e) {
            Logger.getLogger(GrupoResultado.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error con el manejo de base de datos, contacte con el adm.\n" + e);
        } finally {
            cerrar();
        }

       return arreglo;
    }

    public ArrayList<String> getLoterias() {
        return loterias;
    }

    public void setLoterias(ArrayList<String> loterias) {
        this.loterias = loterias;
    }

    
    
    public boolean isEmpty(){
         return Float.compare(numGrupo, 0) == 0 ? true:false;
    }
    public boolean isSameGrupo(int grupo){
        return Float.compare(numGrupo, grupo) == 0 ? true:false;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.numGrupo;
        hash = 79 * hash + Objects.hashCode(this.nombresLotterias);
        hash = 79 * hash + Objects.hashCode(this.horasSorteo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GrupoResultado other = (GrupoResultado) obj;
        if (this.numGrupo != other.numGrupo) {
            return false;
        }
        if (!Objects.equals(this.nombresLotterias, other.nombresLotterias)) {
            return false;
        }
        return Objects.equals(this.horasSorteo, other.horasSorteo);
    }
    
    
    
    
   
   public void addHoraSorteo(String hora){
       if (!horasSorteo.contains(hora)){
           horasSorteo.add(hora);
       }
   }
   public ArrayList<String> getHorasSorteo(){
       return this.horasSorteo;
   }
    
    
    
private void cerrar() {
        try {
            if (pst != null) {
                pst.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(GrupoResultado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
   


    
   

    public int getNumGrupo() {
        return numGrupo;
    }

    public void setNumGrupo(int numGrupo) {
        this.numGrupo = numGrupo;
    }

    

    public String getNombresLotterias() {
        return nombresLotterias;
    }

    public void setnombresLotterias(String nombresLotterias) {
        this.nombresLotterias = nombresLotterias;
    }
    
    
    
    
    
    
    
}
