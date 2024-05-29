package View;

import java.util.ArrayList;

public class UsuarioView {
    private int dni;
    private String nombre;
    private String direccion;
    private String apellido;
    private String categoria;
    private ArrayList<String> pedidos;

    public UsuarioView(int dni,String nombre, String apellido, String categoria,String direccion){
        this.dni=dni;
        this.nombre=nombre;
        this.apellido=apellido;
        this.categoria=categoria;
        this.direccion=direccion;
    }
    public String toString(){
        return "Dni: "+dni+" nombre: "+nombre+" apellido: "+apellido+" direccion: "+direccion+" categoria: "+categoria;
    }
}
