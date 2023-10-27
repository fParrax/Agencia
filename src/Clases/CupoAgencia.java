
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class CupoAgencia {
    
    
    int idcupo,idAgencia;
    String tipoCupo,fechaInicio,fechaFin,estadoCupo;
    
    String sql;
    PreparedStatement pst;
    ResultSet rs;

    public CupoAgencia() {
    }

    

    public CupoAgencia(int idcupo, int idAgencia, String tipoCupo, String fechaInicio, String fechaFin, String estadoCupo) {
        this.idcupo = idcupo;
        this.idAgencia = idAgencia;
        this.tipoCupo = tipoCupo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estadoCupo = estadoCupo;
    }
    
    public boolean insertCupo(
            int idAgencia,
            String tipo,
            String desde,
            String hasta
    ){
        sql = "call `sp.insertCupo` (?,?,?,?)";
        try ( Connection con = new ConectarDBCloud("ag").getCon()) {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idAgencia);
            pst.setString(2, tipo);
            pst.setString(3, desde);
            pst.setString(4, hasta);
           
            return pst.executeUpdate() > 0 ? true : false;
            
            
        } catch (Exception e) {
            Logger.getLogger(CupoAgencia.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
            return false;
        } finally {
            try {
                pst.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(CupoAnimal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    
    public ArrayList getCupos(int idAgencia){
        ArrayList<CupoAgencia> busqueda = new ArrayList();
        
        sql = "call `sp.getCupoAgencia` (?)";
        try ( Connection con = new ConectarDBCloud("ag").getCon()) {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idAgencia);
           
            rs = pst.executeQuery();
            while(rs.next()){
                busqueda.add(new CupoAgencia(
                        rs.getInt("idCupo"),
                        rs.getInt("idAgencia"),
                        rs.getString("tipoCupo"),
                        rs.getString("fechaInicio"),
                        rs.getString("fechaFin"),
                        rs.getString("estadoCUpo")
                      
                ));
            }
            
            
        } catch (Exception e) {
            Logger.getLogger(CupoAgencia.class.getName()).log(Level.SEVERE, null, e);
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
        return busqueda;
    }
    
    
     public boolean deleteCupoTemporal(
            int idAgencia
    ){
        sql = "call `sp.EliminarCupoTemporal` (?)";
        try ( Connection con = new ConectarDBCloud("ag").getCon()) {
            pst = con.prepareStatement(sql);
            pst.setInt(1, idAgencia);
           
            return pst.executeUpdate() > 0 ? true : false;
            
        } catch (Exception e) {
            Logger.getLogger(CupoAgencia.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
            return false;
        } finally {
            try {
                pst.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(CupoAnimal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    
}
