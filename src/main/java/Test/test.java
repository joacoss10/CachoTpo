package Test;

import Model.Producto;
import Service.CatalogoService;

public class test {
    public static void main(String args[]){
        //Cliente a=new Cliente(1454421,"bruno","viejo","reputo");
        //ClienteService.getService().nuevoCliente(a);
        //ClienteService.getService().agregarPedido(1454421,"10");
        /*try {
            ClienteService.getService().recuperarCliente(1454421).imprimirCLiente();
        }catch (ClienteExeption e){
            System.out.println(e.getMessage());
        }*/
        Producto b=new Producto(01,"Camiseta del cava","Boca",45000,10,0.1,"url","foto");
        CatalogoService.getService().registrarProducto(b);
    }
}

