package Test;

import Controller.ControladorUsuario;

import java.util.concurrent.TimeUnit;

public class test {
    public static void main(String args[]){
        //Controlador.getInstancia().registrarUsuario(44123190,"facu","bianchi","su casa","coca");
        ControladorUsuario.getInstancia().iniciarSesion(44123190,"coca");

        ControladorUsuario.getInstancia().cerrarSesion();





        //crear tabla catalogo en cassandra
        //crear el primer id en redis de todos los que manejamos nosotros (Catalogo)
        //***CLAVES REDIS CATALOGO --set
            //sesionUsuario+dni --hget
            //Carritos:+dni --l
            //Carrito:+numeroCarrito

    }
    public static void dormir(){
        try {
            TimeUnit.MINUTES.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    //Controlador.getInstancia().nuevoProducto("Camiseta del cava","Boca",45000,10,"url","foto",0.2);
}

