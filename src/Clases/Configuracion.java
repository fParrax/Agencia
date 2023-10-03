
package Clases;

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

    public static void main(String[] args) {
        System.out.println( new ConectarDBLocal("agtest"));
    }
    public Configuracion getDatos(){
        Configuracion c = new Configuracion();
        /*
         
        sql = "select * from configuracion";
        try (java.sql.Connection con = new Conectar().getCon()) {
        pst =con.prepareStatement(sql);
        rs=pst.executeQuery();
        while(rs.next()){
            c = new Configuracion(rs.getInt("idConfiguracion"),rs.getString("nombreAgencia"),rs.getInt("cupoAnimal"),
            rs.getString("tamanoPapel"),rs.getString("fechaTicket"),rs.getInt("numTicket"),rs.getDouble("comision"));
        }
        } catch (Exception e) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error con el manejo de base de datos, contacte con el adm.\n" + e);
        } finally {
            cerrar();
        }
        
        */
       return c;
    }
    
    public int update(){
        int rsp=0;
        sql = "update configuracion set nombreAgencia=?, cupoAnimal=?, tamanoPapel=?,"
                + "fechaTicket=?, numTicket=?, comision=? where idConfiguracion=?";
        try (java.sql.Connection con = new ConectarDBLocal().getCon()) {
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
