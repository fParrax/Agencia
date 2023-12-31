
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Agencia {
    
    
    int id=-1,numTicket, cupoAnimal;
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
    
    public Agencia getAgencia(String nameAgencia) {
        Agencia my = new Agencia();

        sql = "call `sp.getAgencia` (?)";
        
        try (Connection con = new ConectarDBCloud("ag").getCon()) {
            con.setCatalog("ag");
           
            pst = con.prepareCall(sql);
            pst.setString(1,nameAgencia);
            
            rs = pst.executeQuery();
            while (rs.next()) {
                    my = new Agencia(
                            rs.getInt("id"),
                            rs.getInt("numTicket"),
                            rs.getInt("cupoAnimal"),
                            rs.getString("serialPc"),
                            rs.getString("nombreAgencia"),
                            rs.getString("username"),
                            rs.getString("pasword"),
                            rs.getString("estado"),
                            rs.getDouble("comision")
                    );
            }
        } catch (Exception e) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error con el manejo de base de datos, contacte con el adm.\n" + e);
        } finally {
            cerrar();
        }

        return my;
    }
    
    
    
    public int insert(String nameAgenciax, String usernamex, String paswordx ,
            String seralPcx, int cupoAnimalx, int comisionx){
        int rsp =0;
        
        try (java.sql.Connection con = new ConectarDBCloud("ag").getCon()) {
        
            sql = "call `sp.newAgencia` (?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1,nameAgenciax);
            pst.setString(2,usernamex);
            pst.setString(3,paswordx);
            pst.setString(4,seralPcx);
            pst.setInt(5,cupoAnimalx);
            pst.setInt(6,comisionx);
            
            
        } catch (Exception e) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error con el manejo de base de datos, contacte con el adm.\n" + e);
        } finally {
            cerrar();
        }
        return rsp;
    }
    
    
    public boolean upSerial(String serialx, int idAgenciax){
         try (java.sql.Connection con = new ConectarDBCloud("ag").getCon()) {
              sql = "call `sp.UpSerial` (?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1,serialx);
            pst.setInt(2,idAgenciax);
            pst.executeUpdate();
            return true;
         } catch (Exception e) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Error con el manejo de base de datos, contacte con el adm.\n" + e);
            return false;
        } finally {
            cerrar();
        }
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
        return serialPC==null?"":serialPC;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
    
    
    
    
    
}
