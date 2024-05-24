package Model;

import java.util.ArrayList;


public class Cliente {
    private int dni;
    private String nombre;
    private String direccion;
    private String apellido;
    private ArrayList<String> pedidos;

    public Cliente (int dni,String nombre,String apellido,String direccion){
        this.dni=dni;
        this.nombre=nombre;
        this.apellido=apellido;
        this.direccion=direccion;
    }
    public int getDni() {

        return dni;
    }
    public String getNombre() {

        return nombre;
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
