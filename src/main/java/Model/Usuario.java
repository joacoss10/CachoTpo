package Model;

import View.UsuarioView;

import java.util.ArrayList;


public class Usuario {
    private int dni;
    private String nombre;
    private String direccion;
    private String apellido;
    private String contrasenia;
    private String categoria;
    private ArrayList<String> pedidos;

    public Usuario(int dni, String nombre, String apellido, String direccion,String contrasenia){
        this.dni=dni;
        this.nombre=nombre;
        this.apellido=apellido;
        this.direccion=direccion;
        this.contrasenia=contrasenia;
        this.categoria=null;
    }
    public int getDni() {

        return dni;
    }
    public String getNombre() {

        return nombre;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getApellido() {

        return apellido;
    }
    public String getDireccion() {

        return direccion;
    }
    public void setPedidos(ArrayList<String> Idpedidos){
            this.pedidos=Idpedidos;

    }
    public UsuarioView UsuarioToView(){
        UsuarioView vista=new UsuarioView(dni,nombre,apellido,categoria,direccion);
        return vista;
    }
}
