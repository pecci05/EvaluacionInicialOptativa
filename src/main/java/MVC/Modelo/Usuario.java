package MVC.Modelo;

public class Usuario {
    private int id;
    private String nombre;
    private String passw;
    private String email;
    private boolean activo;
    private boolean admin;
    private Carrito carritoUser;

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", activo=" + activo +
                '}';
    }

    public Usuario(int id, String nombre,String passw ,String email, boolean activo, boolean admin) {
        this.id = id;
        this.nombre = nombre;
        this.passw = passw;
        this.email = email;
        this.activo = activo;
        this.admin = admin;
    }

    public String getPassw() {
        return passw;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public Carrito getCarritoUser() {
        return carritoUser;
    }

    public void setCarritoUser(Carrito carritoUser) {
        this.carritoUser = carritoUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
