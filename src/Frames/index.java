package Frames;

import Clases.Agencia;
import Clases.ConectarDBCloud;
import Clases.Configuracion;
import Clases.CupoAnimal;
import Clases.Imprimir;
import Clases.JugadasTicket;
import Clases.NTPService;
import Clases.PlaceHolder;
import Clases.Ticket;
import Clases.tools;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;
import rojerusan.RSNotifyFade;

public class index extends javax.swing.JFrame {

    ArrayList<String> programas = new ArrayList();
    VerTickets verTickets;
    verResultados verResul;
    verVentas vVentas;
    ArrayList<CupoAnimal> cuposRegistrados = new ArrayList();
    //CupoAnimal cupos = new CupoAnimal();
    public Configuracion datos;

    ArrayList<JToggleButton> animales = new ArrayList();
    ArrayList<JCheckBox> sorteos = new ArrayList();
    DefaultTableModel modelo;

    boolean tablero = false;
    String programa = "LottoActivo";
    double totalTicket = 0.0;
    long tInicio, tFinal;
    int myNumTicket = 0;
    int espaciosPrevios = 0;

    Calendar myHoraActual = Calendar.getInstance();
    public Calendar myUltimaHora = Calendar.getInstance();

    public String fechaHoy = "2022-11-01";

    Agencia agencia;
    public index() {
        initComponents();
        datos = new Configuracion();
        changeIcon();
        new Thread(this::iniciar).start();
        

    }

    public index(Agencia agencia) {
        initComponents();
        this.agencia=agencia;
        setTitle(getTitle()+" - "+agencia.getNombreAgencia());
        
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
        jPanel1 = new javax.swing.JPanel();
        animalTxt = new javax.swing.JTextField();
        montoTxt = new javax.swing.JTextField();
        btnGenerarJugada = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        cbTodos = new javax.swing.JCheckBox();
        c7pm = new javax.swing.JCheckBox();
        c6pm = new javax.swing.JCheckBox();
        c5pm = new javax.swing.JCheckBox();
        c4pm = new javax.swing.JCheckBox();
        c3pm = new javax.swing.JCheckBox();
        c2pm = new javax.swing.JCheckBox();
        c1pm = new javax.swing.JCheckBox();
        c12pm = new javax.swing.JCheckBox();
        c11am = new javax.swing.JCheckBox();
        c10am = new javax.swing.JCheckBox();
        c9am = new javax.swing.JCheckBox();
        c8am = new javax.swing.JCheckBox();
        lbAvisoLt8am = new javax.swing.JLabel();
        panelJugadas = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        totalTicketTxt = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new rojerusan.RSTableMetro();
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
        txtRepetir = new javax.swing.JTextField();
        btnRepetir = new javax.swing.JButton();
        lbMensajeSistema = new javax.swing.JLabel();
        panelPrograma = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        checkLotto = new javax.swing.JCheckBox();
        checkGranjita = new javax.swing.JCheckBox();
        menuMain = new javax.swing.JMenuBar();
        archivoMenu = new javax.swing.JMenu();
        salir = new javax.swing.JMenuItem();
        ticketMenu = new javax.swing.JMenu();
        verTicketsItem = new javax.swing.JMenuItem();
        resultadosItem = new javax.swing.JMenuItem();
        ventasItem = new javax.swing.JMenuItem();

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
        a00.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a35.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a31.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a33.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a30.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a36.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a32.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a34.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        a27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        animalTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        animalTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
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

        btnGenerarJugada.setText("Agregar Jugada");
        btnGenerarJugada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarJugadaActionPerformed(evt);
            }
        });

        jButton5.setText("Imprimir ( + )");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        cbTodos.setText("Seleccionar Todos los Sorteos");
        cbTodos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTodosItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(animalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(montoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbTodos)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGenerarJugada, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTodos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(animalTxt)
                    .addComponent(montoTxt)
                    .addComponent(btnGenerarJugada, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        c7pm.setBackground(new java.awt.Color(255, 255, 255));
        c7pm.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        c7pm.setText(" 7 PM");
        c7pm.setName("7 PM"); // NOI18N
        c7pm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c7pmActionPerformed(evt);
            }
        });

        c6pm.setBackground(new java.awt.Color(255, 255, 255));
        c6pm.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        c6pm.setText(" 6 PM");
        c6pm.setName("6 PM"); // NOI18N
        c6pm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c6pmActionPerformed(evt);
            }
        });

        c5pm.setBackground(new java.awt.Color(255, 255, 255));
        c5pm.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        c5pm.setText(" 5 PM");
        c5pm.setName("5 PM"); // NOI18N
        c5pm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c5pmActionPerformed(evt);
            }
        });

        c4pm.setBackground(new java.awt.Color(255, 255, 255));
        c4pm.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        c4pm.setText(" 4 PM");
        c4pm.setName("4 PM"); // NOI18N
        c4pm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c4pmActionPerformed(evt);
            }
        });

        c3pm.setBackground(new java.awt.Color(255, 255, 255));
        c3pm.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        c3pm.setText(" 3 PM");
        c3pm.setName("3 PM"); // NOI18N
        c3pm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c3pmActionPerformed(evt);
            }
        });

        c2pm.setBackground(new java.awt.Color(255, 255, 255));
        c2pm.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        c2pm.setText(" 2 PM");
        c2pm.setName("2 PM"); // NOI18N
        c2pm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c2pmActionPerformed(evt);
            }
        });

        c1pm.setBackground(new java.awt.Color(255, 255, 255));
        c1pm.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        c1pm.setText(" 1 PM");
        c1pm.setName("1 PM"); // NOI18N
        c1pm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c1pmActionPerformed(evt);
            }
        });

        c12pm.setBackground(new java.awt.Color(255, 255, 255));
        c12pm.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        c12pm.setText(" 12 PM");
        c12pm.setName("12 PM"); // NOI18N
        c12pm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c12pmActionPerformed(evt);
            }
        });

        c11am.setBackground(new java.awt.Color(255, 255, 255));
        c11am.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        c11am.setText(" 11 AM");
        c11am.setName("11 AM"); // NOI18N
        c11am.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c11amActionPerformed(evt);
            }
        });

        c10am.setBackground(new java.awt.Color(255, 255, 255));
        c10am.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        c10am.setText(" 10 AM");
        c10am.setName("10 AM"); // NOI18N
        c10am.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c10amActionPerformed(evt);
            }
        });

        c9am.setBackground(new java.awt.Color(255, 255, 255));
        c9am.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        c9am.setText("9 AM");
        c9am.setName("9 AM"); // NOI18N
        c9am.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c9amActionPerformed(evt);
            }
        });

        c8am.setBackground(new java.awt.Color(255, 255, 255));
        c8am.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        c8am.setText("8 AM");
        c8am.setName("8 AM"); // NOI18N
        c8am.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c8amActionPerformed(evt);
            }
        });

        lbAvisoLt8am.setForeground(new java.awt.Color(102, 102, 102));
        lbAvisoLt8am.setText("Lotto Activo no tiene Sorteo 8am.");

        javax.swing.GroupLayout panelSorteosLayout = new javax.swing.GroupLayout(panelSorteos);
        panelSorteos.setLayout(panelSorteosLayout);
        panelSorteosLayout.setHorizontalGroup(
            panelSorteosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSorteosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelSorteosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelSorteosLayout.createSequentialGroup()
                        .addComponent(c8am)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbAvisoLt8am, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(c9am, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(c10am, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                    .addComponent(c11am, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(c12pm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(c1pm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(c2pm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(c3pm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(c4pm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(c5pm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(c6pm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(c7pm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelSorteosLayout.setVerticalGroup(
            panelSorteosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSorteosLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelSorteosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(c8am, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(lbAvisoLt8am, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c9am, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c10am, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c11am, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c12pm, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c1pm, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c2pm, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c3pm, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c4pm, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c5pm, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c6pm, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c7pm, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        panelJugadas.setBackground(new java.awt.Color(255, 255, 255));
        panelJugadas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                panelJugadasKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Total del Ticket: Bs");

        totalTicketTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        totalTicketTxt.setText("0");

        jButton4.setText("Eliminar Todas las Jugadas");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

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
        tabla.setFuenteFilas(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tabla.setFuenteFilasSelect(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tabla.setFuenteHead(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        tabla.setGridColor(new java.awt.Color(0, 0, 0));
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

        javax.swing.GroupLayout panelJugadasLayout = new javax.swing.GroupLayout(panelJugadas);
        panelJugadas.setLayout(panelJugadasLayout);
        panelJugadasLayout.setHorizontalGroup(
            panelJugadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJugadasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelJugadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                    .addGroup(panelJugadasLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalTicketTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)))
                .addContainerGap())
        );
        panelJugadasLayout.setVerticalGroup(
            panelJugadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelJugadasLayout.createSequentialGroup()
                .addGroup(panelJugadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelJugadasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelJugadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalTicketTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                .addContainerGap())
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

        txtRepetir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtRepetir.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRepetir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRepetirKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRepetirKeyTyped(evt);
            }
        });

        btnRepetir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRepetir.setText("Repetir");
        btnRepetir.setEnabled(false);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtRepetir, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRepetir)
                .addGap(26, 26, 26)
                .addComponent(lbMensajeSistema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRepetir, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRepetir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(lbMensajeSistema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelPrograma.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("ELIJA EL TIPO DE SORTEO PARA EL TICKET");

        checkLotto.setBackground(new java.awt.Color(255, 255, 255));
        checkLotto.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        checkLotto.setText("Lotto Activo");
        checkLotto.setIconTextGap(10);
        checkLotto.setMargin(new java.awt.Insets(2, 5, 2, 2));
        checkLotto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkLottoItemStateChanged(evt);
            }
        });
        checkLotto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkLottoActionPerformed(evt);
            }
        });

        checkGranjita.setBackground(new java.awt.Color(255, 255, 255));
        checkGranjita.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        checkGranjita.setText("Granjita");
        checkGranjita.setIconTextGap(10);
        checkGranjita.setMargin(new java.awt.Insets(2, 5, 2, 2));
        checkGranjita.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkGranjitaItemStateChanged(evt);
            }
        });
        checkGranjita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkGranjitaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelProgramaLayout = new javax.swing.GroupLayout(panelPrograma);
        panelPrograma.setLayout(panelProgramaLayout);
        panelProgramaLayout.setHorizontalGroup(
            panelProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProgramaLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(checkLotto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(checkGranjita, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelProgramaLayout.setVerticalGroup(
            panelProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelProgramaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProgramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkLotto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelProgramaLayout.createSequentialGroup()
                        .addComponent(checkGranjita, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout panelCentralLayout = new javax.swing.GroupLayout(panelCentral);
        panelCentral.setLayout(panelCentralLayout);
        panelCentralLayout.setHorizontalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCentralLayout.createSequentialGroup()
                .addComponent(panelAnimales, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelSorteos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelJugadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panelAyuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelPrograma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelCentralLayout.setVerticalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCentralLayout.createSequentialGroup()
                .addComponent(panelPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelSorteos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelAnimales, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelJugadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

    private void c4pmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c4pmActionPerformed
        if (animalTxt.isEnabled()) {
            animalTxt.requestFocus();
        } else if (!animalTxt.isEnabled() || !animalTxt.getText().isEmpty()) {
            montoTxt.requestFocus();
        }
    }//GEN-LAST:event_c4pmActionPerformed

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

             jugar();
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

            }
        }).start();
        
    }//GEN-LAST:event_btnGenerarJugadaActionPerformed

    private void animalTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_animalTxtKeyTyped
        new tools().soloDoubleyCantidadDigitos(evt, animalTxt, 1);

    }//GEN-LAST:event_animalTxtKeyTyped

    private void BorrarJugadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarJugadasActionPerformed
        borrarJugadas();
    }//GEN-LAST:event_BorrarJugadasActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        if(JOptionPane.showConfirmDialog(archivoMenu, "Desea borrar las jugadas?","Limpiar",JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION){
        resetearJugadas();
        resetearBotones();
        resetearSorteos();
        animalTxt.requestFocus();
        }
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (modelo.getRowCount() > 0) {
            new Thread(this::imprimir).start();
        } else {
            JOptionPane.showMessageDialog(rootPane, "No hay jugadas realizadas para imprimir");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

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
        }

        if (evt.getKeyCode() == KeyEvent.VK_ADD) {
            if (modelo.getRowCount() > 0) {
               new Thread(this::imprimir).start();
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

    private void panelJugadasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panelJugadasKeyPressed

    }//GEN-LAST:event_panelJugadasKeyPressed

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

    private void c9amActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c9amActionPerformed
        if (animalTxt.isEnabled()) {
            animalTxt.requestFocus();
            if (animalTxt.getText().length() == 2) {
                montoTxt.requestFocus();
            }
        } else if (!animalTxt.isEnabled() || !animalTxt.getText().isEmpty()) {
            montoTxt.requestFocus();
        }
    }//GEN-LAST:event_c9amActionPerformed

    private void c10amActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c10amActionPerformed
        if (animalTxt.isEnabled()) {
            animalTxt.requestFocus();
            if (animalTxt.getText().length() == 2) {
                montoTxt.requestFocus();
            }
        } else if (!animalTxt.isEnabled() || !animalTxt.getText().isEmpty()) {
            montoTxt.requestFocus();
        }
    }//GEN-LAST:event_c10amActionPerformed

    private void c11amActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c11amActionPerformed
        if (animalTxt.isEnabled()) {
            animalTxt.requestFocus();
            if (animalTxt.getText().length() == 2) {
                montoTxt.requestFocus();
            }
        } else if (!animalTxt.isEnabled() || !animalTxt.getText().isEmpty()) {
            montoTxt.requestFocus();
        }
    }//GEN-LAST:event_c11amActionPerformed

    private void c12pmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c12pmActionPerformed
        if (animalTxt.isEnabled()) {
            animalTxt.requestFocus();
            if (animalTxt.getText().length() == 2) {
                montoTxt.requestFocus();
            }
        } else if (!animalTxt.isEnabled() || !animalTxt.getText().isEmpty()) {
            montoTxt.requestFocus();
        }
    }//GEN-LAST:event_c12pmActionPerformed

    private void c1pmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c1pmActionPerformed
        if (animalTxt.isEnabled()) {
            animalTxt.requestFocus();
            if (animalTxt.getText().length() == 2) {
                montoTxt.requestFocus();
            }
        } else if (!animalTxt.isEnabled() || !animalTxt.getText().isEmpty()) {
            montoTxt.requestFocus();
        }
    }//GEN-LAST:event_c1pmActionPerformed

    private void c2pmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c2pmActionPerformed
        if (animalTxt.isEnabled()) {
            animalTxt.requestFocus();
            if (animalTxt.getText().length() == 2) {
                montoTxt.requestFocus();
            }
        } else if (!animalTxt.isEnabled() || !animalTxt.getText().isEmpty()) {
            montoTxt.requestFocus();
        }
    }//GEN-LAST:event_c2pmActionPerformed

    private void c3pmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c3pmActionPerformed
        if (animalTxt.isEnabled()) {
            animalTxt.requestFocus();
            if (animalTxt.getText().length() == 2) {
                montoTxt.requestFocus();
            }
        } else if (!animalTxt.isEnabled() || !animalTxt.getText().isEmpty()) {
            montoTxt.requestFocus();
        }
    }//GEN-LAST:event_c3pmActionPerformed

    private void c5pmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c5pmActionPerformed
        if (animalTxt.isEnabled()) {
            animalTxt.requestFocus();
            if (animalTxt.getText().length() == 2) {
                montoTxt.requestFocus();
            }
        } else if (!animalTxt.isEnabled() || !animalTxt.getText().isEmpty()) {
            montoTxt.requestFocus();
        }
    }//GEN-LAST:event_c5pmActionPerformed

    private void c6pmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c6pmActionPerformed
        if (animalTxt.isEnabled()) {
            animalTxt.requestFocus();
            if (animalTxt.getText().length() == 2) {
                montoTxt.requestFocus();
            }
        } else if (!animalTxt.isEnabled() || !animalTxt.getText().isEmpty()) {
            montoTxt.requestFocus();
        }
    }//GEN-LAST:event_c6pmActionPerformed

    private void c7pmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c7pmActionPerformed
        if (animalTxt.isEnabled()) {
            animalTxt.requestFocus();
            if (animalTxt.getText().length() == 2) {
                montoTxt.requestFocus();
            }
        } else if (!animalTxt.isEnabled() || !animalTxt.getText().isEmpty()) {
            montoTxt.requestFocus();
        }
    }//GEN-LAST:event_c7pmActionPerformed

    private void animalTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_animalTxtKeyReleased
        if (animalTxt.getText().length() == 2) {
            montoTxt.requestFocus();
        }

    }//GEN-LAST:event_animalTxtKeyReleased

    private void txtPagarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagarKeyTyped
        new tools().soloDoubleyCantidadDigitos(evt, txtPagar, 4);
    }//GEN-LAST:event_txtPagarKeyTyped

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed

        Ticket ticket = new Ticket();
        String serialTicketx = txtPagar.getText();
        ticket = new Ticket().getTicketBySerial(serialTicketx);
        if (ticket.getId() < 1) {
            JOptionPane.showMessageDialog(rootPane, "No se encontró ningún ticket con ese serial");
        } else {
            if (ticket.getEstado().equalsIgnoreCase("premiado")) {
               double premios=0.0;
                for(JugadasTicket jugada : ticket.getJugadas()){
                    if(jugada.getEstado().equalsIgnoreCase("premiado")){
                        premios+=jugada.getMonto();
                        ticket.pagar(jugada.getId());
                    }
                }
                JOptionPane.showMessageDialog(archivoMenu, "Jugadas marcadas premiadas. Pague Bs. "+premios);
                

            } else if (ticket.getEstado().equalsIgnoreCase("pagado")) {
                JOptionPane.showMessageDialog(rootPane, "Ticket ya fue pagado");
            } else if (ticket.getEstado().equalsIgnoreCase("pagado")) {
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
            ticket = new Ticket().getTicketByNum(agencia.getNombreAgencia(),fechaHoy,nTicketx);
            if (ticket.getId() < 1) {
                JOptionPane.showMessageDialog(rootPane, "No se encontró ningún ticket con ese número");
            } else {
                if (validarMinutos(ticket, 3)) {
                    if (JOptionPane.showConfirmDialog(rootPane, "¿Seguro Desea eliminar Ticket?") == 0) {
                        int rsp = new Ticket().anular(nTicketx);
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

    private void txtRepetirKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRepetirKeyTyped
        new tools().soloDoubleyCantidadDigitos(evt, txtRepetir, 3);
    }//GEN-LAST:event_txtRepetirKeyTyped

    private void btnRepetirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepetirActionPerformed
/*
        if (txtRepetir.getText().length() > 0) {

            Ticket ticket = new Ticket();
            int nTicketx = Integer.parseInt(txtRepetir.getText());
            ticket = new Ticket().buscarTicket(nTicketx, fechaHoy);
            if (ticket.getId() < 1) {
                JOptionPane.showMessageDialog(rootPane, "No se encontró ningún ticket con ese número");
            } else {
                modelo.setRowCount(0);
                totalTicket = 0;
                for (JugadasTicket jugada : ticket.getJugadas()) {
                    String hora = jugada.getSorteo().replace("Granjita ", "");
                    hora = hora.replace(ticket.getPrograma() + " ", "");
                    hora = hora.contains("AM")
                            ? hora.replace(" AM", "")
                            : hora.contains("PM")
                            ? hora.replace(" PM", "")
                            : "";
                    int horaSorteo = Integer.parseInt(hora);
                    if (horaSorteo >= 1 && horaSorteo <= 7) {
                        horaSorteo += 12;
                    }
                    boolean proximo = false;
                    for (JCheckBox sorteo : sorteos) {
                        int horaNameSorteo = Integer.parseInt(sorteo.getName());
                        //Misma hora y visible o en caso que próximo sea true
                        if ((sorteo.isVisible() && Float.compare(horaNameSorteo, horaSorteo) == 0 && sorteo.getText().equals(jugada.getSorteo())) || (proximo == true && sorteo.isVisible())) {

                            modelo.addRow(new Object[]{
                                sorteo.getText(), jugada.getAnimal(), jugada.getMonto()
                            });
                            totalTicket += jugada.getMonto();
                            totalTicketTxt.setText(totalTicket + "");
                            proximo = false;
                        } else if (!sorteo.isVisible() && Float.compare(horaNameSorteo, horaSorteo) == 0 && sorteo.getText().equals(jugada.getSorteo())) {//Mismo sorteo pero no está disponible
                            proximo = true;
                        }
                    }
                }
                txtRepetir.setText("");
                new rojerusan.RSNotifyFade("Copia Realizada", "Las jugadas se han realizado correctamente.", 4,
                        RSNotifyFade.PositionNotify.BottomRight, RSNotifyFade.TypeNotify.SUCCESS).setVisible(true);
                animalTxt.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Para repetir un ticket debe colocar primero su número");
        }

        txtRepetir.setText("");
        */
        
    }//GEN-LAST:event_btnRepetirActionPerformed

    private void txtRepetirKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRepetirKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnRepetir.doClick();
        }
    }//GEN-LAST:event_txtRepetirKeyReleased

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
                            String sorteo =sorteoSeparado[1]+sorteoSeparado[2].toLowerCase();
                            
                            
                            String animalCompleto = tabla.getValueAt(row, 1).toString();
                            String animalReducido = "";
                            
                            for (int j = 0; j < animalCompleto.length(); j++) {
                                    if(new tools().ComprobarNumeros(animalCompleto.substring(j, (j+1)))){
                                        animalReducido += animalCompleto.substring(j, (j+1));
                                    }else{
                                        break;
                                    }
                            }
                            
                            
                           
                            
                            CupoAnimal cupoJugada = cuposRegistrados.stream()
                                            .filter(t-> 
                                                t.getFecha().equalsIgnoreCase(fechaHoy) &&
                                                t.getPrograma().equalsIgnoreCase(programa) &&
                                                t.getSorteo().equalsIgnoreCase(sorteo)
                                            ).findFirst().orElse(
                                                    insertCupo(fechaHoy,programa,sorteo)
                                            );
                                    
                                    double cupoAnimalJugado = cupoJugada.getCupoActual(animalReducido);
                            
                            System.out.println("cupo: "+cupoAnimalJugado);
                            
                            double nuevoTotal = newMonto>cupoAnimalJugado
                                    ?cupoAnimalJugado
                                    :newMonto;
                            
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

    private void checkLottoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkLottoActionPerformed
        
    }//GEN-LAST:event_checkLottoActionPerformed

    private void checkGranjitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkGranjitaActionPerformed
      
    }//GEN-LAST:event_checkGranjitaActionPerformed

    private void checkLottoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkLottoItemStateChanged
     if (checkLotto.isSelected()) {
            JCheckBox c8amSorteo = sorteos.stream()
                    .filter(t-> t.getName().equals("8 AM"))
                    .findFirst().get();
            c8amSorteo.setSelected(false);
            c8amSorteo.setEnabled(false);
            lbAvisoLt8am.setVisible(true);
         
         for (JCheckBox sorteo : sorteos) {
                if (!sorteo.getText().toLowerCase().contains("lottoactivo") && !sorteo.getName().equalsIgnoreCase("8 am")) {
                    sorteo.setText("LottoActivo" + " " + sorteo.getText());
                }
            }
        } else {
         JCheckBox c8amSorteo = sorteos.stream()
                    .filter(t-> t.getName().equals("8 AM"))
                    .findFirst().get();
            lbAvisoLt8am.setVisible(false);
            c8amSorteo.setEnabled(true);
            
            for (JCheckBox sorteo : sorteos) {
                if (sorteo.getText().toLowerCase().contains("lottoactivo") && !sorteo.getName().equalsIgnoreCase("8 am")) {
                    sorteo.setText(sorteo.getText().replace("LottoActivo ", ""));
                }
            }
        }
     animalTxt.requestFocus();
    }//GEN-LAST:event_checkLottoItemStateChanged

    private void checkGranjitaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkGranjitaItemStateChanged
         if (checkGranjita.isSelected()) {
            
             for (JCheckBox sorteo : sorteos) {
                if (!sorteo.getText().toLowerCase().contains("granjita")) {
                    sorteo.setText("Granjita" + " " + sorteo.getText());
                }
            }
        } else {
            for (JCheckBox sorteo : sorteos) {
                if (sorteo.getText().toLowerCase().contains("granjita")) {
                    sorteo.setText(sorteo.getText().replace("Granjita ", ""));
                }
            }
        }
         animalTxt.requestFocus();
    }//GEN-LAST:event_checkGranjitaItemStateChanged

    private void c8amActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c8amActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c8amActionPerformed

    private void cbTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTodosItemStateChanged
      for (JCheckBox sorteo : sorteos) {
          sorteo.setSelected(cbTodos.isSelected());
      }
    }//GEN-LAST:event_cbTodosItemStateChanged

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
    private javax.swing.JTextField animalTxt;
    private javax.swing.JMenu archivoMenu;
    private javax.swing.ButtonGroup bg1;
    private javax.swing.JButton btnAnular;
    private javax.swing.JButton btnGenerarJugada;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnRepetir;
    private javax.swing.JCheckBox c10am;
    private javax.swing.JCheckBox c11am;
    private javax.swing.JCheckBox c12pm;
    private javax.swing.JCheckBox c1pm;
    private javax.swing.JCheckBox c2pm;
    private javax.swing.JCheckBox c3pm;
    private javax.swing.JCheckBox c4pm;
    private javax.swing.JCheckBox c5pm;
    private javax.swing.JCheckBox c6pm;
    private javax.swing.JCheckBox c7pm;
    private javax.swing.JCheckBox c8am;
    private javax.swing.JCheckBox c9am;
    private javax.swing.JCheckBox cbTodos;
    private javax.swing.JCheckBox checkGranjita;
    private javax.swing.JCheckBox checkLotto;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbAvisoLt8am;
    private javax.swing.JLabel lbMensajeSistema;
    private javax.swing.JMenuBar menuMain;
    private javax.swing.JTextField montoTxt;
    private javax.swing.JPopupMenu opcionesTabla;
    private javax.swing.JPanel panelAnimales;
    private javax.swing.JPanel panelAyuda;
    private javax.swing.JPanel panelCentral;
    private javax.swing.JPanel panelJugadas;
    private javax.swing.JPanel panelPrograma;
    private javax.swing.JPanel panelSorteos;
    private javax.swing.JMenuItem resultadosItem;
    private javax.swing.JMenuItem salir;
    private rojerusan.RSTableMetro tabla;
    private javax.swing.JMenu ticketMenu;
    private javax.swing.JLabel totalTicketTxt;
    private javax.swing.JTextField txtAnular;
    private javax.swing.JTextField txtPagar;
    private javax.swing.JTextField txtRepetir;
    private javax.swing.JMenuItem ventasItem;
    private javax.swing.JMenuItem verTicketsItem;
    // End of variables declaration//GEN-END:variables

    private void iniciar() {
        try {
            lbMensajeSistema.setText("Cargando fecha del servidor");
            lbAvisoLt8am.setVisible(false);
            fechaHoy = new ConectarDBCloud("ag").tomarFecha();
           
            lbMensajeSistema.setText("Cargando placeHolder");
            modelo = (DefaultTableModel) tabla.getModel();
            new PlaceHolder("Jugada", animalTxt);
            new PlaceHolder("Monto", montoTxt);
            new PlaceHolder("Serial", txtPagar);
            new PlaceHolder("# Ticket", txtAnular);
            new PlaceHolder("# Ticket", txtRepetir);

            lbMensajeSistema.setText("Cargando Botones");
            agregarBotones();
            lbMensajeSistema.setText("Cargando sorteos");
            agregarSorteos();
            programas.add("LottoActivo");
            programas.add("Granjita");
            lbMensajeSistema.setText("Cargando Cupos");
            new Thread(this::crearCupos).start();
            animalTxt.requestFocus();

            myHoraActual.setTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2022-01-01 00:00:00"));
            myUltimaHora.setTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2022-01-01 00:00:00"));
            tInicio = System.currentTimeMillis();

            new Timer().scheduleAtFixedRate(actualizarHoraTT, 0, 5000);
            verTickets = new VerTickets(this);
            verResul = new verResultados(this);
            vVentas = new verVentas(this);
            //new Timer().scheduleAtFixedRate(desactivarSorteosTT, 10000, 10000);
            lbMensajeSistema.setText("Cargando información de Ag.");
            agencia= new Agencia();
            agencia.setNombreAgencia("parra");
            agencia.setComision(10);
            
            
            
            
            
            lbMensajeSistema.setText("Sistema Listo. Esperando Novedades");
        } catch (ParseException ex) {
            Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    
    TimerTask actualizarHoraTT = new TimerTask() {
        public void run() {
            try {

                String capturaHora = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new NTPService().getNTPDate());
                myHoraActual.setTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(capturaHora));

                if (myHoraActual.compareTo(myUltimaHora) >= 0) {
                    tInicio = System.currentTimeMillis();
                    myUltimaHora = myHoraActual;

                    fechaHoy = fechaHoy.equals("2022-11-01")
                            ? new SimpleDateFormat("yyyy-MM-dd").format(myUltimaHora.getTime())
                            : fechaHoy;

//System.out.println("Actualizada: "+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(myUltimaHora.getTime()));
                } else {
                    tFinal = System.currentTimeMillis();
                    long dif = (tFinal - tInicio);
                    myUltimaHora.add(Calendar.MILLISECOND, (int) dif);
                    tInicio = System.currentTimeMillis();
                    //System.out.println("Sin Internet: "+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(myUltimaHora.getTime()));
                }

            } catch (ParseException ex) {
                Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };

    TimerTask desactivarSorteosTT = new TimerTask() {
        public void run() {
            try {
                int minutos = 0;
                for (JCheckBox sorteo : sorteos) {
                    minutos = 0;
                    String myHorax = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.UK).format(myUltimaHora.getTime());
                    Calendar myHora = Calendar.getInstance();
                    myHora.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.UK).parse(myHorax));

                    String horaSorteo = fechaHoy + " " + sorteo.getName() + ":00";
                    Calendar mySorteo = Calendar.getInstance();
                    myHora.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.UK).parse(horaSorteo));
                    minutos = new tools().restarMinutos(mySorteo.getTime(), myHora.getTime());
                    if (minutos < 3) {
                        sorteo.setVisible(false);
                    } else {
                        sorteo.setVisible(true);
                    }
                }

            } catch (ParseException ex) {
                Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };

    private void agregarBotones() {
        animales.add(a0);
        animales.add(a00);
        animales.add(a1);
        animales.add(a2);
        animales.add(a3);
        animales.add(a4);
        animales.add(a5);
        animales.add(a6);
        animales.add(a7);
        animales.add(a8);
        animales.add(a9);
        animales.add(a10);
        animales.add(a11);
        animales.add(a12);
        animales.add(a13);
        animales.add(a14);
        animales.add(a15);
        animales.add(a16);
        animales.add(a17);
        animales.add(a18);
        animales.add(a19);
        animales.add(a20);
        animales.add(a21);
        animales.add(a22);
        animales.add(a23);
        animales.add(a24);
        animales.add(a25);
        animales.add(a26);
        animales.add(a27);
        animales.add(a28);
        animales.add(a29);
        animales.add(a30);
        animales.add(a31);
        animales.add(a32);
        animales.add(a33);
        animales.add(a34);
        animales.add(a35);
        animales.add(a36);

    }

    private void agregarSorteos() {
        sorteos.add(c8am);
        sorteos.add(c9am);
        sorteos.add(c10am);
        sorteos.add(c11am);
        sorteos.add(c12pm);
        sorteos.add(c1pm);
        sorteos.add(c2pm);
        sorteos.add(c3pm);
        sorteos.add(c4pm);
        sorteos.add(c5pm);
        sorteos.add(c6pm);
        sorteos.add(c7pm);

    }

    private void resetearBotones() {
        for (JToggleButton btn : animales) {
            btn.setSelected(false);
        }
    }

    private void resetearSorteos() {
        for (JCheckBox sorteo : sorteos) {
            sorteo.setSelected(false);
        }
    }

    public String getAnimal(int numero) {
        String animal = "";

        if (true) {
            switch (numero) {
                case 0:
                    animal = "Delfin";
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
                    animal = "Leon";
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
                    animal = "Aguila";
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
        for (JToggleButton btn : animales) {
            if (btn.isSelected()) {
                animalTxt.setEnabled(false);
                animalTxt.setText("Tablero");
                montoTxt.requestFocus();
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
                    
                    for (JCheckBox sorteo : sorteos) {
                        if (sorteo.isSelected() && sorteo.isShowing()) {//Usaremos solo el sorteo activo
                            String monto = montoTxt.getText();
                            double montoDouble = Double.parseDouble(monto);
                            
                            
                            if (tablero == true) {//Varios animales
                                String separador = Pattern.quote(" ");
                                String[] programas = sorteo.getText().split(separador);
                                for (String programa : programas) {
                                    if (programa.equalsIgnoreCase("lottoactivo") || programa.equalsIgnoreCase("granjita")) {
                                        String programaYsorteo = programa + " " + sorteo.getName();
                                        for (JToggleButton animal : animales) {
                                            if (animal.isSelected()) {
                                                String anmx = animal.getName().equals("00") ? "-1" : animal.getName();
                                                int anim = Integer.parseInt(anmx);
                                                String animString = getAnimal(anim);
                                                String animalJugado = anmx.equals("-1") ? "00" : anmx;
                                                String jugada = animalJugado + "" + animString;

                                                CupoAnimal cupoJugada = cuposRegistrados
                                                        .stream()
                                                        .filter(t
                                                                -> t.getFecha().equalsIgnoreCase(fechaHoy)
                                                        && t.getPrograma().equalsIgnoreCase(programa)
                                                        && t.getSorteo().equalsIgnoreCase(sorteo.getName().toLowerCase().replace(" ", ""))
                                                        )
                                                        .findFirst()
                                                        .orElse(
                                                                insertCupo(fechaHoy, programa, sorteo.getName().toLowerCase().replace(" ", ""))
                                                        );

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
                                    }
                                }

                                
                                
                            } else {// Solo un animal
                                String separador = Pattern.quote(" ");
                                String[] programas = sorteo.getText().split(separador);
                                for (String programa : programas) {
                                    if (programa.equalsIgnoreCase("lottoActivo") || programa.equalsIgnoreCase("granjita")) {
                                        String programaYsorteo = programa + " " + sorteo.getName();
                                        String animalSeleccionado = animalTxt.getText().equals("00") ? "-1" : animalTxt.getText();
                                        int anim = Integer.parseInt(animalSeleccionado);
                                        String animString = getAnimal(anim);
                                        String animalJugado = animalSeleccionado.equals("-1") ? "00" : animalSeleccionado;
                                        String jugada = animalJugado + "" + animString;

                                        CupoAnimal cupoJugada = cuposRegistrados.stream()
                                                .filter(t
                                                        -> t.getFecha().equalsIgnoreCase(fechaHoy)
                                                && t.getPrograma().equalsIgnoreCase(programa)
                                                && t.getSorteo().equalsIgnoreCase(sorteo.getName().toLowerCase().replace(" ", ""))
                                                ).findFirst().orElse(
                                                        insertCupo(fechaHoy, programa, sorteo.getName().toLowerCase().replace(" ", ""))
                                                );

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
                            }
                        }

                    }
                    limpiarJugada();
                }
            } 
        } catch (Exception e) {
            Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    private CupoAnimal insertCupo(String fecha, String programa, String sorteo){
        CupoAnimal temp = new CupoAnimal().get(fecha, programa, sorteo);
        cuposRegistrados.add(temp);
        return temp;
    }
    
    private boolean validarSorteos() {
        boolean llave = false;
        for (JCheckBox sorteo : sorteos) {
            if (sorteo.isSelected()) {
                llave = true;
                break;
            }
        }
        if(llave){
           if(checkGranjita.isSelected() || checkLotto.isSelected()){
               llave=true;
           }else{
               llave=false;
               JOptionPane.showMessageDialog(archivoMenu, "Debe seleccionar al menos 1 Programa entre los disponibles");
           }    
        }else{
            JOptionPane.showMessageDialog(archivoMenu, "Debe seleccionar al menos 1 sorteo");
        }
        return llave;
    }

    private boolean validarAnimal() {
        boolean llave = false;
        double animalJugado = 37;
        if(animalTxt.getText().length() >0 ){
            animalJugado = Double.parseDouble(animalTxt.getText());
        }
        
        if ( (animalTxt.getText().length() > 0 && animalJugado<37) ) {//animalTxt.getText().equalsIgnoreCase("tablero") ||
            llave = true;
        }else{
            JOptionPane.showMessageDialog(archivoMenu, "Debe seleccionar un animal del tablero o agregarlo manualmente\nVerifique que el campo no esté vacio y que el número ingreso sea 00, o del 0 al 36");
        }

        return llave;
    }

    private void limpiarJugada() {
        tablero = false;
        montoTxt.setText("");
        resetearBotones();
        animalTxt.setText("");
        animalTxt.setEnabled(true);
        animalTxt.requestFocus();
    }

    private void borrarJugadas() {
        int[] filas = tabla.getSelectedRows();
        if (filas.length > 0) {
            for (int i = filas.length; i > 0; i--) {
                

                String separador = Pattern.quote(" ");
                String sorteox = tabla.getValueAt(i, 0).toString();
                String []sorteoYprograma = sorteox.split(separador);
                String programa = sorteoYprograma[0];
                String sorteoReducido = sorteoYprograma[1];
                String sorteoCompleto = sorteoYprograma[1]+sorteoYprograma[2].toLowerCase();
                String animalCompleto = tabla.getValueAt(i, 1).toString();
                Double montoJugado = Double.parseDouble(tabla.getValueAt(i-1, 2).toString());                 
                
                totalTicket -= montoJugado;
                totalTicketTxt.setText(totalTicket + "");
                modelo.removeRow(filas[i - 1]);
                
                String animalReducido = "";

                for (int j = 0; j < animalCompleto.length(); j++) {
                    if (new tools().ComprobarNumeros(animalCompleto.substring(j, (j + 1)))) {
                        animalReducido += animalCompleto.substring(j, (j + 1));
                    } else {
                        break;
                    }
                }
                final String animalJugada = animalReducido;
                
                
                      CupoAnimal jugadaTabla = cuposRegistrados.stream()
                        .filter(t
                                -> t.getPrograma().equalsIgnoreCase(programa)
                        && t.getSorteo().equalsIgnoreCase(sorteoCompleto)
                        && t.getFecha().equalsIgnoreCase(fechaHoy)
                        )
                        .findFirst()
                        .get();
                    cuposRegistrados.remove(jugadaTabla);
                    System.out.println("cuposRegistrados.size: "+cuposRegistrados.size());
                
                
                
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Debe seleccionar 1 o más jugadas a borrar");
        }
    }

    private void resetearJugadas() {
        totalTicketTxt.setText("0");
        modelo.setRowCount(0);
        totalTicket = 0.0;
        cuposRegistrados.clear();
    }

    private void imprimir() {
       

       double totalJugado=0.0;
        ArrayList<JugadasTicket> jugadas = new ArrayList();/////////////////////////
            for (int i = 0; i < tabla.getRowCount(); i++) {
                String separador = Pattern.quote(" ");
                String sorteox = tabla.getValueAt(i, 0).toString();
                String []sorteoYprograma = sorteox.split(separador);
                String programa = sorteoYprograma[0];
                String sorteoReducido = sorteoYprograma[1];
                String sorteoCompleto = sorteoYprograma[1]+sorteoYprograma[2].toLowerCase();
                String animalCompleto = tabla.getValueAt(i, 1).toString();
                Double montoJugado = Double.parseDouble(tabla.getValueAt(i, 2).toString());
                
                 String animalReducido = "";

                for (int j = 0; j < animalCompleto.length(); j++) {
                    if (new tools().ComprobarNumeros(animalCompleto.substring(j, (j + 1)))) {
                        animalReducido += animalCompleto.substring(j, (j + 1));
                    } else {
                        break;
                    }
                }
                final String animalJugada = animalReducido;
                
                try {
                    new Thread(()->{
                        CupoAnimal jugadaTabla = cuposRegistrados.stream()
                                .filter(t ->
                                    t.getPrograma().equalsIgnoreCase(programa) &&
                                    t.getSorteo().equalsIgnoreCase(sorteoCompleto) &&
                                    t.getFecha().equalsIgnoreCase(fechaHoy)
                                )
                                .findFirst()
                                .get();
//a
                        jugadaTabla.setVendido(animalJugada, montoJugado);
                        jugadaTabla.updateCupo();
                    
                        System.out.println("Actualizado: "+jugadaTabla.toString());
                    }).start();
                } catch (Exception e) {
                    Logger.getLogger(CupoAnimal.class.getName()).log(Level.SEVERE, null, e);
                }
                
                
                
                
                
                Float montoParseado = Float.parseFloat(tabla.getValueAt(i, 2).toString());
                totalJugado+=montoParseado;
                jugadas.add(new JugadasTicket(0, agencia.getNumTicket(), programa,fechaHoy, sorteox, animalCompleto, montoParseado, "Activo"));
            }

        String hora = new SimpleDateFormat("hh:mm:ss").format(myUltimaHora.getTime());
        int rsp = 0;
        
        rsp = new Ticket().insert(
            agencia.getNumTicket(),
            agencia.getNombreAgencia(),
            totalJugado,
            jugadas
        );
        if (rsp > 0) {
            
            String numJugadas = jugadas.size() + "";/////////////////////////
            //IMPRESION - Organizar un arreglo de Jugadas para Luego imprimir

            //Organizamos las jugadas por orden del Monto
            
 
            for (int i = 0; i < jugadas.size(); i++) {
                for (int j = 0; j < jugadas.size() - 1; j++) {
                    JugadasTicket tempx = new JugadasTicket();
                    if (jugadas.get(j).getMonto() > jugadas.get(j + 1).getMonto()) {
                        tempx = jugadas.get(j);
                        jugadas.set(j, jugadas.get(j + 1));
                        jugadas.set(j + 1, tempx);
                    }
                }
            }
            
            
            for (int i = 0; i < jugadas.size(); i++) {
                for (int j = 0; j < jugadas.size() - 1; j++) {
                    JugadasTicket tempx = new JugadasTicket();
                    if (jugadas.get(j).getHoradelSorteo() > jugadas.get(j + 1).getHoradelSorteo()) {
                        tempx = jugadas.get(j);
                        jugadas.set(j, jugadas.get(j + 1));
                        jugadas.set(j + 1, tempx);
                    }
                }
            }
            
            

            new Imprimir().enviarImpresion(
                    espaciosPrevios, agencia.getNombreAgencia(),
                    fechaHoy, programa, hora,
                    agencia.getNumTicket()+"", "numSerial",
                    numJugadas, jugadas, totalTicket);

            //FIN IMPRESION
            agencia.incrementarTicket();
            resetearBotones();
            resetearSorteos();
            resetearJugadas();
            limpiarJugada();
            new rojerusan.RSNotifyFade("Ticket Impreso", "Se realizó la impresión del ticket, en caso contrario contacte al Administrador.", 4,
                    RSNotifyFade.PositionNotify.BottomRight, RSNotifyFade.TypeNotify.SUCCESS).setVisible(true);

        }
    }

    private void esperar(int mill) {
        try {
            Thread.sleep(mill);
        } catch (InterruptedException ex) {
            Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean validarMinutos(Ticket ticket, int minutos) {
        boolean llave = false;
        try {
            String actual = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new NTPService().getNTPDate());
            Date hActual = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(actual);
            Date horaInicial = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(ticket.getFecha());

            int resultado = new tools().restarMinutos(horaInicial, hActual);
            //System.out.println("Inicial: "+horaInicial);
            //System.out.println("Final: "+hActual);
            //System.out.println("Resultado: "+resultado);
            if (resultado <= minutos) {
                llave = true;
            }
        } catch (ParseException ex) {
            Logger.getLogger(VerTickets.class.getName()).log(Level.SEVERE, null, ex);
        }
        return llave;
    }

    private void setNameSorteo() {
        for (JCheckBox sorteo : sorteos) {
            int hora = Integer.parseInt(sorteo.getName());
            if (hora < 12) {
                sorteo.setText(programa + " " + sorteo.getName() + " AM");
            } else if (hora == 12) {
                sorteo.setText(programa + " " + sorteo.getName() + " PM");
            } else {
                hora -= 12;
                sorteo.setText(programa + " " + sorteo.getName() + " PM");
            }
        }
    }

    private void getNumTicket() {
        if (!datos.getFechaTicket().equals(fechaHoy)) {
            datos.setFechaTicket(fechaHoy);
            datos.setNumTicket(1);
            myNumTicket = 1;
            datos.update();
        } else {
            myNumTicket = datos.getNumTicket();
            myNumTicket += 1;
            datos.setNumTicket(myNumTicket);
            datos.update();
        }
    }

    private void crearCupos() {
        long inicio = System.currentTimeMillis();
        for(String programa:programas){
            for(JCheckBox sorteo:sorteos){
                String mySorteo = sorteo.getName().toLowerCase().replace(" ", "");
               new CupoAnimal().get(fechaHoy, programa, mySorteo).toString();
            }
        }
        long fin = System.currentTimeMillis();
        long duracion = (fin - inicio)*100;
    }

}
