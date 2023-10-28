
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Configuracion {
    
    int id=0;
    String nombreAgencia;
    int cupoAnimal;
    String tamanoPapel,fechaTicket;
    int numTicket;
    double comision=0;
    String sql;
    
    
    PreparedStatement pst;
    ResultSet rs;
    public Configuracion() {
        
    }

    public Configuracion(int id, String nombreAgencia, int cupoAnimal, String tamanoPapel, String fechaTicket, int numTicket,double comision) {
        this.id = id;
        this.nombreAgencia = nombreAgencia;
        this.cupoAnimal = cupoAnimal;
        this.tamanoPapel = tamanoPapel;
        this.fechaTicket = fechaTicket;
        this.numTicket = numTicket;
        this.comision=comision;
    }

    
    
    public int getNumTicket(String fecha){
        
        try ( Connection con = new ConectarDBSQLLite().getCon()) {
            sql ="select * from ticketAgencia where fecha = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1,fecha);
            rs = pst.executeQuery();
            if(rs.next()){
                this.numTicket = rs.getInt("numTicket");
                return this.numTicket;
            }else{
                insert(fecha);
                return 0;
            }
        }catch (Exception e) {
            Logger.getLogger(CupoAnimal.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
            return 1;
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
    
    private boolean insert(String fecha){
        try ( Connection con = new ConectarDBSQLLite().getCon()) {
            sql ="insert into ticketAgencia (fecha) values (?)";
            pst = con.prepareStatement(sql);
            pst.setString(1,fecha);
            
            if(pst.executeUpdate() > 0){
                return true;
            }else{
                return false;
            }
        }catch (Exception e) {
            Logger.getLogger(CupoAnimal.class.getName()).log(Level.SEVERE, null, e);
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
    
    public boolean increaseTicket(int numTicket , String fecha){
        try ( Connection con = new ConectarDBSQLLite().getCon()) {
            sql ="update  ticketAgencia set numTicket=? where fecha=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1,numTicket);
            pst.setString(2,fecha);
            
            if(pst.executeUpdate() > 0){
                return true;
            }else{
                return false;
            }
        }catch (Exception e) {
            Logger.getLogger(CupoAnimal.class.getName()).log(Level.SEVERE, null, e);
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
    
    public int update(){
        int rsp=0;
        sql = "update configuracion set nombreAgencia=?, cupoAnimal=?, tamanoPapel=?,"
                + "fechaTicket=?, numTicket=?, comision=? where idConfiguracion=?";
        try (java.sql.Connection con = new ConectarDBCloud().getCon()) {
            con.setCatalog("ag");
        pst = con.prepareStatement(sql);
        pst.setString(1,this.nombreAgencia);
        pst.setInt(2,this.cupoAnimal);
        pst.setString(3,this.tamanoPapel);
        pst.setString(4,this.fechaTicket);
        pst.setInt(5,this.numTicket);
        pst.setDouble(6,this.comision);
        pst.setInt(7,1);
        rsp = pst.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error con el manejo de base de datos, contacte con el adm.\n" + e);
        } finally {
            cerrar();
        }
        return rsp;
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
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return "Configuracion{" + "id=" + id + ", nombreAgencia=" + nombreAgencia + ", cupoAnimal=" + cupoAnimal + ", tamanoPapel=" + tamanoPapel + ", fechaTicket=" + fechaTicket + ", numTicket=" + numTicket + ", comision=" + comision + '}';
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreAgencia() {
        return nombreAgencia;
    }

    public void setNombreAgencia(String nombreAgencia) {
        this.nombreAgencia = nombreAgencia;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public int getCupoAnimal() {
        return cupoAnimal;
    }

    public void setCupoAnimal(int cupoAnimal) {
        this.cupoAnimal = cupoAnimal;
    }

    public String getTamanoPapel() {
        return tamanoPapel;
    }

    public void setTamanoPapel(String tamanoPapel) {
        this.tamanoPapel = tamanoPapel;
    }

    public String getFechaTicket() {
        return fechaTicket;
    }

    public void setFechaTicket(String fechaTicket) {
        this.fechaTicket = fechaTicket;
    }

    public int getNumTicket() {
        return numTicket;
    }

    public void setNumTicket(int numTicket) {
        this.numTicket = numTicket;
    }
    
    
    
    
}
