package Test;

import Controller.Controlador;
import Model.Catalogo;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class test {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        //Controlador.getInstancia().registrarUsuario(44655190,"joaquin","morelli","La Boca","aguanteBoca");
        Controlador.getInstancia().iniciarSesion(44655190,"aguanteBoca");
        /*try {
            TimeUnit.MINUTES.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        //Controlador.getInstancia().nuevoCarrito();

        //System.out.println(Controlador.getInstancia().mostrarUsuario());
        //Controlador.getInstancia().nuevoProducto(01,"Camiseta del cava","Boca",45000,10,"url","foto",0.2);
        //Controlador.getInstancia().actualizarPrecio(01,2);
        System.out.println("boca");
        Controlador.getInstancia().editarDescripcion(01,"facubaja");

        System.out.println("CABJ");
        Controlador.getInstancia().cerrarSesion();
        System.out.println("cami");
    }
}

