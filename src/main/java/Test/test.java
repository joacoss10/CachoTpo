package Test;

import Excepciones.ClienteExeption;
import Model.Cliente;
import Service.ClienteService;

public class test {
    public static void main(String args[]){
        //Cliente a=new Cliente(1454421,"bruno","viejo","reputo");
        //ClienteService.getInstance().nuevoCliente(a);
        //ClienteService.getInstance().agregarPedido(1454421,11);
        try {
            ClienteService.getInstance().recuperarCliente(0).imprimirCLiente();
        }catch (ClienteExeption e){
            System.out.println(e.getMessage());
        }
    }
}

