package Model;

import java.util.ArrayList;


public class Usuario {
    private int dni;
    private String nombre;
    private String direccion;
    private String apellido;
    private String contrasenia;
    private ArrayList<String> pedidos;

    public Usuario(int dni, String nombre, String apellido, String direccion,String contrasenia){
        this.dni=dni;
        this.nombre=nombre;
        this.apellido=apellido;
        this.direccion=direccion;
        this.contrasenia=contrasenia;
    }
    public int getDni() {

        return dni;
    }
    public String getNombre() {

        return nombre;
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
    public void imprimirCLiente(){
       // String a=pedidos.get(0);
        System.out.println(dni+nombre+apellido+direccion);
    }
}
