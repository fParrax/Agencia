/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package panels;

import Clases.JugadasTicket;
import Frames.index;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;

/**
 *
 * @author franklinp
 */
public class SorteoRepetir extends javax.swing.JPanel {
    index myIndex;
    public ArrayList<JCheckBox> sorteos = new ArrayList();
    public JugadasTicket myJugada;
    
    public SorteoRepetir() {
        initComponents();
    }
    
    public SorteoRepetir(index index,JugadasTicket myJugada) {
        initComponents();
        myIndex=index;
        this.myJugada = myJugada;
        mySorteoPrincipal.setText(myJugada.getSorteo()+" - "+myJugada.getAnimal());
        mySorteoPrincipal.setName(myJugada.getSorteo()+" - "+myJugada.getAnimal());
        panelSorteos.setLayout(new BoxLayout(panelSorteos, BoxLayout.Y_AXIS));
        iniciar();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCentral = new javax.swing.JPanel();
        mySorteoPrincipal = new javax.swing.JCheckBox();
        panelSorteos = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(0, 102, 102));

        panelCentral.setBackground(new java.awt.Color(0, 102, 102));

        mySorteoPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        mySorteoPrincipal.setText("jCheckBox1");

        panelSorteos.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout panelSorteosLayout = new javax.swing.GroupLayout(panelSorteos);
        panelSorteos.setLayout(panelSorteosLayout);
        panelSorteosLayout.setHorizontalGroup(
            panelSorteosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 367, Short.MAX_VALUE)
        );
        panelSorteosLayout.setVerticalGroup(
            panelSorteosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelCentralLayout = new javax.swing.GroupLayout(panelCentral);
        panelCentral.setLayout(panelCentralLayout);
        panelCentralLayout.setHorizontalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCentralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mySorteoPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelSorteos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCentralLayout.setVerticalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCentralLayout.createSequentialGroup()
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelSorteos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mySorteoPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelCentral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JCheckBox mySorteoPrincipal;
    private javax.swing.JPanel panelCentral;
    private javax.swing.JPanel panelSorteos;
    // End of variables declaration//GEN-END:variables

    private void iniciar() {
        for(String programa: myIndex.getProgramas()){
            for(JCheckBox sorteo:myIndex.getSorteos()){
            if(sorteo.isVisible()){
                JCheckBox temp = new JCheckBox();    
                temp.setText(programa + sorteo.getText());
                temp.setForeground(Color.white);
                 
                sorteos.add(sorteo);
                panelSorteos.add(temp);
            }
        }
        }
        
        
        
        panelSorteos.setSize(sorteos.size()*22, panelSorteos.getWidth());
        panelCentral.setSize(panelSorteos.getSize());
        this.setSize(panelSorteos.getSize());
        
    }
}
