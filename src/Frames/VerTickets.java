/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Clases.JugadasTicket;
import Clases.Ticket;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author parra
 */
public class VerTickets extends javax.swing.JFrame {

    public String programa = "";
    String estadoTicket = "";
    DefaultTableModel modeloTickets;
    DefaultTableModel modeloJugadas;
    ArrayList<Ticket> tickets;
    index ind;

    public VerTickets() {
        initComponents();
        changeIcon();
        iniciar();
    }

    public VerTickets(index ind) {
        initComponents();
        changeIcon();
        this.ind = ind;
        iniciar();
    }

    Ticket myTicket;

    public void changeIcon() {
        Image icon = new ImageIcon(getClass().getResource("/imgs/chip.png")).getImage();
        setIconImage(icon);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbPrograma = new javax.swing.ButtonGroup();
        rbEstadosTicket = new javax.swing.ButtonGroup();
        panelFiltros = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnBuscarTicket = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        comboEstadoTicket = new javax.swing.JComboBox<>();
        fechaDesde = new com.toedter.calendar.JDateChooser();
        fechaHasta = new com.toedter.calendar.JDateChooser();
        panelResultados = new javax.swing.JPanel();
        panelInfoTicket = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lbNumticket = new javax.swing.JLabel();
        lbFecha = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbMontoPrograma = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbTotalPremios = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbTotalPagado = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaTickets = new rojerusan.RSTableMetro();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaJugadas = new rojerusan.RSTableMetro();
        jLabel3 = new javax.swing.JLabel();
        lbTotalVendido = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbTotalAnulado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Visualización de Tickets");

        panelFiltros.setBackground(new java.awt.Color(255, 255, 255));
        panelFiltros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtros de búsqueda de tickets", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("DESDE");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("HASTA");

        btnBuscarTicket.setText("Buscar Tickets");
        btnBuscarTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarTicketActionPerformed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Estado del Ticket");

        comboEstadoTicket.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        comboEstadoTicket.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Premiado", "Anulado" }));

        fechaDesde.setDateFormatString("yyyy-MM-dd");
        fechaDesde.setMinimumSize(new java.awt.Dimension(82, 23));
        fechaDesde.setPreferredSize(new java.awt.Dimension(103, 23));

        fechaHasta.setDateFormatString("yyyy-MM-dd");
        fechaHasta.setMinimumSize(new java.awt.Dimension(82, 23));
        fechaHasta.setPreferredSize(new java.awt.Dimension(103, 23));

        javax.swing.GroupLayout panelFiltrosLayout = new javax.swing.GroupLayout(panelFiltros);
        panelFiltros.setLayout(panelFiltrosLayout);
        panelFiltrosLayout.setHorizontalGroup(
            panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFiltrosLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelFiltrosLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(fechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelFiltrosLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(fechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFiltrosLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelFiltrosLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(comboEstadoTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscarTicket)
                        .addContainerGap())))
        );
        panelFiltrosLayout.setVerticalGroup(
            panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFiltrosLayout.createSequentialGroup()
                .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelFiltrosLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel7))
                    .addComponent(fechaDesde, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboEstadoTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelFiltrosLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(9, 9, 9))
        );

        panelResultados.setBackground(new java.awt.Color(255, 255, 255));
        panelResultados.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultados de la Búsqueda", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        panelInfoTicket.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información del Ticket", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel5.setText("# Ticket:");

        lbNumticket.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbNumticket.setText("#");

        lbFecha.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbFecha.setText("#");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel8.setText("Ticket Jugado el:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel13.setText("Monto Ticket:");

        lbMontoPrograma.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbMontoPrograma.setText("#");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel15.setText("Total Premios:");

        lbTotalPremios.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbTotalPremios.setText("#");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel17.setText("Total Pagado:");

        lbTotalPagado.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbTotalPagado.setText("#");

        javax.swing.GroupLayout panelInfoTicketLayout = new javax.swing.GroupLayout(panelInfoTicket);
        panelInfoTicket.setLayout(panelInfoTicketLayout);
        panelInfoTicketLayout.setHorizontalGroup(
            panelInfoTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoTicketLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInfoTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoTicketLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNumticket, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelInfoTicketLayout.createSequentialGroup()
                        .addGroup(panelInfoTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelInfoTicketLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(20, 20, 20)
                                .addComponent(lbTotalPremios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelInfoTicketLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(20, 20, 20)
                                .addComponent(lbTotalPagado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelInfoTicketLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(24, 24, 24)
                                .addComponent(lbMontoPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelInfoTicketLayout.setVerticalGroup(
            panelInfoTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoTicketLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(panelInfoTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbNumticket)
                    .addComponent(jLabel8)
                    .addComponent(lbFecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInfoTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lbMontoPrograma))
                .addGap(15, 15, 15)
                .addGroup(panelInfoTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lbTotalPremios))
                .addGap(15, 15, 15)
                .addGroup(panelInfoTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(lbTotalPagado))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        tablaTickets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Ticket", "Fecha y Hora", "Monto", "Premios", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaTickets.setAltoHead(30);
        tablaTickets.setColorBackgoundHead(new java.awt.Color(0, 102, 102));
        tablaTickets.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        tablaTickets.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tablaTickets.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tablaTickets.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tablaTickets.setColorSelBackgound(new java.awt.Color(0, 102, 102));
        tablaTickets.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tablaTickets.setFuenteFilas(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tablaTickets.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tablaTickets.setFuenteHead(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tablaTickets.setGridColor(new java.awt.Color(0, 0, 0));
        tablaTickets.setRowHeight(23);
        tablaTickets.setSelectionBackground(new java.awt.Color(0, 102, 102));
        tablaTickets.setShowGrid(true);
        tablaTickets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaTicketsMouseClicked(evt);
            }
        });
        tablaTickets.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaTicketsTicksKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(tablaTickets);
        if (tablaTickets.getColumnModel().getColumnCount() > 0) {
            tablaTickets.getColumnModel().getColumn(0).setMinWidth(80);
            tablaTickets.getColumnModel().getColumn(0).setPreferredWidth(80);
            tablaTickets.getColumnModel().getColumn(0).setMaxWidth(80);
        }

        tablaJugadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sorteo", "Jugada", "Monto", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaJugadas.setAltoHead(30);
        tablaJugadas.setColorBackgoundHead(new java.awt.Color(0, 51, 153));
        tablaJugadas.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        tablaJugadas.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tablaJugadas.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tablaJugadas.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tablaJugadas.setColorSelBackgound(new java.awt.Color(0, 102, 102));
        tablaJugadas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tablaJugadas.setFuenteFilas(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tablaJugadas.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tablaJugadas.setFuenteHead(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tablaJugadas.setGridColor(new java.awt.Color(0, 0, 0));
        tablaJugadas.setRowHeight(23);
        tablaJugadas.setSelectionBackground(new java.awt.Color(0, 102, 102));
        tablaJugadas.setShowGrid(true);
        tablaJugadas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaJugadasKeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(tablaJugadas);
        if (tablaJugadas.getColumnModel().getColumnCount() > 0) {
            tablaJugadas.getColumnModel().getColumn(0).setMinWidth(130);
            tablaJugadas.getColumnModel().getColumn(0).setPreferredWidth(130);
            tablaJugadas.getColumnModel().getColumn(0).setMaxWidth(130);
        }

        jLabel3.setText("Total Vendido:");

        lbTotalVendido.setText("#");

        jLabel6.setText("Total En ticket Anulados:");

        lbTotalAnulado.setText("#");

        javax.swing.GroupLayout panelResultadosLayout = new javax.swing.GroupLayout(panelResultados);
        panelResultados.setLayout(panelResultadosLayout);
        panelResultadosLayout.setHorizontalGroup(
            panelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelResultadosLayout.createSequentialGroup()
                .addGroup(panelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelResultadosLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(panelResultadosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbTotalVendido, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbTotalAnulado, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(panelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelInfoTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelResultadosLayout.setVerticalGroup(
            panelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelResultadosLayout.createSequentialGroup()
                .addGroup(panelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelResultadosLayout.createSequentialGroup()
                        .addGroup(panelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTotalVendido, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTotalAnulado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(panelResultadosLayout.createSequentialGroup()
                        .addComponent(panelInfoTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFiltros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelResultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tablaTicketsTicksKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaTicketsTicksKeyPressed

    }//GEN-LAST:event_tablaTicketsTicksKeyPressed

    private void tablaJugadasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaJugadasKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaJugadasKeyPressed

    private void tablaTicketsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTicketsMouseClicked
        int row = tablaTickets.getSelectedRow();
        if (row >= 0) {
            int numTicket = Integer.parseInt(tablaTickets.getValueAt(row, 0).toString());

            modeloJugadas.setRowCount(0);

            Ticket ticketSeleccionado = tickets.stream()
                    .filter(t
                            -> Float.compare(
                            t.getId(),
                            numTicket) == 0
                    ).findFirst().get();

            lbNumticket.setText(ticketSeleccionado.getNumTicket() + "");
            lbFecha.setText(ticketSeleccionado.getFecha());
            lbMontoPrograma.setText(ticketSeleccionado.getTotalJugado() + "");
            lbTotalPremios.setText(ticketSeleccionado.getTotalPremio() + "");
            lbTotalPagado.setText(ticketSeleccionado.getMontoPagado() + "");
            for (JugadasTicket jugada : ticketSeleccionado.getJugadas()) {
                modeloJugadas.addRow(new Object[]{
                    jugada.getSorteo(),
                    jugada.getAnimal(),
                    jugada.getMonto(),
                    jugada.getEstado()
                });
            }

        }
    }//GEN-LAST:event_tablaTicketsMouseClicked

    private void btnBuscarTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTicketActionPerformed
        String fecha01 = getFechaDesde();
        String fecha02 = getFechaHasta();
//ind.agencia.getNombreAgencia()
        tickets = (ArrayList) new Ticket().getTickets(ind.agencia.getId(), fecha01, fecha02).clone();

        modeloTickets.setRowCount(0);

        String estado = comboEstadoTicket.getSelectedIndex() == 0
                ? ""
                : comboEstadoTicket.getSelectedItem().toString().toLowerCase();
        double totalVendido = 0.0;
        double totalAnulado = 0.0;
        for (Ticket ticket : tickets) {
            if (estado.equalsIgnoreCase("premiado")) {
                if (ticket.getEstado().toLowerCase().contains("premiado") || ticket.getEstado().toLowerCase().contains("pagado")) {
                    modeloTickets.addRow(new Object[]{
                        ticket.getId(), ticket.getNumTicket(), ticket.getFecha(), ticket.getTotalJugado(),ticket.getTotalPremio(), ticket.getEstado()
                    });
                } 
            }else{
                 if (ticket.getEstado().toLowerCase().contains(estado)) {
                        modeloTickets.addRow(new Object[]{
                            ticket.getId(), ticket.getNumTicket(), ticket.getFecha(), ticket.getTotalJugado(),ticket.getTotalPremio(), ticket.getEstado()
                        });
                    }
            }
            if (ticket.getEstado().equalsIgnoreCase("anulado")) {
                totalAnulado += ticket.getTotalJugado();
            } else {
                totalVendido += ticket.getTotalJugado();
            }
        }
        lbTotalAnulado.setText(totalAnulado + "");
        lbTotalVendido.setText(totalVendido + "");
    }//GEN-LAST:event_btnBuscarTicketActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(VerTickets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerTickets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerTickets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerTickets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerTickets().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBuscarTicket;
    private javax.swing.JComboBox<String> comboEstadoTicket;
    private com.toedter.calendar.JDateChooser fechaDesde;
    private com.toedter.calendar.JDateChooser fechaHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbMontoPrograma;
    private javax.swing.JLabel lbNumticket;
    private javax.swing.JLabel lbTotalAnulado;
    private javax.swing.JLabel lbTotalPagado;
    private javax.swing.JLabel lbTotalPremios;
    private javax.swing.JLabel lbTotalVendido;
    private javax.swing.JPanel panelFiltros;
    private javax.swing.JPanel panelInfoTicket;
    private javax.swing.JPanel panelResultados;
    private javax.swing.ButtonGroup rbEstadosTicket;
    private javax.swing.ButtonGroup rbPrograma;
    private rojerusan.RSTableMetro tablaJugadas;
    private rojerusan.RSTableMetro tablaTickets;
    // End of variables declaration//GEN-END:variables

    public void iniciar() {
        this.setExtendedState(MAXIMIZED_BOTH);
        fechaDesde.setDate(new Date());
        fechaHasta.setDate(new Date());

        modeloJugadas = (DefaultTableModel) tablaJugadas.getModel();
        modeloTickets = (DefaultTableModel) tablaTickets.getModel();
    }

    private void resetDatosTicket() {
        modeloJugadas.setRowCount(0);

        lbNumticket.setText("#");
        lbFecha.setText("#");

        lbMontoPrograma.setText("#");
        lbTotalPagado.setText("#");
        lbTotalPremios.setText("#");
        lbTotalAnulado.setText("#");
        lbTotalVendido.setText("#");
    }

    public String getFechaDesde() {
        return new SimpleDateFormat("yyyy-MM-dd").format(fechaDesde.getDate());
    }

    public String getFechaHasta() {
        return new SimpleDateFormat("yyyy-MM-dd").format(fechaHasta.getDate());
    }

}
