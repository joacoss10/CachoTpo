package Model;

public class SesionUsuario {
    private String key;
    private String nombre;
    private String apellido;
    private String inicio;
    private String fin;
    private String direccion;

    public SesionUsuario(){
        this.key=null;
        this.inicio=null;
        this.apellido=null;
        this.fin=null;
        this.nombre=null;
        this.direccion=null;
    }

    public String getInicio() {
        return inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getKey() {
        return key;
    }
}
