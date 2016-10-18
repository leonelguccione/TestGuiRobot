package controlador;

import gui.InterfazOptionPanel;
import gui.MiOptionPane;
import gui.Ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.ConjuntoUsuarios;
import modelo.Usuario;

public class Controlador implements ActionListener {
    private ConjuntoUsuarios conjunto = new ConjuntoUsuarios();
    private InterfazOptionPanel optionpane = new MiOptionPane();
    private Ventana ventana = new Ventana("Ejemplo");
    private Usuario usuarioactual = null;


    public void setOptionpane(InterfazOptionPanel optionpane) {
        this.optionpane = optionpane;
    }


    public Ventana getVentana() {
        return ventana;
    }

    public ConjuntoUsuarios getConjunto() {
        return conjunto;
    }

    public Usuario getUsuarioactual() {
        return usuarioactual;
    }

    public Controlador() {
        super();
        ventana.setControlador(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("registro"))
        {
            try
            {
                conjunto.registrar(this.ventana.getNombreRegistro(), this.ventana.getContrasenaRegistro(),
                                   this.ventana.getCofirmacionContrasenaRegistro());
            } catch (Exception f)
            {
                this.optionpane.ShowMessage(null, f.getMessage());
            }
        }
        if (e.getActionCommand().equals("login"))
        {
            try
            {
                this.usuarioactual = conjunto.login(this.ventana.getNombreLogin(), this.ventana.getContrasenaLogin());
            } catch (Exception g)
            {
                this.optionpane.ShowMessage(null, g.getMessage());
            }
        }
    }

    public static void main(String args[]) {
        Controlador controlador = new Controlador();
    }

}
