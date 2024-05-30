package Frames;

import Clases.Agencia;
import Clases.ConectarDBCloud;
import Clases.CupoAnimal;
import Clases.HoraSorteo;
import Clases.Imprimir;
import Clases.JCheckBoxPrograma;
import Clases.JugadasTicket;
import Clases.Loteria;
import Clases.NTPService;
import Clases.NewCupos;
import Clases.PlaceHolder;
import Clases.ScrollSens;
import Clases.Ticket;
import Clases.tools;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;
import rojerusan.RSNotifyFade;

public class index extends javax.swing.JFrame {

    int contadorCupos=0;
     int mbCuota = 1024 * 1024; // 1 MB en bytes
    
    
    VerTickets verTickets;
    verResultados verResul;
    verVentas vVentas;
    
    ArrayList<CupoAnimal> animalesVendidos = new ArrayList();
    ArrayList<JToggleButton> animalesTablero = new ArrayList();
    ArrayList<Loteria> loterias = new ArrayList();
    ArrayList<JCheckBoxPrograma> sorteos = new ArrayList();
    
    ArrayList<String> sorteosDisponibles = new ArrayList();
    ArrayList<CupoAnimal> myCupos = new ArrayList();

    
    DefaultTableModel modelo;
    

    boolean tablero = false;
    public double totalTicket = 0.0;
    long tInicio, tFinal;
    int espaciosPrevios = 0;
    boolean isConnected = false;
    boolean imprimiendo = false;
    private String myUrl = "c1046.gconex.com";

    Calendar myHoraActual = Calendar.getInstance();
    public Calendar myUltimaHora = Calendar.getInstance();

    public String fechaHoy = "2022-11-01";

    Agencia agencia;

    public index() {
        initComponents();

        changeIcon();
        new Thread(this::iniciar).start();

    }

    public index(Agencia agencia) {
        initComponents();
        this.agencia = agencia;
        setTitle(getTitle() + " - " + agencia.getNombreAgencia());

        changeIcon();
        new Thread(this::iniciar).start();

    }

    public void changeIcon() {
        Image icon = new ImageIcon(getClass().getResource("/imgs/chip.png")).getImage();
        setIconImage(icon);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg1 = new javax.swing.ButtonGroup();
        jMenuItem1 = new javax.swing.JMenuItem();
        opcionesTabla = new javax.swing.JPopupMenu();
        BorrarJugadas = new javax.swing.JMenuItem();
        panelCentral = new javax.swing.JPanel();
        panelAnimales = new javax.swing.JPanel();
        a00 = new javax.swing.JToggleButton();
        a0 = new javax.swing.JToggleButton();
        a3 = new javax.swing.JToggleButton();
        a1 = new javax.swing.JToggleButton();
        a2 = new javax.swing.JToggleButton();
        a5 = new javax.swing.JToggleButton();
        a4 = new javax.swing.JToggleButton();
        a6 = new javax.swing.JToggleButton();
        a7 = new javax.swing.JToggleButton();
        a8 = new javax.swing.JToggleButton();
        a9 = new javax.swing.JToggleButton();
        a12 = new javax.swing.JToggleButton();
        a11 = new javax.swing.JToggleButton();
        a10 = new javax.swing.JToggleButton();
        a21 = new javax.swing.JToggleButton();
        a20 = new javax.swing.JToggleButton();
        a23 = new javax.swing.JToggleButton();
        a22 = new javax.swing.JToggleButton();
        a24 = new javax.swing.JToggleButton();
        a19 = new javax.swing.JToggleButton();
        a16 = new javax.swing.JToggleButton();
        a17 = new javax.swing.JToggleButton();
        a18 = new javax.swing.JToggleButton();
        a15 = new javax.swing.JToggleButton();
        a14 = new javax.swing.JToggleButton();
        a13 = new javax.swing.JToggleButton();
        a25 = new javax.swing.JToggleButton();
        a35 = new javax.swing.JToggleButton();
        a29 = new javax.swing.JToggleButton();
        a31 = new javax.swing.JToggleButton();
        a33 = new javax.swing.JToggleButton();
        a26 = new javax.swing.JToggleButton();
        a30 = new javax.swing.JToggleButton();
        a36 = new javax.swing.JToggleButton();
        a32 = new javax.swing.JToggleButton();
        a28 = new javax.swing.JToggleButton();
        a34 = new javax.swing.JToggleButton();
        a27 = new javax.swing.JToggleButton();
        panelSorteos = new javax.swing.JPanel();
        scrollSorteos = new javax.swing.JScrollPane();
        panelAyuda = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtPagar = new javax.swing.JTextField();
        btnPagar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        txtAnular = new javax.swing.JTextField();
        btnAnular = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        btnRepetir = new javax.swing.JButton();
        lbMensajeSistema = new javax.swing.JLabel();
        panelTablaJugadas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new rojerusan.RSTableMetro();
        totalTicketTxt = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbNumTicket = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        panelMontos = new javax.swing.JPanel();
        animalTxt = new javax.swing.JTextField();
        montoTxt = new javax.swing.JTextField();
        btnGenerarJugada = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        menuMain = new javax.swing.JMenuBar();
        archivoMenu = new javax.swing.JMenu();
        salir = new javax.swing.JMenuItem();
        ticketMenu = new javax.swing.JMenu();
        verTicketsItem = new javax.swing.JMenuItem();
        resultadosItem = new javax.swing.JMenuItem();
        ventasItem = new javax.swing.JMenuItem();
        menuHerramientas = new javax.swing.JMenu();
        checkImprimirTicket = new javax.swing.JCheckBoxMenuItem();

        jMenuItem1.setText("jMenuItem1");

        BorrarJugadas.setText("Borrar Jugadas Seleccionadas");
        BorrarJugadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarJugadasActionPerformed(evt);
            }
        });
        opcionesTabla.add(BorrarJugadas);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agencia de Loterias");
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        panelCentral.setBackground(new java.awt.Color(255, 255, 255));

        panelAnimales.setBackground(new java.awt.Color(255, 255, 255));
        panelAnimales.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                panelAnimalesKeyPressed(evt);
            }
        });
        panelAnimales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        a00.setBackground(new java.awt.Color(51, 51, 51));
        a00.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a00.setForeground(new java.awt.Color(255, 255, 255));
        a00.setText("00");
        a00.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a00.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a00.setIconTextGap(0);
        a00.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a00.setName("-1"); // NOI18N
        a00.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a00ActionPerformed(evt);
            }
        });
        panelAnimales.add(a00, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 120, 53));

        a0.setBackground(new java.awt.Color(51, 51, 51));
        a0.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a0.setForeground(new java.awt.Color(255, 255, 255));
        a0.setText("0");
        a0.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a0.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a0.setIconTextGap(0);
        a0.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a0.setName("0"); // NOI18N
        a0.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a0ActionPerformed(evt);
            }
        });
        panelAnimales.add(a0, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 120, 53));

        a3.setBackground(new java.awt.Color(51, 51, 51));
        a3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a3.setForeground(new java.awt.Color(255, 255, 255));
        a3.setText("3");
        a3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a3.setIconTextGap(0);
        a3.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a3.setName("3"); // NOI18N
        a3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a3ActionPerformed(evt);
            }
        });
        panelAnimales.add(a3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 80, 40));

        a1.setBackground(new java.awt.Color(51, 51, 51));
        a1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a1.setForeground(new java.awt.Color(255, 255, 255));
        a1.setText("1");
        a1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a1.setIconTextGap(0);
        a1.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a1.setName("1"); // NOI18N
        a1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a1ActionPerformed(evt);
            }
        });
        panelAnimales.add(a1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 80, 40));

        a2.setBackground(new java.awt.Color(51, 51, 51));
        a2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a2.setForeground(new java.awt.Color(255, 255, 255));
        a2.setText("2");
        a2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a2.setIconTextGap(0);
        a2.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a2.setName("2"); // NOI18N
        a2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a2ActionPerformed(evt);
            }
        });
        panelAnimales.add(a2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 80, 40));

        a5.setBackground(new java.awt.Color(51, 51, 51));
        a5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a5.setForeground(new java.awt.Color(255, 255, 255));
        a5.setText("5");
        a5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a5.setIconTextGap(0);
        a5.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a5.setName("5"); // NOI18N
        a5.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a5ActionPerformed(evt);
            }
        });
        panelAnimales.add(a5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 80, 40));

        a4.setBackground(new java.awt.Color(51, 51, 51));
        a4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a4.setForeground(new java.awt.Color(255, 255, 255));
        a4.setText("4");
        a4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a4.setIconTextGap(0);
        a4.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a4.setName("4"); // NOI18N
        a4.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a4ActionPerformed(evt);
            }
        });
        panelAnimales.add(a4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 80, 40));

        a6.setBackground(new java.awt.Color(51, 51, 51));
        a6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a6.setForeground(new java.awt.Color(255, 255, 255));
        a6.setText("6");
        a6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a6.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a6.setIconTextGap(0);
        a6.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a6.setName("6"); // NOI18N
        a6.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a6ActionPerformed(evt);
            }
        });
        panelAnimales.add(a6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 80, 40));

        a7.setBackground(new java.awt.Color(51, 51, 51));
        a7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a7.setForeground(new java.awt.Color(255, 255, 255));
        a7.setText("7");
        a7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a7.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a7.setIconTextGap(0);
        a7.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a7.setName("7"); // NOI18N
        a7.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a7ActionPerformed(evt);
            }
        });
        panelAnimales.add(a7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 80, 40));

        a8.setBackground(new java.awt.Color(51, 51, 51));
        a8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a8.setForeground(new java.awt.Color(255, 255, 255));
        a8.setText("8");
        a8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a8.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a8.setIconTextGap(0);
        a8.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a8.setName("8"); // NOI18N
        a8.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a8ActionPerformed(evt);
            }
        });
        panelAnimales.add(a8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 80, 40));

        a9.setBackground(new java.awt.Color(51, 51, 51));
        a9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a9.setForeground(new java.awt.Color(255, 255, 255));
        a9.setText("9");
        a9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a9.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a9.setIconTextGap(0);
        a9.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a9.setName("9"); // NOI18N
        a9.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a9ActionPerformed(evt);
            }
        });
        panelAnimales.add(a9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 80, 40));

        a12.setBackground(new java.awt.Color(51, 51, 51));
        a12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a12.setForeground(new java.awt.Color(255, 255, 255));
        a12.setText("12");
        a12.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a12.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a12.setIconTextGap(0);
        a12.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a12.setName("13"); // NOI18N
        a12.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a12ActionPerformed(evt);
            }
        });
        panelAnimales.add(a12, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 80, 40));

        a11.setBackground(new java.awt.Color(51, 51, 51));
        a11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a11.setForeground(new java.awt.Color(255, 255, 255));
        a11.setText("11");
        a11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a11.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a11.setIconTextGap(0);
        a11.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a11.setName("11"); // NOI18N
        a11.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a11ActionPerformed(evt);
            }
        });
        panelAnimales.add(a11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 80, 40));

        a10.setBackground(new java.awt.Color(51, 51, 51));
        a10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a10.setForeground(new java.awt.Color(255, 255, 255));
        a10.setText("10");
        a10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a10.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a10.setIconTextGap(0);
        a10.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a10.setName("10"); // NOI18N
        a10.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a10ActionPerformed(evt);
            }
        });
        panelAnimales.add(a10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 80, 40));

        a21.setBackground(new java.awt.Color(51, 51, 51));
        a21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a21.setForeground(new java.awt.Color(255, 255, 255));
        a21.setText("21");
        a21.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a21.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a21.setIconTextGap(0);
        a21.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a21.setName("21"); // NOI18N
        a21.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a21ActionPerformed(evt);
            }
        });
        panelAnimales.add(a21, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 80, 40));

        a20.setBackground(new java.awt.Color(51, 51, 51));
        a20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a20.setForeground(new java.awt.Color(255, 255, 255));
        a20.setText("20");
        a20.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a20.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a20.setIconTextGap(0);
        a20.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a20.setName("20"); // NOI18N
        a20.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a20ActionPerformed(evt);
            }
        });
        panelAnimales.add(a20, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 80, 40));

        a23.setBackground(new java.awt.Color(51, 51, 51));
        a23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a23.setForeground(new java.awt.Color(255, 255, 255));
        a23.setText("23");
        a23.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a23.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a23.setIconTextGap(0);
        a23.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a23.setName("23"); // NOI18N
        a23.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a23ActionPerformed(evt);
            }
        });
        panelAnimales.add(a23, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 80, 40));

        a22.setBackground(new java.awt.Color(51, 51, 51));
        a22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a22.setForeground(new java.awt.Color(255, 255, 255));
        a22.setText("22");
        a22.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a22.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a22.setIconTextGap(0);
        a22.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a22.setName("22"); // NOI18N
        a22.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a22ActionPerformed(evt);
            }
        });
        panelAnimales.add(a22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 80, 40));

        a24.setBackground(new java.awt.Color(51, 51, 51));
        a24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a24.setForeground(new java.awt.Color(255, 255, 255));
        a24.setText("24");
        a24.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a24.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a24.setIconTextGap(0);
        a24.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a24.setName("24"); // NOI18N
        a24.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a24ActionPerformed(evt);
            }
        });
        panelAnimales.add(a24, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 80, 40));

        a19.setBackground(new java.awt.Color(51, 51, 51));
        a19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a19.setForeground(new java.awt.Color(255, 255, 255));
        a19.setText("19");
        a19.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a19.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a19.setIconTextGap(0);
        a19.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a19.setName("19"); // NOI18N
        a19.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a19ActionPerformed(evt);
            }
        });
        panelAnimales.add(a19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 80, 40));

        a16.setBackground(new java.awt.Color(51, 51, 51));
        a16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a16.setForeground(new java.awt.Color(255, 255, 255));
        a16.setText("16");
        a16.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a16.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a16.setIconTextGap(0);
        a16.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a16.setName("16"); // NOI18N
        a16.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a16ActionPerformed(evt);
            }
        });
        panelAnimales.add(a16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 80, 40));

        a17.setBackground(new java.awt.Color(51, 51, 51));
        a17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a17.setForeground(new java.awt.Color(255, 255, 255));
        a17.setText("17");
        a17.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a17.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a17.setIconTextGap(0);
        a17.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a17.setName("17"); // NOI18N
        a17.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a17ActionPerformed(evt);
            }
        });
        panelAnimales.add(a17, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 80, 40));

        a18.setBackground(new java.awt.Color(51, 51, 51));
        a18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a18.setForeground(new java.awt.Color(255, 255, 255));
        a18.setText("18");
        a18.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a18.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a18.setIconTextGap(0);
        a18.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a18.setName("18"); // NOI18N
        a18.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a18ActionPerformed(evt);
            }
        });
        panelAnimales.add(a18, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 80, 40));

        a15.setBackground(new java.awt.Color(51, 51, 51));
        a15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a15.setForeground(new java.awt.Color(255, 255, 255));
        a15.setText("15");
        a15.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a15.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a15.setIconTextGap(0);
        a15.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a15.setName("15"); // NOI18N
        a15.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a15ActionPerformed(evt);
            }
        });
        panelAnimales.add(a15, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 80, 40));

        a14.setBackground(new java.awt.Color(51, 51, 51));
        a14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a14.setForeground(new java.awt.Color(255, 255, 255));
        a14.setText("14");
        a14.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a14.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a14.setIconTextGap(0);
        a14.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a14.setName("14"); // NOI18N
        a14.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a14ActionPerformed(evt);
            }
        });
        panelAnimales.add(a14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 80, 40));

        a13.setBackground(new java.awt.Color(51, 51, 51));
        a13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a13.setForeground(new java.awt.Color(255, 255, 255));
        a13.setText("13");
        a13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a13.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a13.setIconTextGap(0);
        a13.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a13.setName("13"); // NOI18N
        a13.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a13ActionPerformed(evt);
            }
        });
        panelAnimales.add(a13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 80, 40));

        a25.setBackground(new java.awt.Color(51, 51, 51));
        a25.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a25.setForeground(new java.awt.Color(255, 255, 255));
        a25.setText("25");
        a25.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a25.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a25.setIconTextGap(0);
        a25.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a25.setName("25"); // NOI18N
        a25.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a25ActionPerformed(evt);
            }
        });
        panelAnimales.add(a25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 80, 40));

        a35.setBackground(new java.awt.Color(51, 51, 51));
        a35.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a35.setForeground(new java.awt.Color(255, 255, 255));
        a35.setText("35");
        a35.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a35.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a35.setIconTextGap(0);
        a35.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a35.setName("35"); // NOI18N
        a35.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a35ActionPerformed(evt);
            }
        });
        panelAnimales.add(a35, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 510, 80, 40));

        a29.setBackground(new java.awt.Color(51, 51, 51));
        a29.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a29.setForeground(new java.awt.Color(255, 255, 255));
        a29.setText("29");
        a29.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a29.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a29.setIconTextGap(0);
        a29.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a29.setName("29"); // NOI18N
        a29.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a29ActionPerformed(evt);
            }
        });
        panelAnimales.add(a29, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, 80, 40));

        a31.setBackground(new java.awt.Color(51, 51, 51));
        a31.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a31.setForeground(new java.awt.Color(255, 255, 255));
        a31.setText("31");
        a31.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a31.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a31.setIconTextGap(0);
        a31.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a31.setName("31"); // NOI18N
        a31.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a31ActionPerformed(evt);
            }
        });
        panelAnimales.add(a31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 80, 40));

        a33.setBackground(new java.awt.Color(51, 51, 51));
        a33.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a33.setForeground(new java.awt.Color(255, 255, 255));
        a33.setText("33");
        a33.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a33.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a33.setIconTextGap(0);
        a33.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a33.setName("33"); // NOI18N
        a33.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a33ActionPerformed(evt);
            }
        });
        panelAnimales.add(a33, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, 80, 40));

        a26.setBackground(new java.awt.Color(51, 51, 51));
        a26.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a26.setForeground(new java.awt.Color(255, 255, 255));
        a26.setText("26");
        a26.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a26.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a26.setIconTextGap(0);
        a26.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a26.setName("26"); // NOI18N
        a26.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a26ActionPerformed(evt);
            }
        });
        panelAnimales.add(a26, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 80, 40));

        a30.setBackground(new java.awt.Color(51, 51, 51));
        a30.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a30.setForeground(new java.awt.Color(255, 255, 255));
        a30.setText("30");
        a30.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a30.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a30.setIconTextGap(0);
        a30.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a30.setName("30"); // NOI18N
        a30.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a30ActionPerformed(evt);
            }
        });
        panelAnimales.add(a30, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, 80, 40));

        a36.setBackground(new java.awt.Color(51, 51, 51));
        a36.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a36.setForeground(new java.awt.Color(255, 255, 255));
        a36.setText("36");
        a36.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a36.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a36.setIconTextGap(0);
        a36.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a36.setName("36"); // NOI18N
        a36.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a36ActionPerformed(evt);
            }
        });
        panelAnimales.add(a36, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 510, 80, 40));

        a32.setBackground(new java.awt.Color(51, 51, 51));
        a32.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a32.setForeground(new java.awt.Color(255, 255, 255));
        a32.setText("32");
        a32.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a32.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a32.setIconTextGap(0);
        a32.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a32.setName("32"); // NOI18N
        a32.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a32ActionPerformed(evt);
            }
        });
        panelAnimales.add(a32, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 470, 80, 40));

        a28.setBackground(new java.awt.Color(51, 51, 51));
        a28.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a28.setForeground(new java.awt.Color(255, 255, 255));
        a28.setText("28");
        a28.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a28.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a28.setIconTextGap(0);
        a28.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a28.setName("28"); // NOI18N
        a28.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a28ActionPerformed(evt);
            }
        });
        panelAnimales.add(a28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 80, 40));

        a34.setBackground(new java.awt.Color(51, 51, 51));
        a34.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a34.setForeground(new java.awt.Color(255, 255, 255));
        a34.setText("34");
        a34.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a34.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a34.setIconTextGap(0);
        a34.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a34.setName("34"); // NOI18N
        a34.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a34ActionPerformed(evt);
            }
        });
        panelAnimales.add(a34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 80, 40));

        a27.setBackground(new java.awt.Color(51, 51, 51));
        a27.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a27.setForeground(new java.awt.Color(255, 255, 255));
        a27.setText("27");
        a27.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        a27.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        a27.setIconTextGap(0);
        a27.setMargin(new java.awt.Insets(2, 0, 2, 0));
        a27.setName("27"); // NOI18N
        a27.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/chip.png"))); // NOI18N
        a27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a27ActionPerformed(evt);
            }
        });
        panelAnimales.add(a27, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 80, 40));

        panelSorteos.setBackground(new java.awt.Color(255, 255, 255));
        panelSorteos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                panelSorteosKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panelSorteosLayout = new javax.swing.GroupLayout(panelSorteos);
        panelSorteos.setLayout(panelSorteosLayout);
        panelSorteosLayout.setHorizontalGroup(
            panelSorteosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSorteosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollSorteos, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        panelSorteosLayout.setVerticalGroup(
            panelSorteosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSorteosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollSorteos, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        panelAyuda.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Pagar Ticket:");

        txtPagar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPagar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPagar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPagarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPagarKeyTyped(evt);
            }
        });

        btnPagar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPagar.setText("Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Anular Ticket:");

        txtAnular.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAnular.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAnular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAnularKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnularKeyTyped(evt);
            }
        });

        btnAnular.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAnular.setText("Anular");
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Repetir Ticket:");

        btnRepetir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRepetir.setText("Repetir");
        btnRepetir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepetirActionPerformed(evt);
            }
        });

        lbMensajeSistema.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbMensajeSistema.setText("Esperando algún mensaje del sistema.");

        javax.swing.GroupLayout panelAyudaLayout = new javax.swing.GroupLayout(panelAyuda);
        panelAyuda.setLayout(panelAyudaLayout);
        panelAyudaLayout.setHorizontalGroup(
            panelAyudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAyudaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPagar)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnular)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRepetir)
                .addGap(18, 18, 18)
                .addComponent(lbMensajeSistema)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        panelAyudaLayout.setVerticalGroup(
            panelAyudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAyudaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAyudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPagar, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPagar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAnular, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnular, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelAyudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRepetir, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                        .addComponent(lbMensajeSistema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sorteo", "Jugada", "Monto", "Cupo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setAltoHead(30);
        tabla.setColorBackgoundHead(new java.awt.Color(0, 102, 102));
        tabla.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        tabla.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tabla.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tabla.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tabla.setColorSelBackgound(new java.awt.Color(0, 102, 102));
        tabla.setComponentPopupMenu(opcionesTabla);
        tabla.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabla.setFuenteFilas(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabla.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabla.setFuenteHead(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tabla.setGridColor(new java.awt.Color(0, 0, 0));
        tabla.setRowHeight(23);
        tabla.setSelectionBackground(new java.awt.Color(0, 102, 102));
        tabla.setShowGrid(true);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        tabla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(1).setMinWidth(100);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(1).setMaxWidth(100);
            tabla.getColumnModel().getColumn(2).setMinWidth(90);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(90);
            tabla.getColumnModel().getColumn(2).setMaxWidth(90);
            tabla.getColumnModel().getColumn(3).setMinWidth(90);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(90);
            tabla.getColumnModel().getColumn(3).setMaxWidth(90);
        }

        javax.swing.GroupLayout panelTablaJugadasLayout = new javax.swing.GroupLayout(panelTablaJugadas);
        panelTablaJugadas.setLayout(panelTablaJugadasLayout);
        panelTablaJugadasLayout.setHorizontalGroup(
            panelTablaJugadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaJugadasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
        );
        panelTablaJugadasLayout.setVerticalGroup(
            panelTablaJugadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );

        totalTicketTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        totalTicketTxt.setText("0");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel2.setText("Ticket #");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        lbNumTicket.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lbNumTicket.setText("jLabel7");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Total del Ticket: Bs");

        jButton4.setText("Eliminar Todas las Jugadas");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        panelMontos.setBackground(new java.awt.Color(255, 255, 255));

        animalTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        animalTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        animalTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animalTxtActionPerformed(evt);
            }
        });
        animalTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                animalTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                animalTxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                animalTxtKeyTyped(evt);
            }
        });

        montoTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        montoTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        montoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                montoTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                montoTxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                montoTxtKeyTyped(evt);
            }
        });

        btnGenerarJugada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/felcha_derecha.png"))); // NOI18N
        btnGenerarJugada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarJugadaActionPerformed(evt);
            }
        });

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/print.png"))); // NOI18N
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Animal");

        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Monto");

        javax.swing.GroupLayout panelMontosLayout = new javax.swing.GroupLayout(panelMontos);
        panelMontos.setLayout(panelMontosLayout);
        panelMontosLayout.setHorizontalGroup(
            panelMontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMontosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMontosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(animalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(montoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnGenerarJugada)
                .addGap(26, 26, 26)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        panelMontosLayout.setVerticalGroup(
            panelMontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMontosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMontosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelMontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(animalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(montoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMontosLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(panelMontosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerarJugada, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelCentralLayout = new javax.swing.GroupLayout(panelCentral);
        panelCentral.setLayout(panelCentralLayout);
        panelCentralLayout.setHorizontalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCentralLayout.createSequentialGroup()
                .addComponent(panelAnimales, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelSorteos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelMontos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCentralLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCentralLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalTicketTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCentralLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbNumTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelCentralLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelTablaJugadas, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panelAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panelCentralLayout.setVerticalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCentralLayout.createSequentialGroup()
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCentralLayout.createSequentialGroup()
                        .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCentralLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(panelMontos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelCentralLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbNumTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(totalTicketTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelSorteos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelTablaJugadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6))
                    .addComponent(panelAnimales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(panelAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        archivoMenu.setText("Archivo");

        salir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, 0));
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        archivoMenu.add(salir);

        menuMain.add(archivoMenu);

        ticketMenu.setText("Reportes");

        verTicketsItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, 0));
        verTicketsItem.setText("Ver Tickets");
        verTicketsItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verTicketsItemActionPerformed(evt);
            }
        });
        ticketMenu.add(verTicketsItem);

        resultadosItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, 0));
        resultadosItem.setText("Resultados");
        resultadosItem.setActionCommand("ingresarResultado");
        resultadosItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultadosItemActionPerformed(evt);
            }
        });
        ticketMenu.add(resultadosItem);

        ventasItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, 0));
        ventasItem.setText("Ventas");
        ventasItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventasItemActionPerformed(evt);
            }
        });
        ticketMenu.add(ventasItem);

        menuMain.add(ticketMenu);

        menuHerramientas.setText("Herramientas");

        checkImprimirTicket.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, 0));
        checkImprimirTicket.setSelected(true);
        checkImprimirTicket.setText("Imprimir Ticket");
        menuHerramientas.add(checkImprimirTicket);

        menuMain.add(menuHerramientas);

        setJMenuBar(menuMain);

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

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void a2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a2ActionPerformed
        tablero();
    }//GEN-LAST:event_a2ActionPerformed

    private void a3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a3ActionPerformed
        tablero();
    }//GEN-LAST:event_a3ActionPerformed

    private void a0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a0ActionPerformed
        tablero();
    }//GEN-LAST:event_a0ActionPerformed

    private void a00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a00ActionPerformed
        tablero();
    }//GEN-LAST:event_a00ActionPerformed

    private void a1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a1ActionPerformed
        tablero();
    }//GEN-LAST:event_a1ActionPerformed

    private void a4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a4ActionPerformed
        tablero();
    }//GEN-LAST:event_a4ActionPerformed

    private void a5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a5ActionPerformed
        tablero();
    }//GEN-LAST:event_a5ActionPerformed

    private void a6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a6ActionPerformed
        tablero();
    }//GEN-LAST:event_a6ActionPerformed

    private void a7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a7ActionPerformed
        tablero();
    }//GEN-LAST:event_a7ActionPerformed

    private void a8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a8ActionPerformed
        tablero();
    }//GEN-LAST:event_a8ActionPerformed

    private void a9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a9ActionPerformed
        tablero();
    }//GEN-LAST:event_a9ActionPerformed

    private void a10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a10ActionPerformed
        tablero();
    }//GEN-LAST:event_a10ActionPerformed

    private void a11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a11ActionPerformed
        tablero();
    }//GEN-LAST:event_a11ActionPerformed

    private void a12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a12ActionPerformed
        tablero();
    }//GEN-LAST:event_a12ActionPerformed

    private void a13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a13ActionPerformed
        tablero();
    }//GEN-LAST:event_a13ActionPerformed

    private void a14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a14ActionPerformed
        tablero();
    }//GEN-LAST:event_a14ActionPerformed

    private void a15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a15ActionPerformed
        tablero();
    }//GEN-LAST:event_a15ActionPerformed

    private void a16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a16ActionPerformed
        tablero();
    }//GEN-LAST:event_a16ActionPerformed

    private void a17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a17ActionPerformed
        tablero();
    }//GEN-LAST:event_a17ActionPerformed

    private void a18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a18ActionPerformed
        tablero();
    }//GEN-LAST:event_a18ActionPerformed

    private void a19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a19ActionPerformed
        tablero();
    }//GEN-LAST:event_a19ActionPerformed

    private void a20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a20ActionPerformed
        tablero();
    }//GEN-LAST:event_a20ActionPerformed

    private void a21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a21ActionPerformed
        tablero();
    }//GEN-LAST:event_a21ActionPerformed

    private void a22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a22ActionPerformed
        tablero();
    }//GEN-LAST:event_a22ActionPerformed

    private void a23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a23ActionPerformed
        tablero();
    }//GEN-LAST:event_a23ActionPerformed

    private void a24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a24ActionPerformed
        tablero();
    }//GEN-LAST:event_a24ActionPerformed

    private void a25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a25ActionPerformed
        tablero();
    }//GEN-LAST:event_a25ActionPerformed

    private void a26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a26ActionPerformed
        tablero();
    }//GEN-LAST:event_a26ActionPerformed

    private void a27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a27ActionPerformed
        tablero();
    }//GEN-LAST:event_a27ActionPerformed

    private void a28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a28ActionPerformed
        tablero();
    }//GEN-LAST:event_a28ActionPerformed

    private void a29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a29ActionPerformed
        tablero();
    }//GEN-LAST:event_a29ActionPerformed

    private void a30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a30ActionPerformed
        tablero();
    }//GEN-LAST:event_a30ActionPerformed

    private void a31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a31ActionPerformed
        tablero();
    }//GEN-LAST:event_a31ActionPerformed

    private void a32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a32ActionPerformed
        tablero();
    }//GEN-LAST:event_a32ActionPerformed

    private void a33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a33ActionPerformed
        tablero();
    }//GEN-LAST:event_a33ActionPerformed

    private void a34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a34ActionPerformed
        tablero();
    }//GEN-LAST:event_a34ActionPerformed

    private void a35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a35ActionPerformed
        tablero();
    }//GEN-LAST:event_a35ActionPerformed

    private void a36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a36ActionPerformed
        tablero();
    }//GEN-LAST:event_a36ActionPerformed

    private void montoTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_montoTxtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                if(!montoTxt.getText().isEmpty()){
                     jugar();
                }
        }


    }//GEN-LAST:event_montoTxtKeyPressed

    private void montoTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_montoTxtKeyReleased

    }//GEN-LAST:event_montoTxtKeyReleased

    private void montoTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_montoTxtKeyTyped
        new tools().soloDoubleyCantidadDigitos(evt, montoTxt, 2);
    }//GEN-LAST:event_montoTxtKeyTyped

    private void btnGenerarJugadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarJugadaActionPerformed

        new Thread(() -> {
            try {
                // btnGenerarJugada.setEnabled(false);
                jugar();
                //   btnGenerarJugada.setEnabled(true);
            } catch (Exception e) {
                Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, e);

            }System.out.println("");
        }).start();

    }//GEN-LAST:event_btnGenerarJugadaActionPerformed

    private void animalTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_animalTxtKeyTyped
        new tools().soloDoubleyCantidadDigitos(evt, animalTxt, 1);

    }//GEN-LAST:event_animalTxtKeyTyped

    private void BorrarJugadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarJugadasActionPerformed
        borrarJugadas();
    }//GEN-LAST:event_BorrarJugadasActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (JOptionPane.showConfirmDialog(archivoMenu, "Desea borrar las jugadas?", "Limpiar", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            resetearJugadas();
            resetearBotones();
            resetearSorteos();
            animalTxt.requestFocus();
        }


    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        if (modelo.getRowCount() > 0) {
            imprimir();
        } else {
            JOptionPane.showMessageDialog(rootPane, "No hay jugadas realizadas para imprimir");
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void verTicketsItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verTicketsItemActionPerformed
        if (verTickets.isShowing() || verTickets.isVisible()) {
            if (verTickets.getExtendedState() == 1) {
                verTickets.setExtendedState(0);
            } else {
                verTickets.setVisible(true);
            }

        } else {
            verTickets = new VerTickets(this);
            verTickets.iniciar();
            verTickets.setVisible(true);

        }
    }//GEN-LAST:event_verTicketsItemActionPerformed

    private void animalTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_animalTxtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            montoTxt.requestFocus();
            montoTxt.setSelectionStart(0);
            montoTxt.setSelectionEnd(3);
        }

        if (evt.getKeyCode() == KeyEvent.VK_ADD) {
            if (modelo.getRowCount() > 0) {
               imprimir();
            } else {
                JOptionPane.showMessageDialog(rootPane, "No hay jugadas realziadas para imprimir");
            }
        }

    }//GEN-LAST:event_animalTxtKeyPressed

    private void panelSorteosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panelSorteosKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ADD) {
            if (modelo.getRowCount() > 0) {
                imprimir();
            } else {
                JOptionPane.showMessageDialog(rootPane, "No hay jugadas realziadas para imprimir");
            }
        }
    }//GEN-LAST:event_panelSorteosKeyPressed

    private void panelAnimalesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panelAnimalesKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ADD) {
            if (modelo.getRowCount() > 0) {
                imprimir();
            } else {
                JOptionPane.showMessageDialog(rootPane, "No hay jugadas realziadas para imprimir");
            }
        }

    }//GEN-LAST:event_panelAnimalesKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ADD) {
            if (modelo.getRowCount() > 0) {
                imprimir();
            } else {
                JOptionPane.showMessageDialog(rootPane, "No hay jugadas realziadas para imprimir");
            }
        }
    }//GEN-LAST:event_formKeyPressed

    private void animalTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_animalTxtKeyReleased
        if (animalTxt.getText().length() == 2) {
            montoTxt.requestFocus();
            montoTxt.setSelectionStart(0);
            montoTxt.setSelectionEnd(3);
            
        }

    }//GEN-LAST:event_animalTxtKeyReleased

    private void txtPagarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagarKeyTyped
        //  new tools().soloDoubleyCantidadDigitos(evt, txtPagar, 4);
    }//GEN-LAST:event_txtPagarKeyTyped

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed

        Ticket ticket = new Ticket();
        String serialTicketx = txtPagar.getText();
        ticket = new Ticket().getTicketBySerial(serialTicketx);
        if (ticket.getId() < 1) {
            JOptionPane.showMessageDialog(rootPane, "No se encontró ningún ticket con ese serial");
        } else {
            if (ticket.getEstado().equalsIgnoreCase("premiado")) {
                double premios = 0.0;
                for (JugadasTicket jugada : ticket.getJugadas()) {
                    if (jugada.getEstado().equalsIgnoreCase("premiado")) {
                        premios += (jugada.getMonto() * 30);
                        ticket.pagar(jugada.getId());
                    }
                }
                JOptionPane.showMessageDialog(archivoMenu, "Jugadas marcadas premiadas. Pague Bs. " + premios);

            } else if (ticket.getEstado().equalsIgnoreCase("pagado")) {
                JOptionPane.showMessageDialog(rootPane, "Ticket ya fue pagado");
            } else if (ticket.getEstado().equalsIgnoreCase("anulado")) {
                JOptionPane.showMessageDialog(rootPane, "Ticket está Anulado");
            }
        }
        txtPagar.setText("");
        animalTxt.requestFocus();

    }//GEN-LAST:event_btnPagarActionPerformed

    private void txtAnularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnularKeyTyped
        new tools().soloDoubleyCantidadDigitos(evt, txtAnular, 3);
    }//GEN-LAST:event_txtAnularKeyTyped

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed

        if (txtAnular.getText().length() > 0) {
            int nTicketx = Integer.parseInt(txtAnular.getText());
            Ticket ticket = new Ticket();
            ticket = new Ticket().getTicketByNum(agencia.getId(), fechaHoy, nTicketx);
            if (ticket.getId() < 1) {
                JOptionPane.showMessageDialog(rootPane, "No se encontró ningún ticket con ese número");
            } else {
                if (validarMinutos(ticket, 3)) {
                    if (JOptionPane.showConfirmDialog(rootPane, "¿Seguro Desea eliminar Ticket?") == 0) {
                        int rsp = new Ticket().anular(ticket.getId());
                        if (rsp > 0) {
                            new rojerusan.RSNotifyFade("Ticket Anulado", "Se anuló correctamente el ticket ingresado.", 4,
                                    RSNotifyFade.PositionNotify.BottomRight, RSNotifyFade.TypeNotify.SUCCESS).setVisible(true);
                            animalTxt.requestFocus();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Pasaron más de 3 minutos luego de emitir el ticket, ya no se puede anular");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Ingrese primero el número de ticket que desea anular");
        }

        txtAnular.setText("");


    }//GEN-LAST:event_btnAnularActionPerformed

    private void btnRepetirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepetirActionPerformed
       
        new RepetirTicket(this).setVisible(true);
    }//GEN-LAST:event_btnRepetirActionPerformed

    private void txtAnularKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnularKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnAnular.doClick();
        }
    }//GEN-LAST:event_txtAnularKeyReleased

    private void txtPagarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagarKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnPagar.doClick();
        }
    }//GEN-LAST:event_txtPagarKeyReleased

    private void tablaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            borrarJugadas();
        }
    }//GEN-LAST:event_tablaKeyPressed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        if (evt.getClickCount() == 2) {
            int row = tabla.getSelectedRow();
            if (row > -1) {
                String mont = tabla.getValueAt(row, 2).toString();
                double montD = Double.parseDouble(mont);
                String rsp = "0";
                rsp = JOptionPane.showInputDialog("Ingrese nuevo monto");
                double newMonto = 0;

                try {
                    newMonto = Double.parseDouble(rsp);
                    totalTicket -= montD;

                    for (int i = 0; i < tabla.getRowCount(); i++) {
                        if (Float.compare(i, row) == 0) {
                            String sorteoCompleto = tabla.getValueAt(row, 0).toString();
                            String separador = Pattern.quote(" ");
                            String[] sorteoSeparado = sorteoCompleto.split(separador);

                            String programa = sorteoSeparado[0];
                            String sorteo = sorteoSeparado[1] + sorteoSeparado[2].toLowerCase();

                            String animalCompleto = tabla.getValueAt(row, 1).toString();
                            String animalReducido = "";

                            for (int j = 0; j < animalCompleto.length(); j++) {
                                if (new tools().ComprobarNumeros(animalCompleto.substring(j, (j + 1)))) {
                                    animalReducido += animalCompleto.substring(j, (j + 1));
                                } else {
                                    break;
                                }
                            }

                            CupoAnimal cupoJugada = myCupos.stream()
                                    .filter(t
                                            -> t.getFecha().equalsIgnoreCase(fechaHoy)
                                    && t.getPrograma().equalsIgnoreCase(programa)
                                    && t.getSorteo().equalsIgnoreCase(sorteo)
                                    ).findFirst()
                                    .get();

                            double cupoAnimalJugado = cupoJugada.getCupoActual(animalReducido);


                            double nuevoTotal = newMonto > cupoAnimalJugado
                                    ? cupoAnimalJugado
                                    : newMonto;

                            tabla.setValueAt(nuevoTotal, row, 2);
                            totalTicket += nuevoTotal;
                            totalTicketTxt.setText(totalTicket + "");
                            break;
                        }
                    }

                } catch (Exception e) {
                    Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, e);
                    JOptionPane.showMessageDialog(archivoMenu, "El valor ingresado no es númerico");
                }

            }
        }
    }//GEN-LAST:event_tablaMouseClicked

    private void resultadosItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultadosItemActionPerformed
        if (verResul.isVisible() || verResul.isShowing()) {
            if (verResul.getExtendedState() == 1) {
                verResul.setExtendedState(0);
            } else {
                verResul.setVisible(true);
            }

        } else {
            verResul = new verResultados(this);
            verResul.setVisible(true);
        }
    }//GEN-LAST:event_resultadosItemActionPerformed

    private void ventasItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventasItemActionPerformed
        if (vVentas.isShowing() || vVentas.isVisible()) {

            if (vVentas.getExtendedState() == 1) {
                vVentas.setExtendedState(0);
            } else {
                vVentas.setVisible(true);
            }

        } else {
            vVentas = new verVentas(this);
            vVentas.setVisible(true);
        }
    }//GEN-LAST:event_ventasItemActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
       
    }//GEN-LAST:event_jLabel2MouseClicked

    private void animalTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_animalTxtActionPerformed
    }//GEN-LAST:event_animalTxtActionPerformed

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
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new index().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem BorrarJugadas;
    private javax.swing.JToggleButton a0;
    private javax.swing.JToggleButton a00;
    private javax.swing.JToggleButton a1;
    private javax.swing.JToggleButton a10;
    private javax.swing.JToggleButton a11;
    private javax.swing.JToggleButton a12;
    private javax.swing.JToggleButton a13;
    private javax.swing.JToggleButton a14;
    private javax.swing.JToggleButton a15;
    private javax.swing.JToggleButton a16;
    private javax.swing.JToggleButton a17;
    private javax.swing.JToggleButton a18;
    private javax.swing.JToggleButton a19;
    private javax.swing.JToggleButton a2;
    private javax.swing.JToggleButton a20;
    private javax.swing.JToggleButton a21;
    private javax.swing.JToggleButton a22;
    private javax.swing.JToggleButton a23;
    private javax.swing.JToggleButton a24;
    private javax.swing.JToggleButton a25;
    private javax.swing.JToggleButton a26;
    private javax.swing.JToggleButton a27;
    private javax.swing.JToggleButton a28;
    private javax.swing.JToggleButton a29;
    private javax.swing.JToggleButton a3;
    private javax.swing.JToggleButton a30;
    private javax.swing.JToggleButton a31;
    private javax.swing.JToggleButton a32;
    private javax.swing.JToggleButton a33;
    private javax.swing.JToggleButton a34;
    private javax.swing.JToggleButton a35;
    private javax.swing.JToggleButton a36;
    private javax.swing.JToggleButton a4;
    private javax.swing.JToggleButton a5;
    private javax.swing.JToggleButton a6;
    private javax.swing.JToggleButton a7;
    private javax.swing.JToggleButton a8;
    private javax.swing.JToggleButton a9;
    public javax.swing.JTextField animalTxt;
    private javax.swing.JMenu archivoMenu;
    private javax.swing.ButtonGroup bg1;
    private javax.swing.JButton btnAnular;
    private javax.swing.JButton btnGenerarJugada;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnRepetir;
    private javax.swing.JCheckBoxMenuItem checkImprimirTicket;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbMensajeSistema;
    private javax.swing.JLabel lbNumTicket;
    private javax.swing.JMenu menuHerramientas;
    private javax.swing.JMenuBar menuMain;
    private javax.swing.JTextField montoTxt;
    private javax.swing.JPopupMenu opcionesTabla;
    private javax.swing.JPanel panelAnimales;
    private javax.swing.JPanel panelAyuda;
    private javax.swing.JPanel panelCentral;
    private javax.swing.JPanel panelMontos;
    private javax.swing.JPanel panelSorteos;
    private javax.swing.JPanel panelTablaJugadas;
    private javax.swing.JMenuItem resultadosItem;
    private javax.swing.JMenuItem salir;
    private javax.swing.JScrollPane scrollSorteos;
    private rojerusan.RSTableMetro tabla;
    private javax.swing.JMenu ticketMenu;
    public javax.swing.JLabel totalTicketTxt;
    private javax.swing.JTextField txtAnular;
    private javax.swing.JTextField txtPagar;
    private javax.swing.JMenuItem ventasItem;
    private javax.swing.JMenuItem verTicketsItem;
    // End of variables declaration//GEN-END:variables

    private void setFocusAnimalAfterSorteo(){
        if (animalTxt.isEnabled()) {
            animalTxt.requestFocus();
            if (animalTxt.getText().length() == 2) {
                montoTxt.requestFocus();
            }
        } else if (!animalTxt.isEnabled() || !animalTxt.getText().isEmpty()) {
            montoTxt.requestFocus();
        }
    }
    
    
    private void iniciar() {
            //double antes = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            //double despues = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            //System.out.println("iniciar Memoria Antes: "+antes+" Memoria usada: "+ (despues-antes)/mbCuota+" --- TOTAL: "+despues+" mbs");
        
            
        try {
            lbMensajeSistema.setText("Cargando fecha del servidor");
            fechaHoy = new ConectarDBCloud("ag").tomarFecha();
            verTickets = new VerTickets(this);
            verResul = new verResultados(this);
            vVentas = new verVentas(this);
            
            lbNumTicket.setText(agencia.getNumTicket()+"");

            
            

            lbMensajeSistema.setText("Cargando placeHolder");
            modelo = (DefaultTableModel) tabla.getModel();
            new PlaceHolder("Jugada", animalTxt);
            new PlaceHolder("Monto", montoTxt);
            new PlaceHolder("Serial", txtPagar);
            new PlaceHolder("# Ticket", txtAnular);

            
            agregarBotones();

            animalTxt.requestFocus();
            tInicio = System.currentTimeMillis();
        
            prepararLoterias();
           
            
            new Thread(()->{
                new Timer().scheduleAtFixedRate(actualizarHoraTT, 0, 5000);
                new Timer().scheduleAtFixedRate(desactivarSorteosTT, 0, 10000);
                new Timer().scheduleAtFixedRate(validarConeccion, 0, 5000); //Sin uso actualmente
                
                mantenerCuposActualizados();
               
                if(agencia.getId() == 1){
                    iniciarIngresoResultados();
                }

            }).start();
            
            lbMensajeSistema.setText("Cargando información de Ag.");

           

            lbMensajeSistema.setText("Sistema Listo. Esperando Novedades");
        } catch (Exception ex) {
            Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(archivoMenu, ex);
        }
        
        
    }

    private void getActualizacionCupos(){
        
        double beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        
        myCupos.clear();
        myCupos =  new CupoAnimal().getCupoAgencia(agencia.getId(), fechaHoy);
       
        double afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        double memoryUsed = afterUsedMem - beforeUsedMem;
        
        System.out.println("Memoria Actual: "+beforeUsedMem/mbCuota+" mbs");
        System.out.println("Memoria Totla: "+afterUsedMem/mbCuota+" mbs");
        System.out.println("Memoria utilizada: " + memoryUsed/mbCuota + " mbs  --- cuposSize: "+myCupos.size());
        
        
        contadorCupos = 0;
        System.out.println("Cupos Actualizados");
    }
    
    TimerTask validarConeccion = new TimerTask() {
        public void run() {
            
                try {
                    isConnected = InetAddress.getByName("c1046.gconex.com").isReachable(1000);

                    lbMensajeSistema.setText("Conexión Estable. Esperando Novedades");
                } catch (IOException e) {
                    isConnected = false;
                    lbMensajeSistema.setText("Ups. Hay problemas de Conexión.");
                }
                
           
            
            
        }
    };

    TimerTask actualizarHoraTT = new TimerTask() {
        public void run() {
            
            myUltimaHora.setTime(new NTPService().getNTPDate());
            myHoraActual.setTime(myUltimaHora.getTime());
            jLabel3.setToolTipText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(myUltimaHora.getTime()));
            
            
//            try {
//
//                String capturaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new NTPService().getNTPDate());
//                myHoraActual.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(capturaHora));
//
//                        
//                if (myHoraActual.compareTo(myUltimaHora) >= 0) {
//                    tInicio = System.currentTimeMillis();
//                    myUltimaHora = myHoraActual;
//
//                    fechaHoy = fechaHoy.equals("2022-11-01")
//                            ? new SimpleDateFormat("yyyy-MM-dd").format(myUltimaHora.getTime())
//                            : fechaHoy;
//
//                } else {
//                    tFinal = System.currentTimeMillis();
//                    long dif = (tFinal - tInicio);
//                    myUltimaHora.add(Calendar.MILLISECOND, (int) dif);
//                    tInicio = System.currentTimeMillis();
//                }
//
//            } catch (ParseException ex) {
//                Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
//            }
        
        
        }
        
        
    };

    TimerTask desactivarSorteosTT = new TimerTask() {
        public void run() {
            
            
            try {
                int minutos = 0;
                sorteosDisponibles.clear();
                String myHorax = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.UK).format(myUltimaHora.getTime());
                Calendar myHora = Calendar.getInstance();
                myHora.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.UK).parse(myHorax));

                for (JCheckBoxPrograma sorteo : sorteos) {
                        minutos = 0;
                        String horaObtenido = sorteo.getName().toLowerCase();
                        String minutosAgregados = ":00";
                        String horaSorteo = fechaHoy + " " + new JugadasTicket().getHoradelSorteo(horaObtenido) + minutosAgregados;
                        
                        
                        Calendar mySorteo = Calendar.getInstance();
                        mySorteo.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.UK).parse(horaSorteo));
                        minutos = new tools().restarMinutos(myHora.getTime(), mySorteo.getTime());

                        boolean visible = minutos < agencia.getMinutosCierre() || minutos>1224? false : true;
                        sorteo.setVisible(visible);//ORIGINAL
                        if(visible){
                            sorteosDisponibles.add(sorteo.getText());
                        }
                        
                        
                        
                        
                        
                }
            //Quitando las jugadas realizadas pasadas de tiempo    
                double monto =0;
                for(int i=modelo.getRowCount()-1; i>=0; i--){
                    String sorteo = modelo.getValueAt(i, 0). toString();
                    if(!sorteosDisponibles.contains(sorteo)){
                        modelo.removeRow(i);
                    }else{
                        monto += Double.parseDouble(modelo.getValueAt(i, 2).toString());
                    }

                }totalTicket=monto;totalTicketTxt.setText(monto+"");
            ////Quitando las jugadas realizadas pasadas de tiempo    
             
            } catch (ParseException ex) {
                Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            }
    };

    private void agregarBotones() {
        lbMensajeSistema.setText("Cargando Botones");
        animalesTablero.add(a0);
        animalesTablero.add(a00);
        animalesTablero.add(a1);
        animalesTablero.add(a2);
        animalesTablero.add(a3);
        animalesTablero.add(a4);
        animalesTablero.add(a5);
        animalesTablero.add(a6);
        animalesTablero.add(a7);
        animalesTablero.add(a8);
        animalesTablero.add(a9);
        animalesTablero.add(a10);
        animalesTablero.add(a11);
        animalesTablero.add(a12);
        animalesTablero.add(a13);
        animalesTablero.add(a14);
        animalesTablero.add(a15);
        animalesTablero.add(a16);
        animalesTablero.add(a17);
        animalesTablero.add(a18);
        animalesTablero.add(a19);
        animalesTablero.add(a20);
        animalesTablero.add(a21);
        animalesTablero.add(a22);
        animalesTablero.add(a23);
        animalesTablero.add(a24);
        animalesTablero.add(a25);
        animalesTablero.add(a26);
        animalesTablero.add(a27);
        animalesTablero.add(a28);
        animalesTablero.add(a29);
        animalesTablero.add(a30);
        animalesTablero.add(a31);
        animalesTablero.add(a32);
        animalesTablero.add(a33);
        animalesTablero.add(a34);
        animalesTablero.add(a35);
        animalesTablero.add(a36);

    }

    

    private void resetearBotones() {
        animalesTablero.forEach(t->t.setSelected(false));
    }

    private void resetearSorteos() {
        sorteos.forEach(t->t.setSelected(false));
    }

    public String getAnimal(int numero) {
        String animal = "";

        if (true) {
            switch (numero) {
                case 0:
                    animal = "Delfín";
                    break;
                case -1:
                    animal = "Ballena";
                    break;
                case 1:
                    animal = "Carnero";
                    break;
                case 2:
                    animal = "Toro";
                    break;
                case 3:
                    animal = "Ciempies";
                    break;
                case 4:
                    animal = "Alacrán";
                    break;
                case 5:
                    animal = "León";
                    break;
                case 6:
                    animal = "Rana";
                    break;
                case 7:
                    animal = "Perico";
                    break;
                case 8:
                    animal = "Ratón";
                    break;
                case 9:
                    animal = "Águila";
                    break;
                case 10:
                    animal = "Tigre";
                    break;
                case 11:
                    animal = "Gato";
                    break;
                case 12:
                    animal = "Caballo";
                    break;
                case 13:
                    animal = "Mono";
                    break;
                case 14:
                    animal = "Paloma";
                    break;
                case 15:
                    animal = "Zorro";
                    break;
                case 16:
                    animal = "Oso";
                    break;
                case 17:
                    animal = "Pavo";
                    break;
                case 18:
                    animal = "Burro";
                    break;
                case 19:
                    animal = "Chivo";
                    break;
                case 20:
                    animal = "Cochino";
                    break;
                case 21:
                    animal = "Gallo";
                    break;
                case 22:
                    animal = "Camello";
                    break;
                case 23:
                    animal = "Cebra";
                    break;
                case 24:
                    animal = "Iguana";
                    break;
                case 25:
                    animal = "Gallina";
                    break;
                case 26:
                    animal = "Vaca";
                    break;
                case 27:
                    animal = "Perro";
                    break;
                case 28:
                    animal = "Zamuro";
                    break;
                case 29:
                    animal = "Elefante";
                    break;
                case 30:
                    animal = "Caimán";
                    break;
                case 31:
                    animal = "Lapa";
                    break;
                case 32:
                    animal = "Ardilla";
                    break;
                case 33:
                    animal = "Pescado";
                    break;
                case 34:
                    animal = "Venado";
                    break;
                case 35:
                    animal = "Jirafa";
                    break;
                case 36:
                    animal = "Culebra";
                    break;
            }
        }
        return animal;
    }

    private void tablero() {
        tablero = false;
        for (JToggleButton btn : animalesTablero) {
            if (btn.isSelected()) {
                animalTxt.setEnabled(false);
                animalTxt.setText("Tablero");
                montoTxt.requestFocus();
                montoTxt.setSelectionStart(0);
                 montoTxt.setSelectionEnd(3);
                tablero = true;
                break;
            }
        }
        if (tablero == false) {
            animalTxt.setEnabled(true);
            animalTxt.setText("");
            animalTxt.requestFocus();
        }
    }

    private void jugar() {

        try {
            if (validarSorteos()) {
                if (validarAnimal()) {
                    if (Integer.valueOf(montoTxt.getText()) >=agencia.getJugadaMinima()) {

                        for (JCheckBoxPrograma sorteo : sorteos.stream().filter(t -> t.isSelected()).collect(Collectors.toList())) {
                            String monto = montoTxt.getText();
                            double montoDouble = Double.parseDouble(monto);

                            if (tablero == true) {//Varios animales
                                String separador = Pattern.quote(" ");
                                String[] programas = sorteo.getText().split(separador);
                                String programaYsorteo = sorteo.getPrograma() + " " + sorteo.getName();
                                programaYsorteo = programaYsorteo.replace("  ", " ");
                                for (JToggleButton animal : animalesTablero) {
                                    if (animal.isSelected()) {
                                        String anmx = animal.getName().equals("00") ? "-1" : animal.getName();
                                        int anim = Integer.parseInt(anmx);
                                        String animString = getAnimal(anim);
                                        String animalJugado = anmx.equals("-1") ? "00" : anmx;
                                        String jugada = animalJugado + "" + animString;

                                        CupoAnimal cupoJugada = myCupos
                                                .stream()
                                                .filter(t -> t.getFecha().equalsIgnoreCase(fechaHoy)
                                                && t.getPrograma().equalsIgnoreCase(sorteo.getPrograma().replace(" ", ""))
                                                && t.getSorteo().equalsIgnoreCase(sorteo.getName().toLowerCase())//.replace(" ", ""))
                                                )
                                                .findFirst().get();

                                        double cupoAnimalJugado = cupoJugada.getCupoActual(animalJugado);

                                        if (tabla.getRowCount() > 0) {//Ya existen jugadas
                                            boolean flag = false;
                                            double montoTabla = 0.0;
                                            int filax = 0;
                                            for (int i = 0; i < tabla.getRowCount(); i++) {
                                                String sorteox = tabla.getValueAt(i, 0).toString();
                                                String jugadax = tabla.getValueAt(i, 1).toString();
                                                if (programaYsorteo.equalsIgnoreCase(sorteox) && jugada.equalsIgnoreCase(jugadax)) {
                                                    montoTabla = Double.parseDouble(tabla.getValueAt(i, 2).toString());
                                                    flag = true;
                                                    filax = i;
                                                }
                                            }
                                            if (flag == false) {//No hay jugadas iguales
                                                double totalJugada = montoDouble > cupoAnimalJugado
                                                        ? cupoAnimalJugado
                                                        : montoDouble;
                                                totalTicket += totalJugada;
                                                //String cupoRestante = cupos.g
                                                modelo.addRow(new Object[]{
                                                    programaYsorteo, jugada, totalJugada, cupoAnimalJugado
                                                });
                                                totalTicketTxt.setText(totalTicket + "");
                                            } else {//si hay jugadas iguales
                                                double nuevoTotalAnimalJugado = (montoTabla + montoDouble) > cupoAnimalJugado
                                                        ? cupoAnimalJugado
                                                        : (montoTabla + montoDouble);

                                                totalTicket += (nuevoTotalAnimalJugado - montoTabla);
                                                tabla.setValueAt(nuevoTotalAnimalJugado, filax, 2);
                                                tabla.setValueAt(cupoAnimalJugado, filax, 3);
                                                totalTicketTxt.setText(totalTicket + "");
                                            }
                                        } else {//La Tabla está vacia
                                            double totalJugada = montoDouble > cupoAnimalJugado
                                                    ? cupoAnimalJugado
                                                    : montoDouble;
                                            totalTicket += totalJugada;
                                            //String cupoRestante = cupos.g
                                            modelo.addRow(new Object[]{
                                                programaYsorteo, jugada, totalJugada, cupoAnimalJugado
                                            });
                                            totalTicketTxt.setText(totalTicket + "");
                                        }

                                    }
                                }

                            } else {// Solo un animal
                                String separador = Pattern.quote(" ");
                                String programaYsorteo = sorteo.getPrograma().replace(" ", "") + " " + sorteo.getName();
                                programaYsorteo = programaYsorteo.replace("  ", " ");

                                String animalSeleccionado = animalTxt.getText().equals("00") ? "-1" : animalTxt.getText();
                                int anim = Integer.parseInt(animalSeleccionado);
                                animalSeleccionado = anim >= 1 && anim <= 9 && animalSeleccionado.length() == 1 ? "0" + animalSeleccionado : animalSeleccionado;
                                String animString = getAnimal(anim);

                                String animalJugado = animalSeleccionado.equals("-1") ? "00" : animalSeleccionado;

                                String jugada = animalJugado + "" + animString;
                                String sorteoUtilizar = sorteo.getName();//.replace(" ", ":30 ");

                                CupoAnimal cupoJugada = myCupos.stream()
                                        .filter(t
                                                -> t.getFecha().equalsIgnoreCase(fechaHoy)
                                        && t.getPrograma().equalsIgnoreCase(sorteo.getPrograma().replace(" ", ""))
                                        && t.getSorteo().equalsIgnoreCase(sorteoUtilizar)//.replace(" ", ""))
                                        ).findFirst()
                                        .get();

                                double cupoAnimalJugado = cupoJugada.getCupoActual(animalJugado);
                                if (tabla.getRowCount() > 0) {//Ya existen jugadas
                                    boolean flag = false;
                                    double montoTabla = 0.0;
                                    int filax = 0;
                                    for (int i = 0; i < tabla.getRowCount(); i++) {
                                        String sorteox = tabla.getValueAt(i, 0).toString();
                                        String jugadax = tabla.getValueAt(i, 1).toString();
                                        if (programaYsorteo.equalsIgnoreCase(sorteox) && jugada.equalsIgnoreCase(jugadax)) {
                                            montoTabla = Double.parseDouble(tabla.getValueAt(i, 2).toString());
                                            flag = true;
                                            filax = i;
                                        }
                                    }
                                    if (flag == false) {//No hay jugadas iguales
                                        double totalJugada = montoDouble > cupoAnimalJugado
                                                ? cupoAnimalJugado
                                                : montoDouble;
                                        totalTicket += totalJugada;
                                        //String cupoRestante = cupos.g
                                        modelo.addRow(new Object[]{
                                            programaYsorteo, jugada, totalJugada, cupoAnimalJugado
                                        });
                                        totalTicketTxt.setText(totalTicket + "");
                                    } else {//si hay jugadas iguales
                                        double nuevoTotalAnimalJugado = (montoTabla + montoDouble) > cupoAnimalJugado
                                                ? cupoAnimalJugado
                                                : (montoTabla + montoDouble);

                                        totalTicket += (nuevoTotalAnimalJugado - montoTabla);
                                        tabla.setValueAt(nuevoTotalAnimalJugado, filax, 2);
                                        tabla.setValueAt(cupoAnimalJugado, filax, 3);
                                        totalTicketTxt.setText(totalTicket + "");
                                    }
                                } else {//La Tabla está vacia
                                    double totalJugada = montoDouble > cupoAnimalJugado
                                            ? cupoAnimalJugado
                                            : montoDouble;
                                    totalTicket += totalJugada;
                                    //String cupoRestante = cupos.g

                                    modelo.addRow(new Object[]{
                                        programaYsorteo, jugada, totalJugada, cupoAnimalJugado
                                    });

                                    totalTicketTxt.setText(totalTicket + "");
                                }

                                ///////////
                            }

                        }

                        limpiarJugada(true);
                    }else{
                        JOptionPane.showMessageDialog(archivoMenu, "La jugada minima permitida es "+agencia.getJugadaMinima()+" BS");
                    }
                }

            } else {
                JOptionPane.showMessageDialog(archivoMenu, "Seleccione al menos 1 sorteo");
            }
        } catch (Exception e) {
            Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, e);
        }

    }


   

    private boolean validarAnimal() {
        boolean llave = false;
        double animalJugado = 37;
        if (tablero) {
            llave = true;
        } else {
            if (animalTxt.getText().length() > 0) {
                animalJugado = Double.parseDouble(animalTxt.getText());
            }

            if ((animalTxt.getText().length() > 0 && animalJugado < 37)) {//animalTxt.getText().equalsIgnoreCase("tablero") ||
                llave = true;
            } else {
                JOptionPane.showMessageDialog(archivoMenu, "Debe seleccionar un animal del tablero o agregarlo manualmente\nVerifique que el campo no esté vacio y que el número ingreso sea 00, o del 0 al 36");
            }
        }

        return llave;
    }

    private void limpiarJugada(boolean fromJugada) {

        if (!fromJugada) {
            montoTxt.setText("");
        }

        tablero = false;
        resetearBotones();
        animalTxt.setText("");
        animalTxt.setEnabled(true);
        animalTxt.requestFocus();
        lbNumTicket.setText(agencia.getNumTicket()+"");
        
    }

    private void borrarJugadas() {
        int[] filas = tabla.getSelectedRows();
        
        for (int i = filas.length; i > 0; i--) {
                modelo.removeRow(filas[i - 1]);
        }
        
        if(modelo.getRowCount()>0){
            totalTicket=0;
            for(int i=0; i<modelo.getRowCount(); i++){
                Double montoJugado = Double.parseDouble(tabla.getValueAt(i, 2).toString());
                totalTicket += montoJugado;
            }totalTicketTxt.setText(totalTicket + "");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Debe seleccionar 1 o más jugadas a borrar");
        }
      
        animalTxt.requestFocus();
    }

    private void resetearJugadas() {
        totalTicketTxt.setText("0");
        modelo.setRowCount(0);
        totalTicket = 0.0;
        sorteos.forEach(t->t.setSelected(false));
        
        
    }

    private void imprimir() {

        try {
            imprimiendo=true;
            confirmarCuposDisponibles();
            double totalJugado = 0.0;
            ArrayList<JugadasTicket> jugadas = new ArrayList();
             
            //Procesando la información de las jugadas.    
            for (int i = 0; i < tabla.getRowCount(); i++) {
                String sorteoJugadox = tabla.getValueAt(i, 0).toString();
                
                if (sorteosDisponibles.contains(sorteoJugadox)) {
                    Double montoJugado = Double.parseDouble(tabla.getValueAt(i, 2).toString());
                    if (montoJugado > 0) {
                        String separador = Pattern.quote(" ");
                        String sorteox = tabla.getValueAt(i, 0).toString();
                        String[] sorteoYprograma = sorteox.split(separador);
                        String programa = sorteoYprograma[0];
                        String sorteoJugado = sorteoYprograma[1] +" "+ sorteoYprograma[2].toUpperCase();
                        String animalCompleto = tabla.getValueAt(i, 1).toString();
                        String animalJugado = tomarAnimal(animalCompleto);

                        

                        animalesVendidos.add(
                                animalesVendidos.stream()
                                .filter(cupo ->
                                        cupo.getPrograma().equals(programa) &&
                                        cupo.getSorteo().equals(sorteoJugado) &&
                                        cupo.getFecha().equals(fechaHoy)
                                ).count()>0 
                                        
                                    ? animalesVendidos.stream()
                                        .filter(cupo ->
                                                cupo.getPrograma().equals(programa) &&
                                                cupo.getSorteo().equals(sorteoJugado) &&
                                                cupo.getFecha().equals(fechaHoy)
                                        ).findFirst()
                                        .get()
                                        .setVendido(animalJugado, montoJugado)
                                
                                    : myCupos.stream()
                                        .filter(cupo ->
                                                cupo.getPrograma().equals(programa) &&
                                                cupo.getSorteo().equals(sorteoJugado) &&
                                                cupo.getFecha().equals(fechaHoy)
                                        ).findFirst()
                                        .get()
                                        .setVendido(animalJugado, montoJugado)
                                
                        );
                               

                        Float montoParseado = Float.parseFloat(tabla.getValueAt(i, 2).toString());
                        totalJugado += montoParseado;
                        jugadas.add(new JugadasTicket(0,
                                agencia.getNumTicket(),
                                programa,
                                fechaHoy,
                                sorteox,
                                animalCompleto,
                                montoParseado,
                                "Activo")
                        );
                    }
                }

            }

            String hora = new SimpleDateFormat("hh:mm:ss").format(myUltimaHora.getTime());
            String serialTicket = "";

            if (!jugadas.isEmpty()) {
                
                serialTicket = new Ticket().insert(
                        agencia.getNumTicket(),
                        agencia.getId(),
                        agencia.getNombreAgencia(),
                        totalJugado,
                        jugadas
                );
                
                
                
                if (!serialTicket.equalsIgnoreCase("error")) {
                    
                    jugadas = (ArrayList) jugadas.stream()
                            .sorted(Comparator.comparing(JugadasTicket::getPrograma))
                            .sorted(Comparator.comparing(JugadasTicket::getMonto))
                            .sorted(Comparator.comparing(JugadasTicket::getSorteo))
                            .collect(Collectors.toList());
                   
//                    jugadas = (ArrayList) jugadas.stream()
//                            .sorted(Comparator.comparing(JugadasTicket::getMonto)
//                            ).collect(Collectors.toList());
//                    
//                    jugadas = (ArrayList) jugadas.stream()
//                            .sorted(Comparator.comparing(JugadasTicket::getSorteo)
//                            ).collect(Collectors.toList());
                   
                        
                  
                    if(checkImprimirTicket.isSelected()){
                       new Imprimir().enviarImpresion(
                            espaciosPrevios,
                            agencia.getNombreAgencia(),
                            fechaHoy,
                            hora,
                            agencia.getNumTicket()+"",
                            serialTicket,
                            jugadas,
                            totalJugado
                        ); 
                    }
                    
                    agencia.incrementarNumTicketLocal();
                    
                    limpiarJugada(false);
                    resetearJugadas();       
                    resetearSorteos();
                    
                     new Thread(() -> {//Actualizar los cupos de los animales que fueron seleccionados para la venta
                        new CupoAnimal().actualizarCupo(procesarVendidos());
                        getActualizacionCupos();
                      }).start();
 
                    
                     contadorCupos =0;
                    
                    
                    
                    new rojerusan.RSNotifyFade(
                            "Ticket Impreso",
                            "Se realizó la impresión del ticket, en caso contrario contacte al Administrador.",
                            4,
                            RSNotifyFade.PositionNotify.BottomRight,
                            RSNotifyFade.TypeNotify.SUCCESS
                    ).setVisible(true);
                    imprimiendo=false;
                } else {
                    jugadas.clear();
                    totalJugado = 0.0;
                    JOptionPane.showMessageDialog(null, "No se ha podido generar el ticket, intente de nuevo");
                    imprimiendo=false;
                }
            } else {
                imprimiendo=false;
                JOptionPane.showMessageDialog(archivoMenu, "No existen: \n-Jugadas disponibles que posean cupos.\n-Jugadas con sorteos Disponibles\n\nRevise las jugadas agregadas..");
            }
            imprimiendo=false;
        } catch (Exception ex) {
            Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    

    public boolean validarMinutos(Ticket ticket, int minutos) {
        boolean llave = false;
        try {
            String actual = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new NTPService().getNTPDate());
            Date hActual = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(actual);
            Date horaInicial = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(ticket.getFecha());

            int resultado = new tools().restarMinutos(horaInicial, hActual);
            if (resultado <= minutos) {
                llave = true;
            }
        } catch (ParseException ex) {
            Logger.getLogger(VerTickets.class.getName()).log(Level.SEVERE, null, ex);
        }
        return llave;
    }


   
    public void mantenerCuposActualizados() {
        new Thread(() -> {
             getActualizacionCupos();
            while (true) {
                for (; contadorCupos < 60; contadorCupos++) {
                    try {
                        double memoria = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                        //System.out.println("Esperando " + contadorCupos + " / 60 --- Memoria actual: "+Double.parseDouble(memoria/mbCuota+"") );
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (Float.compare(contadorCupos, 59) > 0) {
                    getActualizacionCupos();
                    
                }

            }
        }).start();
    }
    
    
        
        
        
    public ArrayList<JCheckBoxPrograma> getSorteos(){
        return sorteos;
    }
    
    public ArrayList<CupoAnimal> getAnimalesVendidos(){
        return animalesVendidos;
    }
    public Agencia getAgencia(){
        return this.agencia;
    }
    public rojerusan.RSTableMetro getTabla(){
        return tabla;
    }
    public void setTotalTicket(String texto){
        totalTicketTxt.setText(texto);
    }
    public DefaultTableModel getModel (){
        return modelo;
    }
    
    
    private void iniciarIngresoResultados(){
        NewCupos nc = new NewCupos().iniciar();
        ProcesarResultados pr = new ProcesarResultados();
        
    }
    
    
    private JSONArray procesarVendidos(){
        JSONArray jsonCupos = new JSONArray();
        JSONObject vendido = new JSONObject();
        for(CupoAnimal cupo : animalesVendidos){
            vendido = new JSONObject();
            vendido.put("p_idx", cupo.getId());
            vendido.put("p_animal_0", cupo.getAnimal_0());
            vendido.put("p_animal_00", cupo.getAnimal_00());
            vendido.put("p_animal_1", cupo.getAnimal_1());
            vendido.put("p_animal_2", cupo.getAnimal_2());
            vendido.put("p_animal_3", cupo.getAnimal_3());
            vendido.put("p_animal_4", cupo.getAnimal_4());
            vendido.put("p_animal_5", cupo.getAnimal_5());
            vendido.put("p_animal_6", cupo.getAnimal_6());
            vendido.put("p_animal_7", cupo.getAnimal_7());
            vendido.put("p_animal_8", cupo.getAnimal_8());
            vendido.put("p_animal_9", cupo.getAnimal_9());
            vendido.put("p_animal_10", cupo.getAnimal_10());
            vendido.put("p_animal_11", cupo.getAnimal_11());
            vendido.put("p_animal_12", cupo.getAnimal_12());
            vendido.put("p_animal_13", cupo.getAnimal_13());
            vendido.put("p_animal_14", cupo.getAnimal_14());
            vendido.put("p_animal_15", cupo.getAnimal_15());
            vendido.put("p_animal_16", cupo.getAnimal_16());
            vendido.put("p_animal_17", cupo.getAnimal_17());
            vendido.put("p_animal_18", cupo.getAnimal_18());
            vendido.put("p_animal_19", cupo.getAnimal_19());
            vendido.put("p_animal_20", cupo.getAnimal_20());
            vendido.put("p_animal_21", cupo.getAnimal_21());
            vendido.put("p_animal_22", cupo.getAnimal_22());
            vendido.put("p_animal_23", cupo.getAnimal_23());
            vendido.put("p_animal_24", cupo.getAnimal_24());
            vendido.put("p_animal_25", cupo.getAnimal_25());
            vendido.put("p_animal_26", cupo.getAnimal_26());
            vendido.put("p_animal_27", cupo.getAnimal_27());
            vendido.put("p_animal_28", cupo.getAnimal_28());
            vendido.put("p_animal_29", cupo.getAnimal_29());
            vendido.put("p_animal_30", cupo.getAnimal_30());
            vendido.put("p_animal_31", cupo.getAnimal_31());
            vendido.put("p_animal_32", cupo.getAnimal_32());
            vendido.put("p_animal_33", cupo.getAnimal_33());
            vendido.put("p_animal_34", cupo.getAnimal_34());
            vendido.put("p_animal_35", cupo.getAnimal_35());
            vendido.put("p_animal_36", cupo.getAnimal_36());
            jsonCupos.put(vendido);
        }
        animalesVendidos.clear();
        return jsonCupos;
    }

    private void confirmarCuposDisponibles() {
        getActualizacionCupos();
        String separador = Pattern.quote(" ");
        for(int i =0 ; i<tabla.getRowCount(); i++){
            
            String[] sorteoArray = tabla.getValueAt(i, 0).toString().split(separador);
            String programa = sorteoArray [0];
            String horaSorteo = sorteoArray [1] + " "+sorteoArray [2];
            String jugada = tabla.getValueAt(i, 1).toString();
            String animalJugado = tomarAnimal(jugada);
            double montoJugada = Double.parseDouble(tabla.getValueAt(i, 2).toString());
            
            CupoAnimal cupoJugada = myCupos
                    .stream()
                    .filter(t -> t.getFecha().equalsIgnoreCase(fechaHoy)
                        && t.getPrograma().equalsIgnoreCase(programa)
                        && t.getSorteo().equalsIgnoreCase(horaSorteo)
                    ).findFirst()
                    .get();

            double cupoAnimalJugado = cupoJugada.getCupoActual(animalJugado);
               if(montoJugada > cupoAnimalJugado){
                   tabla.setValueAt(cupoAnimalJugado, i, 3);
               }     
        }
    }

    private String tomarAnimal(String animalCompleto) {
        String animalJugado="";
        for (int j = 0; j < animalCompleto.length(); j++) {
            if (new tools().ComprobarNumeros(animalCompleto.substring(j, (j + 1)))) {
                animalJugado += animalCompleto.substring(j, (j + 1));
            } else {
                break;
            }
        }
        return animalJugado;
    }

    private void prepararLoterias() {
        new ScrollSens(scrollSorteos, 40);
        loterias =  new Loteria().getLoterias();
        sorteos.clear();
        JPanel myPanel = new JPanel();
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
        myPanel.setBackground(Color.WHITE);
        myPanel.setBorder(BorderFactory.createEmptyBorder(2, 10, 0, 0)); // Agrega padding de 10 pixeles en todos los bordes
        
        ItemListener itemListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
               setFocusAnimalAfterSorteo();
            }
        };
        
        
        int contador = 0;
        JSeparator separator = new JSeparator();
        separator.setBackground(Color.BLACK);
        separator.setSize(120, 5);
        for (Loteria loteria : loterias) {
            myPanel.add(new JLabel("    "));
            for (HoraSorteo horaSorteo : loteria.getSorteos()) 
            {
                
                ++contador;
                if (loteria.getNombre().equals("LottoActivo") && horaSorteo.getHoraSorteo().equals("8:00 AM")) {

                } else {
                    JCheckBoxPrograma temp = new JCheckBoxPrograma();
                    temp.setVisible(false);
                    temp.setToolTipText(loteria.getFkGrupoResultado() + "");
                    temp.addItemListener(itemListener);
                    temp.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                    temp.setSize(120, 22);
                    String completo = loteria.getNombre() + " " + horaSorteo.getHoraSorteo();
                    temp.setText(completo);
                    temp.setName(horaSorteo.getHoraSorteo());
                    temp.setPrograma(loteria.getNombre());
                    sorteos.add(temp);
                    myPanel.add(temp);
                }

            }

        }
        myPanel.add(new JLabel("    "));
        myPanel.add(new JLabel("    "));
        myPanel.setSize(200, 25*contador);
        scrollSorteos.setViewportView(myPanel);
        
        
        
    }

    private boolean validarSorteos() {
        return sorteos.stream()
                .filter(t-> t.isSelected())
                .count()> 0 ;
    }
    
    
    
    
    
}
