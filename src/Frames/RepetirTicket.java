/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;

import Clases.CupoAnimal;
import Clases.JugadasTicket;
import Clases.ScrollSens;
import Clases.Ticket;
import Clases.tools;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import panels.SorteoRepetir;


public class RepetirTicket extends javax.swing.JFrame {
JPanel myPanelRepetir = new JPanel();
    index myIndex;
    ArrayList<SorteoRepetir> listaRepetir = new ArrayList();
    Ticket myTicket;
    public RepetirTicket() {
        initComponents();
        changeIcon();
        iniciarDatos();
    }
    public RepetirTicket(index index) {
        initComponents();
        changeIcon();
        myIndex=index;
        iniciarDatos();
    }

     public void changeIcon() {
        Image icon = new ImageIcon(getClass().getResource("/imgs/chip.png")).getImage();
        setIconImage(icon);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCentral = new javax.swing.JPanel();
        fechaDesde = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNumTicket = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        scroll = new javax.swing.JScrollPane();
        btnBuscar = new javax.swing.JButton();
        btnRepetir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Repetir Ticket");

        panelCentral.setBackground(new java.awt.Color(255, 255, 255));

        fechaDesde.setDateFormatString("yyyy-MM-dd");

        jLabel1.setText("Seleccione Fecha:");

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setForeground(new java.awt.Color(0, 102, 102));

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("REPETIR TICKET");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
        );

        jLabel3.setText("Número Ticket:");

        txtNumTicket.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumTicketKeyPressed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnRepetir.setText("Repetir");
        btnRepetir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepetirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCentralLayout = new javax.swing.GroupLayout(panelCentral);
        panelCentral.setLayout(panelCentralLayout);
        panelCentralLayout.setHorizontalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelCentralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(scroll))
                .addContainerGap())
            .addGroup(panelCentralLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNumTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRepetir)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        panelCentralLayout.setVerticalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCentralLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaDesde, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNumTicket)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRepetir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRepetirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepetirActionPerformed
        if(validarRepetir()){
            myIndex.getModel().setRowCount(0);
            myIndex.totalTicket = 0;
            myIndex.totalTicketTxt.setText(myIndex.totalTicket + "");
            
            ArrayList<SorteoRepetir> sorteosSeleccionados = new ArrayList();
            
            sorteosSeleccionados = (ArrayList)listaRepetir.stream()
                .filter(t-> t.mySorteoPrincipal.isSelected())
                .collect(Collectors.toList());
            
            for (SorteoRepetir mainSorteoSelected : sorteosSeleccionados) {
                ArrayList<JCheckBox> jugadasSeleccionadas = new ArrayList();

                double montoDouble = mainSorteoSelected.myJugada.getMonto();
                jugadasSeleccionadas = (ArrayList) mainSorteoSelected.getSorteosSeleccionados()
                        .stream()
                        .filter(select -> select.isSelected())
                        .collect(Collectors.toList());

                String separadorEspacio = Pattern.quote(" ");
                String[] separarJugadaOriginal = mainSorteoSelected.mySorteoPrincipal.getText().split(separadorEspacio);
                String animalJugadoCompleto = separarJugadaOriginal[4];

                //Granjita  8 AM
                String animalJugado = new tools().getAnimalFromString(animalJugadoCompleto);
                for (JCheckBox jugada : jugadasSeleccionadas) {
                    String programaYsorteo = jugada.getText();

                    String programa = jugada.getToolTipText();

                    CupoAnimal cupoJugada = myIndex.getAnimalesVendidos().stream()
                            .filter(t
                                    -> t.getFecha().equalsIgnoreCase(myIndex.fechaHoy)
                            && t.getPrograma().equalsIgnoreCase(programa)
                            && t.getSorteo().equalsIgnoreCase(jugada.getName().toLowerCase().replace(" ", ""))
                            ).findFirst().orElse(
                                    insertCupo(
                                            myIndex.fechaHoy,
                                            programa,
                                            jugada.getName().toLowerCase().replace(" ", ""),
                                            50
                                    )
                            );

                    double cupoAnimalJugado = cupoJugada.getCupoActual(animalJugado);

                    if (myIndex.getModel().getRowCount() > 0) {//Ya existen jugadas
                        boolean flag = false;
                        double montoTabla = 0.0;
                        int filax = 0;
                        for (int i = 0; i < myIndex.getTabla().getRowCount(); i++) {
                            String sorteox = myIndex.getTabla().getValueAt(i, 0).toString();
                            String jugadax = myIndex.getTabla().getValueAt(i, 1).toString();
                            if (programaYsorteo.equalsIgnoreCase(sorteox) && animalJugadoCompleto.equalsIgnoreCase(jugadax)) {
                                montoTabla = Double.parseDouble(myIndex.getTabla().getValueAt(i, 2).toString());
                                flag = true;
                                filax = i;
                            }
                        }
                        if (flag == false) {//No hay jugadas iguales
                            double totalJugada = montoDouble > cupoAnimalJugado
                                    ? cupoAnimalJugado
                                    : montoDouble;
                            myIndex.totalTicket += totalJugada;
                            //String cupoRestante = cupos.g
                            myIndex.getModel().addRow(new Object[]{
                                programaYsorteo, animalJugadoCompleto, totalJugada, cupoAnimalJugado
                            });
                            myIndex.totalTicketTxt.setText(myIndex.totalTicket + "");
                        } else {//si hay jugadas iguales
                            double nuevoTotalAnimalJugado = (montoTabla + montoDouble) > cupoAnimalJugado
                                    ? cupoAnimalJugado
                                    : (montoTabla + montoDouble);

                            myIndex.totalTicket += (nuevoTotalAnimalJugado - montoTabla);
                            myIndex.getTabla().setValueAt(nuevoTotalAnimalJugado, filax, 2);
                            myIndex.getTabla().setValueAt(cupoAnimalJugado, filax, 3);
                            myIndex.totalTicketTxt.setText(myIndex.totalTicket + "");
                        }
                    } else {//La Tabla está vacia
                        double totalJugada = montoDouble > cupoAnimalJugado
                                ? cupoAnimalJugado
                                : montoDouble;
                        myIndex.totalTicket += totalJugada;
                        //String cupoRestante = cupos.g

                        myIndex.getModel().addRow(new Object[]{
                            programaYsorteo, animalJugadoCompleto, totalJugada, cupoAnimalJugado
                        });

                        myIndex.totalTicketTxt.setText(myIndex.totalTicket + "");
                    }
                    /*
                     */

                }
            }
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione al menos un Sorteo (Lado Izquierdo) y un objetivo (lado Derecho)");
        }
    }//GEN-LAST:event_btnRepetirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
      int numTicket= Integer.parseInt(txtNumTicket.getText());
        myTicket = new Ticket().getTicketByNum(
              myIndex.getAgencia().getId(),
              getFechaDesde(),
              numTicket
        );
        if(myTicket.getId()>0){
            mostrarDatos(myTicket);
        }else{
            JOptionPane.showMessageDialog(this, "Ticket no encontrado");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtNumTicketKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumTicketKeyPressed
     if(evt.getKeyCode() == KeyEvent.VK_ENTER){
         btnBuscar.doClick();
     }
    }//GEN-LAST:event_txtNumTicketKeyPressed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RepetirTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RepetirTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RepetirTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RepetirTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RepetirTicket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRepetir;
    private com.toedter.calendar.JDateChooser fechaDesde;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelCentral;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextField txtNumTicket;
    // End of variables declaration//GEN-END:variables

public String getFechaDesde() {
        return new SimpleDateFormat("yyyy-MM-dd").format(fechaDesde.getDate());
    }

    private boolean validarRepetir() {
        /*
        &&
                        (t.sorteos.stream()
                                .filter(f-> f.isSelected() )
                                .count() > 0 
                                ? true 
                                : false
                        )
         */
        return listaRepetir.stream()
                .filter(t
                        -> t.mySorteoPrincipal.isSelected()
                && (t.getSorteosSeleccionados().stream()
                        .filter(f -> f.isSelected())
                        .count() > 0
                        ? true
                        : false)
                ).count() > 0 ? true : false;

    }

    private void iniciarDatos() {
        txtNumTicket.requestFocus();

        new ScrollSens(scroll, 40);
        fechaDesde.setDate(new Date());
    }

    private void mostrarDatos(Ticket ticket) {
        myPanelRepetir = new JPanel();
        myPanelRepetir.setLayout(new BoxLayout(myPanelRepetir, BoxLayout.Y_AXIS));
        myPanelRepetir.setBackground(new Color(0, 102, 102));

        for (JugadasTicket jugada : ticket.getJugadas()) {
            SorteoRepetir temp = new SorteoRepetir(myIndex, jugada);
            listaRepetir.add(temp);
            myPanelRepetir.add(temp);
        }
        scroll.setViewportView(myPanelRepetir);
    }

    private CupoAnimal insertCupo(String fecha, String programa, String sorteo, double monto) {
        return new CupoAnimal().get(fecha, programa, sorteo, monto);

    }
    
}
