package gui;

import controlador.Controlador;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Ventana extends JFrame implements KeyListener {
    private JPanel panelLogin;
    private JPanel panelRegistro;
    private JButton botonLogin;
    private JButton botonRegistro;
    private JTextField jtNombreLogin;
    private JTextField jtNombreRegistro;
    private JTextField jtContrasenaLogin;
    private JTextField jtContrasenaRegistro;
    private JTextField jtConfirmacionRegistro;


    public Ventana(String string) throws HeadlessException {
        super(string);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.inicilaiza();
        this.setVisible(true);
    }

    private void inicilaiza() {
        //dimensiono la ventana y configuro el layout principal
        this.setSize(700, 200);
        Container contenedor = this.getContentPane();
        contenedor.setLayout(new FlowLayout());

        //Creo los componentes
        this.panelLogin = new JPanel();
        this.panelRegistro = new JPanel();
        this.botonLogin = new JButton("Aceptar");
        this.botonRegistro = new JButton("Aceptar");
        this.jtNombreLogin = new JTextField();
        this.jtNombreLogin = new JTextField();
        this.jtNombreRegistro = new JTextField();
        this.jtContrasenaLogin = new JPasswordField();
        this.jtContrasenaRegistro = new JPasswordField();
        this.jtConfirmacionRegistro = new JPasswordField();

        //configuro el panel de registro
        this.panelRegistro.setBorder(new TitledBorder("Registrar"));
        this.panelRegistro.setLayout(new GridLayout(3, 3, 10, 10));
        this.panelRegistro.add(new JLabel("Nombre de usuario"));
        this.panelRegistro.add(new JLabel("Contraseña"));
        this.panelRegistro.add(new JLabel("Reingrese contraseña"));
        this.panelRegistro.add(this.jtNombreRegistro);
        this.panelRegistro.add(this.jtContrasenaRegistro);
        this.panelRegistro.add(this.jtConfirmacionRegistro);
        this.panelRegistro.add(new JLabel(""));
        this.panelRegistro.add(this.botonRegistro);
        this.panelRegistro.add(new JLabel(""));
        this.botonRegistro.setEnabled(false);
        this.botonRegistro.setActionCommand("registro");
        contenedor.add(this.panelRegistro);


        //configuro el panel de login
        this.panelLogin.setBorder(new TitledBorder("Login"));
        this.panelLogin.setLayout(new GridLayout(3, 2, 10, 10));
        this.panelLogin.add(new JLabel("Nombre de usuario"));
        this.panelLogin.add(new JLabel("Contraseña"));
        this.panelLogin.add(this.jtNombreLogin);
        this.panelLogin.add(this.jtContrasenaLogin);
        this.panelLogin.add(new JLabel(""));
        this.panelLogin.add(this.botonLogin);
        this.botonLogin.setEnabled(false);
        this.botonLogin.setActionCommand("login");
        contenedor.add(this.panelLogin);

        //Agrego a la propia ventana como listener de los JTextField
        this.jtNombreRegistro.addKeyListener(this);
        this.jtContrasenaRegistro.addKeyListener(this);
        this.jtConfirmacionRegistro.addKeyListener(this);
        this.jtContrasenaLogin.addKeyListener(this);
        this.jtNombreLogin.addKeyListener(this);

        //Seteo los nombres
        this.botonLogin.setName("botonLogin");
        this.botonRegistro.setName("botonRegistro");
        this.jtConfirmacionRegistro.setName("jtConfirmacionRegistro");
        this.jtContrasenaRegistro.setName("jtContrasenaRegistro");
        this.jtContrasenaLogin.setName("jtContrasenaLogin");
        this.jtNombreRegistro.setName("jtNombreRegistro");
        this.jtNombreLogin.setName("jtNombreLogin");
    }


    @Override
    public void keyTyped(KeyEvent e) {
        this.botonRegistro.setEnabled(!(this.jtNombreRegistro.getText().isEmpty() ||
                                        this.jtContrasenaRegistro.getText().isEmpty() ||
                                        this.jtConfirmacionRegistro.getText().isEmpty()));
        this.botonLogin.setEnabled(!(this.jtNombreLogin.getText().isEmpty() ||
                                     this.jtContrasenaLogin.getText().isEmpty()));
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Implement this method
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Implement this method
    }

    public void setControlador(Controlador c) {
        this.botonLogin.addActionListener(c);
        this.botonRegistro.addActionListener(c);
    }

    public String getContrasenaLogin() {
        return this.jtContrasenaLogin.getText();
    }

    public String getContrasenaRegistro() {
        return this.jtContrasenaRegistro.getText();
    }

    public String getNombreLogin() {
        return this.jtNombreLogin.getText();
    }

    public String getNombreRegistro() {
        return this.jtNombreRegistro.getText();
    }

    public String getCofirmacionContrasenaRegistro() {
        return this.jtConfirmacionRegistro.getText();
    }
}
