
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;





public class HoraSorteo {
    
    
    int  num_grupo;
    String horaSorteo;
    
    String sql;
    PreparedStatement pst;
    ResultSet rs;

    public HoraSorteo() {
        
    }

    public HoraSorteo(int num_grupo, String horaSorteo) {
        this.num_grupo = num_grupo;
        this.horaSorteo = horaSorteo;
    }
    

    
  
     public ArrayList<HoraSorteo> getSorteos(){
        ArrayList<HoraSorteo> lista = new ArrayList();
         sql = "call `sp.getGrupoResultado` ()";
        try ( Connection con = new ConectarDBCloud("ag").getCon()) {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                lista.add(new HoraSorteo(
                       rs.getInt("numGrupo"),
                       rs.getString("horaSorteo")
                    )
                );
            }
        } catch (Exception e) {
            Logger.getLogger(HoraSorteo.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                pst.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(CupoAnimal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        return lista;
    }
     public static void main(String[] args) {
        for(int i=2; i<37;i++){// "+i+"
         
            
            
            
            System.out.println("CASE\n" +
"				WHEN (cupoGrupero.maximo - cupoGrupero.animal_"+i+") < 0 THEN cupoAgencia.maximo\n" +
"        WHEN (cupoGrupero.maximo - cupoGrupero.animal_"+i+") <= (cupoAgencia.maximo - cupoAgencia.animal_"+i+") THEN (cupoGrupero.maximo - cupoGrupero.animal_"+i+")\n" +
"        WHEN cupoAgencia.animal_"+i+" <= cupoAgencia.maximo THEN cupoAgencia.animal_"+i+"\n" +
"				ELSE (cupoAgencia.maximo - cupoAgencia.animal_"+i+")\n" +
"END AS animal_"+i+", ");
            
        }
    }

    public String getHoraSorteo() {
        return horaSorteo;
    }

    public void setHoraSorteo(String horaSorteo) {
        this.horaSorteo = horaSorteo;
    }

    public int getNum_grupo() {
        return num_grupo;
    }

    public void setNum_grupo(int num_grupo) {
        this.num_grupo = num_grupo;
    }

    @Override
    public String toString() {
        return "Loteria{" + "fkGrupoResultado=" + num_grupo + ", nombre=" + horaSorteo + '}';
    }

    
     
     
     
     
     
     
     
     
     
}
