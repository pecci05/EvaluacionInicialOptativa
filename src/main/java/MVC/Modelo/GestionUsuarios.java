package MVC.Modelo;

import java.util.ArrayList;
import java.util.HashSet;

public class GestionUsuarios {
    ArrayList<Usuario> listaUsuarios;
    HashSet<Integer> idsUsuarios;
    private static int contadorUsuarios;

    public GestionUsuarios(){
        listaUsuarios = new ArrayList<>();
        idsUsuarios = new HashSet<>();
        contadorUsuarios = 0;
    }

    public void crearNuevoUsuario(String nombre, String passw, String email, boolean activo,boolean admin){
        int id = contadorUsuarios++;
        if (idsUsuarios.add(id)){
            Usuario usuario = new Usuario(id,nombre,passw,email,activo,admin);
            listaUsuarios.add(usuario);
        }
    }

    public void borrarUsuario(int id){
        for (Usuario usuario : listaUsuarios){
            if (usuario.getId() == id) listaUsuarios.remove(id);
        }
    }

    public Usuario buscarUserPorID(int id){
        for (Usuario usuario1 : listaUsuarios){
            if (usuario1.getId() == id) return usuario1;
        }
        return null;
    }

    public Usuario buscarUserPorNombre(String nombre){
        for (Usuario usuario1 : listaUsuarios){
            if (usuario1.getNombre().equals(nombre)) return usuario1;
        }
        return null;
    }

    public void listarUsuarios(){
        listaUsuarios.stream().filter(Usuario::isActivo).forEach(System.out::println);
    }


}
