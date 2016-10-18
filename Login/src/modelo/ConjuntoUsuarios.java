package modelo;

import java.util.HashMap;

public class ConjuntoUsuarios {
    private HashMap<String, Usuario> listado = new HashMap<String, Usuario>();

    /**
     * Metodo para registrar usuarios ingresando nombre, contrase�a y confirmacion de la contrase�a
     * @param nombre Nombre del usuario
     * @param contrasena Contraseña del usuario
     * @param confirmacion Confirmación de la contraseña
     * @throws Exception El método lanzara una excepcion si alguno de los parámetros es null, o vacío, si la contraseña tiene menos de 6 caracteres, si la contraseña no coincide con la confirmacion o si el nombre de usuario ya existe.
     */
    public void registrar(String nombre, String contrasena, String confirmacion) throws Exception {
        if (nombre == null)
            throw new Exception("Nombre nulo");
        if (contrasena == null)
            throw new Exception("Contraseña nula");
        if (confirmacion == null)
            throw new Exception("Confirmacion de contraseña nula");
        if (nombre.isEmpty())
            throw new Exception("Nombre vacio");
        if (contrasena.isEmpty())
            throw new Exception("Contraseña vacia");
        if (confirmacion.isEmpty())
            throw new Exception("Confirmacion de contraseña vacia");
        if (!contrasena.equals(confirmacion))
            throw new Exception("Contraseña y confirmacion no coinciden");
        if (listado.containsKey(nombre))
            throw new Exception("Nombre de usuario ya existente");
        Usuario nuevo_usuario = new Usuario(nombre, contrasena);
        listado.put(nuevo_usuario.getNombre(), nuevo_usuario);

    }

    /**
     * Metodo para ingresar al sistema ingresando nombre de usuario y contrase�a.
     * @param nombre Nombre de usuario
     * @param contrasena Contrase�a de Usuario
     * @return Devuelve el usuario buscado si el login es exitoso, en caso de ingresar un nombre de usuario no o registrado, el metodo retornara null
     * @throws Exception El método lanza una excepción si alguno de los parámetros es nulo o vacío, o si la contraseña no es la correcta.
     */
    public Usuario login(String nombre, String contrasena) throws Exception {
        if (nombre == null)
            throw new Exception("Nombre nulo");
        if (contrasena == null)
            throw new Exception("Contraseña nula");
        if (nombre.isEmpty())
            throw new Exception("Nombre vacio");
        if (contrasena.isEmpty())
            throw new Exception("Contraseña vacia");
        Usuario usuario_buscado = this.listado.get(nombre);
        if (usuario_buscado != null)
            if (!usuario_buscado.getContrasena().equals(contrasena))
                throw new Exception("Contraseña incorrecta");
        return usuario_buscado;
    }

    /**
     * Metodo que devuelve la cantidad de usuarios registrados
     * @return Cantidad de usarios registrados
     */
    public int cantidadDeUsuarios() {
        return listado.size();
    }


}
