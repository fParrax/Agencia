
package Clases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Agencia {
    
    
    int id,numTicket, cupoAnimal;
    String serialPC, nombreAgencia,username,password,estado;
    double comision;
    
    String sql;
    PreparedStatement pst;
    ResultSet rs;

    public Agencia() {//Esto es un comentarios para hacer prueba
    }

    public Agencia(int id, int numTicket, int cupoAnimal, String serialPC, String nombreAgencia, String nameUsuario, String contraseña, String estado, double comision) {
        this.id = id;
        this.numTicket = numTicket;
        this.cupoAnimal = cupoAnimal;
        this.serialPC = serialPC;
        this.nombreAgencia = nombreAgencia;
        this.username = nameUsuario;
        this.password = contraseña;
        this.estado = estado;
        this.comision = comision;
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
            Logger.getLogger(Agencia.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

   

     public void incrementarTicket(){
         numTicket++;
     }

    @Override
    public String toString() {
        return "Agencia{" + "id=" + id + ", numTicket=" + numTicket + ", cupoAnimal=" + cupoAnimal + ", serialPC=" + serialPC + ", nombreAgencia=" + nombreAgencia + ", username=" + username + ", password=" + password + ", estado=" + estado + ", comision=" + comision + '}';
    }
     
     
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumTicket() {
        return numTicket;
    }

    public void setNumTicket(int numTicket) {
        this.numTicket = numTicket;
    }

    public int getCupoAnimal() {
        return cupoAnimal;
    }

    public void setCupoAnimal(int cupoAnimal) {
        this.cupoAnimal = cupoAnimal;
    }

    public String getNombreAgencia() {
        return nombreAgencia;
    }

    public void setNombreAgencia(String nombreAgencia) {
        this.nombreAgencia = nombreAgencia;
    }

    public String getSerialPC() {
        return serialPC;
    }

    public void setSerialPC(String serialPC) {
        this.serialPC = serialPC;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public PreparedStatement getPst() {
        return pst;
    }

    public void setPst(PreparedStatement pst) {
        this.pst = pst;
    }
    
    
    
    
    
    
    
}
