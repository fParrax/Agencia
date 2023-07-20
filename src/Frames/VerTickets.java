/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Clases.JugadasTicket;
import Clases.NTPService;
import Clases.Ticket;
import java.awt.Image;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        this.ind=ind;
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
        RbLottoActivo = new javax.swing.JRadioButton();
        RbGranjita = new javax.swing.JRadioButton();
        RbTodos = new javax.swing.JRadioButton();
        btnBuscarTicket = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rbEstadoTodos = new javax.swing.JRadioButton();
        rbEstadoAnulados = new javax.swing.JRadioButton();
        rbEstadoPremiados = new javax.swing.JRadioButton();
        rbEstadoPagados = new javax.swing.JRadioButton();
        fechaHasta = new javax.swing.JTextField();
        fechaDesde = new javax.swing.JTextField();
        panelResultados = new javax.swing.JPanel();
        panelInfoTicket = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lbNumticket = new javax.swing.JLabel();
        lbFecha = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbAnimales = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Visualización de Tickets");

        panelFiltros.setBackground(new java.awt.Color(255, 255, 255));
        panelFiltros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtros de búsqueda de tickets", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("DESDE");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("HASTA");

        rbPrograma.add(RbLottoActivo);
        RbLottoActivo.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        RbLottoActivo.setText("LottoActivo");
        RbLottoActivo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                RbLottoActivoItemStateChanged(evt);
            }
        });

        rbPrograma.add(RbGranjita);
        RbGranjita.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        RbGranjita.setText("Granjita");
        RbGranjita.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                RbGranjitaItemStateChanged(evt);
            }
        });

        rbPrograma.add(RbTodos);
        RbTodos.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        RbTodos.setSelected(true);
        RbTodos.setText("Todos");
        RbTodos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                RbTodosItemStateChanged(evt);
            }
        });

        btnBuscarTicket.setText("Buscar Tickets");
        btnBuscarTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarTicketActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Programa");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Estado:");

        rbEstadosTicket.add(rbEstadoTodos);
        rbEstadoTodos.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        rbEstadoTodos.setSelected(true);
        rbEstadoTodos.setText("Todos");
        rbEstadoTodos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbEstadoTodosItemStateChanged(evt);
            }
        });

        rbEstadosTicket.add(rbEstadoAnulados);
        rbEstadoAnulados.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        rbEstadoAnulados.setText("Anulados");
        rbEstadoAnulados.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbEstadoAnuladosItemStateChanged(evt);
            }
        });

        rbEstadosTicket.add(rbEstadoPremiados);
        rbEstadoPremiados.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        rbEstadoPremiados.setText("Premiados");
        rbEstadoPremiados.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbEstadoPremiadosItemStateChanged(evt);
            }
        });

        rbEstadosTicket.add(rbEstadoPagados);
        rbEstadoPagados.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        rbEstadoPagados.setText("Pagados");
        rbEstadoPagados.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbEstadoPagadosItemStateChanged(evt);
            }
        });

        fechaHasta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fechaHasta.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        fechaDesde.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fechaDesde.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout panelFiltrosLayout = new javax.swing.GroupLayout(panelFiltros);
        panelFiltros.setLayout(panelFiltrosLayout);
        panelFiltrosLayout.setHorizontalGroup(
            panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFiltrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fechaHasta, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(fechaDesde))
                .addGap(18, 18, 18)
                .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(RbTodos, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(rbEstadoTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(RbLottoActivo, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(rbEstadoAnulados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(RbGranjita, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(rbEstadoPremiados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFiltrosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(rbEstadoPagados, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFiltrosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscarTicket)
                        .addContainerGap())))
        );
        panelFiltrosLayout.setVerticalGroup(
            panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFiltrosLayout.createSequentialGroup()
                .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelFiltrosLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(btnBuscarTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelFiltrosLayout.createSequentialGroup()
                        .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFiltrosLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbEstadoTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rbEstadoAnulados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rbEstadoPremiados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rbEstadoPagados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(panelFiltrosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFiltrosLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(RbTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(RbGranjita)
                            .addComponent(RbLottoActivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelFiltrosLayout.createSequentialGroup()
                                .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(fechaHasta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 17, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        panelResultados.setBackground(new java.awt.Color(255, 255, 255));
        panelResultados.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultados de la Búsqueda", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        panelInfoTicket.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información del Ticket", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N

        jLabel5.setText("# Ticket:");

        lbNumticket.setText("#");

        lbFecha.setText("#");

        jLabel8.setText("Fecha:");

        jLabel9.setText("Animales:");

        lbAnimales.setText("#");

        jLabel13.setText("Monto Ticket:");

        lbMontoPrograma.setText("#");

        jLabel15.setText("Total Premios:");

        lbTotalPremios.setText("#");

        jLabel17.setText("Total Pagado:");

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
                        .addComponent(lbFecha)
                        .addGap(95, 95, 95)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbAnimales, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                    .addGroup(panelInfoTicketLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTotalPremios, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTotalPagado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelInfoTicketLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbMontoPrograma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelInfoTicketLayout.setVerticalGroup(
            panelInfoTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoTicketLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInfoTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbNumticket)
                    .addComponent(jLabel8)
                    .addComponent(lbFecha)
                    .addComponent(jLabel9)
                    .addComponent(lbAnimales))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInfoTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lbMontoPrograma))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInfoTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(lbTotalPremios)
                    .addComponent(jLabel17)
                    .addComponent(lbTotalPagado))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        tablaTickets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ticket", "Fecha", "Monto", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
        tablaTickets.setFuenteFilas(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tablaTickets.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tablaTickets.setFuenteHead(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tablaTickets.setGridColor(new java.awt.Color(0, 0, 0));
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
            tablaTickets.getColumnModel().getColumn(2).setMinWidth(50);
            tablaTickets.getColumnModel().getColumn(2).setPreferredWidth(50);
            tablaTickets.getColumnModel().getColumn(2).setMaxWidth(75);
        }

        tablaJugadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sorteo", "Jugada", "Monto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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
        tablaJugadas.setFuenteFilas(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tablaJugadas.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tablaJugadas.setFuenteHead(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tablaJugadas.setGridColor(new java.awt.Color(0, 0, 0));
        tablaJugadas.setSelectionBackground(new java.awt.Color(0, 102, 102));
        tablaJugadas.setShowGrid(true);
        tablaJugadas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaJugadasKeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(tablaJugadas);

        javax.swing.GroupLayout panelResultadosLayout = new javax.swing.GroupLayout(panelResultados);
        panelResultados.setLayout(panelResultadosLayout);
        panelResultadosLayout.setHorizontalGroup(
            panelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelResultadosLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelInfoTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelResultadosLayout.setVerticalGroup(
            panelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelResultadosLayout.createSequentialGroup()
                .addGroup(panelResultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelResultadosLayout.createSequentialGroup()
                        .addComponent(panelInfoTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE))
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

    private void RbLottoActivoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_RbLottoActivoItemStateChanged
        if (RbLottoActivo.isSelected()) {
            programa = "LottoActivo";
        }
    }//GEN-LAST:event_RbLottoActivoItemStateChanged

    private void RbGranjitaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_RbGranjitaItemStateChanged
        if (RbGranjita.isSelected()) {
            programa = "Granjita";
        }
    }//GEN-LAST:event_RbGranjitaItemStateChanged

    private void RbTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_RbTodosItemStateChanged
        if (RbTodos.isSelected()) {
            programa = "";
        }
    }//GEN-LAST:event_RbTodosItemStateChanged

    private void rbEstadoTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbEstadoTodosItemStateChanged
        if (rbEstadoTodos.isSelected()) {
            estadoTicket = "";
        }
    }//GEN-LAST:event_rbEstadoTodosItemStateChanged

    private void rbEstadoAnuladosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbEstadoAnuladosItemStateChanged
        if (rbEstadoAnulados.isSelected()) {
            estadoTicket = "Anulado";
        }
    }//GEN-LAST:event_rbEstadoAnuladosItemStateChanged

    private void rbEstadoPremiadosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbEstadoPremiadosItemStateChanged
        if (rbEstadoPremiados.isSelected()) {
            estadoTicket = "Premiado";
        }
    }//GEN-LAST:event_rbEstadoPremiadosItemStateChanged

    private void rbEstadoPagadosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbEstadoPagadosItemStateChanged
        if (rbEstadoPagados.isSelected()) {
            estadoTicket = "Pagado";
        }
    }//GEN-LAST:event_rbEstadoPagadosItemStateChanged

    private void btnBuscarTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTicketActionPerformed
        String fecha01 = fechaDesde.getText();
        String fecha02 = fechaHasta.getText();
        
        tickets = (ArrayList) new Ticket().getTickets(ind.agencia.getNombreAgencia(),fecha01, fecha02).clone();
       
        modeloTickets.setRowCount(0);
        for (Ticket ticket : tickets) {
            modeloTickets.addRow(new Object[]{
                ticket.getId(), ticket.getFecha(), ticket.getTotalJugado(), ticket.getEstado()
            });
        }
       // resetDatosTicket();
    }//GEN-LAST:event_btnBuscarTicketActionPerformed

    private void tablaTicketsTicksKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaTicketsTicksKeyPressed
      
    }//GEN-LAST:event_tablaTicketsTicksKeyPressed

    private void tablaJugadasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaJugadasKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaJugadasKeyPressed

    private void tablaTicketsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTicketsMouseClicked
        int row = tablaTickets.getSelectedRow();
        if (row >= 0) {
            int idx = Integer.parseInt(tablaTickets.getValueAt(row, 0).toString());
            
            modeloJugadas.setRowCount(0);
            for (Ticket ticket : tickets) {
                if (Float.compare(idx, ticket.getId()) == 0) {
                    myTicket = ticket;

                    
                    lbNumticket.setText(ticket.getId() + "");
                    lbFecha.setText(ticket.getFecha());
                    lbAnimales.setText(ticket.getJugadas().size() + "");
                    
                    lbMontoPrograma.setText(ticket.getTotalJugado() + "");
                    lbTotalPremios.setText(ticket.getTotalPremio() + "");
                    lbTotalPagado.setText(ticket.getMontoPagado() + "");

                    for (JugadasTicket jugada : ticket.getJugadas()) {
                        modeloJugadas.addRow(new Object[]{
                            jugada.getSorteo(), jugada.getAnimal(), jugada.getMonto()
                        });
                    }

                    

                    break;
                }
            }
        }
    }//GEN-LAST:event_tablaTicketsMouseClicked

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
    private javax.swing.JRadioButton RbGranjita;
    private javax.swing.JRadioButton RbLottoActivo;
    private javax.swing.JRadioButton RbTodos;
    public javax.swing.JButton btnBuscarTicket;
    private javax.swing.JTextField fechaDesde;
    private javax.swing.JTextField fechaHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbAnimales;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbMontoPrograma;
    private javax.swing.JLabel lbNumticket;
    private javax.swing.JLabel lbTotalPagado;
    private javax.swing.JLabel lbTotalPremios;
    private javax.swing.JPanel panelFiltros;
    private javax.swing.JPanel panelInfoTicket;
    private javax.swing.JPanel panelResultados;
    private javax.swing.JRadioButton rbEstadoAnulados;
    private javax.swing.JRadioButton rbEstadoPagados;
    private javax.swing.JRadioButton rbEstadoPremiados;
    private javax.swing.JRadioButton rbEstadoTodos;
    private javax.swing.ButtonGroup rbEstadosTicket;
    private javax.swing.ButtonGroup rbPrograma;
    private rojerusan.RSTableMetro tablaJugadas;
    private rojerusan.RSTableMetro tablaTickets;
    // End of variables declaration//GEN-END:variables

    public void iniciar() {
        fechaDesde.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        fechaHasta.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

        

        modeloJugadas = (DefaultTableModel) tablaJugadas.getModel();
        modeloTickets = (DefaultTableModel) tablaTickets.getModel();
    }

    private boolean validarMinutos(Ticket ticket, int minutos) {
        boolean llave = false;
        try {
            String actual = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new NTPService().getNTPDate());
            Date hActual = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(actual);
           // Date horaInicial = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(ticket.getFecha() + " " + ticket.getHoraTicket());

           // int resultado = new tools().restarMinutos(horaInicial, hActual);
            //if (resultado <= minutos) {
                llave = true;
           // }
        } catch (ParseException ex) {
            Logger.getLogger(VerTickets.class.getName()).log(Level.SEVERE, null, ex);
        }
        return llave;
    }

    private void resetDatosTicket() {
        modeloJugadas.setRowCount(0);
       
        lbAnimales.setText("#");
        lbNumticket.setText("#");
        lbFecha.setText("#");
        
        lbMontoPrograma.setText("#");
        lbTotalPagado.setText("#");
        lbTotalPremios.setText("#");
    }
}
