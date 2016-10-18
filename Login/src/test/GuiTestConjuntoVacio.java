package test;

import controlador.Controlador;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.JButton;
import javax.swing.JTextField;

import modelo.ConjuntoUsuarios;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GuiTestConjuntoVacio
{
    Robot robot;
    Controlador controlador;
    FalsoOptionPane op = new FalsoOptionPane();

    public GuiTestConjuntoVacio()
    {
        try
        {
            robot = new Robot();
        } catch (AWTException e)
        {
        }
    }

    @Before
    public void setUp() throws Exception
    {
        controlador = new Controlador();
        controlador.setOptionpane(op);
    }

    @After
    public void tearDown() throws Exception
    {
        controlador.getVentana().setVisible(false);
    }

    @Test
    public void testCantidad()
    {
        Assert.assertEquals("Debe haber 0 usuarios registrados", 0, controlador.getConjunto().cantidadDeUsuarios());
    }


    @Test
    public void testLogUsuarioInexistente()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtNombreLogin");
        JTextField contrasena =
            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtContrasenaLogin");
        JButton aceptarLog = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonLogin");
        //lleno los JTextField
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Juan Alberto", robot);
        TestUtils.clickComponent(contrasena, robot);
        TestUtils.tipeaTexto("Qwerty123", robot);
        TestUtils.clickComponent(aceptarLog, robot);
        //verifico los resultados
        Assert.assertNull("Usuario actual debería ser null", controlador.getUsuarioactual());
    }


    @Test
    public void testRegistroOk()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        ConjuntoUsuarios conjunto = controlador.getConjunto();
        int cantidad = conjunto.cantidadDeUsuarios();
        int cantidadactual;
        JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtNombreRegistro");
        JTextField contra =
            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtContrasenaRegistro");
        JTextField confirma =
            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtConfirmacionRegistro");
        JButton aceptar = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonRegistro");
        //lleno los JTextField
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Usuario", robot);
        TestUtils.clickComponent(contra, robot);
        TestUtils.tipeaTexto("Qwerty123", robot);
        TestUtils.clickComponent(confirma, robot);
        TestUtils.tipeaTexto("Qwerty123", robot);
        TestUtils.clickComponent(aceptar, robot);
        cantidadactual = conjunto.cantidadDeUsuarios();
        //verifico los resultados
        Assert.assertEquals("Deberia haber un elemento mas que antes", cantidad + 1, cantidadactual);
        Assert.assertNull("No debería haber excepcion", op.getMensaje());
    }

    @Test
    public void testRegistroTresYLogueo()
    {
        robot.delay(TestUtils.getDelay());
        ConjuntoUsuarios conjunto = controlador.getConjunto();
        int cantidad = conjunto.cantidadDeUsuarios();
        int cantidadactual;
        //obtengo las referencias a los componentes necesarios
        JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtNombreRegistro");
        JTextField contra =
            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtContrasenaRegistro");
        JTextField confirma =
            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtConfirmacionRegistro");
        JButton aceptar = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonRegistro");
        JTextField logNombre = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtNombreLogin");
        JTextField logContrasena =
            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtContrasenaLogin");
        JButton aceptarLog = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonLogin");
        //lleno los JTextField 
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Leonoel", robot);
        TestUtils.clickComponent(contra, robot);
        TestUtils.tipeaTexto("Qwerty123", robot);
        TestUtils.clickComponent(confirma, robot);
        TestUtils.tipeaTexto("Qwerty123", robot);
        TestUtils.clickComponent(aceptar, robot);
        TestUtils.borraJTextField(nombre, robot);
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Adolfo", robot);
        TestUtils.borraJTextField(contra, robot);
        TestUtils.clickComponent(contra, robot);
        TestUtils.tipeaTexto("caramelo2016", robot);
        TestUtils.borraJTextField(confirma, robot);
        TestUtils.clickComponent(confirma, robot);
        TestUtils.tipeaTexto("caramelo2016", robot);
        TestUtils.clickComponent(aceptar, robot);
        TestUtils.borraJTextField(nombre, robot);
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Cristian", robot);
        TestUtils.borraJTextField(contra, robot);
        TestUtils.clickComponent(contra, robot);
        TestUtils.tipeaTexto("pizzacalabresa", robot);
        TestUtils.borraJTextField(confirma, robot);
        TestUtils.clickComponent(confirma, robot);
        TestUtils.tipeaTexto("pizzacalabresa", robot);
        TestUtils.clickComponent(aceptar, robot);
        cantidadactual = conjunto.cantidadDeUsuarios();
        //verifico los resultados
        Assert.assertEquals("Deberia haber tres elementos mas que antes", cantidad + 3, cantidadactual);
        
        robot.delay(TestUtils.getDelay());
        //lleno los JTextField
        TestUtils.clickComponent(logNombre, robot);
        TestUtils.tipeaTexto("Adolfo", robot);
        TestUtils.clickComponent(logContrasena, robot);
        TestUtils.tipeaTexto("caramelo2016", robot);
        TestUtils.clickComponent(aceptarLog, robot);
        //verifico los resultados
        Assert.assertEquals("Deberia coincidir el nombre de usuario con el nombre ingresado", "Adolfo",
                            controlador.getUsuarioactual().getNombre());
    }

    @Test
    public void testConfirmacionMal()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtNombreRegistro");
        JTextField contra =
            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtContrasenaRegistro");
        JTextField confirma =
            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtConfirmacionRegistro");
        JButton aceptar = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonRegistro");
        //lleno los JTextField
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Usuario", robot);
        TestUtils.clickComponent(contra, robot);
        TestUtils.tipeaTexto("hola", robot);
        TestUtils.clickComponent(confirma, robot);
        TestUtils.tipeaTexto("holis", robot);
        TestUtils.clickComponent(aceptar, robot);
        //verifico los resultados
        Assert.assertEquals("Deberia decir: Contraseña y confirmacion no coinciden",
                            "Contraseña y confirmacion no coinciden", op.getMensaje());
    }

    @Test
    public void testRegContrasenaCorta()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JTextField nombre = (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtNombreRegistro");
        JTextField contra =
            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtContrasenaRegistro");
        JTextField confirma =
            (JTextField) TestUtils.getComponentForName(controlador.getVentana(), "jtConfirmacionRegistro");
        JButton aceptar = (JButton) TestUtils.getComponentForName(controlador.getVentana(), "botonRegistro");
        //lleno los JTextField
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("Usuario", robot);
        TestUtils.clickComponent(contra, robot);
        TestUtils.tipeaTexto("hola", robot);
        TestUtils.clickComponent(confirma, robot);
        TestUtils.tipeaTexto("hola", robot);
        TestUtils.clickComponent(aceptar, robot);
        //verifico los resultados
        Assert.assertEquals("Deberia decir: contraseña corta", "Contraseña muy corta", op.getMensaje());
    }
}
