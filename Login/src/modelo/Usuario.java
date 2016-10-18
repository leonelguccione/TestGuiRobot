package modelo;

import javax.swing.ImageIcon;

public class Usuario {
    private String nombre;
    private String contrasena;
    private String email;
    private ImageIcon avatar;


    /**
     * <b>pre:</b> nombre y contrasena deben ser distintos de null y no vacíos.
     * @param nombre nombre del nuevo usuario
     * @param contrasena contraseña del nuevo usuario
     * @throws Exception Se lanza una excepcion si la contraseña tiene menos de 6 caracteres.
     */
    public Usuario(String nombre, String contrasena) throws Exception {

        this.nombre = nombre;
        this.setContrasena(contrasena);
    }

    public String getNombre() {
        return nombre;
    }

    public void setContrasena(String contrasena) throws Exception {
        if (contrasena.length() < 6)
            throw new Exception("Contraseña muy corta");
        this.contrasena = contrasena;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setAvatar(ImageIcon avatar) {
        this.avatar = avatar;
    }

    public ImageIcon getAvatar() {
        return avatar;
    }

    public String toString() {
        return "Nombre de usuario: " + this.getNombre();
    }

}
